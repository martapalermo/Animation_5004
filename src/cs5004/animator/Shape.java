package cs5004.animator;

/**
 * Represents a Shape object.
 */
public interface Shape extends ReadonlyShape {

  /**
   * Set the shape's position.
   * @param x x coordinate, a double
   * @param y y coordinate, a double
   *          potentially throwIllegalArgument if pos is outside of the screen?
   */
  void setPos(double x, double y);

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
}
