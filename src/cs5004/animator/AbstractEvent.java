package cs5004.animator;

abstract class AbstractEvent implements Event {
  protected String shapeName;
  protected int start;
  protected int stop;

  public AbstractEvent(String shapeName, int start, int stop) {
    this.shapeName = shapeName;
    this.start = start;
    this.stop = stop;
  }

  public int getStart() {
    return this.start;
  }

  public int getStop() {
    return this.stop;
  }

  public String getShapeName() {
    return this.shapeName;
  }
}
