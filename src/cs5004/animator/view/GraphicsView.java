package cs5004.animator.view;

import cs5004.animator.model.animation.ReadonlyAnimator;
import cs5004.animator.model.shape.Shape;

import javax.swing.JFrame;
import javax.swing.JScrollBar;

import java.awt.BorderLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.List;

/**
 * This is the Graphics view class, it extends JFrame and implements our View interface, IView.
 * This view outputs a java swing window visual representation of the animation.
 */
public class GraphicsView extends JFrame implements VisualView {

  private ReadonlyAnimator model;
  private GraphicsPanel panel;
  private final int timeConverter;

  /**
   * Graphics View constructor. Takes in two parameters model and speed.
   * @param model readonly animation model, ReadonlyAnimator interface
   * @param speed speed of animation, int
   */
  public GraphicsView(ReadonlyAnimator model, int speed) {
    super("Animation Window");
    this.model = model;
    int[] canvas = this.model.getCanvas();
    this.timeConverter = 100 / speed;


    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocation(canvas[0], canvas[1]);
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

    /**
     * Adjustment Listener class for the horizontal scroll bar.
     */
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

    /**
     * Adjustment Listener class for the vertical scroll bar.
     */
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
   * @param listOfShapes List of {@link Shape}s
   */
  @Override
  public void getCurrentDisplay(List<Shape> listOfShapes) {
    this.panel.updateModel(listOfShapes);
  }

  /**
   * Helper method facilitating start of animation.
   */
  @Override
  public void runView() {
    int count = 0;
    while (count < 1000000) {
      count++;
      getCurrentDisplay(model.getCurrentShapes(count));
      try {
        Thread.sleep(timeConverter);
      } catch (Exception e) {

      }
    }
  }

}
