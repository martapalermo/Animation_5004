package cs5004.animator.model.animation;

import cs5004.animator.model.shape.Shape;

/**
 * This is the ChangeColor class. It represents the event/transformation
 * that changes the color of a shape.
 * This class extends AbstractEvent.
 */
class ChangeColor extends AbstractEvent {
  private final int originalRed;
  private final int originalBlue;
  private final int originalGreen;
  private final int red;
  private final int blue;
  private final int green;

  /**
   * ChangeColor event/transformation constructor.
   *
   * @param shape shape being transformed, a {@link Shape}
   * @param start start tick, start of the event, int
   * @param stop stop tick, end of the event, int
   * @param red new red pigment, int
   * @param green new green pigment, int
   * @param blue new blue pigment, int
   * @param originalRed original red pigment, int
   * @param originalGreen original green pigment, int
   * @param originalBlue original blue pigment, int
   */
  public ChangeColor(Shape shape, int start, int stop, int red, int green, int blue,
                     int originalRed, int originalGreen, int originalBlue) {
    super(shape, start, stop);
    this.red = red;
    this.blue = blue;
    this.green = green;
    this.originalRed = originalRed;
    this.originalBlue = originalBlue;
    this.originalGreen = originalGreen;
    this.addValues();
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
   * Sets the given shape's new values based on the event that occurred; calculate the in between
   * factor to multiply values by.
   * @param shape shape to be transformed
   */
  @Override
  public void setValues(Shape shape, int tick) {
    int currentRed;
    int currentGreen;
    int currentBlue;

    if (tick < this.stop) {
      currentRed = (((this.originalRed) * (this.stop - tick)) + ((this.red)
          * (tick - this.start))) / (this.stop - this.start);
      currentGreen = (((this.originalGreen) * (this.stop - tick)) + ((this.green)
          * (tick - this.start))) / (this.stop - this.start);
      currentBlue = (((this.originalBlue) * (this.stop - tick)) + ((this.blue)
          * (tick - this.start))) / (this.stop - this.start);

      shape.setColor(currentRed, currentGreen, currentBlue);
    }

    else {
      shape.setColor(this.red, this.green, this.blue);
    }
  }

  /**
   * Copy the Event.
   * @return copied Event
   */
  @Override
  public Event copy() {
    Event copy = new ChangeColor(this.shape.copy(), this.start, this.stop, this.red, this.green,
            this.blue, this.originalRed, this.originalGreen, this.originalBlue);
    return copy;
  }

  /**
   * toString method outlining the change of color event.
   * @return toString with original color pigments, new color pigments
   *        and the start and stop ticks for the movement time
   */
  @Override
  public String toString() {
    return "Shape " + this.getShapeName() + " changes color from (" + originalRed + ","
            + originalGreen + "," + originalBlue + ") to (" + this.red + "," + this.green + ","
            + this.blue + ") from t=" + this.getStart() + " to t=" + this.getStop();
  }

  /**
   * Add the event values to the HashMap to be used to create the SVG in the view.
   */
  private void addValues() {
    this.values.put("fill", new int[] {this.originalRed, this.originalGreen, this.originalBlue,
        this.red, this.green, this.blue});
  }
}
