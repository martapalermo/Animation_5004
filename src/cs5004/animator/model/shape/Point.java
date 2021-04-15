package cs5004.animator.model.shape;

/**
 * This is the point class. It represents a space on a plane where the shapes are located.
 */
class Point {
  protected int x;
  protected int y;

  /**
   * Point constructor takes two doubles for x and y coordinates.
   * @param x x-value coordinate, int
   * @param y y-value coordinate, int
   */
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }


  /**
   * Empty Point constructor for uninitialized shapes.
   */
  public Point() {
    // empty constructor for testing
  }

  /**
   * Getter method for x value of coordinate.
   * @return returns the x value, int
   */
  public int getX() {
    return this.x;
  }

  /**
   * Getter method for y value of coordinate.
   * @return returns the y value, int
   */
  public int getY() {
    return this.y;
  }

  /**
   * Setter method for x value of coordinate.
   * @param x an new x value that will be set, int
   */
  public void setX(int x) {
    this.x = x;
  }

  /**
   * Setter method for y value of coordinate.
   * @param y an new y value that will be set, int
   */
  public void setY(int y) {
    this.y = y;
  }
}
