package cs5004.animator.model.animation;

import cs5004.animator.model.shape.Shape;

/**
 * This is the Static class. It represents the non-event of a shape in an animation.
 * This class extends AbstractEvent.
 */
public class Static extends AbstractEvent {
  private int x;
  private int y;
  private int width;
  private int height;
  private int red;
  private int green;
  private int blue;

  /**
   * Static event constructor.
   * @param shape shape being transformed, a {@link Shape}
   * @param start start of the transformation, int
   * @param stop end of the transformation, int
   * @param x shape's x position, an int
   * @param y shape's y position, an int
   * @param width shape's width, an int
   * @param height shape's height, an int
   * @param red shape's red value, an int
   * @param green shape's green value, an int
   * @param blue shape's blue value, an int
   * @throws IllegalArgumentException thrown if the stop time is <= start time of the
   *      transformation event.
   */
  public Static(Shape shape, int start, int stop, int x, int y, int width, int height, int red,
                int green, int blue) throws IllegalArgumentException {
    super(shape, start, stop);
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * Get the event type.
   * @return event name, a String
   */
  @Override
  public String getEvent() {
    return "static";
  }

  /**
   * Sets the given shape's new values based on the event that occurred.
   * @param shape shape to be transformed
   */
  @Override
  public void setValues(Shape shape, int tick) {
    shape.setPos(this.x, this.y);
    shape.setDimension(this.width, this.height);
    shape.setColor(this.red, this.green, this.blue);
  }

  /**
   * Copy the Event.
   * @return copied Event
   */
  @Override
  public Event copy() {
    Event copy = new Static(this.shape.copy(), this.start, this.stop, this.x, this.y, this.width,
            this.height, this.red, this.green, this.blue);
    return copy;
  }

  @Override
  public String toString() {
    return "Shape: " + this.shapeName + " remains at " + this.x + ", " + this.y
            + " and has a width of " + this.width + " and a height of " + this.height
            + " with color (" + this.red + ", " + this.green + ", " + this.blue + ")";
  }
}
