package cs5004.animator.view;

import java.awt.event.ActionListener;

public interface InteractiveView extends VisualView {

  // void makeVisible();

  void start();

  void pause();

  void resume();

  void restart();

  void loop();

  void speedUp();

  void slowDown();

  void refresh();
}
