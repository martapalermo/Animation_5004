package cs5004.animator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.naming.OperationNotSupportedException;

import cs5004.animator.model.animation.Animator;
import cs5004.animator.view.IView;

// Should controller take in command input from EasyAnimator?
public class ControllerImpl implements Controller {
  private Animator model;
  private IView view;

  public ControllerImpl(Animator model, IView view) {
    this.model = model;
    this.view = view;
  }

  // Different methods to start
  @Override
  public void startController() {
    this.view.runView();
  }

  private void configureButtonListener() {
    Map<String, Runnable> buttonClickedMap = new HashMap<>();
    ButtonListener buttonListener = new ButtonListener();

    //buttonClickedMap.put()
  }
}
