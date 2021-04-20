package cs5004.animator.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.List;

import javax.swing.*;

import cs5004.animator.controller.Controller;
import cs5004.animator.model.animation.ReadonlyAnimator;
import cs5004.animator.model.shape.Shape;

public class InteractiveViewImpl extends JFrame implements InteractiveView, ActionListener {
  private GraphicsPanel panel;
  private ReadonlyAnimator model;
  private final int timeConverter;

  JFrame frame = new JFrame();
  JButton start = new JButton("Start");
  JButton pause = new JButton("Pause");
  JButton resume = new JButton("Resume");
  JButton restart = new JButton("Restart");
  JButton loop = new JButton("loop");
  JButton speedUp = new JButton("Speed +");
  JButton speedDown = new JButton("Speed -");

  public InteractiveViewImpl(ReadonlyAnimator model, int speed) {
    if (model == null) {
      throw new IllegalArgumentException("Model cannot be null.");
    }

    if (model.copyShapesList().size() == 0) {
      throw new IllegalArgumentException("Model cannot be empty.");
    }

    this.model = model;
    this.timeConverter = 100 / speed;
    int [] canvas = this.model.getCanvas();

    this.panel = new GraphicsPanel(); // panel with scroll panes!

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocation(canvas[0], canvas[1]);
    setSize(canvas[2], canvas[3]);
    setLayout(null);
    setVisible(true);

    JScrollBar horizontalBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 100,
        -600,600);
    JScrollBar verticalBar = new JScrollBar(JScrollBar.VERTICAL, 0, 100,
        -600,600);

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


    this.start.setBounds(10, 24, 40, 35);
    this.start.setFocusable(true);
    this.start.addActionListener(this);

    this.pause.setBounds(50, 24, 50, 35);
    this.pause.setFocusable(true);
    this.pause.addActionListener(this);

    this.resume.setBounds(100, 24, 60, 35);
    this.resume.setFocusable(true);
    this.resume.addActionListener(this);

    this.restart.setBounds(160, 24, 60, 35);
    this.restart.setFocusable(true);
    this.restart.addActionListener(this);

    this.loop.setBounds(220, 24, 40, 35);
    this.loop.setFocusable(true);
    this.loop.addActionListener(this);

    this.speedUp.setBounds(260, 10, 65, 35);
    this.speedUp.setFocusable(true);
    this.speedUp.addActionListener(this);

    this.speedDown.setBounds(260, 45, 65, 35);
    this.speedDown.setFocusable(true);
    this.speedDown.addActionListener(this);

    frame.add(start);
    frame.add(pause);
    frame.add(resume);
    frame.add(restart);
    frame.add(loop);
    frame.add(speedUp);
    frame.add(speedDown);

    frame.add(panel);
  }

  @Override
  public void runView() {
    int count = 0;
    while (count < 1000000) {
      count++;
      getCurrentDisplay(model.getCurrentShapes(count));
      try {
        Thread.sleep(timeConverter);
      } catch (Exception e) {
        throw new IllegalStateException("Issue with speed/timing.");
      }
    }
  }

  @Override
  public void getCurrentDisplay(List<Shape> shapesList) {
    this.panel.updateModel(shapesList);
  }

  // Set buttons to their respective methods (actions)
  @Override
  public void setListeners(Controller controller) {
  }

  @Override
  public void start() {

  }

  @Override
  public void pause() {

  }

  @Override
  public void resume() {

  }

  @Override
  public void restart() {

  }

  @Override
  public void loop() {

  }

  @Override
  public void speedUp() {

  }

  @Override
  public void slowDown() {

  }

  @Override
  public void refresh() {

  }

  /**
   * Invoked when an action occurs.
   *
   * @param e the event to be processed
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == start) {
      // enter action for start
      // could just runView here? or prompt the start of the animation
    }
    else if (e.getSource() == pause) {
      // enter action for pause
    }
    else if (e.getSource() == resume) {
      // enter action for resume
    }
    else if (e.getSource() == restart) {
      // enter action for restart
    }
    else if (e.getSource() == loop) {
      // enter action for loop
    }
    else if (e.getSource() == speedUp) {
      // enter action for speed up
    }
    else if (e.getSource() == speedDown) {
      // enter action for speed down
    }
  }

}
