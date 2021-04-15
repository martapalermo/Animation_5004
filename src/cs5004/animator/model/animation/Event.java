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
   * Sets the given shape's new values based on the event that occurred.
   * @param shape shape to be transformed
   * @param tick current time, an int
   */
  void setValues(Shape shape, int tick);

  /**
   * Copy the Event.
   * @return copied Event
   */
  Event copy();

  /**
   * Get the values of the Event taking place; key is the attribute changing and value is
   * an array of the old/new values.
   * @return values, a HashMap
   */
  HashMap<String, int[]> getValues();
}
