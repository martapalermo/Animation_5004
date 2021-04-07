package cs5004.animator.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JFrameView extends JFrame implements IView {
  private JLabel display;
  private JScrollBar scrollBar;

  public JFrameView() {

    setSize(500, 300);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


  }


  /**
   * Make the view visible. This is usually called
   * after the view is constructed.
   */
  @Override
  public void makeVisible() {

  }

  /**
   * Provide the view with an action listener for
   * the button that should cause the program to
   * process a command. This is so that when the button
   * is pressed, control goes to the action listener.
   *
   * @param listener listener, ActionListener
   */
  @Override
  public void setCommandButtonListener(ActionListener listener) {

  }

  /**
   * Provide the view with the shapes to be drawn.
   *
   * @param shape
   */
  @Override
  public void setShapes(Shape shape) {

  }

  /**
   * Provide the view with the shape's color.
   *
   * @param red
   * @param green
   * @param blue
   */
  @Override
  public void setShapeColor(int red, int green, int blue) {

  }

  /**
   * Provide the view with shape's position.
   *
   * @param position
   */
  @Override
  public void setShapePosition(Point position) {

  }

  /**
   * Provide the view with shape's size/dimensions.
   *
   * @param size
   */
  @Override
  public void setShapeDimensions(Dimension size) {

  }

  /**
   * Display this view.
   */
  @Override
  public void display() {
    setVisible(true);
  }

}
