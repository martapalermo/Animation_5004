package cs5004.animator.model;

/**
 * This is the Scale class. It represents the scaling event/transformation that a shape can undergo.
 * This class extends AbstractEvent.
 */
public class Scale extends AbstractEvent {
  private final double originalWidth;
  private final double originalHeight;
  private final double height;
  private final double width;

  /**
   * Scale event/transformation constructor.
   *
   * @param shapeName name of the shape, String
   * @param start start tick, start of the event, int
   * @param stop stop tick, end of the event, int
   * @param width new width of shape, double
   * @param originalWidth original width of the shape before transformation, double
   * @param height new height of shape, double
   * @param originalHeight original height of the shape before transformation, double
   */
  public Scale(String shapeName, int start, int stop, double width, double originalWidth, double
          height, double originalHeight) {
    super(shapeName, start, stop);
    this.width = width;
    this.height = height;
    this.originalWidth = originalWidth;
    this.originalHeight = originalHeight;
  }

  /**
   * toString method outlining the scaling event.
   * @return toString with original dimensions (width,height), new dimensions and
   *        the start and stop ticks for the movement time.
   */
  @Override
  public String toString() {
    return "Shape " + this.getShapeName() + " scales from Width: " + originalWidth + ", Height: "
        + originalHeight + " to Width: " + this.width + ", Height: " + this.height + " from t="
        + this.getStart() + " to t=" + this.getStop();
  }

  /**
   * Get the event type.
   * @return event name, a String
   */
  @Override
  public String getEvent() {
    return "scale";
  }

  /**
   * Sets the given shape's new values based on the event that occurred.
   * @param shape shape to be transformed
   */
  @Override
  public void setValues(Shape shape) {
    shape.setDimension(this.width, this.height);
  }
}
