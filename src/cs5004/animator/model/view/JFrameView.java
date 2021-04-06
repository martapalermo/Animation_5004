package cs5004.animator.model.view;

import javax.swing.*;

public class JFrameView extends JFrame implements IView {
  private JScrollBar scrollBar;

  public JFrameView() {

    setSize(500, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


  }

}
