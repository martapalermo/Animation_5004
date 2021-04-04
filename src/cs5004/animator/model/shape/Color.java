package cs5004.animator.model.shape;

/**
 * This class represents the colors of the shapes in the animation.
 */
public class Color {
  protected double red;
  protected double green;
  protected double blue;

  /**
   * Color constructor takes three parameters.
   * @param red red pigment, double
   * @param green green pigment, double
   * @param blue blue pigment, double
   */
  public Color(double red, double green, double blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * Get the value of the shape's red pigment.
   * @return red pigment, a double
   */
  public double getRed() {
    return red;
  }

  /**
   * Get the value of the shape's green pigment.
   * @return green pigment, a double
   */
  public double getGreen() {
    return green;
  }

  /**
   * Get the value of the shape's blue pigment.
   * @return blue pigment, a double
   */
  public double getBlue() {
    return blue;
  }

  /**
   * Setter method - sets the value for the red pigment of the shape.
   * @param red red pigment, double
   */
  public void setRed(double red) {
    this.red = red;
  }

  /**
   * Setter method - sets the value for the green pigment of the shape.
   * @param green green pigment, double
   */
  public void setGreen(double green) {
    this.green = green;
  }

  /**
   * Setter method - sets the value for the blue pigment of the shape.
   * @param blue blue pigment, double
   */
  public void setBlue(double blue) {
    this.blue = blue;
  }
}
