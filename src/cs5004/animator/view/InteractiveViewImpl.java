package cs5004.animator.view;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;

import cs5004.animator.model.animation.ReadonlyAnimator;
import cs5004.animator.model.shape.Shape;

public class InteractiveViewImpl extends JFrame implements InteractiveView {
  private GraphicsPanel panel;
  private ReadonlyAnimator model;
  private int speed;

  public InteractiveViewImpl(ReadonlyAnimator model, int speed) {
    if (model == null) {
      throw new IllegalArgumentException("Model cannot be null.");
    }

    if (model.copyShapesList().size() == 0) {
      throw new IllegalArgumentException("Model cannot be empty.");
    }

    this.panel = new GraphicsPanel();
    this.model = model;
    this.speed = speed;
  }

  @Override
  public void runView() {

  }

  @Override
  public void getCurrentDisplay(List<Shape> shapesList) {

  }

  // Set buttons to their respective methods (actions)
  @Override
  public void setListeners(ActionListener actionEvent) {

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
}
