package cs5004.animator;

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
   * @param x
   * @param y
   * @param originalX
   * @param originalY
   */
  public Move(String shapeName, int start, int stop, double x, double y,
              double originalX, double originalY) {
    super(shapeName, start, stop);
    this.x = x;
    this.y = y;
    this.originalX = originalX;
    this.originalY = originalY;
  }

  @Override
  public String toString() {
    return "Shape " + this.getShapeName() + " moves from (" + originalX + "," + originalY + "to ("
        + this.x + "," + this.y + ") from t=" + this.getStart() + " to t=" + this.getStop() + "\n";
  }

  @Override
  public String getEvent() {
    return "move";
  }

  @Override
  public void setValues(Shape shape) {
    shape.setPos(this.x, this.y);
  }
}
