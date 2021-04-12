package cs5004.animator.view;

import cs5004.animator.model.animation.AnimatorModel;
import cs5004.animator.model.animation.ReadonlyAnimator;
import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.Shape;
import cs5004.animator.model.shape.ShapeType;

import javax.swing.*;

import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.List;

public class GraphicsView extends JFrame implements IView {

  private List<Shape> model;
  private GraphicsPanel panel;

  public GraphicsView(List<Shape> model) {
    super("Animation Window");
    this.model = model;

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocation(0,0); // top left corner
    setSize(600, 400);
    setLayout(null);
    setVisible(true);

    JScrollBar horBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 100,
        -600,600);
    JScrollBar verBar = new JScrollBar(JScrollBar.VERTICAL, 0, 100,
        -600,600);


    this.panel = new GraphicsPanel(model); //panel that scroll pane displays
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

    horBar.addAdjustmentListener(new ALHorizontal());
    verBar.addAdjustmentListener(new ALVertical());

    setLayout(new BorderLayout());
    getContentPane().add(horBar, BorderLayout.PAGE_END);
    getContentPane().add(verBar, BorderLayout.LINE_END);

    getContentPane().add(this.panel, BorderLayout.CENTER);
    this.setVisible(true);
    setResizable(true);

  }


  public static void main(String[] args) {
    AnimatorModel obj = new AnimatorModel();

    obj.addShape(new Oval(ShapeType.OVAL, 50, 50, 3, 1000, 40,40, 150,
        250,0), "oval" );

    obj.move("oval", 70, 70, 50, 50, 5, 25);
    obj.scaleShape("oval",20,20,40, 40,10, 15);
    obj.changeColor("oval", 254,0,0,150,250,
        0, 10,15);

    obj.addShape(new Rectangle(ShapeType.RECTANGLE, 100,120,8,1000,35,40,0,
        0,255), "rect");

    obj.move("rect", 40, 199,100, 120,10,45);



    GraphicsView gv = new GraphicsView(obj.getCurrentShapes(3));
    gv.getCurrentDisplay(obj.getCurrentShapes(5));

    int count = 0;
    while (count < 6000) {
      count++;
      gv.getCurrentDisplay(obj.getCurrentShapes(count));
      System.out.println(obj.getCurrentShapes(count));
          try {
            Thread.sleep(100);
          } catch (Exception e) {

          }
        }
  }

  /**
   * Display this view.
   *
   * @param model
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
