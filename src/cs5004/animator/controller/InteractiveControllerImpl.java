package cs5004.animator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import cs5004.animator.view.InteractiveView;

/**
 * Interactive Controller implementing class, implements Interactive controller interface
 * and ActionListener interface.
 * This controller is specific to our visual/interactive graphic view.
 */
public class InteractiveControllerImpl implements InteractiveController, ActionListener {

  private InteractiveView view;
  private int speed;
  private final Timer timer;
  private int tick;
  private boolean looping;
  private final StringBuilder log;
  private static int TIME_CONVERTER = 600;

  /**
   * Constructor for our interactive controller implementing class.
   * @param view InteractiveView view, interface
   * @param speed speed of animation, int
   */
  public InteractiveControllerImpl(InteractiveView view,
                                   int speed) {
    this.view = view;
    this.log = new StringBuilder();


    if (speed < 1) {
      throw new IllegalArgumentException("Speed cannot be less than 1.");
    }
    this.speed = speed;
    this.view.setSpeed(this.speed);

    this.tick = 0;
    this.timer = new Timer(TIME_CONVERTER / this.speed, this);
    this.looping = false;
  }

  /**
   * Helper method that sets the action listeners
   * and starts the interactive controller.
   */
  @Override
  public void startController() {
    this.view.setListeners(this);
  }

  /**
   * Invoked when an action occurs.
   *
   * @param e the event to be processed
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (this.tick < this.view.getEndTime()) {
      this.view.run(this.tick);
      this.tick++;
    }

    else if (this.tick == this.view.getEndTime()  && this.looping) {
      this.tick = 0;
    }
  }

  /**
   * Method that assigns the specific action for start button.
   */
  @Override
  public void start() {
    this.timer.start();
    this.log.append("Clicked start button.\n");
  }

  /**
   * Method that assigns the specific action for stop/pause button.
   */
  @Override
  public void stop() {
    this.timer.stop();
    this.log.append("Clicked stop button.\n");
  }

  /**
   * Method that assigns the specific action for restart/resume button.
   */
  @Override
  public void restart() {
    this.tick = 0;
    this.log.append("Clicked restart button.\n");
  }

  /**
   * Method that assigns the specific action for loop checkbox.
   */
  @Override
  public void loop() {
    this.looping = !this.looping;
    this.log.append("Clicked loop checkbox.\n");
  }

  /**
   * Method that assigns the specific action for speed up button.
   */
  @Override
  public void speedUp() {
    this.speed++;
    this.timer.setDelay(TIME_CONVERTER / this.speed);
    this.view.setSpeed(this.speed);
    this.log.append("Clicked speed-up button.\n");
  }

  /**
   * Method that assigns the specific action for slow down button.
   */
  @Override
  public void slowDown() {
    if (this.speed > 1) {
      this.speed--;
      this.timer.setDelay(TIME_CONVERTER / this.speed);
      this.view.setSpeed(this.speed);
      this.log.append("Clicked slow-down button.\n");
    }
  }

  /**
   * Getter method for the button logs.
   * @return returns the button click logged activity, String
   */
  @Override
  public String getLog() {
    return this.log.toString();
  }
}
