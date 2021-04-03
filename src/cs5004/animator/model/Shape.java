package cs5004.animator.model;

/**
 * Represents a Shape object.
 */
public interface Shape {

  /**
   * Set the shape's position.
   * @param x x coordinate, a double
   * @param y y coordinate, a double
   *          potentially throwIllegalArgument if pos is outside of the screen?
   */
  void setPos(double x, double y);

  /**
   * Set the shape's width and height.
   * @param width shape's width, a double
   * @param height shape's height, a double
   * @throws IllegalArgumentException if width and/or height <= 0
   */
  void setDimension(double width, double height) throws IllegalArgumentException;

  /**
   * Set the color of the shape with the given pigments
   * @param red red pigment, a double
   * @param blue blue pigment, a double
   * @param green green pigment, a double
   * @throws IllegalArgumentException if red < 0 || red > 255 || blue < 0 || blue > 255
   * || green < 0 || green > 255
   */
  void setColor(double red, double green, double blue) throws IllegalArgumentException;

  /**
   * Set the shape's name.
   * @param name, a String
   * @throws IllegalArgumentException if name is null or empty
   */
  void setName(String name) throws IllegalArgumentException;

  /**
   * Get the shape's x coordinate
   * @return x coordinate, a double
   */
  double getX();

  /**
   * Get the shape's y coordinate.
   * @return y coordinate, a double
   */
  double getY();

  /**
   * Get the shape's appear time.
   * @return appear time, an int
   */
  int getAppearTime();

  /**
   * Get the shape's disappear time.
   * @return disappear time, an int
   */
  int getDisappearTime();

  /**
   * Get the shape's width.
   * @return width, a double
   */
  double getWidth();

  /**
   * Get the shape's height.
   * @return height, a double
   */
  double getHeight();

  /**
   * Get the value of the shape's red pigment.
   * @return red pigment, a double
   */
  double getRed();

  /**
   * Get the value of the shape's green pigment.
   * @return green pigment, a double
   */
  double getGreen();

  /**
   * Get the value of the shape's blue pigment.
   * @return blue pigment, a double
   */
  double getBlue();

  /**
   * Get the shape's name.
   * @return name, a String
   */
  String getName();

  /**
   * Copies the shape.
   * @return copy of the shape
   */
  Shape copy();
}