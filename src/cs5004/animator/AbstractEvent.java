package cs5004.animator;

abstract class AbstractEvent implements Event {
  protected String shapeName;
  protected int start;
  protected int stop;

  public AbstractEvent(String shapeName, int start, int stop) {
    this.shapeName = shapeName;

    if (stop <= start) {
      throw new IllegalArgumentException("Stop time cannot be less than the start time.");
    }

    this.start = start;
    this.stop = stop;
  }

  @Override
  public int getStart() {
    return this.start;
  }

  @Override
  public int getStop() {
    return this.stop;
  }

  @Override
  public String getShapeName() {
    return this.shapeName;
  }
}
