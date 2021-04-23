package cs5004.animator.controller;

/**
 * Controller interface for the visual view specifically/ the interactive view.
 */
public interface InteractiveController extends Controller {

  /**
   * Method that assigns the specific action for start button.
   */
  void start();

  /**
   * Method that assigns the specific action for stop/pause button.
   */
  void stop();

  /**
   * Method that assigns the specific action for restart/resume button.
   */
  void restart();

  /**
   * Method that assigns the specific action for loop checkbox.
   */
  void loop();

  /**
   * Method that assigns the specific action for speed up button.
   */
  void speedUp();

  /**
   * Method that assigns the specific action for slow down button.
   */
  void slowDown();

  /**
   * Getter method for the button logs.
   * @return returns the button click logged activity, String
   */
  String getLog();
}
