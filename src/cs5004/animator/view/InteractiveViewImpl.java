package cs5004.animator.view;

import java.awt.BorderLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollBar;
import javax.swing.JPanel;

import cs5004.animator.controller.ButtonListener;
import cs5004.animator.controller.InteractiveController;
import cs5004.animator.model.animation.ReadonlyAnimator;
import cs5004.animator.model.shape.Shape;

/**
 * This is the InteractiveViewImpl view class, it extends JFrame and implements
 * our InteractiveView interface.
 * This interactiveView allows the controller to prompt the view to outputs
 * a java swing window visual representation of the animation, with buttons that are linked
 * to interactive controls the user can modify the animation with.
 */
public class InteractiveViewImpl extends JFrame implements InteractiveView {
  private GraphicsPanel panel;
  private ReadonlyAnimator model;
  private int speed;
  private ButtonListener buttonListener;
  private int endTime;

  //JFrame frame = new JFrame();

  JButton start = new JButton("Start");
  JButton pause = new JButton("Pause");
  JButton resume = new JButton("Resume");
  JButton restart = new JButton("Restart");
  JCheckBox loop = new JCheckBox("loop");
  JButton speedUp = new JButton("Speed +");
  JButton speedDown = new JButton("Speed -");

  /**
   * InteractiveViewImpl constructor. Takes in a readonly animator model.
   * @param model readonly animation model, ReadonlyAnimator interface
   * @throws IllegalArgumentException if the model is null or empty.
   */
  public InteractiveViewImpl(ReadonlyAnimator model) {
    if (model == null) {
      throw new IllegalArgumentException("Model cannot be null.");
    }

    if (model.copyShapesList().size() == 0) {
      throw new IllegalArgumentException("Model cannot be empty.");
    }

    this.model = model;
    int [] canvas = this.model.getCanvas();

    this.speed = 0;

    this.panel = new GraphicsPanel(); // panel with scroll panes!
    this.buttonListener = new ButtonListener();
    this.endTime = 0;
    this.setEndTime();

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocation(canvas[0], canvas[1]);
    setSize(canvas[2] + 100, canvas[3] + 150);
    setLayout(null);
    setVisible(true);

    JScrollBar horizontalBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 100,
        -600,600);
    JScrollBar verticalBar = new JScrollBar(JScrollBar.VERTICAL, 0, 100,
        -600,600);

    BorderLayout bl = new BorderLayout(0,0);
    setLayout(bl);
    //this.panel.setVisible(true);
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

    //JPanel checkBoxPanel = new JPanel();
    //checkBoxPanel.setBorder(BorderFactory.createTitledBorder("Loop"));
    //checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.PAGE_AXIS));
    //JCheckBox loop = new JCheckBox("loop");
    this.loop.setSelected(false);
    this.loop.setFocusable(true);
    this.loop.setActionCommand("Loop Checkbox");



    JPanel buttonPanel = new JPanel();

   // this.start.setBounds(10, 24, 40, 35);
    this.start.setFocusable(true);
    this.start.setActionCommand("Start Button");

   // this.pause.setBounds(50, 24, 50, 35);
    this.pause.setFocusable(true);
    this.pause.setActionCommand("Pause Button");

    //this.resume.setBounds(100, 24, 60, 35);
    this.resume.setFocusable(true);
    this.resume.setActionCommand("Resume Button");

    //this.restart.setBounds(160, 24, 60, 35);
    this.restart.setFocusable(true);
    this.restart.setActionCommand("Restart Button");

    //this.loop.setBounds(220, 24, 40, 35);
    this.loop.setFocusable(true);
    this.loop.setActionCommand("Loop Button");

    //this.speedUp.setBounds(260, 10, 65, 35);
    this.speedUp.setFocusable(true);
    this.speedUp.setActionCommand("Speed Up");

