import cs5004.animator.Oval;
import cs5004.animator.Rectangle;
import cs5004.animator.Shape;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * test class for all shapes.
 */
public class AbstractShapeTest {

  private Shape oval;
  private Shape rectangle;

  private final double EPSILON = 0.01;

  @Before
  public void setUp() {
    this.oval = new Oval(0,0,5,10,4,
        8, 0, 128,0); // navy blue oval
    this.rectangle = new Rectangle(4,3,1,25,5,5,
        255,71,99); // tomato red rectangle
  }

  @Test
  public void testGetX() {
    assertEquals(0, oval.getX(), EPSILON);
    assertEquals(4, rectangle.getX(), EPSILON);
  }

  @Test
  public void testGetY() {
    assertEquals(0, oval.getY(), EPSILON);
    assertEquals(3, rectangle.getY(), EPSILON);
  }

  @Test
  public void testGetColor() {
    assertEquals("(0.0, 0.0, 128.0)", oval.getColor());
    assertEquals("(255.0, 99.0, 71.0)", rectangle.getColor());
  }

  @Test
  public void testGetRed() {
    assertEquals(0, oval.getRed(), EPSILON);
    assertEquals(255, rectangle.getRed(), EPSILON);
  }

  @Test
  public void testGetGreen() {
    assertEquals(0, oval.getGreen(), EPSILON);
    assertEquals(99, rectangle.getGreen(), EPSILON);
  }

  @Test
  public void testGetBlue() {
    assertEquals(128, oval.getBlue(), EPSILON);
    assertEquals(71, rectangle.getBlue(), EPSILON);
  }

  @Test
  public void testGetNameEmptyString() {
    assertEquals("", rectangle.getName());
  }

  @Test
  public void testSetAndGetName() {
    oval.setName("Navy oval");
    assertEquals("Navy oval", oval.getName());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetEmptyName() throws IllegalArgumentException {
    oval.setName("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetNullName() throws IllegalArgumentException {
    oval.setName(null);
  }

}
