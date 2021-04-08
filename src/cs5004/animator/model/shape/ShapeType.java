package cs5004.animator.model.shape;

public enum ShapeType {
  OVAL,
  RECTANGLE;

  public String getType() {
    if (this == OVAL) {
      return "oval";
    }
    return "rectangle";
  }

}
