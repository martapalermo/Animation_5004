package cs5004.animator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Timer;

import cs5004.animator.model.animation.Animator;
import cs5004.animator.view.InteractiveView;

public class InteractiveControllerImpl implements InteractiveController, ActionListener {
  private Animator model;
  private InteractiveView view;
  private int speed;
  private Timer timer;
  private int tick;
  private ButtonListener buttonListener;
  private boolean looping;
  private StringBuilder log;
  //private ActionListener timeListener();
  private final static int TIME_CONVERTER = 500;

  public InteractiveControllerImpl(Animator model, InteractiveView view,
                                   int speed) {
    this.model = model;
    this.view = view;
    this.log = new StringBuilder();


    if (speed < 1) {
      throw new IllegalArgumentException("Speed cannot be less than 1.");
    }
    this.speed = speed;
    this.view.setSpeed(this.speed);

    this.buttonListener = new ButtonListener();
    this.tick = 0;
    this.timer = new Timer(TIME_CONVERTER / this.speed, this);
    this.looping = false;
    }
    //this.timer.start();

  @Override
  public void startController() {
//    int count = 0;
//    //this.timer.start();
//    //timer.setDelay(100000);
//    while (this.timer.isRunning() && this.tick < 100) {
//      System.out.println(this.tick);
//      this.view.getCurrentDisplay(model.getCurrentShapes(this.tick));
//      //count++;
////      try {
////        Thread.sleep(this.speed);
////      } catch (Exception e) {
////        throw new IllegalStateException("Issue with speed/timing.");
////      }
//    }

    this.view.setListeners(this);
  }

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

  @Override
  public void start() {
    this.timer.start();
    this.log.append("Clicked start button.");
  }

  @Override
  public void stop() {
    this.timer.stop();
    this.log.append("Clicked stop button.");
  }

  @Override
  public void restart() {
    this.tick = 0;
    this.log.append("Clicked restart button.");
  }

  @Override
  public void loop() {
    this.looping = !this.looping;
    this.log.append("Clicked loop checkbox.");
  }

  @Override
  public void speedUp() {
    this.speed++;
    this.timer.setDelay(TIME_CONVERTER / this.speed);
    this.view.setSpeed(this.speed);
    this.log.append("Clicked speed-up button.");
  }

  @Override
  public void slowDown() {
    if (this.speed > 1) {
      this.speed--;
      this.timer.setDelay(TIME_CONVERTER / this.speed);
      this.view.setSpeed(this.speed);
      this.log.append("Clicked speed-down button.");
    }
  }

  @Override
  public StringBuilder getLog() {
    return this.log;
  }
}
