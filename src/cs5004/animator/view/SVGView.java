package cs5004.animator.view;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cs5004.animator.model.animation.Event;
import cs5004.animator.model.animation.ReadonlyAnimator;
import cs5004.animator.model.shape.Shape;

public class SVGView extends WrittenView {
  private List<Shape> shapes;
  private LinkedHashMap<String, List<Event>> events;
  private int[] canvas;
  private int timeConverter;

  public SVGView(ReadonlyAnimator model, Appendable writer, int speed) {
    super(model, writer);

    this.shapes = this.model.copyShapesList();
    this.events = this.model.copyEventsList();
    this.canvas = this.model.getCanvas();
    this.timeConverter = 100 / speed;
  }

    private String createAnimateString(int oldValue, int newValue, int start, int stop, String
            attribute, String fill) {
      int duration = (stop - start) * this.timeConverter;
      int startConverted = start * this.timeConverter;

      return "\t\t<animate attributeType=\"xml\" begin=\"" + startConverted + "ms\" dur=\""
              + duration + "ms\" attributeName=\"" + attribute + "\" from=\"" + oldValue
              + "\" to=\"" + newValue + "\" fill=\"" + fill + "\" />\n";
    }

  private String createAnimateString(int oldRed, int oldGreen, int oldBlue, int newRed,
                                     int newGreen, int newBlue, int start, int stop, String fill) {
    int duration = (stop - start) * this.timeConverter;
    int startConverted = start * this.timeConverter;

    return "\t\t<animate attributeType=\"xml\" begin=\"" + startConverted + "ms\" dur=\""
            + duration + "ms\" attributeName=\"fill\" from=\"rgb(" + oldRed + "," + oldGreen + ","
            + oldBlue + ")\" to=\"rgn(" + newRed + "," + newGreen + "," + newBlue + ")\" fill=\""
            + fill + "\" />\n";
  }

  private Shape getShape(String shapeName) {
    for (Shape shape : this.shapes) {
      if (shapeName.equalsIgnoreCase(shape.getName())) {
        return shape;
      }
    }
    throw new IllegalArgumentException("No shape has this name.");
  }

  private String createHeaderString() {
    return "<svg width=\"" + this.canvas[2] + "\" height=\"" + this.canvas[3] + "\" "
            + "version=\"1.1\" viewBox=\"" + this.canvas[0] + " " + this.canvas[1] + " "
            + this.canvas[2] + " " + this.canvas[3] + "\"\n\txmlns=\"http://www.w3.org/2000/svg\""
            + ">\n";
  }

  private String createIndividualSVG(String shapeName, List<Event> events) {
    Shape currentShape = this.getShape(shapeName);
    StringBuilder text = new StringBuilder(currentShape.getSVG());

    for (Event event : events) {
      HashMap<String, int[]> eventValues = event.getValues();

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

  private String createFullSVG() {
    String header = this.createHeaderString();

    StringBuilder text = new StringBuilder();

    for (Map.Entry<String, List<Event>> entry : this.events.entrySet()) {
      text.append(this.createIndividualSVG(entry.getKey(), entry.getValue()));
    }

    return header + text +"\n</svg>";
  }

  /**
   * Helper method facilitating start of animation.
   */
    @Override
    public void go() {
      String text = this.createFullSVG();
      this.writeToFile(text);
    }
}
