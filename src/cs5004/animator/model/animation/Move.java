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
    String hor = "";
    String ver = "";
    int duration = Math.abs(this.stop - this.start);

    if (this.getShapeName().equals("rectangle")) {
      String svg = "<rect id=\"" + this.getShapeName() + "\" x=\"" + this.originalX + "\" y=\""
          + this.originalY + "\" width=\"" + this.shape.getWidth() + "\" height=\""
          + this.shape.getHeight() + "\" fill=\"rgb(" + this.shape.getRed() + ","
          + this.shape.getGreen() + "," + this.shape.getBlue() + ")\" visibility=\"visible\">\n";

      // horizontal movement
      if (this.originalX != this.x && this.originalY == this.y) {
        hor += "<animate attributeType=\"xml\" begin=\"" + this.getStart() + "\" dur=\""
          + duration + "ms\" attributeName=\"x\" from=\"" + this.originalX + "\" to=\"" + this.x
          + "\" fill=\"freeze\" />\n";
        return svg + hor + "</rect>\n";
      }
      // vertical movement
      else if (this.originalY != this.y && this.originalX == this.y) {
        ver += "<animate attributeType=\"xml\" begin=\"" + this.getStart() + "\" dur=\""
            + duration + "ms\" attributeName=\"y\" from=\"" + this.originalY + "\" to=\"" + this.y
            + "\" fill=\"freeze\" />\n";
        return svg + ver + "</rect>\n";
      } // if both vertical horizontal movement happen together
      return svg + hor + ver;
    }
    else if (this.getShapeName().equals("ellipse")) {
      String ellipseSvg = "<ellipse id" + this.getShapeName() + "\" cx=\"" + this.originalX + "\" cy=\""
          + this.originalY + "\" rx=\"" + this.shape.getWidth() / 2 + "\" ry=\""
          + this.shape.getHeight() / 2 + "\" fill=\"rgb(" + this.shape.getRed() + ","
          + this.shape.getGreen() + "," + this.shape.getBlue() + ")\" visibility=\"visible\">\n"

          + "<animate attributeType=\"xml\" begin=\"" + this.getStart() + "\" dur=\""
          + duration + "ms\" attributeName=\"cx\" from=\"" + this.originalX + "\" to=\"" + this.x
          + "\" fill=\"remove\" />\n"

          + "<animate attributeType=\"xml\" begin=\"" + this.getStart() + "\" dur=\""
          + duration + "ms\" attributeName=\"cy\" from=\"" + this.originalY + "\" to=\"" + this.y
          + "\" fill=\"remove\" />\n";
      return ellipseSvg + "</ellipse>\n";
      }

    return "</svg>\n";
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
