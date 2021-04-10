package cs5004.animator.view;

import cs5004.animator.model.animation.ReadonlyAnimator;
import cs5004.animator.util.AnimationBuilder;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

// class that will write a text file output
public class WriteTextView {
  private String path;
  private boolean appendToFile = false;
  private ReadonlyAnimator model;
  // boolean is set to default value false -> means you don't want to append
  // but you want to erase everything in the file

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
   * @param model takes in the model, readonlyAnimator
   * @return string text description
   */
  private static String convertString(ReadonlyAnimator model) {
    String text = model.getAnimation();
    return text;
  }

  /**
   * Method that writes string to text file from model ReadonlyAnimator.
   * @param text text that we want to write to file, String
   *                 textLine -- will probably be the model string (model.toString())
   * @param fileName file Name where we want to write to // create new file, String
   * @throws IOException
   */
  public static void writeToFile(ReadonlyAnimator model, String text, String fileName)
      throws IOException {
    text = convertString(model);
    try {
      FileWriter newWriter = new FileWriter(fileName);
      newWriter.write(text);
      newWriter.close();
      System.out.println("Successfully wrote to file."); // should append to file
    } catch (IOException e) {
      System.out.println("An error occurred while writing to file.");
      e.printStackTrace();
    }
  }

  /**
   * Method that writes string to text file.
   * @param text text that we want to write to file, String
   *                 textLine -- will probably be the model string (model.toString())
   * @param fileName file Name where we want to write to // create new file, String
   * @throws IOException
   */
  public static void writeToFile(String text, String fileName) throws IOException {
    try {
      FileWriter newWriter = new FileWriter(fileName);
      newWriter.write(text);
      newWriter.close();
      System.out.println("Successfully wrote to file."); // should append to file
    } catch (IOException e) {
      System.out.println("An error occurred while writing to file.");
      e.printStackTrace();
    }

  }

  public static void main(String[] args) throws IOException {
    writeToFile("Hello", "testing1.txt"); // WORKS!!
    writeToFile("this is the second line, testing", "testing1.txt");
  }


}
