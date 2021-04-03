package cs5004.animator;

/**
 * This is the point class. It represents a space on a plan where the shapes are located.
 */
class Point {
  protected double x;
  protected double y;

  /**
   * Point constructor takes two doubles for x and y coordinates.
   * @param x x-value coordinate, double
   * @param y y-value coordinate, double
   */
  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Getter method for x value of coordinate.
   * @return returns the x value, double
   */
  public double getX() {
    return this.x;
  }

  /**
   * Getter method for y value of coordinate.
   * @return returns the y value, double
   */
  public double getY() {
    return this.y;
  }

  /**
   * Setter method for x value of coordinate.
   * @param x an new x value that will be set, double
   */
  public void setX(double x) {
    this.x = x;
  }

  /**
   * Setter method for y value of coordinate.
   * @param y an new y value that will be set, double
   */
  public void setY(double y) {
    this.y = y;
  }
}
