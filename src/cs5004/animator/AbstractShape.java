package cs5004.animator;

/**
 * This class implements the Shape interface.
 */
public abstract class AbstractShape implements Shape {

  protected Point reference;
  protected String name = "";
  protected int appearTime;
  protected int disappearTime;
  protected double width;
  protected double height;
  protected Color colorValues;


  public AbstractShape(double x, double y, int appearTime, int disappearTime, double width,
                       double height, double red, double blue, double green)
      throws IllegalArgumentException {
    // Need to figure out coordinate boundaries
    this.reference = new Point(x, y);

    if (appearTime < 1) {
      throw new IllegalArgumentException("The appearance time must be at or after 0.");
    }
    this.appearTime = appearTime;

    if (disappearTime <= appearTime) {
      throw new IllegalArgumentException("The disappearance time must be "
          + "after the appearance time.");
    }
    this.disappearTime = disappearTime;

    if (width <= 0) {
      throw new IllegalArgumentException("Width must be greater than 0.");
    }
    this.width = width;

    if (height <= 0) {
      throw new IllegalArgumentException("Height must be greater than 0.");
    }
    this.height = height;

    if (red < 0 || red > 255) {
      throw new IllegalArgumentException("Invalid value for red: must be between 0 and 255");
    }
    if (blue < 0 || blue > 255) {
      throw new IllegalArgumentException("Invalid value for blue: must be between 0 and 255");
    }
    if (green < 0 || green > 255) {
      throw new IllegalArgumentException("Invalid value for green: must be between 0 and 255");
    }
    this.colorValues = new Color(red,blue,green);
  }

  @Override
  public void setPos(double x, double y) {
    this.reference.setX(x);
    this.reference.setY(y);
  }

  @Override
  public double getX() {
    return this.reference.x;
  }

  @Override
  public double getY() {
    return this.reference.y;
  }

  @Override
  public int getAppearTime() {
    return this.appearTime;
  }

  @Override
  public int getDisappearTime() {
    return this.disappearTime;
  }

  @Override
  public double getWidth() {
    return this.width;
  }

  @Override
  public double getHeight() {
    return this.height;
  }

  @Override
  public void setWidth(double width) throws IllegalArgumentException {
    if (width <= 0) {
      throw new IllegalArgumentException("Width must be greater than 0.");
    }
    this.width = width;
  }

  @Override
  public void setHeight(double height) throws IllegalArgumentException {
    if (height <= 0) {
      throw new IllegalArgumentException("Height must be greater than 0.");
    }
    this.height = height;
  }

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


  @Override
  public double getRed() {
    return this.colorValues.red;
  }

  @Override
  public double getBlue() {
    return this.colorValues.blue;
  }

  @Override
  public double getGreen() {
    return this.colorValues.green;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setName(String name) throws IllegalArgumentException {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name cannot be null or empty.");
    }
    this.name = name;
  }
}
