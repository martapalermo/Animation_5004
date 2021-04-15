package cs5004.animator.view;

import cs5004.animator.model.animation.ReadonlyAnimator;

public class TextView extends WrittenView {
  public TextView(ReadonlyAnimator model, Appendable writer) {
    super(model, writer);
  }

  /**
   * Helper converter method from readOnlyAnimator model to string.
   * @return string text description
   */
  private String convertString() {
    return this.model.getAnimation();
  }

  /**
   * Helper method facilitating start of animation.
   */
  @Override
  public void go() {
    String text = this.convertString();
    this.writeToFile(text);
  }
}
