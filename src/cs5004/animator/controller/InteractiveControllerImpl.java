package cs5004.animator.controller;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Timer;

import cs5004.animator.model.animation.Animator;
import cs5004.animator.view.InteractiveView;

public class InteractiveControllerImpl implements Controller {
  private Animator model;
  private InteractiveView view;
  private int speed;
  private Timer timer;
  private final static int TIME_CONVERTER = 100;

  public InteractiveControllerImpl(Animator model, InteractiveView view, int speed) {
    this.model = model;
    this.view = view;

    if (speed < 1) {
      throw new IllegalArgumentException("Speed cannot be less than 1.");
    }
    this.speed = speed;
    //this.view.setSpeed(this.speed);

    this.timer = new Timer(TIME_CONVERTER / this.speed, this.configureButtonListener());
  }

  @Override
  public void startController() {
    this.view.runView();
  }

  private ActionListener configureButtonListener() {
    Map<String, Runnable> buttonClickedMap = new HashMap<>();
    ButtonListener buttonListener = new ButtonListener();

    // Test what happens if these buttons are pressed more than once in a row
    buttonClickedMap.put("Start Button", () -> this.timer.start());
    buttonClickedMap.put("Pause Button", () -> this.timer.stop());
    buttonClickedMap.put("Resume Button", () -> this.timer.start());
    buttonClickedMap.put("Restart Button", () -> this.timer.restart());

    // Should default be looping or not?
    buttonClickedMap.put("Loop Button", () -> this.timer.setRepeats(!(this.timer.isRepeats())));
    buttonClickedMap.put("Speed Up", () -> {this.speed++;
                                            this.timer.setDelay(TIME_CONVERTER / this.speed);
                                            this.view.setSpeed(this.speed);});
    buttonClickedMap.put("Slow Down", () -> {this.speed--;
                                             this.timer.setDelay(TIME_CONVERTER / this.speed);
                                             this.view.setSpeed(this.speed);});
    this.view.setListeners(buttonListener);

    return buttonListener;
  }
}
