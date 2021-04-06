package cs5004.animator.view;

import java.awt.event.ActionListener;

/**
 * The interface for our view class.
 */
public interface IView {

  /**
   * Set the listener for any actions.
   * @param listener listener, ActionListener
   */
  void setListener(ActionListener listener);

  /**
   * Display this view.
   */
  void display();
}
