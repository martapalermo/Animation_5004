package cs5004.animator.view;

import cs5004.animator.model.animation.AnimatorModel;
import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Shape;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.List;

public class GraphicsView extends JFrame implements IView {

  private List<Shape> model;
  private GraphicsPanel panel;


  GraphicsView(List<Shape> model) {
    super("Animation Window");
    setLocation(0,0); // top left corner
    setSize(600, 400);
    setLayout(null);
    setVisible(true);


    this.model = model;

    JScrollBar horBar = new JScrollBar(JScrollBar.HORIZONTAL, 300, 100,
        0,600);
    JScrollBar verBar = new JScrollBar(JScrollBar.VERTICAL, 300, 100,
        0, 600);

    this.panel = new GraphicsPanel(model); //panel that scroll pane displays

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
        /// offset for X
        // subtract e from get X
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
        // offset for Y
        //subtract e from get Y
        panel.setOffsetY(e.getValue());
      }
    }

    horBar.addAdjustmentListener(new ALHorizontal());
    verBar.addAdjustmentListener(new ALVertical());

    setLayout(new BorderLayout());
    this.getContentPane().add(horBar, BorderLayout.SOUTH);
    this.getContentPane().add(verBar, BorderLayout.EAST);
    this.setVisible(true);

  }

  public JComponent getPanel() {
    return panel;
  }

  public static void main(String[] args) {
    AnimatorModel obj = new AnimatorModel();

    obj.addShape(new Oval(50, 50, 3, 30, 40,40, 150,
        250,0), "oval" );

    obj.move("oval", 70, 70, 50, 50, 5, 25);

   // Runnable r = new Runnable() {
//      @Override
//      public void run() {
//        try {
//          UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
//        } catch (Exception useDefault) {

        //} // should this be passing List<Shape> model
    GraphicsView gv = new GraphicsView(obj.getCurrentShapes(3));
    gv.getCurrentDisplay(obj.getCurrentShapes(5));

    int count = 0;
    while (count < 30) {
      count++;
      gv.getCurrentDisplay(obj.getCurrentShapes(count));
      System.out.println(obj.getCurrentShapes(count));
          try {
            Thread.sleep(100);
          } catch (Exception e) {

          }
        }

//        JFrame frame = new JFrame(gv.getClass().getSimpleName());
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLocationByPlatform(true);
//        frame.setContentPane(gv.getPanel());
//        frame.pack();
        // Dimension d = frame.getSize();
        // frame.setSize(new Dimension(d.width, 400));
//        frame.setSize(600,400);
//        frame.setMinimumSize(frame.getSize());
//
//        frame.setVisible(true);
//        }
//    };
//    SwingUtilities.invokeLater(r);
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


//
//  private final GraphicsPanel panel;
//  private JLabel display;
//  private JScrollBar scrollBar;
//
//  public GraphicsView(List<Shape> model) {
//    super("Animation");
//    setSize(500, 400); // window size
//    setVisible(true); // visibility is always set true
//    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    setLayout(null);
//    this.panel = new GraphicsPanel(model);
//    this.add(this.panel);
//    this.panel.setVisible(true);
//  }

//  /**
//   * Display's this view.
//   */
//  @Override
//  public void getCurrentDisplay(List<Shape> model) {
//    this.panel.updateModel(model);
//    this.repaint();
//  }
//
//  @Override
//  public void go(String outFile) {
//
//  }
}
