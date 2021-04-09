package cs5004.animator.model.animation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.Shape;
import cs5004.animator.util.AnimationBuilder;

/**
 * This is the Animator Model class. It implements the Animator interface.
 */
public class AnimatorModel implements Animator {
  private final List<Shape> shapes;
  private final HashMap<String, List<Event>> events;
  private int[] canvas;

  /**
   * Animator Model constructor. The constructor doesn't take any parameters. It instantiates two
   * different data structures: An ArrayList for the collection of shapes involved in the animation,
   * and a HashMap where the list of shapes is organized by event types.
   */
  public AnimatorModel() {
    this.shapes = new ArrayList<>();
    this.events = new HashMap<>();
    this.canvas = new int[4];
  }

//  private AnimatorModel(AnimationBuilder builder) {
////    this.shapes = builder.shapesList;
////    this.events = builder.eventsList;
//  }

  /**
   * Add a shape to the list.
   *
   * @param shape the {@link Shape} to be added to the list
   * @param name  a unique, non-empty, non-null name for the shape within the list, a String
   * @throws IllegalArgumentException if the shape is null
   */
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
    this.events.put(name, new ArrayList<>());
  }

  /**
   * Remove a shape from the list.
   *
   * @param name name of the shape to be removed
   * @throws NoSuchElementException if there is no shape with the given name
   */
  @Override
  public void removeShape(String name) throws NoSuchElementException {
    if (!(this.shapes.removeIf(s -> s.getName().equalsIgnoreCase(name)))) {
      throw new NoSuchElementException("No shape in this list has that name.");
    }
  }

  @Override
  public void initializeShape(String name, int start, int stop, int x1, int y1, int width1, int
          height1, int red1, int green1, int blue1) {
    for (Shape shape : this.shapes) {
      if (shape.getName().equalsIgnoreCase(name)) {
        if (!shape.isInitialized()) {
          shape.setAppearTime(start);
          shape.setDisappearTime(stop);
          shape.setPos(x1, y1);
          shape.setDimension(width1, height1);
          shape.setColor(red1, green1, blue1);
          shape.setInitialized();
        }

        if (stop > shape.getDisappearTime()) {
          shape.setDisappearTime(stop);
        }
      }
    }
    this.shapes.sort(Comparator.comparingInt(Shape::getAppearTime));
  }

  @Override
  public void transform(String name, int start, int x1, int y1, int width1, int height1, int red1,
                        int green1, int blue1, int stop, int x2, int y2, int width2, int height2,
                        int red2, int green2, int blue2) {




  }

  /**
   * Move the given shape to the new position.
   *
   * @param name      the name of the {@link Shape} to be moved, a String
   * @param x         new x coordinate, int
   * @param y         new y coordinate, int
   * @param originalX old x coordinate, int
   * @param originalY old y coordinate, int
   * @param start     move start time, an int
   * @param stop      move stop time, an int
   * @throws IllegalArgumentException if the start or stop times are out of bounds of the shape's
   *                                  appear/disappear window, if the stop time is less than or
   *                                  equal to the start time, or if the shape is already moving in
   *                                  this window, or if no shape if the list has the given name
   */
  @Override
  public void move(String name, int x, int y, int originalX, int originalY, int start,
                   int stop) throws IllegalArgumentException {
    for (Shape shape : this.shapes) {
      if (shape.getName().equalsIgnoreCase(name)) {

        // Current characteristics of the shape about to be transformed
        Shape currentShape = this.getShape(name, start - 1);

        // Shape being transformed hasn't appeared yet
        if (currentShape == null) {

          if (shape.getX() != originalX || shape.getY() != originalY) {
            throw new IllegalArgumentException("Shape's original values are invalid.");
          }
        } else if (currentShape.getX() != originalX || currentShape.getY() != originalY) {
          throw new IllegalArgumentException("Shape's original values are invalid.");
        }

        // Check to see if shape is already moving in this window
        if (this.events.containsKey(name) && this.isTransforming(name, "move",
                start, stop)) {
          throw new IllegalArgumentException("This shape is already moving.");
        }

        Event move = new Move(shape, start, stop, x, y, originalX, originalY);

        this.events.get(name).add(move);
        this.events.get(name).sort(Comparator.comparingInt(Event::getStart));
        return;
      }
    }
    throw new IllegalArgumentException("No shape has this name.");
  }

  /**
   * Change the color of the given shape.
   *
   * @param name          the name of the {@link Shape} to change color, a String
   * @param red           new red value, int
   * @param blue          new blue value, int
   * @param green         new green value, int
   * @param originalRed   original red value, int
   * @param originalBlue  original blue value, int
   * @param originalGreen original green value, int
   * @param start         color change start time, an int
   * @param stop          color stop time, an int
   * @throws IllegalArgumentException if the start or stop times are out of bounds of the shape's
   *                                  appear/disappear window, if the stop time is less than or
   *                                  equal to the start time or if the shape is already changing
   *                                  colors in this window, or if the red, blue, or green values
   *                                  are out of range (0-255), or if no shape in the list has the
   *                                  given name
   */
  @Override
  public void changeColor(String name, int red, int green, int blue, int originalRed,
                          int originalGreen, int originalBlue, int start, int stop)
          throws IllegalArgumentException {

    if (red < 0 || red > 255 || blue < 0 || blue > 255 || green < 0 || green > 255) {
      throw new IllegalArgumentException("Invalid color.");
    }

    for (Shape shape : this.shapes) {
      if (shape.getName().equalsIgnoreCase(name)) {

        // Current characteristics of the shape about to be transformed
        Shape currentShape = this.getShape(name, start - 1);

        // Shape being transformed hasn't appeared yet
        if (currentShape == null) {
          if (shape.getRed() != originalRed || shape.getGreen() != originalGreen || shape.getBlue()
                  != originalBlue) {
            throw new IllegalArgumentException("Shape's original values are invalid.");
          }
        } else if (currentShape.getRed() != originalRed || currentShape.getGreen() != originalGreen
                || shape.getBlue() != originalBlue) {
          throw new IllegalArgumentException("Shape's original values are invalid.");
        }

        // Check to see if shape is already changing color in this window
        if (this.events.containsKey(name) && this.isTransforming(name, "change color",
                start, stop)) {
          throw new IllegalArgumentException("This shape is already changing color.");
        }

        Event changeColor = new ChangeColor(shape, start, stop, red, blue, green, originalRed,
                originalBlue, originalGreen);

        this.events.get(name).add(changeColor);
        this.events.get(name).sort(Comparator.comparingInt(Event::getStart));
        return;
      }
    }
    throw new IllegalArgumentException("No shape has this name.");
  }

  /**
   * Change the shape's scale.
   *
   * @param name           name of the {@link Shape} to be scaled, a String
   * @param width          new width, int
   * @param height         new height, int
   * @param originalHeight original height, int
   * @param originalWidth  original width, int
   * @param start          scaling start time, an int
   * @param stop           scaling stop time, an int
   * @throws IllegalArgumentException if the start or stop times are out of bounds of the shape's
   *                                  appear/disappear window, or if the shape's width and/or height
   *                                  is already scaling in this window, or if width and/or height
   *                                  <= 0, or if no shape in the list has the given name
   */
  @Override
  public void scaleShape(String name, int width, int height, int originalHeight, int
          originalWidth, int start, int stop) throws IllegalArgumentException {

    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Width/Height must be a non-zero positive number.");
    }

    for (Shape shape : this.shapes) {
      if (shape.getName().equalsIgnoreCase(name)) {

        // Current characteristics of the shape about to be transformed
        Shape currentShape = this.getShape(name, start - 1);

        // Shape being transformed hasn't appeared yet
        if (currentShape == null) {
          if (shape.getWidth() != originalWidth || shape.getHeight() != originalHeight) {
            throw new IllegalArgumentException("Shape's original values are invalid.");
          }
        } else if (currentShape.getWidth() != originalWidth || currentShape.getHeight()
                != originalHeight) {
          throw new IllegalArgumentException("Shape's original values are invalid.");
        }

        // Check to see if shape is already scaling in this window
        if (this.events.containsKey(name)
                && this.isTransforming(name, "scale", start, stop)) {
          throw new IllegalArgumentException("This shape is already scaling.");
        }

        Event scale = new Scale(shape, start, stop, width, originalWidth, height, originalHeight);

        this.events.get(name).add(scale);
        this.events.get(name).sort(Comparator.comparingInt(Event::getStart));
        return;
      }
    }
    throw new IllegalArgumentException("No shape has this name.");
  }

  /**
   * Returns a list of {@link Shape}s that appear on screen at the given tick.
   *
   * @param tick current frame, an int
   * @return List of {@link Shape}s on screen
   */
  @Override
  public List<Shape> getCurrentShapes(int tick) {

    List<Shape> currentShapes = new ArrayList<>();
    for (Shape shape : this.shapes) {
      if (shape.getAppearTime() <= tick && shape.getDisappearTime() > tick) {
        Shape copy = shape.copy();
        if (this.events.containsKey(shape.getName())) {
          this.transformShape(copy, tick);
        }
        currentShapes.add(copy);
      }
    }
    return currentShapes;
  }

  /**
   * A text description of the animation.
   *
   * @return animation description, a String
   */
  @Override
  public String getAnimation() {
    return "Shapes:\n" + this.shapeInformation() + this.eventInformation();
  }

  // THROW EXCEPTIONS

  // CHECK ORIGINAL VALUES AGAINST CURRENT VALUES
