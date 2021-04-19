package cs5004.animator.controller;

public interface Controller {
  void processCommand(String command);

  void start();

  void pause();

  void resume();

  void restart();

  void loop();

  void speedUp();

  void slowDown();

  void startController();
}