    //this.speedDown.setBounds(260, 45, 65, 35);
    this.speedDown.setFocusable(true);
    this.speedDown.setActionCommand("Slow Down");

//    frame.add(start);
//    frame.add(pause);
//    frame.add(resume);
//    frame.add(restart);
//    frame.add(loop);
//    frame.add(speedUp);
//    frame.add(speedDown);

    setLayout(new BorderLayout());
    getContentPane().add(horizontalBar, BorderLayout.PAGE_END);
    getContentPane().add(verticalBar, BorderLayout.LINE_END);


    buttonPanel.add(start, BorderLayout.SOUTH);
    buttonPanel.add(pause, BorderLayout.SOUTH);
    buttonPanel.add(resume, BorderLayout.SOUTH);
    buttonPanel.add(restart, BorderLayout.SOUTH);
    buttonPanel.add(speedUp, BorderLayout.SOUTH);
    buttonPanel.add(speedDown, BorderLayout.SOUTH);
    buttonPanel.add(loop, BorderLayout.SOUTH);

    getContentPane().add(this.panel, BorderLayout.CENTER);
    //add(buttonPanel, BorderLayout.SOUTH);
    this.panel.add(buttonPanel);
    //this.panel.add(checkBoxPanel);
    this.setVisible(true);
    setResizable(true);
  }

  /**
   * Helper method facilitating start of animation.
   */
  @Override
  public void runView() {
    int count = 0;
    while (count < 100) {
      count++;
      getCurrentDisplay(model.getCurrentShapes(count));
//      try {
//        Thread.sleep(this.speed);
//      } catch (Exception e) {
//        throw new IllegalStateException("Issue with speed/timing.");
//      }
    }
  }


  /**
   * Display this view.
   *
   * @param shapesList List of {@link Shape}s
   */
  @Override
  public void getCurrentDisplay(List<Shape> shapesList) {
    this.panel.updateModel(shapesList);
  }

  /**
   * Helper method facilitating start of animation with given count.
   * @param count int value
   */
  public void run(int count) {
    //System.out.println(count);
//    while (count < 100) {
//      this.getCurrentDisplay(this.model.getCurrentShapes(count));
//      count++;
//    }
    this.getCurrentDisplay(this.model.getCurrentShapes(count));
  }

  /**
   * Helper method that sets buttons to their respective action- methods.
   * @param controller interactiveController interface
   */
  @Override
  public void setListeners(InteractiveController controller) {
    Map<String, Runnable> buttonClickedMap = new HashMap<>();

    // Test what happens if these buttons are pressed more than once in a row
    this.start.addActionListener(c -> controller.start());
    buttonClickedMap.put("Start Button", controller::start);

    this.pause.addActionListener(c -> controller.stop());
    buttonClickedMap.put("Pause Button", controller::stop);

    this.resume.addActionListener(c -> controller.start());
    buttonClickedMap.put("Resume Button", controller::start);

    this.restart.addActionListener(c -> controller.restart());
    buttonClickedMap.put("Restart Button", controller::restart);

    // Should default be looping or not?
    this.loop.addActionListener(c -> controller.loop());
    buttonClickedMap.put("Loop Button", controller::loop);

    this.speedUp.addActionListener(c -> controller.speedUp());
    buttonClickedMap.put("Speed Up", controller::speedUp);

    this.speedDown.addActionListener(c -> controller.slowDown());
    buttonClickedMap.put("Slow Down", controller::slowDown);

    this.buttonListener.setButtonClickedActionMap(buttonClickedMap);
  }

  /**
   * Setter method for speed.
   * @param speed speed of animation, int
   */
  @Override
  public void setSpeed(int speed) {
    this.speed = speed;
  }

  /**
   * Getter method for endTime for animation.
   * @return  endTime, int
   */
  @Override
  public int getEndTime() {
    return this.endTime;
  }

  /**
   * Setter method for endTime.
   */
  private void setEndTime() {
    for (Shape shape : model.copyShapesList()) {
      if (shape.getDisappearTime() > this.endTime) {
        this.endTime = shape.getDisappearTime();
      }
    }
  }
}
