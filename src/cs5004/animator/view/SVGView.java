package cs5004.animator.view;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cs5004.animator.model.animation.Event;
import cs5004.animator.model.animation.ReadonlyAnimator;
import cs5004.animator.model.shape.Shape;

/**
 * This class outputs an SVG view of the animation.
 */
public class SVGView extends WrittenView {
  private final List<Shape> shapes;
  private final LinkedHashMap<String, List<Event>> events;
  private int[] canvas;
  private int timeConverter;

  /**
   * Construct an SVG view.
   * @param model model with the data, a ReadonlyAnimator version
   * @param writer a writer to append the SVG text to, an Appendable
   * @param speed animation speed, an int
   */
  public SVGView(ReadonlyAnimator model, Appendable writer, int speed) {
    super(model, writer);

    this.shapes = this.model.copyShapesList();
    this.events = this.model.copyEventsList();
    this.canvas = this.model.getCanvas();
    this.timeConverter = 100 / speed;
  }

  /**
   * Create an SVG animate String (Move/Scale {@link Event}).
   *
   * @param oldValue original value, an int
   * @param newValue final value, an int
   * @param start start time, an int
   * @param stop stop time, an int
   * @param attribute attribute changing, a String
   * @param fill fill status, a String
   * @return constructed animate String
   */
  private String createAnimateString(int oldValue, int newValue, int start, int stop, String
          attribute, String fill) {
    int duration = (stop - start) * this.timeConverter;
    int startConverted = start * this.timeConverter;

    return "\t\t<animate attributeType=\"xml\" begin=\"" + startConverted + "ms\" dur=\""
            + duration + "ms\" attributeName=\"" + attribute + "\" from=\"" + oldValue
            + "\" to=\"" + newValue + "\" fill=\"" + fill + "\" />\n";
  }

  /**
   * Create an SVG animate String (ChangeColor {@link Event}).
   * @param oldRed original red value, an int
   * @param oldGreen original green value, an int
   * @param oldBlue original blue value, an int
   * @param newRed new red value, an int
   * @param newGreen new green value, an int
   * @param newBlue new blue value, an int
   * @param start start time, an int
   * @param stop stop time, an int
   * @param fill fill status, a String
   * @return constructed animate String
   */
  private String createAnimateString(int oldRed, int oldGreen, int oldBlue, int newRed,
                                     int newGreen, int newBlue, int start, int stop, String fill) {
    int duration = (stop - start) * this.timeConverter;
    int startConverted = start * this.timeConverter;

    return "\t\t<animate attributeType=\"xml\" begin=\"" + startConverted + "ms\" dur=\""
            + duration + "ms\" attributeName=\"fill\" from=\"rgb(" + oldRed + "," + oldGreen + ","
            + oldBlue + ")\" to=\"rgn(" + newRed + "," + newGreen + "," + newBlue + ")\" fill=\""
            + fill + "\" />\n";
  }

  /**
   * Get the shape with the given name.
   * @param shapeName shape name, a String
   * @return Shape
   * @throws IllegalArgumentException if no shape has that name
   */
  private Shape getShape(String shapeName) throws IllegalArgumentException {
    for (Shape shape : this.shapes) {
      if (shapeName.equalsIgnoreCase(shape.getName())) {
        return shape;
      }
    }
    throw new IllegalArgumentException("No shape has this name.");
  }

  /**
   * Create the header String for the SVG file.
   * @return header String
   */
  private String createHeaderString() {
    return "<svg width=\"" + this.canvas[2] + "\" height=\"" + this.canvas[3] + "\" "
            + "version=\"1.1\" viewBox=\"" + this.canvas[0] + " " + this.canvas[1] + " "
            + this.canvas[2] + " " + this.canvas[3]
        + "\"\n\txmlns=\"http://www.w3.org/2000/svg\">\n";

  }

  /**
   * Create the animate strings for every event that occurred for the given shape.
   * @param shapeName shape name, a String
   * @param events shape's events, List<{@link Event}>
   * @return animate String for the shape
   */
  private String createIndividualSVG(String shapeName, List<Event> events) {
    Shape currentShape = this.getShape(shapeName);
    StringBuilder text = new StringBuilder(currentShape.getSVG());

    // Iterate through every event that occurred
    for (Event event : events) {
      HashMap<String, int[]> eventValues = event.getValues();

      // Get the data of all those events
      for (Map.Entry<String, int[]> entry : eventValues.entrySet()) {
        int[] values = entry.getValue();
        if (values.length == 2) {
          text.append(this.createAnimateString(values[0], values[1], event.getStart(),
                  event.getStop(), entry.getKey(), "freeze"));
        }

        // Color is changing (more values)
        else {
          text.append(this.createAnimateString(values[0], values[1], values[2], values[3],
                  values[4], values[5], event.getStart(), event.getStop(), "freeze"));
        }
      }
    }

    text.append(currentShape.getSVGType());
    return text.toString();
  }

  /**
   * Construct the full SVG document with the header, shape descriptions,
   * and animate descriptions.
   * @return SVG String
   */
  private String createFullSVG() {
    String header = this.createHeaderString();
    try {
      this.writer.append(header);
    } catch (IOException e) {
      e.printStackTrace();
    }
    //StringBuilder text = new StringBuilder();

    /*for (Map.Entry<String, List<Event>> entry : this.events.entrySet()) {
      text.append(this.createIndividualSVG(entry.getKey(), entry.getValue()));
    }
    return header + text + "\n</svg>";*/
    for (Map.Entry<String, List<Event>> entry : this.events.entrySet()) {
      try {
        this.writer.append(this.createIndividualSVG(entry.getKey(), entry.getValue()));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    try {
      this.writer.append("\n</svg>");
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      FileWriter var = (FileWriter) this.writer;
      var.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return this.writer.toString();
  }

  /**
   * Helper method facilitating start of animation.
   */
  @Override
  public void runView() {
    this.createFullSVG();
  }
}
