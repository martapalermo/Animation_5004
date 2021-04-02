package cs5004.animator;

public class ScaleWidth extends AbstractEvent {
  private final double originalWidth;
  private final double height;
  private final double width;


  public ScaleWidth(String shapeName, int start, int stop, double width, double originalWidth, double height) {
    super(shapeName, start, stop);
    this.width = width;
    this.height = height;
    this.originalWidth = originalWidth;
  }

  @Override
  public String toString() {
    return "Shape " + this.getShapeName() + " scales from Width: " + originalWidth + ", Height: "
        + height + "to Width: " + this.width + ", Height: " + this.height + "from t="
        + this.getStart() + "to t=" + this.getStop();
  }

  /**
   * Get the event type.
   *
   * @return event name, a String
   */
  @Override
  public String getEvent() {
    return null;
  }

  /**
   * Sets the given shape's new values based on the event that occurred.
   *
   * @param shape shape to be transformed
   */
  @Override
  public void setValues(Shape shape) {

  }
}
