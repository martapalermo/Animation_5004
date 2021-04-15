package cs5004.animator.model.animation;

import java.util.HashMap;

import cs5004.animator.model.shape.Shape;

/**
 * This class implements the Event interface, and represents an Abstract Event.
 */
abstract class AbstractEvent implements Event {
  protected String shapeName;
  protected Shape shape;
  protected int start;
  protected int stop;
  protected HashMap<String, int []> values;

  /**
   * AbstractEvent Constructor.
   * @param shape shape being transformed, a {@link Shape}
   * @param start start of the transformation, int
   * @param stop end of the transformation, int
   * @throws IllegalArgumentException thrown if the stop time is < start time of the
   *      transformation event.
   */
  public AbstractEvent(Shape shape, int start, int stop)
          throws IllegalArgumentException {
    this.shape = shape;
    this.shapeName = shape.getName();

    if (stop < start) {
      throw new IllegalArgumentException("Stop time cannot be less than the start time.");
    }

    if (start < shape.getAppearTime() || stop > shape.getDisappearTime()) {
      throw new IllegalArgumentException("Start/stop time is out of the shape's appear "
              + "window.");
    }

    this.start = start;
    this.stop = stop;
    this.values = new HashMap<>();
  }

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


  /**
   * Get the values of the Event taking place; key is the attribute changing and value is
   * an array of the old/new values.
   * @return values, a HashMap
   */
  @Override
  public HashMap<String, int[]> getValues() {
    return this.values;
  }
}
