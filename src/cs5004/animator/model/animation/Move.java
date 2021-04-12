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
  public Move(Shape shape, int start, int stop, int x, int y,
              int originalX, int originalY) {
    super(shape, start, stop);
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
   * Get the SVG description of an event.
   *
   * @return SVG description, a String
   */
  @Override
  public String getSVG() {
    String svg = "";
    if (this.getShapeName().equals("rectangle")) {
      svg = "<!-- starting at time=" + this.getStart() + "s, move the rectangle ";

      if (this.originalX != this.x && this.originalY == this.y) { // horizontal movement
        return svg + "horizontally from x=" + this.originalX + " to x=" + this.x
            + "IN X SECONDS -->\n";
      } // TODO: after this.x needs to be edited!!!
      else if (this.originalY != this.y && this.originalX == this.y) { // vertical movement
        return svg + "vertically from y=" + this.originalY + " to y=" + this.y
            + "IN X SECONDS -->\n";
      }
    }
    else if (this.getShapeName().equals("ellipse")) {
      svg = "<!-- starting at time=" + this.getStart() + "s, move the ellipse's center from ("
              + this.originalX + "," + this.originalY + ") to (" + this.shape.getX() + ","
              + this.shape.getY() + ")" + " IN X SECONDS -->\n";
      return svg;
      }
    return null;
  }

  /**
   * Sets the given shape's new values based on the event that occurred; calculate the in between
   * factor to multiply values by.
   * @param shape shape to be transformed
   */
  @Override
  public void setValues(Shape shape, int tick) {
    int currentX, currentY;

    if (tick < this.stop) {
      currentX = (((this.originalX) * (this.stop - tick)) + ((this.x) * (tick - this.start))) /
              (this.stop - this.start);
      currentY = (((this.originalY) * (this.stop - tick)) + ((this.y) * (tick - this.start))) /
              (this.stop - this.start);
    }

    else {
      currentX = this.x;
      currentY = this.y;
    }

    shape.setPos(currentX, currentY);
  }
}
