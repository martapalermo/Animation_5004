package cs5004.animator;

class ChangeColor extends AbstractEvent {
  private final double originalRed = this.shape.getRed();
  private final double originalBlue = this.shape.getBlue();
  private final double originalGreen = this.shape.getGreen();
  private final double red;
  private final double blue;
  private final double green;

  public ChangeColor(Shape shape, String shapeName, int start, int stop, double red,
                     double blue, double green) {
    super(shape, shapeName, start, stop);
    this.red = red;
    this.blue = blue;
    this.green = green;
  }

  @Override
  public String toString() {
    return "Shape " + this.getShapeName() + " changes color from (" + originalRed + ","
        + originalBlue + "," + originalGreen + ") to (" + this.red + "," + this.blue + ","
        + this.green + ") from t=" + this.getStart() + "to t=" + this.getStop();
  }
}