//  private void staticEvent(String name, int x, int y, int width, int height, int red, int green,
//                           int blue, int start, int stop) {
//    for (Shape shape : this.shapes) {
//
//    }
//  }

  /**
   * Private helper method that checks if the shape being passed is already doing something.
   *
   * @param name  shape name, String
   * @param event event identifier, String
   * @param start start tick/time, int
   * @param stop  end tick/time, int
   * @return returns a boolean: true if the shape is undergoing a transformation, false if it isn't.
   */
  private boolean isTransforming(String name, String event, int start, int stop) {
    List<Event> transformations = this.events.get(name);

    for (Event transformation : transformations) {
      if (transformation.getEvent().equalsIgnoreCase(event) && ((transformation.getStart() >= start
              && transformation.getStop() < stop) || (transformation.getStart() <= stop
              && transformation.getStop() > stop) || (transformation.getStart() <= start
              && transformation.getStop() > start))) {
        return true;
      }
    }
    return false;
  }

  /**
   * Helper methods that transforms shape being passed at a specific tick - like a setter.
   *
   * @param shape shape being transformed
   * @param tick  tick point at which the shape transforms, int
   */
  private void transformShape(Shape shape, int tick) {
    for (Event event : this.events.get(shape.getName())) {
      if (event.getStart() <= tick && event.getStop() > tick) {
        event.setValues(shape, tick);
      }

      // Tick is outside start/stop time of the event but no other event of the same kind has
      // happened
      else if (tick >= event.getStop()) {
        event.setValues(shape, tick);
        return;
      }
    }
  }

  /**
   * Helper private method that retrieves the toString for shape information.
   *
   * @return toString with shape information/values etc, String
   */
  private String shapeInformation() {
    String information = "";

    for (Shape shape : this.shapes) {
      information += shape.toString() + "\n";
    }
    return information;
  }

  /**
   * Helper method that retrieves information about the transformations/events that the shapes have
   * completed.
   *
   * @return toString with the list of all event representations, String
   */
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

  /**
   * Helper method for events to determine if the incoming original values are valid.
   *
   * @param name shape name that is transforming, a String
   * @param tick the tick one unit before the start of the transformation
   * @return shape that is being transformed with current attributes, null if the shape hasn't
   * appeared yet
   */
  private Shape getShape(String name, int tick) {
    List<Shape> currentShapes = this.getCurrentShapes(tick);

    for (Shape shape : currentShapes) {
      if (shape.getName().equalsIgnoreCase(name)) {
        return shape;
      }
    }
    return null;
  }

  private boolean isInBounds(int x, int y, int width, int height) {
    return true;
  }

  protected void setBounds(int x, int y, int width, int height) {
    this.canvas = new int[]{x, y, width, height};
  }

  public int[] getCanvas() {
    return this.canvas;
  }

  public static class AnimationBuilderImpl implements AnimationBuilder<Animator> {
    private Animator model = new AnimatorModel();

    /**
     * Constructs a final document.
     *
     * @return the newly constructed document
     */
    @Override
    public Animator build() {
      return model;
    }

    /**
     * // this will take the input from txt file: parse at canvas Specify the bounding box to be
     * used for the animation.
     *
     * @param x      The leftmost x value
     * @param y      The topmost y value
     * @param width  The width of the bounding box
     * @param height The height of the bounding box
     * @return This {@link AnimationBuilder}
     */
    @Override
    public AnimationBuilder setBounds(int x, int y, int width, int height) {
      return this;
    }

    /**
     * Adds a new shape to the growing document.
     *
     * @param name The unique name of the shape to be added. No shape with this name should already
     *             exist.
     * @param type The type of shape (e.g. "ellipse", "rectangle") to be added. The set of supported
     *             shapes is unspecified, but should include "ellipse" and "rectangle" as a
     *             minimum.
     * @throws IllegalArgumentException if the name is empty, null, or already exists for a shape in
     *                                  the list, or if the shape type doesn't exist
     * @return This {@link AnimationBuilder}
     */
    @Override
    public AnimationBuilder declareShape(String name, String type) {
      if (type.equalsIgnoreCase("rectangle")) {
        Shape rect = new Rectangle();
        this.model.addShape(rect, name);
      }

      else if (type.equalsIgnoreCase("ellipse")) {
        Shape oval = new Oval();
        this.model.addShape(oval, name);
      }

      else {
        throw new IllegalArgumentException("Invalid shape type.");
      }
      return this;
    }

    /**
     * Adds a transformation to the growing document.
     *
     * @param name The name of the shape (added with {@link AnimationBuilder#declareShape})
     * @param t1   The start time of this transformation
     * @param x1   The initial x-position of the shape
     * @param y1   The initial y-position of the shape
     * @param w1   The initial width of the shape
     * @param h1   The initial height of the shape
     * @param r1   The initial red color-value of the shape
     * @param g1   The initial green color-value of the shape
     * @param b1   The initial blue color-value of the shape
     * @param t2   The end time of this transformation
     * @param x2   The final x-position of the shape
     * @param y2   The final y-position of the shape
     * @param w2   The final width of the shape
     * @param h2   The final height of the shape
     * @param r2   The final red color-value of the shape
     * @param g2   The final green color-value of the shape
     * @param b2   The final blue color-value of the shape
     * @return This {@link AnimationBuilder}
     */
    @Override
    public AnimationBuilder addMotion(String name,
                                      int t1, int x1, int y1, int w1, int h1, int r1, int g1,
                                      int b1, int t2, int x2, int y2, int w2, int h2, int r2,
                                      int g2, int b2) {

      this.model.initializeShape(name, t1, t2, x1, y1, w1, h1, r1, g1, b1);

      if (x1 != x2 || y1 != y2) {
        this.model.move(name, x2, y2, x1, y1, t1, t2);
      }

      if (r1 != r2 || g1 != g2 || b1 != b2) {
        this.model.changeColor(name, r2, g2, b2, r1, g1, b1, t1, t2);
      }

      if (h1 != h2 || w1 != w2) {
        this.model.scaleShape(name, w2, h2, h1, w1, t1, t2);
      }

      if (x1 == x2 && y1 == y2 && w1 == w2 && h1 == h2 && r1 == r2 && g1 == g2 && b1 == b2) {
        this.model.move(name, x2, y2, x1, y1, t1, t2);
        this.model.changeColor(name, r2, g2, b2, r1, g1, b1, t1, t2);
        this.model.scaleShape(name, w2, h2, h1, w1, t1, t2);
      }
      // Incorporate tween formula


      return this;
    }
  }
}
