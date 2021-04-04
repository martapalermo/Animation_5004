package cs5004.animator.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

public class AnimatorModel implements Animator {
  private List<Shape> shapes;
  private HashMap<String, List<Event>> events;

  public AnimatorModel() {
    this.shapes = new ArrayList<>();
    this.events = new HashMap<>();
  }

  @Override
  public void addShape(Shape shape, String name) throws IllegalArgumentException {
    if (name == null) {
      throw new IllegalArgumentException("Name cannot be null.");
    }

    if (name.isEmpty()) {
      throw new IllegalArgumentException("Name cannot be empty.");
    }

    if (shape == null) {
      throw new IllegalArgumentException("Shape cannot be null.");
    }

    for (Shape s : this.shapes) {
      if (s.getName().equalsIgnoreCase(name)) {
        throw new IllegalArgumentException("A shape in this list already has that name.");
      }
    }

    shape.setName(name);
    this.shapes.add(shape);
    this.shapes.sort(Comparator.comparingInt(Shape::getAppearTime));
    this.events.put(name, new ArrayList<>());
  }

  @Override
  public void removeShape(String name) throws NoSuchElementException {
    if (!(this.shapes.removeIf(s -> s.getName().equalsIgnoreCase(name)))) {
      throw new NoSuchElementException("No shape in this list has that name.");
    }
  }

  @Override
  public void move(String name, double x, double y, int originalX, int originalY, int start,
                   int stop) throws IllegalArgumentException {

    for (Shape shape : this.shapes) {
      if (shape.getName().equalsIgnoreCase(name)) {
        if (start < shape.getAppearTime() && stop > shape.getDisappearTime()) {
          throw new IllegalArgumentException("Start/stop time is out of the shape's appear "
                  + "window.");
        }

        // Check to see if shape is already moving in this window
        if (this.events.containsKey(name) && this.isTransforming(name, "move",
                start, stop)) {
          throw new IllegalArgumentException("This shape is already moving.");
        }

        Event move = new Move(name, start, stop, x, y, originalX, originalY);

        this.events.get(name).add(move);
        this.events.get(name).sort(Comparator.comparingInt(Event::getStart));

        return;
      }
    }
    throw new IllegalArgumentException("No shape has this name.");
  }

  @Override
  public void changeColor(String name, double red, double green, double blue, double originalRed,
                          double originalGreen, double originalBlue, int start, int stop)
                          throws IllegalArgumentException {

    if (red < 0 || red > 255 || blue < 0 || blue > 255 || green < 0 || green > 255) {
      throw new IllegalArgumentException("Invalid color.");
    }

    for (Shape shape : this.shapes) {
      if (shape.getName().equalsIgnoreCase(name)) {

        if (start < shape.getAppearTime() && stop > shape.getDisappearTime()) {
          throw new IllegalArgumentException("Start/stop time is out of the shape's appear "
                  + "window.");
        }

        // Check to see if shape is already changing color in this window
        if (this.events.containsKey(name) && this.isTransforming(name, "change color",
                start, stop)) {
          throw new IllegalArgumentException("This shape is already changing color.");
        }

        Event changeColor = new ChangeColor(name, start, stop, red, blue, green, shape.getRed(),
                shape.getBlue(), shape.getGreen());

        this.events.get(name).add(changeColor);
        this.events.get(name).sort(Comparator.comparingInt(Event::getStart));
        return;
      }
    }
    throw new IllegalArgumentException("No shape has this name.");
  }

  @Override
  public void scaleShape(String name, double width, double height, double originalHeight, double
          originalWidth, int start, int stop) throws IllegalArgumentException {

    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Width/Height must be a non-zero positive number.");
    }

    for (Shape shape : this.shapes) {
      if (shape.getName().equalsIgnoreCase(name)) {

        if (start < shape.getAppearTime() && stop > shape.getDisappearTime()) {
          throw new IllegalArgumentException("Start/stop time is out of the shape's "
              + "appear window.");
        }

        // Check to see if shape is already scaling in this window
        if (this.events.containsKey(name)
            && this.isTransforming(name, "scale", start, stop)) {
          throw new IllegalArgumentException("This shape is already scaling.");
        }

        Event scale = new Scale(name, start, stop, width, originalWidth, height, originalHeight);

        this.events.get(name).add(scale);
        this.events.get(name).sort(Comparator.comparingInt(Event::getStart));
        return;
      }
    }
    throw new IllegalArgumentException("No shape has this name.");
  }

  // have it part of the move ?
  @Override
  public List<Shape> getCurrentShapes(int tick) {

    List<Shape> currentShapes = new ArrayList<>();
    for (Shape shape : this.shapes) {
      if (shape.getAppearTime() <= tick && shape.getDisappearTime() > tick) {

        Shape copy = shape.copy();
        if (this.events.get(shape.getName()).size() > 0) {
          this.transformShape(copy, tick);
        }
        currentShapes.add(copy);
      }
    }
    return currentShapes;
  }

  @Override
  public String getAnimation() {
    return "Shapes:\n" + this.shapeInformation() + this.eventInformation();
  }

  private boolean isTransforming(String name, String event, int start, int stop) {
    List<Event> transformations = this.events.get(name);

    for (Event transformation : transformations) {
      //System.out.println(transformation.toString());
      if ((transformation.getStart() > start || transformation.getStop() > stop) && transformation.getEvent().equalsIgnoreCase(event)) {

        return true;
      }
    }
    return false;
  }

  // in between method with time elapsed
  private void transformShape(Shape shape, int tick) {
    for (Event event : this.events.get(shape.getName())) {
      if (event.getStart() >= tick && event.getStop() < tick) {
        event.setValues(shape);
      }

      // Tick is outside start/stop time of the event but no other event of the same kind has
      // happened
      else if (tick > event.getStop()) {
        event.setValues(shape);
      }
    }
  }

  private String shapeInformation() {
    String information = "";

    for (Shape shape : this.shapes) {
      information += shape.toString() + "\n";
    }
    return information;
  }

  private String eventInformation() {
    List<Event> transformations = new ArrayList<>();

    // Create one list of all events from lists of individual shape events
    for (List<Event> shapeEvents : this.events.values()) {
      transformations.addAll(shapeEvents);
    }
    transformations.sort(Comparator.comparingInt(Event::getStart));

    //Create String representation of the events
    String[] information = new String[transformations.size()];
    for (int i = 0; i < information.length; i++) {
      information[i] = transformations.get(i).toString();
    }
    return String.join("\n", information);
  }
}
