package cs5004.animator.model;

/**
 * This is the ChangeColor class. It represents the event/transformation
 * that changes the color of a shape.
 * This class extends AbstractEvent.
 */
class ChangeColor extends AbstractEvent {
  private final double originalRed;
  private final double originalBlue;
  private final double originalGreen;
  private final double red;
  private final double blue;
  private final double green;

  /**
   * ChangeColor event/transformation constructor.
   *
   * @param shapeName name of the shape, String
   * @param start start tick, start of the event, int
   * @param stop stop tick, end of the event, int
   * @param red new red pigment, double
   * @param green new green pigment, double
   * @param blue new blue pigment, double
   * @param originalRed original red pigment, double
   * @param originalGreen original green pigment, double
   * @param originalBlue original blue pigment, double
   */
  public ChangeColor(String shapeName, int start, int stop, double red, double green, double blue,
                     double originalRed, double originalGreen, double originalBlue) {
    super(shapeName, start, stop);
    this.red = red;
    this.blue = blue;
    this.green = green;
    this.originalRed = originalRed;
    this.originalBlue = originalBlue;
    this.originalGreen = originalGreen;
  }

  /**
   * toString method outlining the change of color event.
   * @return toString with original color pigments, new color pigments
   *        and the start and stop ticks for the movement time
   */
  @Override
  public String toString() {
    return "Shape " + this.getShapeName() + " changes color from (" + originalRed + ","
        + originalBlue + "," + originalGreen + ") to (" + this.red + "," + this.blue + ","
        + this.green + ") from t=" + this.getStart() + " to t=" + this.getStop();
  }

  /**
   * Get the event type.
   * @return event name, a String
   */
  @Override
  public String getEvent() {
    return "change color";
  }

  /**
   * Sets the given shape's new values based on the event that occurred.
   * @param shape shape to be transformed
   */
  @Override
  public void setValues(Shape shape) {
    shape.setColor(this.red, this.green, this.blue);
  }
}
