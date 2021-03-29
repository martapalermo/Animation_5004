package cs5004.animator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ShapesListImpl implements ShapesList {
  private List<Shape> shapes;

  // Should this be a String or should the events be stored in a different way?
  private List<String> events;

  public ShapesListImpl() {
    this.shapes = new ArrayList<>();
    this.events = new ArrayList<>();
  }

  @Override
  public void addShape(Shape shape, String identifier) throws IllegalArgumentException {
    if (identifier == null) {
      throw new IllegalArgumentException("Identifier cannot be null.");
    }

    if (identifier.isEmpty()) {
      throw new IllegalArgumentException("Identifier cannot be empty.");
    }

    if (shape == null) {
      throw new IllegalArgumentException("Shape cannot be null.");
    }

    for (Shape s : this.shapes) {
      if (s.getName().equalsIgnoreCase(identifier)) {
        throw new IllegalArgumentException("A shape in this list already has that name.");
      }
    }

    shape.setName(identifier);
    this.shapes.add(shape);
  }

  @Override
  public void removeShape(String name) throws NoSuchElementException {
    if (!(this.shapes.removeIf(s -> s.getName().equalsIgnoreCase(name)))) {
      throw new NoSuchElementException("No shape in this list has that name.");
    }
  }

  @Override
  public void move(String name, double x, double y, int start, int stop) throws IllegalArgumentException {
    for (Shape shape : this.shapes) {
      if (shape.getName().equalsIgnoreCase(name)) {
        double oldX = shape.getX();
        double oldY = shape.getY();

        shape.setPos(x, y);
        this.events.add(String.format("Shape %s moves from (%f,%f) to (%f,%f) from t=%d to t=%d",
                name, oldX, oldY, x, y, start, stop));
      }
    }
    throw new IllegalArgumentException("No shape in this list has this name.");
  }

  @Override
  public void changeColor(String name, double red, double blue, double green, int start, int stop) throws IllegalArgumentException {
    for (Shape shape : this.shapes) {
      if (shape.getName().equalsIgnoreCase(name)) {
        double oldRed = shape.getRed();
        double oldBlue = shape.getBlue();
        double oldGreen = shape.getGreen();

        shape.setColor(red, blue, green);
        this.events.add(String.format("Shape %s changes color from (%f,%f,%f) to (%f,%f,%f) "
                + "from t=%d to t=%d", name, oldRed, oldBlue, oldGreen, red, blue, green,
                start, stop));
      }
    }
    throw new IllegalArgumentException("No shape in this list has this name.");
  }

  // Scale will probably end up being one method but slightly confused how it's going to be called
  // (i.e., always passing in a width/height even if only one is changing?)
  @Override
  public void scaleWidth(String name, double width, int start, int stop) throws IllegalArgumentException {
    if (width <= 0) {
      throw new IllegalArgumentException("Width must be a non-zero positive number.");
    }

    for (Shape shape : this.shapes) {
      if (shape.getName().equalsIgnoreCase(name)) {
        double oldWidth = shape.getWidth();

        shape.setWidth(width);
        // Need to add in handling to determine what type of Shape it is (Rectangle has width/height
        // and Oval has x radius/y radius)
        this.events.add(String.format("Shape %s changes scales from Width: %f, Height: %f to "
                + "Width: %f, Height: %f from t=%d to t=%d", shape, oldWidth, shape.getHeight(),
                width, shape.getHeight(), start, stop));
      }
    }
    throw new IllegalArgumentException("No shape in this list has this name.");
  }

  @Override
  public void scaleHeight(String name, double height, int start, int stop) throws IllegalArgumentException {
    // Same as above but too lazy to implement rn lol
  }

  @Override
  public ShapesList getCurrentShapes(int tick) {
    // Make new list so current one doesn't get mutated

    // Add copy method to Shape class??
    ShapesList currentShapes = new ShapesListImpl();
    this.shapes.stream().filter(s -> s.getAppearTime() >= tick && s.getDisappearTime() < tick).forEach(s -> currentShapes.addShape(s, s.getName()));
    return currentShapes;
  }
}
