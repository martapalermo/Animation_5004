package cs5004.animator.model.animation;

import cs5004.animator.model.shape.Rectangle;
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
  public Move(Shape shape, int start, int stop, int x, int y, int originalX, int originalY, int
          xOffset, int yOffset, int speed) {
    super(shape, start, stop, xOffset, yOffset, speed);
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
    String[] moveTypes = this.shape.getMoveSVG();

    String hor = "\t<animate attributeType=\"xml\" begin=\"" + this.getStart() * this.timeConverter
            + "ms\" dur=\"" + this.duration + "ms\" attributeName=\"" + moveTypes[0] + "\" "
            + "from=\"" + this.originalX + "\" to=\"" + this.x + "\" fill=\""
            + "freeze\" />\n";

    String ver = "\t<animate attributeType=\"xml\" begin=\"" + this.getStart() * this.timeConverter
            + "ms\" dur=\"" + this.duration + "ms\" attributeName=\"" + moveTypes[1] + "\" from=\""
            + this.originalY + "\" to=\"" + this.y + "\" fill=\"freeze\" />\n";

    if (this.originalX != this.x && this.originalY == this.y) {
      return hor;
    }

    else if (this.originalY != this.y && this.originalX == this.y) {
      return ver;
    }

    else {
      return hor + ver;
    }
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
