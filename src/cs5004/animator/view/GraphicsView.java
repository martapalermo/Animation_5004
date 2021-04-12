package cs5004.animator.view;

import cs5004.animator.model.shape.Shape;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class GraphicsView implements IView {

  private List<Shape> model;
  private JComponent panel = null;

  // List<Shape> model
  GraphicsView() {
    panel = new JPanel(new BorderLayout(2,2));
    panel.setBorder(new EmptyBorder(2,2,2,2));

    JPanel p = new JPanel();
    panel.add(new JScrollPane(p, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
  }

  public JComponent getPanel() {
    return panel;
  }

  public static void main(String[] args) {
    Runnable r = new Runnable() {
      @Override
      public void run() {
        try {
          UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception useDefault) {

        } // should this be passing List<Shape> model
        GraphicsView gv = new GraphicsView();

        JFrame frame = new JFrame(gv.getClass().getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setContentPane(gv.getPanel());
        frame.pack();
        // Dimension d = frame.getSize();
        // frame.setSize(new Dimension(d.width, 400));
        frame.setSize(600,400);
        frame.setMinimumSize(frame.getSize());

        frame.setVisible(true);
        }
    };
    SwingUtilities.invokeLater(r);
  }

  /**
   * Display this view.
   *
   * @param shapesList
   */
  @Override
  public void getCurrentDisplay(List<Shape> shapesList) {

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
