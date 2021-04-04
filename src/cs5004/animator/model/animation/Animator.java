package cs5004.animator.model.animation;

import java.util.NoSuchElementException;

import cs5004.animator.model.shape.Shape;

/**
 * Represents a collection of {@link Shape}s and their transformations.
 */
public interface Animator extends ReadonlyAnimator {

  /**
   * Add a shape to the list.
   * @param shape the {@link Shape} to be added to the list
   * @param name a unique, non-empty, non-null name for the shape within the list, a String
   * @throws IllegalArgumentException if the name is empty, null, or already exists for a
   *      shape in the list, or if the shape is null
   */
  void addShape(Shape shape, String name) throws IllegalArgumentException;

  /**
   * Remove a shape from the list.
   * @param name name of the shape to be removed
   * @throws NoSuchElementException if there is no shape with the given name
   */
  void removeShape(String name) throws NoSuchElementException;

  /**
   * Move the given shape to the new position.
   * @param name the name of the {@link Shape} to be moved, a String
   * @param x new x coordinate, a double
   * @param y new y coordinate, a double
   * @param originalX old x coordinate, a double
   * @param originalY old y coordinate, a double
   * @param start move start time, an int
   * @param stop move stop time, an int
   * @throws IllegalArgumentException if the start or stop times are out of bounds of the shape's
   *      appear/disappear window, if the stop time is less than or equal to the start time, or if
   *      the shape is already moving in this window, or if no shape if the list has the given name
   */
  void move(String name, double x, double y, int originalX, int originalY, int start, int stop)
          throws IllegalArgumentException;

  /**
   * Change the color of the given shape.
   * @param name the name of the {@link Shape} to change color, a String
   * @param red new red value, a double
   * @param blue new blue value, a double
   * @param green new green value, a double
   * @param originalRed original red value, a double
   * @param originalBlue original blue value, a double
   * @param originalGreen original green value, a double
   * @param start color change start time, an int
   * @param stop color stop time, an int
   * @throws IllegalArgumentException if the start or stop times are out of bounds of the shape's
   *      appear/disappear window, if the stop time is less than or equal to the start time or if
   *      the shape is already changing colors in this window, or if the red, blue, or green values
   *      are out of range (0-255), or if no shape in the list has the given name
   */
  void changeColor(String name, double red, double green, double blue, double originalRed, double
          originalGreen, double originalBlue, int start, int stop) throws IllegalArgumentException;

  /**
   * Change the shape's scale.
   *
   * @param name name of the {@link Shape} to be scaled, a String
   * @param width new width, a double
   * @param height new height, a double
   * @param originalHeight original height, a double
   * @param originalWidth original width, a double
   * @param start scaling start time, an int
   * @param stop scaling stop time, an int
   * @throws IllegalArgumentException if the start or stop times are out of bounds of the shape's
   *      appear/disappear window, or if the shape's width and/or height is already scaling in this
   *      window, or if width and/or height <= 0, or if no shape in the list has the given name
   */
  void scaleShape(String name, double width, double height, double originalHeight, double
          originalWidth, int start, int stop) throws IllegalArgumentException;
}
