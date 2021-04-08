package cs5004.animator.model.animation;

import java.util.NoSuchElementException;

import cs5004.animator.model.shape.Shape;
import cs5004.animator.util.AnimationBuilder;

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
   * @param x new x coordinate, int
   * @param y new y coordinate, int
   * @param originalX old x coordinate, int
   * @param originalY old y coordinate, int
   * @param start move start time, an int
   * @param stop move stop time, an int
   * @throws IllegalArgumentException if the start or stop times are out of bounds of the shape's
   *      appear/disappear window, if the stop time is less than or equal to the start time, or if
   *      the shape is already moving in this window, or if no shape if the list has the given name
   */
  void move(String name, int x, int y, int originalX, int originalY, int start, int
          stop) throws IllegalArgumentException;

  /**
   * Change the color of the given shape.
   * @param name the name of the {@link Shape} to change color, a String
   * @param red new red value, int
   * @param blue new blue value, int
   * @param green new green value, int
   * @param originalRed original red value, int
   * @param originalBlue original blue value, int
   * @param originalGreen original green value, int
   * @param start color change start time, an int
   * @param stop color stop time, an int
   * @throws IllegalArgumentException if the start or stop times are out of bounds of the shape's
   *      appear/disappear window, if the stop time is less than or equal to the start time or if
   *      the shape is already changing colors in this window, or if the red, blue, or green values
   *      are out of range (0-255), or if no shape in the list has the given name
   */
  void changeColor(String name, int red, int green, int blue, int originalRed, int
          originalGreen, int originalBlue, int start, int stop) throws IllegalArgumentException;

  /**
   * Change the shape's scale.
   *
   * @param name name of the {@link Shape} to be scaled, a String
   * @param width new width, int
   * @param height new height, int
   * @param originalHeight original height, int
   * @param originalWidth original width, int
   * @param start scaling start time, an int
   * @param stop scaling stop time, an int
   * @throws IllegalArgumentException if the start or stop times are out of bounds of the shape's
   *      appear/disappear window, or if the shape's width and/or height is already scaling in this
   *      window, or if width and/or height <= 0, or if no shape in the list has the given name
   */
  void scaleShape(String name, int width, int height, int originalHeight, int
          originalWidth, int start, int stop) throws IllegalArgumentException;

  /**
   * Transforms the shape with the given name.
   * @param name The name of the shape
   * @param start The start time of this transformation
   * @param x1 The initial x-position of the shape
   * @param y1 The initial y-position of the shape
   * @param width1 The initial width of the shape
   * @param height1 The initial height of the shape
   * @param red1 The initial red color-value of the shape
   * @param green1 The initial green color-value of the shape
   * @param blue1 The initial blue color-value of the shape
   * @param stop The end time of this transformation
   * @param x2 The final x-position of the shape
   * @param y2 The final y-position of the shape
   * @param width2 The final width of the shape
   * @param height2 The final height of the shape
   * @param red2 The final red color-value of the shape
   * @param green2 The final green color-value of the shape
   * @param blue2 The final blue color-value of the shape
   */
  public void transform(String name, int start, int x1, int y1, int width1, int height1, int red1,
                        int green1, int blue1, int stop, int x2, int y2, int width2, int height2,
                        int red2, int green2, int blue2);
}
