package cs5004.animator;

public interface Event {


//  /**
//   * Change the color of the given shape.
//   * @param shape the {@link Shape} to change color
//   * @param red new red value, a double
//   * @param blue new blue value, a double
//   * @param green new green value, a double
//   * @param start color change start time, an int
//   * @param stop color stop time, an int
//   */
//  void changeColor(Shape shape, double red, double blue, double green, int start, int stop);
//
//  /**
//   * Change the shape's width.
//   * @param shape the {@link Shape} to be scaled
//   * @param width new width, a double
//   * @param start scale start time, an int
//   * @param stop scale stop time, an int
//   */
//  void scaleWidth(Shape shape, double width, int start, int stop);
//
//  /**
//   * Change the shape's height
//   * @param shape the {@link Shape} to be scaled
//   * @param height new height, a double
//   * @param start scale start time, an int
//   * @param stop scale stop time, an int
//   */
//  void scaleHeight(Shape shape, double height, int start, int stop);

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
   */
  void setValues(Shape shape);
}
