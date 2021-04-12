package cs5004.animator.view;

import cs5004.animator.model.animation.ReadonlyAnimator;

public class TextView extends WrittenView {
  public TextView(ReadonlyAnimator model) {
    super(model);
  }

  /**
   * Helper converter method from readOnlyAnimator model to string.
   * @return string text description
   */
  private String convertString() {
    return this.model.getAnimation();
  }

  @Override
  public void go(String outfile) {
    String text = this.convertString();
    writeToFile(text, outfile);
  }
}
