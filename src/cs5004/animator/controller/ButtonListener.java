package cs5004.animator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 * Button Listener class - implements action listener.
 */
public class ButtonListener implements ActionListener {
  private Map<String, Runnable> buttonClickedActions;

  public ButtonListener() {
    this.buttonClickedActions = null;
  }

  public void setButtonClickedActionMap(Map<String, Runnable> map) {
    this.buttonClickedActions = map;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (this.buttonClickedActions.containsKey(e.getActionCommand())) {
      this.buttonClickedActions.get(e.getActionCommand()).run();
    }
  }
}
