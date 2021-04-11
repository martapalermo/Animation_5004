package cs5004.animator.model.shape;

/**
 * This is the Dimension class. It represents the size of a shape
 * through width and height values.
 */
public class Dimension {
  protected int width;
  protected int height;

  /**
   * Dimensions constructor takes two doubles for width and height of the shape.
   * @param width width of the shape, int
   * @param height height of the shape, int
   */
  public Dimension(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public Dimension() {
  }

  /**
   * Get the shape's width.
   * @return width, int
   */
  public int getWidth() {
    return this.width;
  }

  /**
   * Get the shape's height.
   * @return height, int
   */
  public int getHeight() {
    return this.height;
  }

  /**
   * Setter method for width of the shape.
   * @param sWidth width being set as the new width for the shape, int
   */
  public void setWidth(int sWidth) {
    this.width = sWidth;
  }

  /**
   * Setter method for height of the shape.
   * @param sHeight height being set as the new height for the shape, int
   */
  public void setHeight(int sHeight) {
    this.height = sHeight;
  }
}
