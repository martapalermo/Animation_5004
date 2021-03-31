package cs5004.animator;

public class ScaleShape extends AbstractEvent {
  private final double originalHeight = this.shape.getHeight();
  private final double originalWidth = this.shape.getWidth();
  private final double height;
  private final double width;


  public ScaleShape(Shape shape, String shapeName, int start, int stop, double height,
                    double width) {
    super(shape, shapeName, start, stop);
    this.height = height;
    this.width = width;
  }

  @Override
  public String toString() {
    return "Shape " + this.getShapeName() + " scales from Width: " + originalWidth + ", Height: "
        + originalHeight + "to Width: " + this.width + ", Height: " + this.height + "from t="
        + this.getStart() + "to t=" + this.getStop();
  }
}
