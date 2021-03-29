package cs5004.animator;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Represents a collection of {@link Shape}s.
 */
public interface ShapesList {

  /**
   * Add a shape to the list.
   * @param shape the {@link Shape} to be added to the list
   * @param identifier a unique, non-empty, non-null name for the shape within the list, a String
   * @throws IllegalArgumentException if the identifier is empty, null, or already exists for a
   * shape in the list, or if the shape is null
   */
  void addShape(Shape shape, String identifier) throws IllegalArgumentException;

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
   * @param start move start time, an int
   * @param stop move stop time, an int
   * @throws IllegalArgumentException if no shape in the list has the given name
   */
  void move(String name, double x, double y, int start, int stop) throws IllegalArgumentException;

  // NEED TO THROW RED, BLUE, GREEN EXCEPTIONS HERE AS WELL AS SHAPE CLASS???
  /**
   * Change the color of the given shape.
   * @param name the name of the {@link Shape} to change color, a String
   * @param red new red value, a double
   * @param blue new blue value, a double
   * @param green new green value, a double
   * @param start color change start time, an int
   * @param stop color stop time, an int
   * @throws IllegalArgumentException if the red, blue, or green values are out of range (0-255),
   * or if no shape in the list has the given name
   */
  void changeColor(String name, double red, double blue, double green, int start, int stop) throws IllegalArgumentException;

  /**
   * Change the shape's width.
   * @param name the name of the {@link Shape} to be scaled, a String
   * @param width new width, a double
   * @param start scale start time, an int
   * @param stop scale stop time, an int
   * @throws IllegalArgumentException if width <= 0, or if no shape in the list has the given name
   */
  void scaleWidth(String name, double width, int start, int stop) throws IllegalArgumentException;

  /**
   * Change the shape's height
   * @param name the name of the {@link Shape} to be scaled, a String
   * @param height new height, a double
   * @param start scale start time, an int
   * @param stop scale stop time, an int
   * @throws IllegalArgumentException if scalar <= 0, or if no shape in the list has the given name
   */
  void scaleHeight(String name, double height, int start, int stop) throws IllegalArgumentException;

  /**
   * Returns a list of {@link Shape}s that appear on screen at the given tick.
   * @param tick current frame, an int
   * @return List of {@link Shape}s on screen
   */
  ShapesList getCurrentShapes(int tick);
}
