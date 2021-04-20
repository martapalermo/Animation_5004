package cs5004.animator.view;

import java.awt.event.ActionListener;

import javax.naming.OperationNotSupportedException;

import cs5004.animator.controller.Controller;
import cs5004.animator.model.animation.ReadonlyAnimator;

/**
 * This view outputs a text file of the animation.
 */
public class TextView extends WrittenView {
  /**
   * Constructor for the text view, takes two parameters the readonly animator model,
   * with instructions on what animation contains, and an appendable writer element.
   * @param model animation model, readonly animator
   * @param writer writer, appendable
   */
  public TextView(ReadonlyAnimator model, Appendable writer) {
    super(model, writer);
  }

  /**
   * Helper method facilitating start of animation.
   */
  @Override
  public void runView() {
    this.writeToFile(this.model.getAnimation());
  }

  @Override
  public void setListeners(Controller controller) {

  }
}
