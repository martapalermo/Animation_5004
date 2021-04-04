package cs5004.animator.model;

/**
 * This class represents the timing element for the shapes in the animation.
 * Specifically considers two periods: the appearance of the shape in the animation and
 * the disappearance of the shape.
 */
public class Time {
  protected int appearTime;
  protected int disappearTime;

  /**
   * Time constructor takes two parameters.
   * @param appearTime start time - when the shape appears in the animation, int
   * @param disappearTime end time = when the shape disappears in the animation, int
   */
  public Time(int appearTime, int disappearTime) {
    this.appearTime = appearTime;
    this.disappearTime = disappearTime;
  }

  /**
   * Get the shape's appear time.
   * @return appear time, an int
   */
  public int getAppearTime() {
    return this.appearTime;
  }

  /**
   * Get the shape's disappear time.
   * @return disappear time, an int
   */
  public int getDisappearTime() {
    return this.disappearTime;
  }

  /**
   * Setter method - sets the new appearTime for the shape.
   * @param sAppearTime appear time, int
   */
  public void setAppearTime(int sAppearTime) {
    this.appearTime = sAppearTime;
  }

  /**
   * Setter method - sets the new disappearTime for the shape.
   * @param sDisappearTime disappear time, int
   */
  public void setDisappearTime(int sDisappearTime) {
    this.disappearTime = sDisappearTime;
  }
}
