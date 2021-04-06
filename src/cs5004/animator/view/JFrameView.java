package cs5004.animator.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class JFrameView extends JFrame implements IView {
  private JLabel display;
  private JScrollBar scrollBar;

  public JFrameView() {

    setSize(500, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


  }

  /**
   * Set the listener for any actions.
   *
   * @param listener listener, ActionListener
   */
  @Override
  public void setListener(ActionListener listener) {

  }

  /**
   * Display this view.
   */
  @Override
  public void display() {
    setVisible(true);
  }

}
