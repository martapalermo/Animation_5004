package cs5004.animator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cs5004.animator.model.animation.Animator;
import cs5004.animator.view.IView;

// Should controller take in command input from EasyAnimator?
public class ControllerImpl implements Controller, ActionListener {
  private Animator model;
  private IView view;

  public ControllerImpl(Animator model, IView view) {
    this.model = model;
    this.view = view;
  }

  // How to know which view? (instanceof?)
  // Different methods to start
  @Override
  public void startController() {
    this.view.runView();
  }

  @Override
  public void processCommand(String command) {

  }

  @Override
  public void start() {

  }

  @Override
  public void pause() {

  }

  @Override
  public void resume() {

  }

  @Override
  public void restart() {

  }

  @Override
  public void loop() {

  }

  @Override
  public void speedUp() {

  }

  @Override
  public void slowDown() {

  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }
}
