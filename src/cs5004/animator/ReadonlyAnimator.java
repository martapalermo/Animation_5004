package cs5004.animator;

public interface ReadonlyAnimator {
  /**
   * Returns a list of {@link Shape}s that appear on screen at the given tick.
   * @param tick current frame, an int
   * @return List of {@link Shape}s on screen
   */
  Animator getCurrentShapes(int tick);
}
