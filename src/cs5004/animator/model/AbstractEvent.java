package cs5004.animator.model;

/**
 * This class implements the Event interface, and represents an Abstract Event.
 */
abstract class AbstractEvent implements Event {
  protected String shapeName;
  protected int start;
  protected int stop;

  /**
   * AbstractEvent Constructor.
   * @param shapeName name of the shape, String
   * @param start start of the transformation, int
   * @param stop end of the transformation, int
   * @throws IllegalArgumentException thrown if the stop time is <= start time of the
   * transformation event.
   */
  public AbstractEvent(String shapeName, int start, int stop) throws IllegalArgumentException {
    this.shapeName = shapeName;

    if (stop <= start) {
      throw new IllegalArgumentException("Stop time cannot be less than the start time.");
    }

    this.start = start;
    this.stop = stop;
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
}
