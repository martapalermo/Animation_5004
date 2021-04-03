package cs5004.animator;

public class Dimension {
  protected double width;
  protected double height;

  public Dimension(double width, double height) {
    this.width = width;
    this.height = height;
  }

  public double getWidth() {
    return this.width;
  }

  public double getHeight() {
    return this.height;
  }

  public void setWidth(double sWidth) {
    this.width = sWidth;
  }

  public void setHeight(double sHeight) {
    this.height = sHeight;
  }
}
