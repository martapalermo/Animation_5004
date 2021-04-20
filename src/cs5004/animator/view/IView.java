package cs5004.animator.view;

import java.awt.event.ActionListener;

import javax.naming.OperationNotSupportedException;

import cs5004.animator.controller.Controller;

/**
 * The interface for our view classes.
 */
public interface IView {

  /**
   * Helper method facilitating start of animation.
   */
  void runView();
}
