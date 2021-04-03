package cs5004.animator.model;

public class Time {
  protected int appearTime;
  protected int disappearTime;

  public Time(int appearTime, int disappearTime) {
    this.appearTime = appearTime;
    this.disappearTime = disappearTime;
  }

  public int getAppearTime() {
    return this.appearTime;
  }

  public int getDisappearTime() {
    return this.disappearTime;
  }

  public void setAppearTime(int sAppearTime) {
    this.appearTime = sAppearTime;
  }

  public void setDisappearTime(int sDisappearTime) {
    this.disappearTime = sDisappearTime;
  }
}
