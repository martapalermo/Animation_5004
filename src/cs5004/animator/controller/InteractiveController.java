package cs5004.animator.controller;

public interface InteractiveController extends Controller {
  public void start();

  public void stop();

  public void restart();

  public void loop();

  public void speedUp();

  public void slowDown();

  public StringBuilder getLog();
}
