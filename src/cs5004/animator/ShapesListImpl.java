package cs5004.animator;

import java.util.List;
import java.util.NoSuchElementException;

public class ShapesListImpl implements ShapesList {
  @Override
  public void addShape(Shape shape, String identifier) throws IllegalArgumentException {

  }

  @Override
  public void removeShape(String name) throws NoSuchElementException {

  }

  @Override
  public void move(Shape shape, double x, double y, int start, int stop) throws IllegalArgumentException {

  }

  @Override
  public void changeColor(Shape shape, double red, double blue, double green) throws IllegalArgumentException {

  }

  @Override
  public void scale(Shape shape, double scalar) throws IllegalArgumentException {

  }

  @Override
  public List<Shape> getCurrentShapes(int tick) {
    return null;
  }
}
