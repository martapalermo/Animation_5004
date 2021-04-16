package cs5004.animator.view;

import cs5004.animator.model.shape.Shape;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.List;

/**
 * This is our Graphics Panel class and it extends JPanel.
 */
public class GraphicsPanel extends JPanel {
  private List<Shape> listOfShapes;
  private int offsetX = 0;
  private int offsetY = 0;

  /**
   * Graphics panel constructor, doesn't take any parameters, but initializes panel bounds,
   * background and visibility boolean.
   */
  public GraphicsPanel() {
    super(true);
    this.listOfShapes = null;
    setBackground(Color.WHITE);
    setBounds(0, 0, 600, 400);
    setVisible(true);

  }

  /**
   * Helper method that takes in a new list of shapes and updates the current list of shapes.
   * Method prompts the graphics element to repaint everytime.
   * @param newListOfShapes List of {@link Shape}s
   */
  public void updateModel(List<Shape> newListOfShapes) {
    this.listOfShapes = newListOfShapes;
    this.repaint();
  }

  /**
   * Setter method for the X offset value.
   * @param x x value, int
   */
  public void setOffsetX(int x) {
    this.offsetX = x;
  }

  /**
   * Setter method for the Y offset value.
   * @param y y value, int
   */
  public void setOffsetY(int y) {
    this.offsetY = y;
  }

  /**
   * Method that creates the graphical component that showed up in the visual window.
   * @param g take a Graphics parameter
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;

    if (listOfShapes != null) {
      for (Shape shape : listOfShapes) {
        if (shape.getType().equals("oval")) {
          g2.setColor(new Color(shape.getRed(), shape.getGreen(), shape.getBlue()));

          g2.drawOval(
              shape.getX() - offsetX, shape.getY() - offsetY, shape.getWidth(), shape.getHeight());
          g2.fillOval(
              shape.getX() - offsetX, shape.getY() - offsetY, shape.getWidth(), shape.getHeight());
        } else {
          g2.setColor(new Color(shape.getRed(), shape.getGreen(), shape.getBlue()));
          g2.drawRect(
              shape.getX() - offsetX, shape.getY() - offsetY, shape.getWidth(), shape.getHeight());
          g2.fillRect(
              shape.getX() - offsetX, shape.getY() - offsetY, shape.getWidth(), shape.getHeight());
        }
      }
    }
  }


}
