package cs5004.animator.view;

import java.io.IOException;

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

  @Override
  public void go() {
    String text = this.convertString();
//    try {
//      writeToFile(text, outfile);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }

    this.writeToFile(text);
  }
}
