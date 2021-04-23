package cs5004.animator.controller;

import cs5004.animator.model.animation.Animator;
import cs5004.animator.model.animation.AnimatorModel;
import cs5004.animator.view.IView;

/**
 * Controller implementing class, specifically for SVG and Text views.
 */
public class ControllerImpl implements Controller {

  private IView view;

  /**
   * Constructor for controllerImpl for text and SVG views.
   * @param model model, Animator interface
   * @param view view, IView interface
   */
  public ControllerImpl(Animator model, IView view) {
    model = new AnimatorModel();
    this.view = view;
  }


  /**
   * Helper method calling the other helper method that starts running the views.
   */
  @Override
  public void startController() {
    this.view.runView();
  }
}
