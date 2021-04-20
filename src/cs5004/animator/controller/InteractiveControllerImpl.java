package cs5004.animator.controller;

import java.util.Timer;

import cs5004.animator.model.animation.Animator;
import cs5004.animator.view.InteractiveView;

public class InteractiveControllerImpl implements Controller {
  private Animator model;
  private InteractiveView view;
  private Timer timer;

  public InteractiveControllerImpl(Animator model, InteractiveView view) {
    this.model = model;
    this.view = view;
    this.timer = new Timer();
  }

  @Override
  public void startController() {

  }
}
