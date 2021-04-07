package cs5004.animator.view;

import cs5004.animator.model.shape.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * The interface for our view class.
 */
public interface IView {

  /**
   * Display this view.
   */
  void getCurrentDisplay(List<Shape> shapesList);
}
