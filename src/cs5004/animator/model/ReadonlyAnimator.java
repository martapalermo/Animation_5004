package cs5004.animator.model;

import java.util.List;

public interface ReadonlyAnimator {

  /**
   * Returns a list of {@link Shape}s that appear on screen at the given tick.
   * @param tick current frame, an int
   * @return List of {@link Shape}s on screen
   */
  List<Shape> getCurrentShapes(int tick);

  /**
   * A text description of the animation.
   * @return animation description, a String
   */
  String getAnimation();
}
