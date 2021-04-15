package cs5004.animator.view;

import cs5004.animator.model.animation.ReadonlyAnimator;

import java.io.IOException;

/**
 * Abstract class for views that use text.
 */
public abstract class WrittenView implements IView {
  protected ReadonlyAnimator model;
  protected Appendable writer;

  public WrittenView(ReadonlyAnimator model, Appendable writer) {
    this.model = model;
    this.writer = writer;
  }

  /**
   * Method that writes string to text file.
   * @param text text that we want to write to file, String
   *        textLine -- will probably be the model string (model.toString())
   * @throws IOException if there is an error writing to the file
   */
  public void writeToFile(String text) {
    try {
      this.writer.append(text);
    } catch (IOException e) {
      throw new IllegalArgumentException("Unable to append to the file.");
    }
  }
}
