package cs5004.animator.view;

import cs5004.animator.model.animation.ReadonlyAnimator;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This view outputs a text file of the animation.
 */
public class TextView implements IView {
  private ReadonlyAnimator model;
  private Appendable writer;

  /**
   * Constructor for the text view, takes two parameters the readonly animator model,
   * with instructions on what animation contains, and an appendable writer element.
   * @param model animation model, readonly animator
   * @param writer writer, appendable
   */
  public TextView(ReadonlyAnimator model, Appendable writer) {
    if (model == null) {
      throw new IllegalStateException("Model cannot be null.");
    }
    this.model = model;

    if (writer == null) {
      throw new IllegalStateException("Writer cannot be null.");
    }
    this.writer = writer;
  }

  private void writeToFile(String text) {
    try {
      this.writer.append(text);
      FileWriter var = (FileWriter) this.writer;
      var.close();
    } catch (IOException e) {
      throw new IllegalStateException("Unable to append to the file.");
    }
  }

  /**
   * Helper method facilitating start of animation.
   */
  @Override
  public void runView() {
    this.writeToFile(this.model.getAnimation());
  }
}
