package cs5004.animator.model.animation;

import java.util.LinkedHashMap;
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
   * Get the dimensions of the canvas.
   * @return canvas dimensions, an int array [upper left x, upper left y, width, height]
   */
  int[] getCanvas();

  /**
   * Copy list of {@link Shape}s in the model.
   * @return copy of shapes, a List
   */
  List<Shape> copyShapesList();

  /**
   * Copy HashMap of {@link Event}s in the model.
   * @return copy of event data, a LinkedHashMap
   */
  LinkedHashMap<String, List<Event>> copyEvents();
}
