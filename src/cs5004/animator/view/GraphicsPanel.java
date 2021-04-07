package cs5004.animator.view;

import cs5004.animator.model.shape.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GraphicsPanel extends JPanel {
  private List<Shape> model;

  public GraphicsPanel(List<Shape> model) {
    super(true);
    this.model = model;
    setBackground(Color.WHITE);
    setLocation(0,0);
    setBounds(100, 100, 600, 400);
    // setBorder(new LineBorder()); ?
  }

  public void updateModel(List<Shape> newModel) {
    this.model = newModel;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D var = (Graphics2D) g;

   /* int count = 0;
    for (Shape shape: model) {
      var.setColor(shape.getColor()); //, shape.getGreen(), shape.getBlue());

    } */

  }


}
