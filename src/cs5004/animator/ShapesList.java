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
   * @param shape the {@link Shape} to be moved
   * @param x new x coordinate, a double
   * @param y new y coordinate, a double
   * @param start move start time, an int
   * @param stop move stop time, a double
   * @throws IllegalArgumentException if the start or stop times are out of bounds of the shape's
   * appear/disappear window, or if the shape is already moving, or if the shape is null
   */
  // Accounting for timing may be better suited for controller?
  void move(Shape shape, double x, double y, int start, int stop) throws IllegalArgumentException;

  /**
   * Change the color of the given shape.
   * @param shape the {@link Shape} to change color
   * @param red new red value, a double
   * @param blue new blue value, a double
   * @param green new green value, a double
   * @throws IllegalArgumentException if the red, blue, or green values are out of range (0-255),
   * or if the shape is null
   */
  void changeColor(Shape shape, double red, double blue, double green) throws IllegalArgumentException;

  /**
   * Scale the given shape by the scalar.
   * @param shape the {@link Shape} to be scaled
   * @param scalar factor to scale by, a double
   * @throws IllegalArgumentException illegal scalar (unsure what), or if the shape is null
   */
  void scale(Shape shape, double scalar) throws IllegalArgumentException;

  /**
   * Returns a list of {@link Shape}s that appear on screen at the given tick.
   * @param tick current frame, an int
   * @return List of {@link Shape}s on screen
   */
  List<Shape> getCurrentShapes(int tick);
}
