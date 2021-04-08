package cs5004.animator.model.shape;

/**
 * This class implements the Shape interface, and represents an Abstract Shape.
 */
public abstract class AbstractShape implements Shape {

  protected Point reference;
  protected String name = "";
  protected Time appearance;
  protected Dimension dimension;
  protected Color colorValues;
  protected boolean initialized;

  /**
   * AbstractShape Constructor for when initial values are known.
   * @param x x-value of the shape for Point reference, int
   * @param y y-value of the shape for Point reference, int
   * @param appearTime appearTime of the shape for Time appearance, int
   * @param disappearTime disappearingTime of the shape for Time appearance, int
   * @param width width of the shape for Dimension size, int
   * @param height height of the shape for Dimension size, int
   * @param red red pigment, int
   * @param green green pigment, int
   * @param blue blue pigment, int
   * @throws IllegalArgumentException thrown if appearance time is before 0, if appearance time is
   *      after disappearance time, if width or height are <= 0, if red, green and/or blue values
   *      are greater than 255 or less than 0.
   */
  public AbstractShape(int x, int y, int appearTime, int disappearTime, int width,
                       int height, int red, int green, int blue)
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

    this.initialized = false;
  }

  /**
   * AbstractShape constructor for when only the name is known.
   * @param name shape name, a String
   */
  public AbstractShape(String name) {
    this.name = name;
  }

  /**
   * Set the shape's position.
   * @param x x coordinate, int
   * @param y y coordinate, int
   *          potentially throwIllegalArgument if pos is outside of the screen?
   */
  @Override
  public void setPos(int x, int y) {
    this.reference.setX(x);
    this.reference.setY(y);
  }

  /**
   * Get the shape's x coordinate.
   * @return x coordinate, int
   */
  @Override
  public int getX() {
    return this.reference.x;
  }

  /**
   * Get the shape's y coordinate.
   * @return y coordinate, int
   */
  @Override
  public int getY() {
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
   * @return width, int
   */
  @Override
  public int getWidth() {
    return this.dimension.width;
  }

  /**
   * Get the shape's height.
   * @return height, int
   */
  @Override
  public int getHeight() {
    return this.dimension.height;
  }

  /**
   * Set the shape's width and height.
   * @param width shape's width, int
   * @param height shape's height, int
   * @throws IllegalArgumentException if width and/or height <= 0
   */
  @Override
  public void setDimension(int width, int height) throws IllegalArgumentException {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Width/Height both must be greater than 0.");
    }
    this.dimension.setWidth(width);
    this.dimension.setHeight(height);
  }

  /**
   * Set the color of the shape with the given pigments.
   * @param red red pigment, int
   * @param blue blue pigment, int
   * @param green green pigment, int
   * @throws IllegalArgumentException if red < 0 || red > 255 || blue < 0 || blue > 255
   *      || green < 0 || green > 255
   */
  @Override
  public void setColor(int red, int blue, int green) throws IllegalArgumentException {
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

  /**
   * Set the disappearance time for the shape.
   * @param time disappearance time, an int
   * @throws IllegalArgumentException if the time is <=0
   */
  @Override
  public void setDisappearTime(int time) throws IllegalArgumentException {
    this.appearance.setDisappearTime(time);
  }

  /**
   * Set the appearance time for the shape.
   * @param time appearance time, an int
   * @throws IllegalArgumentException if the time is <= 0
   */
  @Override
  public void setAppearTime(int time) throws IllegalArgumentException {
    this.appearance.setDisappearTime(time);
  }

  /**
   * Get the value of the shape's red pigment.
   * @return red pigment, int
   */
  @Override
  public int getRed() {
    return this.colorValues.red;
  }

  /**
   * Get the value of the shape's green pigment.
   * @return green pigment, int
   */
  @Override
  public int getGreen() {
    return this.colorValues.green;
  }

  /**
   * Get the value of the shape's blue pigment.
   * @return blue pigment, int
   */
  @Override
  public int getBlue() {
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
   * @param name a String
   * @throws IllegalArgumentException if name is null or empty
   */
  @Override
  public void setName(String name) throws IllegalArgumentException {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name cannot be null or empty.");
    }
    this.name = name;
  }

  /**
   * Set the shape's initialization status.
   */
  @Override
  public void setInitialized() {
    this.initialized = true;
  }

  /**
   * Get initialization status of the shape.
   * @return true if the shape is initialized, false otherwise
   */
  @Override
  public boolean isInitialized() {
    return this.initialized;
  }
}
