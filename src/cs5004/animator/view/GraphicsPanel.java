package cs5004.animator.view;


import cs5004.animator.model.shape.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GraphicsPanel extends JPanel {
  private List<Shape> model;
  private int offsetX = 0;
  private int offsetY = 0;

  public GraphicsPanel(List<Shape> model) {
    super(true);
    this.model = model;
    setBackground(Color.WHITE);
    //setLocation(0,0);
    setBounds(0, 0, 600, 400);
    setVisible(true);

  }

  public void updateModel(List<Shape> newModel) {
    this.model = newModel;
  }

  public void setOffsetX(int x) {
      this.offsetX = x;
  }

  public void setOffsetY(int y) {
    this.offsetY = y;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;

    for (Shape shape: model) {
     if(shape.getType() == "oval") {
       g2.setColor(new Color(shape.getRed(), shape.getGreen(), shape.getBlue()));

       g2.drawOval(shape.getX() - offsetX, shape.getY() -offsetY, shape.getWidth(),
           shape.getHeight());
       g2.fillOval(shape.getX() - offsetX, shape.getY() - offsetY, shape.getWidth(),
           shape.getHeight());
      }
     else {
        g2.setColor(new Color(shape.getRed(), shape.getGreen(), shape.getBlue()));
        g2.drawRect(
            shape.getX() - offsetX, shape.getY() - offsetY, shape.getWidth(),
            shape.getHeight());
        g2.fillRect(
            shape.getX() - offsetX, shape.getY() - offsetY, shape.getWidth(),
            shape.getHeight());
     }
    }

  }


}
