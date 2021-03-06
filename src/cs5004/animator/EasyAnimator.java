package cs5004.animator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

import javax.swing.JOptionPane;

import cs5004.animator.controller.Controller;
import cs5004.animator.controller.ControllerImpl;
import cs5004.animator.controller.InteractiveControllerImpl;
import cs5004.animator.model.animation.Animator;
import cs5004.animator.model.animation.AnimatorModel;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.GraphicsView;
import cs5004.animator.view.InteractiveViewImpl;
import cs5004.animator.view.SVGView;
import cs5004.animator.view.TextView;

/**
 * Easy Animator class - barebones controller that facilitates animation outputs.
 */
public final class EasyAnimator {

  /**
   * Parse the input commands.
   * @param args input args, String array
   * @return validated input commands, String array
   */
  public static String[] parseCommands(String[] args) {
    StringBuilder strArgs = new StringBuilder();

    // Convert String array of command line input into a String to iterate through
    for (String arg : args) {
      strArgs.append(arg).append(" ");
    }

    // Scan through command line
    Scanner scan = new Scanner(String.valueOf(strArgs));

    // [in, view, out, speed]
    String[] input = new String[4];

    while (scan.hasNext()) {
      String token = scan.next();

      if (token.charAt(0) == '-') {
        String command = scan.next();
        if (token.equalsIgnoreCase("-in")) {
          if (!command.endsWith(".txt")) {
            JOptionPane.showMessageDialog(null, "Invalid input file.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
          }
          input[0] = command;

        } else if (token.equalsIgnoreCase("-view")) {
          if (!command.equalsIgnoreCase("text")
                  && !command.equalsIgnoreCase("visual")
                  && !command.equalsIgnoreCase("svg")
                  && !command.equalsIgnoreCase("playback")) {
            JOptionPane.showMessageDialog(null, "Invalid view type.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
          }
          input[1] = command;

        } else if (token.equalsIgnoreCase("-out")) {
          input[2] = command;

        } else if (token.equalsIgnoreCase("-speed")) {
          int speed = 0;
          try {
            speed = Integer.parseInt(command, 10);
          } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Speed must be a positive"
                    + "nonzero int.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
          }
          if (speed < 1) {
            JOptionPane.showMessageDialog(null, "Speed must be a positive"
                    + "nonzero int.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
          }
          input[3] = command;
        }
      }
      else {
        JOptionPane.showMessageDialog(null, String.format("Invalid command line "
                + "input: %s", token), "Error", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
      }
    }
    scan.close();

    // Set default values for speed/out (if necessary) and check to make sure in/view are not
    // empty
    if (input[0] == null) {
      JOptionPane.showMessageDialog(null, "Must pass in a file to read "
              + "from.");
      System.exit(1);
    }

    if (input[1] == null) {
      JOptionPane.showMessageDialog(null, "Must pass in a view type (svg, "
              + "text, visual) to display the animation.", "Error", JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }

    if (input[2] == null) {
      input[2] = "System.out";
    }

    if (input[3] == null) {
      input[3] = "1";
    }

    return input;
  }

  /**
   * Create the Writer for views that require it.
   * @param fileName outfile name, a string
   * @return writer, a Writer
   */
  public static Writer getWriter(String fileName) {
    try {
      Writer newWriter;
      if (fileName.equalsIgnoreCase("System.out")) {
        newWriter = new OutputStreamWriter(System.out);
      }
      else {
        newWriter = new FileWriter(fileName);
      }
      return newWriter;

    } catch (IOException e) {
      throw new IllegalStateException("Unable to create the file.");
    }
  }

  /**
   * Create a new controller based on the view type.
   * @param input input commands, String array
   * @param model model populated with data, Animator
   * @param writer writer for views that need it
   * @return controller, Controller
   * @throws IllegalArgumentException if the view type is invalid
   */
  public static Controller factoryOfViews(String[] input, Animator model, Appendable writer)
          throws IllegalArgumentException {
    if (input[1].equalsIgnoreCase("visual")) {
      return new ControllerImpl(model, new GraphicsView(model, Integer.parseInt(input[3])));
    }

    else if (input[1].equalsIgnoreCase("text")) {
      return new ControllerImpl(model, new TextView(model, writer));
    }

    else if (input[1].equalsIgnoreCase("svg")) {
      return new ControllerImpl(model, new SVGView(model, writer, Integer.parseInt(input[3])));
    }

    else if (input[1].equalsIgnoreCase("playback")) {
      return new InteractiveControllerImpl(
          new InteractiveViewImpl(model), Integer.parseInt(input[3]));
    }

    else {
      throw new IllegalArgumentException("Invalid view type.");
    }
  }

  /**
   * Static main method that runs the animations.
   * @param args takes an input of array of strings.
   */
  public static void main(String[] args) {
    String[] input = parseCommands(args);

    // Input file
    Readable inFile = null;
    try {
      inFile = new FileReader(input[0]);
    } catch (FileNotFoundException e) {
      JOptionPane.showMessageDialog(null, "Invalid input file",
              "Error", JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }

    Writer writer = getWriter(input[2]);
    Animator model = AnimationReader.parseFile(inFile, new AnimatorModel.AnimationBuilderImpl());

    Controller controller = factoryOfViews(input, model, writer);
    controller.startController();

    try {
      writer.close();
    } catch (IOException e) {
      throw new IllegalStateException("Unable to close the writer.");
    }
  }
}
