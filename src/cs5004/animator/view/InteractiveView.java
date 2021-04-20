package cs5004.animator.view;

import java.awt.event.ActionListener;

import cs5004.animator.controller.Controller;

public interface InteractiveView extends VisualView {

  void setListeners(ActionListener actionListener);

  void start();

  void pause();

  void resume();

  void restart();

  void loop();

  void speedUp();

  void slowDown();

  void refresh();
}
