package cs5004.animator.view;

import cs5004.animator.model.animation.ReadonlyAnimator;

/**
 * This view outputs a text file of the animation.
 */
public class TextView extends WrittenView {
  public TextView(ReadonlyAnimator model, Appendable writer) {
    super(model, writer);
  }

  /**
   * Helper method facilitating start of animation.
   */
  @Override
  public void go() {
    this.writeToFile(this.model.getAnimation());
  }
}
