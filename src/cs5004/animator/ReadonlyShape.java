package cs5004.animator;

/**
 * Create a Readonly Shape (only allows access to getters).
 */
public interface ReadonlyShape {

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

  //TODO: Added getColor but we can take this out!

  /**
   * Get the whole RGB values of the color being used on the shape.
   * @return String of doubles: red, green, blue
   */
  String getColor();

  /**
   * Get the value of the shape's red pigment.
   * @return red pigment, a double
   */
  double getRed();

  /**
   * Get the value of the shape's blue pigment.
   * @return blue pigment, a double
   */
  double getBlue();

  /**
   * Get the value of the shape's green pigment.
   * @return green pigment, a double
   */
  double getGreen();

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
