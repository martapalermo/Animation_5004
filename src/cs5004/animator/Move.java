package cs5004.animator;

class Move extends AbstractEvent {
  private final double originalX;
  private final double originalY;
  private final double x;
  private final double y;

  public Move(String shapeName, int start, int stop, double x, double y,
              double originalX, double originalY) {
    super(shapeName, start, stop);
    this.x = x;
    this.y = y;
    this.originalX = originalX;
    this.originalY = originalY;
  }

  @Override
  public String toString() {
    return "Shape " + this.getShapeName() + " moves from (" + originalX + "," + originalY + "to ("
        + this.x + "," + this.y + ") from t=" + this.getStart() + " to t=" + this.getStop();
  }

  @Override
  public String getEvent() {
    return "move";
  }

  @Override
  public void setValues(Shape shape) {
    shape.setPos(this.x, this.y);
  }
}
