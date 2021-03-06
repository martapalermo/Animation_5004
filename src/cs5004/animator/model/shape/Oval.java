package cs5004.animator.model.shape;

/**
 * This is the Oval class. It represents an oval shape. This class extends AbstractShape.
 */
public class Oval extends AbstractShape {
  private int xRadius;
  private int yRadius;

  /**
   * Oval shape constructor for when initial values are known.
   *
   * @param x x-value of the oval for Point reference, int
   * @param y y-value of the oval for Point reference, int
   * @param appearTime appearTime of the oval for Time appearance, int
   * @param disappearTime disappearingTime of the oval for Time appearance, int
   * @param width width of the oval for Dimension size, int
   * @param height height of the oval for Dimension size, int
   * @param red red pigment, int
   * @param green green pigment, int
   * @param blue blue pigment, int
   * @throws IllegalArgumentException thrown if appearance time is before 0, if appearance time is
   *      after disappearance time, if width or height are <= 0, if red, green and/or blue values
   *      are greater than 255 or less than 0.
   */
  public Oval(int x, int y, int appearTime, int disappearTime, int width, int height,
      int red, int green, int blue) throws IllegalArgumentException {
    super(x, y, appearTime, disappearTime, width, height, red, green, blue);

    this.xRadius = this.getWidth() / 2;
    this.yRadius = this.getHeight() / 2;
    this.type = ShapeType.OVAL;
  }

  /**
   * Oval empty constructor.
   */
  public Oval() {
    this.type = ShapeType.OVAL;
  }

  @Override
  public void setDimension(int width, int height) throws IllegalArgumentException {
    super.setDimension(width, height);
    this.xRadius = width / 2;
    this.yRadius = height / 2;
  }

  /**
   * Get the SVG description of an event.
   *
   * @return SVG description, a String
   */
  @Override
  public String getSVG() {
    return "<ellipse id=\"" + this.getName() + "\" cx=\"" + this.getX() + "\" cy=\""
            + this.getY() + "\" rx=\"" + this.xRadius + "\" ry=\"" + this.yRadius
            + "\" fill=\"rgb(" + this.getRed() + "," + this.getGreen() + "," + this.getBlue()
            + ")\" " + " >\n";
  }

  /**
   * Get the shape type.
   * @return shape's type, a String
   */
  @Override
  public String getType() {
    return this.type.toString();
  }

  /**
   * Copies the shape.
   * @return copy of the shape
   */
  @Override
  public Shape copy() {
    Shape copy = new Oval(this.getX(), this.getY(), this.getAppearTime(), this.getDisappearTime(),
        this.getWidth(), this.getHeight(), this.getRed(), this.getGreen(), this.getBlue());
    copy.setName(this.name);
    return copy;
  }

  /**
   * Get the SVG formatting for the end of the shape's SVG declaration.
   * @return SVG shape type, a String
   */
  @Override
  public String getSVGType() {
    return "</ellipse>\n";
  }

  /**
   * Get scale attributes for shape's SVG documentation.
   * @return names of scale SVG attributes, a String array
   */
  @Override
  public String[] getScaleSVG() {
    return new String[]{"rx", "ry"};
  }

  /**
   * Get move attributes for shape's SVG documentation.
   * @return names of move SVG attributes, a String array
   */
  @Override
  public String[] getMoveSVG() {
    return new String[]{"cx", "cy"};
  }

  /**
   * toString method with all features of the oval shape.
   * @return toString for oval shape
   */
  @Override
  public String toString() {
    return "Name: " + this.getName() + "\n"
            + "Type: " + this.type.toString() + "\n" + "Center: (" + this.getX() + ","
            + this.getY() + "), " + "X radius: " + this.xRadius + ", " + "Y radius: " + yRadius
            + ", " + "Color: (" + this.getRed() + "," + this.getGreen() + "," + this.getBlue()
            + ")\n" + "Appears at t=" + getAppearTime() + "\n" + "Disappears at t="
            + getDisappearTime() + "\n";
  }
}
