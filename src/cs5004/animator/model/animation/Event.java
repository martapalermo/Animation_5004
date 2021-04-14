package cs5004.animator.model.animation;

import java.util.HashMap;

import cs5004.animator.model.shape.Shape;

/**
 * Represents an event or transformation for a shape.
 */
public interface Event {

  /**
   * Get the shape name.
   * @return shapeName, a String
   */
  String getShapeName();

  /**
   * Get the start tick.
   * @return start, an int
   */
  int getStart();

  /**
   * Get the stop tick.
   * @return stop, an int
   */
  int getStop();

  /**
   * Get the event type.
   * @return event name, a String
   */
  String getEvent();

  /**
   * Get the SVG description of an event.
   * @return SVG description, a String
   */
  String getSVG();

  /**
   * Sets the given shape's new values based on the event that occurred.
   * @param shape shape to be transformed
   * @param tick current time, an int
   */
  void setValues(Shape shape, int tick);

  Event copy();

  HashMap<String, int[]> getValues();
}
