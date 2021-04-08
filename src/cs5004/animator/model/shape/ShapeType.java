package cs5004.animator.model.shape;

/**
 * Enum class that represents the types of shapes
 * that can be created in the animation.
 */
public enum ShapeType {
  OVAL("oval"),
  RECTANGLE("rectangle");

  private String type;

  /**
   * Shape Type constructor with a single parameter for type.
   * @param type type of shape, String
   */
  ShapeType(String type) {
    this.type = type;
  }

  /**
   * Helper method to get shape type.
   * @return type of shape, String
   */
  String getType() {
   return this.type;
  }

  /**
   * Helper method to set new shape type.
   * @param newType new shape type
   */
  void setType(String newType) {
    this.type = newType;
  }

}
