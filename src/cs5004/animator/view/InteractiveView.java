package cs5004.animator.view;

import java.awt.event.ActionListener;

import cs5004.animator.controller.InteractiveController;

public interface InteractiveView extends VisualView {

  void setListeners(InteractiveController controller);

  void setSpeed(int speed);

  void run(int count);

  int getEndTime();
}
