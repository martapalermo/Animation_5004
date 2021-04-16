package cs5004.animator.model.animation;

import cs5004.animator.model.shape.Shape;

/**
 * This is the Move class. It represents the move event/transformation that a shape can undergo.
 * This class extends AbstractEvent.
 */
class Move extends AbstractEvent {
  private final int originalX;
  private final int originalY;
  private final int x;
  private final int y;

  /**
   * Move event/transformation constructor.
   *
   * @param shape shape to be transformed, {@link Shape}
   * @param start start tick, start of the event, int
   * @param stop stop tick, end of the event, int
   * @param x x value for destination coordinate, int
   * @param y y value for destination coordinate, int
   * @param originalX starting x value for shape, int
   * @param originalY starting y value for shape, int
   */
  public Move(Shape shape, int start, int stop, int x, int y, int originalX, int originalY) {
    super(shape, start, stop);
    this.x = x;
    this.y = y;
    this.originalX = originalX;
    this.originalY = originalY;
    this.addValues();
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
   * Sets the given shape's new values based on the event that occurred; calculate the in between
   * factor to multiply values by.
   * @param shape shape to be transformed
   */
  @Override
  public void setValues(Shape shape, int tick) {
    int currentX;
    int currentY;

    if (tick < this.stop) {
      currentX = (((this.originalX) * (this.stop - tick)) + ((this.x)
          * (tick - this.start))) / (this.stop - this.start);
      currentY = (((this.originalY) * (this.stop - tick)) + ((this.y)
          * (tick - this.start))) / (this.stop - this.start);
      shape.setPos(currentX, currentY);
    }

    else {
      shape.setPos(this.x, this.y);
    }
  }

  /**
   * Copy the Event.
   * @return copied Event
   */
  @Override
  public Event copy() {
    Event copy = new Move(this.shape.copy(), this.start, this.stop, this.x, this.y, this.originalX,
            this.originalY);
    return copy;
  }

  /**
   * toString method outlining the move event.
   * @return toString with original coordinates, new coordinates and the start and stop ticks for
   *        the movement time
   */
  @Override
  public String toString() {
    return "Shape " + this.getShapeName() + " moves from (" + originalX + "," + originalY
        + ") to (" + this.x + "," + this.y + ") from t=" + this.getStart() + " to t="
        + this.getStop();
  }

  /**
   * Add the event values to the HashMap to be used to create the SVG in the view.
   */
  private void addValues() {
    String[] moveTypes = this.shape.getMoveSVG();

    if (this.x != this.originalX) {
      this.values.put(moveTypes[0], new int[]{this.originalX, this.x});
    }

    if (this.y != this.originalY) {
      this.values.put(moveTypes[1], new int[]{this.originalY, this.y});
    }
  }
}
