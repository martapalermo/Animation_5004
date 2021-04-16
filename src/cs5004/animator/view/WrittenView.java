package cs5004.animator.view;

import cs5004.animator.model.animation.ReadonlyAnimator;

import java.io.IOException;

/**
 * Abstract class for views that use text.
 */
public abstract class WrittenView implements IView {
  protected ReadonlyAnimator model;
  protected Appendable writer;

  /**
   * Constructor for the abstract written view, takes two parameters the readonly animator model,
   * with instructions on what animation contains, and an appendable writer element.
   * @param model animation model, readonly animator
   * @param writer writer, appendable
   * @throws IllegalArgumentException if model or writer is null
   */
  public WrittenView(ReadonlyAnimator model, Appendable writer) {
    if (model == null) {
      throw new IllegalStateException("Model cannot be null.");
    }
    this.model = model;

    if (writer == null) {
      throw new IllegalStateException("Writer cannot be null.");
    }
    this.writer = writer;
  }

  /**
   * Method that writes string to text file.
   * @param text text that we want to write to file, String
   *        textLine -- will probably be the model string (model.toString())
   * @throws IOException if there is an error writing to the file
   */
  protected void writeToFile(String text) {
    try {
      this.writer.append(text);
    } catch (IOException e) {
      throw new IllegalStateException("Unable to append to the file.");
    }
  }
}
