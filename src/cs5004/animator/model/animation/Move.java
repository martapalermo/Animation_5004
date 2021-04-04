package cs5004.animator.model.animation;

import cs5004.animator.model.shape.Shape;

/**
 * This is the Move class. It represents the move event/transformation that a shape can undergo.
 * This class extends AbstractEvent.
 */
class Move extends AbstractEvent {
  private final double originalX;
  private final double originalY;
  private final double x;
  private final double y;

  /**
   * Move event/transformation constructor.
   *
   * @param shapeName name of the shape, String
   * @param start start tick, start of the event, int
   * @param stop stop tick, end of the event, int
   * @param x x value for destination coordinate, double
   * @param y y value for destination coordinate, double
   * @param originalX starting x value for shape, double
   * @param originalY starting y value for shape, double
   */
  public Move(String shapeName, int start, int stop, double x, double y,
              double originalX, double originalY) {
    super(shapeName, start, stop);
    this.x = x;
    this.y = y;
    this.originalX = originalX;
    this.originalY = originalY;
  }

  /**
   * toString method outlining the move event.
   * @return toString with original coordinates, new coordinates and the start and stop ticks for
   *        the movement time
   */
  @Override
  public String toString() {
    return "Shape " + this.getShapeName() + " moves from (" + originalX + "," + originalY + ") to ("
        + this.x + "," + this.y + ") from t=" + this.getStart() + " to t=" + this.getStop();
  }

  /**
   * Get the event type.
   * @return event name, a String
   */
  @Override
  public String getEvent() {
    return "move";
  }

  /**
   * Sets the given shape's new values based on the event that occurred.
   * @param shape shape to be transformed
   */
  @Override
  public void setValues(Shape shape) {
    shape.setPos(this.x, this.y);
  }
}
