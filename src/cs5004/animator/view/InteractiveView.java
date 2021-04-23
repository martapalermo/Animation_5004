package cs5004.animator.view;

import cs5004.animator.controller.InteractiveController;

/**
 * This is the interactive view interface which extends the visual view interface.
 * This interface is specific to the interactive graphical representation
 * of the animation.
 */
public interface InteractiveView extends VisualView {

  /**
   * Helper method that sets buttons to their respective action- methods.
   * @param controller interactiveController interface
   */
  void setListeners(InteractiveController controller);

  /**
   * Setter method for speed.
   * @param speed speed of animation, int
   */
  void setSpeed(int speed);

  /**
   * Getter method for endTime for animation.
   * @return  endTime, int
   */
  void run(int count);

  /**
   * Setter method for endTime.
   */
  int getEndTime();
}
