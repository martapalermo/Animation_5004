package cs5004.animator.view;

import cs5004.animator.model.animation.ReadonlyAnimator;
import cs5004.animator.model.shape.Shape;
import cs5004.animator.util.AnimationBuilder;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

// class that will write a text file output
public abstract class WrittenView implements IView {
  protected ReadonlyAnimator model;
  protected Appendable writer;
  // boolean is set to default value false -> means you don't want to append
  // but you want to erase everything in the file

  public WrittenView(ReadonlyAnimator model, Appendable writer) {
    this.model = model;
    this.writer = writer;
  }

  /**
   * Method that writes string to text file.
   * @param text text that we want to write to file, String
   *                 textLine -- will probably be the model string (model.toString())
   * @throws IOException if there is an error writing to the file
   */
  public void writeToFile(String text) {
//    try {
//      Writer newWriter;
//      if (fileName.equalsIgnoreCase("System.out")) {
//        newWriter = new OutputStreamWriter(System.out);
//      }
//      else {
//        newWriter = new FileWriter(fileName);
//      }
//
//      newWriter.append(text);
//      newWriter.close();
//      System.out.println("Successfully wrote to file.");
//
//    } catch (IOException e) {
//      System.out.println("An error occurred while writing to file.");
//    }
    try {
      this.writer.append(text);
    } catch (IOException e) {
      throw new IllegalArgumentException("Unable to append to the file.");
    }
  }


  @Override
  public void getCurrentDisplay(List<Shape> shapesList) {

  }

//  public static void main(String[] args) {
//  //  writeToFile("Hello", "testing1.txt"); // WORKS!!
//  //  writeToFile("this is the second line, testing", "testing1.txt");

//  }


}
