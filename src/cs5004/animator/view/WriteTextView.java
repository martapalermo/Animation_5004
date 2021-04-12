package cs5004.animator.view;

import cs5004.animator.model.animation.ReadonlyAnimator;
import cs5004.animator.model.shape.Shape;
import cs5004.animator.util.AnimationBuilder;

import java.io.Closeable;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

// class that will write a text file output
public class WriteTextView implements IView {
  private String path;
  private String textToWrite;
  private String fileName;
  private boolean appendToFile = false;
  private ReadonlyAnimator model;
  // boolean is set to default value false -> means you don't want to append
  // but you want to erase everything in the file

  public WriteTextView(ReadonlyAnimator model){//, String textToWrite, String fileName) {
    this.model = model;
//    this.textToWrite = textToWrite;
//    this.fileName = fileName;
  }

  /**
   * Writing a text file constructor one.
   * This constructor OVERWRITES the file.
   * Sets a value for the path field, the name and location of the file.
   * This will get handed over when creating a new object from TextView class.
   * @param file_path file path, String
   */
  public WriteTextView(String file_path) {
    this.path = file_path;
  }

  /**
   * Writing a text file second constructor.
   * This constructor APPENDS to the file.    *
   * @param file_path file path, String
   * @param appendValue value that gets appended, boolean
   */
  public WriteTextView(String file_path, boolean appendValue) {
    this.path = file_path;
    this.appendToFile = appendValue;
  }

  /**
   * Helper converter method from readOnlyAnimator model to string.
   * @return string text description
   */
  private String convertString() {
    return this.model.getAnimation();
  }

  /**
   * Method that writes string to text file.
   * @param text text that we want to write to file, String
   *                 textLine -- will probably be the model string (model.toString())
   * @param fileName file Name where we want to write to // create new file, String
   * @throws IOException
   */
  public static void writeToFile(String text, String fileName) {
    try {
      Writer newWriter = new FileWriter(fileName);
      newWriter.append(text);
      newWriter.close();
      System.out.println("Successfully wrote to file."); // should append to file
    } catch (IOException e) {
      System.out.println("An error occurred while writing to file.");
      e.printStackTrace();
    }

  }

  @Override
  public void getCurrentDisplay(List<Shape> shapesList) {

  }

  public void go(String outfile) {
    String text = convertString();
    writeToFile(text, outfile);
  }

//  public static void main(String[] args) {
//  //  writeToFile("Hello", "testing1.txt"); // WORKS!!
//  //  writeToFile("this is the second line, testing", "testing1.txt");

//  }


}
