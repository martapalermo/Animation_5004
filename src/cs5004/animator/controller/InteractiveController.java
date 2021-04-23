package cs5004.animator.controller;

/**
 * Controller interface for the visual view specifically/ the interactive view.
 */
public interface InteractiveController extends Controller {
  public void start();

  public void stop();

  public void restart();

  public void loop();

  public void speedUp();

  public void slowDown();

  public String getLog();
}
