package cs5004.animator.model;

/**
 * This is the Dimension class. It represents the size of a shape
 * through width and height values.
 */
public class Dimension {
  protected double width;
  protected double height;

  /**
   * Dimensions constructor takes two doubles for width and height of the shape.
   * @param width width of the shape, double
   * @param height height of the shape, double
   */
  public Dimension(double width, double height) {
    this.width = width;
    this.height = height;
  }

  /**
   * Get the shape's width.
   * @return width, double
   */
  public double getWidth() {
    return this.width;
  }

  /**
   * Get the shape's height.
   * @return height, double
   */
  public double getHeight() {
    return this.height;
  }

  /**
   * Setter method for width of the shape.
   * @param sWidth width being set as the new width for the shape, double
   */
  public void setWidth(double sWidth) {
    this.width = sWidth;
  }

  /**
   * Setter method for height of the shape.
   * @param sHeight height being set as the new height for the shape, double
   */
  public void setHeight(double sHeight) {
    this.height = sHeight;
  }
}
