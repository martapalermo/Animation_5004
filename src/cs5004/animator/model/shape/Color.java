package cs5004.animator.model.shape;

/**
 * This class represents the colors of the shapes in the animation.
 */
public class Color {
  protected int red;
  protected int green;
  protected int blue;

  /**
   * Color constructor takes three parameters.
   * @param red red pigment, int
   * @param green green pigment, int
   * @param blue blue pigment, int
   */
  public Color(int red, int green, int blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * Get the value of the shape's red pigment.
   * @return red pigment, int
   */
  public int getRed() {
    return red;
  }

  /**
   * Get the value of the shape's green pigment.
   * @return green pigment, int
   */
  public int getGreen() {
    return green;
  }

  /**
   * Get the value of the shape's blue pigment.
   * @return blue pigment, int
   */
  public int getBlue() {
    return blue;
  }

  /**
   * Setter method - sets the value for the red pigment of the shape.
   * @param red red pigment, int
   */
  public void setRed(int red) {
    this.red = red;
  }

  /**
   * Setter method - sets the value for the green pigment of the shape.
   * @param green green pigment, int
   */
  public void setGreen(int green) {
    this.green = green;
  }

  /**
   * Setter method - sets the value for the blue pigment of the shape.
   * @param blue blue pigment, int
   */
  public void setBlue(int blue) {
    this.blue = blue;
  }
}
