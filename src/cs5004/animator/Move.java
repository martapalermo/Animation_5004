package cs5004.animator;

class Move extends AbstractEvent {
  private final double originalX = this.shape.getX();
  private final double originalY = this.shape.getY();
  private final double x;
  private final double y;

  public Move(Shape shape, String shapeName, int start, int stop, double x, double y) {
    super(shape, shapeName, start, stop);
    this.x = x;
    this.y = y;
    this.shape.setPos(x,y);
  }
}
