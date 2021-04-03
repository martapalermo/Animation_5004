package cs5004.animator.model;

/**
 * This class implements the Shape interface, and represents an Abstract Shape.
 */
public abstract class AbstractShape implements Shape {

  protected Point reference;
  protected String name = "";
  protected Time appearance;
  protected Dimension dimension;
  protected Color colorValues;

  /**
   * AbstractShape Constructor.
   * @param x x-value of the shape for Point reference, double
   * @param y y-value of the shape for Point reference, double
   * @param appearTime appearTime of the shape for Time appearance, int
   * @param disappearTime disappearingTime of the shape for Time appearance, int
   * @param width width of the shape for Dimension size, double
   * @param height height of the shape for Dimension size, double
   * @param red red pigment, double
   * @param green green pigment, double
   * @param blue blue pigment, double
   * @throws IllegalArgumentException thrown if appearance time is before 0, if appearance time is
   * after disappearance time, if width or height are <= 0, if red, green and/or blue values are
   * greater than 255 or less than 0.
   */
  public AbstractShape(double x, double y, int appearTime, int disappearTime, double width,
                       double height, double red, double green, double blue)
      throws IllegalArgumentException {
    // Need to figure out coordinate boundaries
    this.reference = new Point(x, y);

    if (appearTime < 1) {
      throw new IllegalArgumentException("The appearance time must be at or after 0.");
    }
    this.appearance = new Time(appearTime, disappearTime);

    if (disappearTime <= appearTime) {
      throw new IllegalArgumentException("The disappearance time must be "
          + "after the appearance time.");
    }
    this.appearance = new Time(appearTime, disappearTime);

    // could these two be refactored? <if width <=0 || height <= 0 { throw argument....
    if (width <= 0) {
      throw new IllegalArgumentException("Width must be greater than 0.");
    }
    this.dimension = new Dimension(width, height);
    //this.width = width;

    if (height <= 0) {
      throw new IllegalArgumentException("Height must be greater than 0.");
    }
    this.dimension = new Dimension(width, height);
    //this.height = height;

    if (red < 0 || red > 255) {
      throw new IllegalArgumentException("Invalid value for red: must be between 0 and 255");
    }
    if (blue < 0 || blue > 255) {
      throw new IllegalArgumentException("Invalid value for blue: must be between 0 and 255");
    }
    if (green < 0 || green > 255) {
      throw new IllegalArgumentException("Invalid value for green: must be between 0 and 255");
    }
    this.colorValues = new Color(red,green,blue);
  }

  /**
   * Set the shape's position.
   * @param x x coordinate, a double
   * @param y y coordinate, a double
   *          potentially throwIllegalArgument if pos is outside of the screen?
   */
  @Override
  public void setPos(double x, double y) {
    this.reference.setX(x);
    this.reference.setY(y);
  }

  /**
   * Get the shape's x coordinate
   * @return x coordinate, a double
   */
  @Override
  public double getX() {
    return this.reference.x;
  }

  /**
   * Get the shape's y coordinate.
   * @return y coordinate, a double
   */
  @Override
  public double getY() {
    return this.reference.y;
  }

  /**
   * Get the shape's appear time.
   * @return appear time, an int
   */
  @Override
  public int getAppearTime() {
    return this.appearance.appearTime;
  }

  /**
   * Get the shape's disappear time.
   * @return disappear time, an int
   */
  @Override
  public int getDisappearTime() {
    return this.appearance.disappearTime;
  }

  /**
   * Get the shape's width.
   * @return width, a double
   */
  @Override
  public double getWidth() {
    return this.dimension.width;
  }

  /**
   * Get the shape's height.
   * @return height, a double
   */
  @Override
  public double getHeight() {
    return this.dimension.height;
  }

  /**
   * Set the shape's width and height.
   * @param width shape's width, a double
   * @param height shape's height, a double
   * @throws IllegalArgumentException if width and/or height <= 0
   */
  @Override
  public void setDimension(double width, double height) throws IllegalArgumentException {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Width/Height both must be greater than 0.");
    }
    this.dimension.setWidth(width);
    this.dimension.setHeight(height);
  }

  /**
   * Set the color of the shape with the given pigments
   * @param red red pigment, a double
   * @param blue blue pigment, a double
   * @param green green pigment, a double
   * @throws IllegalArgumentException if red < 0 || red > 255 || blue < 0 || blue > 255
   * || green < 0 || green > 255
   */
  @Override
  public void setColor(double red, double blue, double green) throws IllegalArgumentException {
    if (red < 0 || red > 255) {
      throw new IllegalArgumentException("Invalid value for red: must be between 0 and 255");
    }
    this.colorValues.setRed(red);

    if (blue < 0 || blue > 255) {
      throw new IllegalArgumentException("Invalid value for blue: must be between 0 and 255");
    }
    this.colorValues.setBlue(blue);

    if (green < 0 || green > 255) {
      throw new IllegalArgumentException("Invalid value for green: must be between 0 and 255");
    }
    this.colorValues.setGreen(green);
  }

  // TODO: should we add a getColor instead of individual getRed/getGreen/getBlue?

  //  @Override
  //  public String getColor() {
  //    return "(" + this.red + ", " + this.green + ", " + this.blue + ")";
  //  }

  /**
   * Get the value of the shape's red pigment.
   * @return red pigment, a double
   */
  @Override
  public double getRed() {
    return this.colorValues.red;
  }

  /**
   * Get the value of the shape's green pigment.
   * @return green pigment, a double
   */
  @Override
  public double getGreen() {
    return this.colorValues.green;
  }

  /**
   * Get the value of the shape's blue pigment.
   * @return blue pigment, a double
   */
  @Override
  public double getBlue() {
    return this.colorValues.blue;
  }

  /**
   * Get the shape's name.
   * @return name, a String
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * Set the shape's name.
   * @param name, a String
   * @throws IllegalArgumentException if name is null or empty
   */
  @Override
  public void setName(String name) throws IllegalArgumentException {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name cannot be null or empty.");
    }
    this.name = name;
  }
}
