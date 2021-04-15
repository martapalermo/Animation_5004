package cs5004.animator.view;

import java.util.List;

import cs5004.animator.model.shape.Shape;

/**
 * Interface for views requiring visuals.
 */
public interface VisualView extends IView {

  /**
   * Get the data of the {@link Shape}s present at the current tick.
   */
  void getCurrentDisplay(List<Shape> shapesList);
}
