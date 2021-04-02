package cs5004.animator;

class ChangeColor extends AbstractEvent {
  private final double originalRed;
  private final double originalBlue;
  private final double originalGreen;
  private final double red;
  private final double blue;
  private final double green;

  public ChangeColor(String shapeName, int start, int stop, double red, double blue, double green,
                     double originalRed, double originalBlue, double originalGreen) {
    super(shapeName, start, stop);
    this.red = red;
    this.blue = blue;
    this.green = green;
    this.originalRed = originalRed;
    this.originalBlue = originalBlue;
    this.originalGreen = originalGreen;
  }

  @Override
  public String toString() {
    return "Shape " + this.getShapeName() + " changes color from (" + originalRed + ","
        + originalBlue + "," + originalGreen + ") to (" + this.red + "," + this.blue + ","
        + this.green + ") from t=" + this.getStart() + "to t=" + this.getStop();
  }

  @Override
  public String getEvent() {
    return "change color";
  }

  @Override
  public void setValues(Shape shape) {
    shape.setColor(this.red, this.blue, this.green);
  }
}
