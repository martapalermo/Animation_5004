package cs5004.animator.model.shape;

/**
 * This is the Rectangle class. It represents an rectangle shape. The fields and attributes are
 * extended form AbstractShape abstract class.
 */
public class Rectangle extends AbstractShape {

  /**
   * Rectangle shape constructor for when initial values are known.
   *
   * @param x x-value of the rectangle for Point reference, int
   * @param y y-value of the rectangle for Point reference, int
   * @param appearTime appearTime of the rectangle for Time appearance, int
   * @param disappearTime disappearingTime of the rectangle for Time appearance, int
   * @param width width of the rectangle for Dimension size, int
   * @param height height of the rectangle for Dimension size, int
   * @param red red pigment, int
   * @param green green pigment, int
   * @param blue blue pigment, int
   * @throws IllegalArgumentException thrown if appearance time is before 0, if appearance time is
   *      after disappearance time, if width or height are <= 0, if red, green and/or blue values
   *      are greater than 255 or less than 0.
   */
  public Rectangle(int x, int y, int appearTime, int disappearTime, int width,
                   int height, int red, int green, int blue)
      throws IllegalArgumentException {
    super(x, y, appearTime, disappearTime, width, height, red, green, blue);
    this.type = ShapeType.RECTANGLE;
  }

  public Rectangle() {
    this.type = ShapeType.RECTANGLE;
  }

  /**
   * Get the SVG description of an event.
   *
   * @return SVG description, a String
   */
  @Override
  public String getSVG() {
    return "<rect id=\"" + this.getName() + "\" x=\"" + this.getX() + "\" y=\""
            + this.getY() + "\" width=\"" + this.getWidth() + "\" height=\""
            + this.getHeight() + "\" fill=\"rgb(" + this.getRed() + "," + this.getGreen() + ","
            + this.getBlue() + ")\" " +  ">\n";
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
    Shape copy = new Rectangle(this.getX(), this.getY(), this.getAppearTime(),
            this.getDisappearTime(), this.getWidth(), this.getHeight(), this.getRed(),
            this.getGreen(), this.getBlue());
    copy.setName(this.name);
    return copy;
  }

  /**
   * Get the SVG formatting for the end of the shape's SVG declaration.
   * @return SVG shape type, a String
   */
  @Override
  public String getSVGType() {
    return "</rect>\n";
  }

  /**
   * Get scale attributes for shape's SVG documentation.
   * @return names of scale SVG attributes, a String array
   */
  @Override
  public String[] getScaleSVG() {
    return new String[]{"width", "height"};
  }

  /**
   * Get move attributes for shape's SVG documentation.
   * @return names of move SVG attributes, a String array
   */
  @Override
  public String[] getMoveSVG() {
    return new String[]{"x", "y"};
  }

  /**
   * toString method with all features of the rectangle shape.
   * @return toString for rectangle shape
   */
  @Override
  public String toString() {
    return "Name: " + this.getName() + "\n"
            + "Type: " + this.type.toString() + "\n" + "Min corner: (" + this.getX() + ","
            + this.getY() + "), " + "Width: " + getWidth() + ", " + "Height: " + getHeight() + ", "
            + "Color: (" + this.getRed() + "," + this.getGreen() + "," + this.getBlue() + ")\n"
            + "Appears at t=" + getAppearTime() + "\n"
            + "Disappears at t=" + getDisappearTime() + "\n";
  }
}
