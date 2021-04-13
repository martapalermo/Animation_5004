package cs5004.animator.model.animation;

import cs5004.animator.model.shape.Shape;

/**
 * This class implements the Event interface, and represents an Abstract Event.
 */
abstract class AbstractEvent implements Event {
  protected String shapeName;
  protected Shape shape;
  protected int start;
  protected int stop;
  protected int duration;
  protected int xOffset;
  protected int yOffset;
  protected int speed;
  protected int timeConverter;

  /**
   * AbstractEvent Constructor.
   * @param shape shape being transformed, a {@link Shape}
   * @param start start of the transformation, int
   * @param stop end of the transformation, int
   * @throws IllegalArgumentException thrown if the stop time is < start time of the
   *      transformation event.
   */
  public AbstractEvent(Shape shape, int start, int stop, int xOffset, int yOffset, int speed)
          throws IllegalArgumentException {
    this.shape = shape;
    this.shapeName = shape.getName();

    if (stop < start) {
      throw new IllegalArgumentException("Stop time cannot be less than the start time.");
    }

    //System.out.println(start);
    //System.out.println(shape.getAppearTime()
    if (start < shape.getAppearTime() || stop > shape.getDisappearTime()) {
      throw new IllegalArgumentException("Start/stop time is out of the shape's appear "
              + "window.");
    }

    this.start = start;
    this.stop = stop;
    this.xOffset = xOffset;
    this.yOffset = yOffset;
    this.speed = speed;
    this.timeConverter = 100 / this.speed;
    this.duration = Math.abs(this.stop - this.start) * this.timeConverter;
  }

  // Static event constructor
//  public AbstractEvent(Shape shape, int start, int stop) {
//    this.shape = shape;
//    this.shapeName = shape.getName();
//
//    if (stop < start) {
//      throw new IllegalArgumentException("Stop time cannot be less than the start time.");
//    }
//
//    if (start < shape.getAppearTime() || stop > shape.getDisappearTime()) {
//      throw new IllegalArgumentException("Start/stop time is out of the shape's appear "
//              + "window.");
//    }
//
//    this.start = start;
//    this.stop = stop;
//  }

  /**
   * Get the start tick.
   * @return start, an int
   */
  @Override
  public int getStart() {
    return this.start;
  }

  /**
   * Get the stop tick.
   * @return stop, an int
   */
  @Override
  public int getStop() {
    return this.stop;
  }

  /**
   * Get the shape name.
   * @return shapeName, a String
   */
  @Override
  public String getShapeName() {
    return this.shapeName;
  }
}
