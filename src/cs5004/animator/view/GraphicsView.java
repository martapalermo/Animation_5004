package cs5004.animator.view;

import cs5004.animator.model.shape.Shape;

import javax.swing.*;
import java.util.List;

public class GraphicsView extends JFrame implements IView {
  private final GraphicsPanel panel;
  private JLabel display;
  private JScrollBar scrollBar;

  public GraphicsView(List<Shape> model) {
    super("Animation");
    setSize(500, 400); // window size
    setVisible(true); // visibility is always set true
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    this.panel = new GraphicsPanel(model);
    this.add(this.panel);
    this.panel.setVisible(true);
  }

  /**
   * Display's this view.
   */
  @Override
  public void getCurrentDisplay(List<Shape> model) {
    this.panel.updateModel(model);
    this.repaint();
  }

  @Override
  public void go(String outFile) {

  }
}
