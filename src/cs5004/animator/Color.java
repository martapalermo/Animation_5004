package cs5004.animator;

public class Color {
  protected double red;
  protected double blue;
  protected double green;

  public Color(double red, double blue, double green) {
    this.red = red;
    this.blue = blue;
    this.green = green;
  }

  public double getRed() {
    return red;
  }

  public double getBlue() {
    return blue;
  }

  public double getGreen() {
    return green;
  }

  public void setRed(double red) {
    this.red = red;
  }

  public void setBlue(double blue) {
    this.blue = blue;
  }

  public void setGreen(double green) {
    this.green = green;
  }
}
