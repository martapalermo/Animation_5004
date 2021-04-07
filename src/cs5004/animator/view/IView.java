package cs5004.animator.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The interface for our view class.
 */
public interface IView {

  /**
   * Make the view visible. This is usually called
   * after the view is constructed.
   */
  void makeVisible();

  /**
   * Provide the view with an action listener for
   * the button that should cause the program to
   * process a command. This is so that when the button
   * is pressed, control goes to the action listener.
   * @param listener listener, ActionListener
   */
  void setCommandButtonListener(ActionListener listener); // ae = action event

  /**
   * Provide the view with the shapes to be drawn.
   * @param shape
   */
  void setShapes(Shape shape);
  // this I guess would take text input thru command line
  // not really a Shape shape

  /**
   * Provide the view with the shape's color.
   * @param red
   * @param green
   * @param blue
   */
  void setShapeColor(int red, int green, int blue);

  /**
   * Provide the view with shape's position.
   * @param position
   */
  void setShapePosition(Point position);

  /**
   * Provide the view with shape's size/dimensions.
   * @param size
   */
  void setShapeDimensions(Dimension size);

  /**
   * Display this view.
   */
  void display();
}
