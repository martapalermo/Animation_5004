package cs5004.animator.view;

import cs5004.animator.model.animation.AnimatorModel;
import cs5004.animator.model.animation.ReadonlyAnimator;
import cs5004.animator.model.shape.Shape;

import javax.swing.*;

import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.List;

public class GraphicsView extends JFrame implements IView {

  private ReadonlyAnimator model;
  private GraphicsPanel panel;
  private int[] canvas;

  public GraphicsView(ReadonlyAnimator model) {
    super("Animation Window");
    this.model = model;
    this.canvas = this.model.getCanvas();


    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //setLocation(0,0);// top left corner
    setLocation(canvas[0], canvas[1]);
    //setSize(600, 400);
    setSize(canvas[2], canvas[3]);
    setLayout(null);
    setVisible(true);

    JScrollBar horizontalBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 100,
        -600,600);
    JScrollBar verticalBar = new JScrollBar(JScrollBar.VERTICAL, 0, 100,
        -600,600);


    this.panel = new GraphicsPanel(); //panel that scroll pane displays
    BorderLayout bl = new BorderLayout(0,0);
    setLayout(bl);


    this.panel.setVisible(true);
    this.add(this.panel);

    class ALHorizontal implements AdjustmentListener {

      /**
       * Invoked when the value of the adjustable has changed.
       *
       * @param e the event to be processed
       */
      @Override
      public void adjustmentValueChanged(AdjustmentEvent e) {
        panel.setOffsetX(e.getValue());
      }
    }

    class ALVertical implements AdjustmentListener {

      /**
       * Invoked when the value of the adjustable has changed.
       *
       * @param e the event to be processed
       */
      @Override
      public void adjustmentValueChanged(AdjustmentEvent e) {
        panel.setOffsetY(e.getValue());
      }
    }

    horizontalBar.addAdjustmentListener(new ALHorizontal());
    verticalBar.addAdjustmentListener(new ALVertical());

    setLayout(new BorderLayout());
    getContentPane().add(horizontalBar, BorderLayout.PAGE_END);
    getContentPane().add(verticalBar, BorderLayout.LINE_END);

    getContentPane().add(this.panel, BorderLayout.CENTER);
    this.setVisible(true);
    setResizable(true);

  }

  /**
   * Display this view.
   *
   * @param listOfShapes
   */
  @Override
  public void getCurrentDisplay(List<Shape> listOfShapes) {
    this.panel.updateModel(listOfShapes);
  }

  @Override
  public void go(String outFile) {
    int count = 0;
    while (count < 1000000) {
      count++;
      getCurrentDisplay(model.getCurrentShapes(count));
      try {
        Thread.sleep(100);
      } catch (Exception e) {

      }
    }
  }

}
