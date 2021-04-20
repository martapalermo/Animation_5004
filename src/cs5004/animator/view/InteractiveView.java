package cs5004.animator.view;

import java.awt.event.ActionListener;

public interface InteractiveView extends VisualView {

  void setListeners(ActionListener actionListener);

  void setSpeed(int speed);

  void run(int count);
}
