package cs5004.animator.model.animation;

import cs5004.animator.model.shape.Shape;

/**
 * This is the Scale class. It represents the scaling event/transformation that a shape can undergo.
 * This class extends AbstractEvent.
 */
public class Scale extends AbstractEvent {
  private final int originalWidth;
  private final int originalHeight;
  private final int height;
  private final int width;

  /**
   * Scale event/transformation constructor.
   *
   * @param shape shape being transformed, a {@link Shape}
   * @param start start tick, start of the event, int
   * @param stop stop tick, end of the event, int
   * @param width new width of shape, int
   * @param originalWidth original width of the shape before transformation, int
   * @param height new height of shape, int
   * @param originalHeight original height of the shape before transformation, int
   */
  public Scale(Shape shape, int start, int stop, int width, int originalWidth, int
          height, int originalHeight) {
    super(shape, start, stop);
    this.width = width;
    this.height = height;
    this.originalWidth = originalWidth;
    this.originalHeight = originalHeight ;
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
   * Get the SVG description of an event.
   *
   * @return SVG description, a String
   */
  @Override
  public String getSVG() {
    int duration = Math.abs(this.stop - this.start);
    String w = "";
    String h = "";
    if (this.originalWidth != this.width && this.originalHeight == this.height) {
      w += "<animate attributeType=\"xml\" begin=\"" + this.getStart() + "\" dur=\""
        + duration + "ms\" attributeName=\"width\" from=\"" + this.originalWidth + "\" to=\""
        + this.width + "\"" + " fill=\"remove\" />\n";

      return w + "</svg>\n";
    }
    else if (this.originalHeight != this.height && this.originalWidth == this.width) {
      h += "<animate attributeType=\"xml\" begin=\"" + this.getStart() + "\" dur=\""
          + duration + "ms\" attributeName=\"height\" from=\"" + this.originalHeight + "\" to=\""
          + this.height + "\"" + " fill=\"remove\" />\n";
      return h + "/svg>\n";
    }
    return w + h + "</svg>\n";
  }

  /**
   * Sets the given shape's new values based on the event that occurred; calculate the in between
   * factor to multiply values by.
   * @param shape shape to be transformed
   */
  @Override
  public void setValues(Shape shape, int tick) {
    int currentWidth, currentHeight;

    if (tick < this.stop) {
      currentWidth = (((this.originalWidth) * (this.stop - tick)) + ((this.width) *
              (tick - this.start))) / (this.stop - this.start);
      currentHeight = (((this.originalHeight) * (this.stop - tick)) + ((this.height) *
              (tick - this.start))) / (this.stop - this.start);
    }

    else {
      currentWidth = this.width;
      currentHeight = this.height;
    }

    shape.setDimension(currentWidth, currentHeight);
  }
}
