package cs5004.animator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import cs5004.animator.model.animation.Animator;
import cs5004.animator.model.animation.AnimatorModel;
import cs5004.animator.model.shape.Shape;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.GraphicsView;
import cs5004.animator.view.IView;
import cs5004.animator.view.SVGVIew;
import cs5004.animator.view.TextView;

public final class EasyAnimator {

  public static String[] parseCommands(String[] args) throws IllegalArgumentException {
//    String[] argSplit = Arrays.toString(args).split("-");
//    List<String> argList = Arrays.asList(argSplit);
//    System.out.println(Arrays.toString(args).substring(1, args.length - 1));
    StringBuilder strArgs = new StringBuilder();

    for (String arg : args) {
      strArgs.append(arg).append(" ");
    }

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
          if (!command.equalsIgnoreCase("text") && !command.equalsIgnoreCase
                  ("visual") && !command.equalsIgnoreCase("svg")) {
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

    // Confirm svg view has an svg file to write to
    // Is this necessary???

//    if (input[1].equalsIgnoreCase("svg") && !input[2].endsWith("svg")) {
//      JOptionPane.showMessageDialog(null, "svg view must have an svg out"
//              + "file to write to.", "Error", JOptionPane.ERROR_MESSAGE);
//      System.exit(1);
//    }

    // Be sure to check for "System.out" when writing; it needs OutputStreamWriter not FileWriter
    if (input[2] == null) {
      input[2] = "System.out";
    }

    if (input[3] == null) {
      input[3] = "1";
    }

    return input;
  }

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

  public static IView factoryOfViews(String[] input, Animator model, Writer writer) throws IllegalArgumentException {
    if (input[1].equalsIgnoreCase("visual")) {
      // return new GraphicView class w/ ReadonlyAnimator model (@clark's tic tac toe)
      return new GraphicsView(model);
    }

    else if (input[1].equalsIgnoreCase("text")) {
      // return new TextView class w/ ReadonlyAnimator model (@clark's tic tac toe)
      return new TextView(model, writer);
    }

    else if (input[1].equalsIgnoreCase("svg")) {
      // return new SVGView class w/ ReadonlyAnimator model (@clark's tic tac toe)
      return new SVGVIew(model, writer, Integer.parseInt(input[3]));
    }

    else {
      throw new IllegalArgumentException("Invalid view type.");
    }
  }

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

    IView view = factoryOfViews(input, model, writer);
    view.go();

    try {
      writer.close();
    } catch (IOException e) {
      throw new IllegalStateException("Unable to close the writer.");
    }
  }
}
