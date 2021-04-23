package cs5004.animator.view;

import cs5004.animator.controller.InteractiveController;

/**
 * This is the interactive view interface which extends the visual view interface.
 * This interface is specific to the interactive graphical representation
 * of the animation.
 */
public interface InteractiveView extends VisualView {

  void setListeners(InteractiveController controller);

  void setSpeed(int speed);

  void run(int count);

  int getEndTime();
}
