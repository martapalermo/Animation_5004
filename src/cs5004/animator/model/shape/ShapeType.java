package cs5004.animator.model.shape;

/**
 * Enum class that represents the types of shapes
 * that can be created in the animation.
 */
public enum ShapeType {
  OVAL,
  RECTANGLE;

  @Override
  public String toString() {
    if (this == OVAL) {
      return "oval";
    }

    else {
      return "rectangle";
    }
  }
}
