package cs5004.animator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Timer;

import cs5004.animator.model.animation.Animator;
import cs5004.animator.view.InteractiveView;

public class InteractiveControllerImpl implements Controller, ActionListener {
  private Animator model;
  private InteractiveView view;
  private int speed;
  private Timer timer;
  private int tick;
  private ButtonListener buttonListener;
  private boolean looping;
  //private ActionListener timeListener();
  private final static int TIME_CONVERTER = 100;

  public InteractiveControllerImpl(Animator model, InteractiveView view, int speed) {
    this.model = model;
    this.view = view;

    if (speed < 1) {
      throw new IllegalArgumentException("Speed cannot be less than 1.");
    }
    this.speed = speed;
    //this.view.setSpeed(this.speed);

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

    Map<String, Runnable> buttonClickedMap = new HashMap<>();

    // Test what happens if these buttons are pressed more than once in a row
//    buttonClickedMap.put("Start Button", () -> {while (this.tick < 100) {
//                                                this.view.run(this.tick++);}});
    buttonClickedMap.put("Start Button", () -> this.timer.start());
    buttonClickedMap.put("Pause Button", () -> this.timer.stop());
    buttonClickedMap.put("Resume Button", () -> this.timer.start());
    buttonClickedMap.put("Restart Button", () -> this.tick = 0);

    // Should default be looping or not?
    buttonClickedMap.put("Loop Button", () -> this.looping = !this.looping);
    buttonClickedMap.put("Speed Up", () -> {this.speed++;
      this.timer.setDelay(TIME_CONVERTER / this.speed);
      this.view.setSpeed(this.speed);});
    buttonClickedMap.put("Slow Down", () -> {this.speed--;
      this.timer.setDelay(TIME_CONVERTER / this.speed);
      this.view.setSpeed(this.speed);});

    this.buttonListener.setButtonClickedActionMap(buttonClickedMap);
    this.view.setListeners(buttonListener);
  }

  private void displayView() {
//    if (!this.timer.isRunning()) {
//      this.timer.start();
//    }

    //System.out.println(this.tick);
//    this.tick++;
//    this.view.getCurrentDisplay(model.getCurrentShapes(this.tick));

    //System.out.println(this.tick);
//    while (this.tick < 100) {
//      this.view.getCurrentDisplay(model.getCurrentShapes(this.tick));
//      try {
//        Thread.sleep(this.timer.getDelay());
//      } catch (Exception e) {
//        throw new IllegalStateException("Issue with speed/timing.");
//      }
//    }
    while (this.tick < 100) {
      this.view.run(this.tick);
      this.tick++;
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (this.tick < 101) {
      this.view.run(this.tick);
      this.tick++;

      if (this.tick == 100 && this.looping) {
        this.tick = 0;
      }
    }
  }
}
