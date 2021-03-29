package cs5004.animator;

/**
 * Represents a Shape object.
 */
public interface Shape {

  /**
   * Set the shape's position.
   * @param x x coordinate, a double
   * @param y y coordinate, a double
   */
  void setPos(double x, double y);

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
   * Set the shape's width.
   * @param width shape's width, a double
   * @throws IllegalArgumentException if the width <= 0
   */
  void setWidth(double width) throws IllegalArgumentException;

  /**
   * Set the shape's height.
   * @param height shape's height, a double
   * @throws IllegalArgumentException if the height <= 0
   */
  void setHeight(double height) throws IllegalArgumentException;

  /**
   * Set the red pigment of the shape.
   * @param red red pigment, a double
   * @throws IllegalArgumentException if red < 0 || red > 255
   */
  void setRed(double red) throws IllegalArgumentException;

  /**
   * Set the blue pigment of the shape.
   * @param blue red pigment, a double
   * @throws IllegalArgumentException if blue < 0 || blue > 255
   */
  void setBlue(double blue) throws IllegalArgumentException;

  /**
   * Set the green pigment of the shape.
   * @param green red pigment, a double
   * @throws IllegalArgumentException if green < 0 || green > 255
   */
  void setGreen(double green) throws IllegalArgumentException;

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
   * Set the shape's name.
   * @param name, a String
   * @throws IllegalArgumentException if name is null or empty
   */
  void setName(String name) throws IllegalArgumentException;
}
