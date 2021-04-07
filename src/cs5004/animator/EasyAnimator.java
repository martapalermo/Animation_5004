package cs5004.animator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;

public final class EasyAnimator {

  public static void parseCommands(String[] args) throws IllegalArgumentException {
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

          // Try/catch for invalid file
          if (!command.endsWith(".txt")) {
            JOptionPane.showMessageDialog(null, "Invalid input file.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
          }
          input[0] = command;
        }

        else if (token.equalsIgnoreCase("-view")) {
          if (!command.equalsIgnoreCase("text") && !command.equalsIgnoreCase
                  ("visual") && !command.equalsIgnoreCase("svg")) {
            JOptionPane.showMessageDialog(null, "Invalid view type.",
                    "Error", JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    }

//    if (!argList.contains("-in")) {
//      throw new IllegalArgumentException("Must provide an input file.");
//    }
//
//    if (!argList.contains("-view")) {
//      throw new IllegalArgumentException("Must provide a view.");
//    }
  }

  public static void main(String[] args) {
    parseCommands(args);
  }
}
