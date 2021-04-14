package cs5004.animator.model.animation;

import java.util.List;

import cs5004.animator.model.shape.Shape;

/**
 * This interface contains the getters for classes that implement Animator.
 */
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

  /**
   * An SVG representation of the animation
   * @return SVG String
   */
  String getSVGAnimation();

  int[] getCanvas();

}
