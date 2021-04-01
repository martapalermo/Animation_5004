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
  public void testToStringRectangleWithName() {
    rectangle.setName("Tomato red rectangle");
    assertEquals("Name: Tomato red rectangle" + "\n" + "Type: rectangle\n"
        + "Min corner: (4.0,3.0), Width: 5.0, Height: 5.0, Color: (255.0,99.0,71.0)\n"
        + "Appears at t=1\n" + "Disappears at t=25\n", rectangle.toString());
  }

  @Test
  public void testToStringOval() {
    assertEquals("Name: " + "\n" + "Type: oval\n" + "Center: (0.0,0.0), "
        + "X radius: 2.0, Y radius: 4.0, Color: (0.0,0.0,128.0)\n" + "Appears at t=5\n"
        + "Disappears at t=10\n", oval.toString());
  }

  @Test
  public void testToStringOvalWithName() {
    oval.setName("Navy oval");
    assertEquals("Name: Navy oval" + "\n" + "Type: oval\n" + "Center: (0.0,0.0), "
        + "X radius: 2.0, Y radius: 4.0, Color: (0.0,0.0,128.0)\n" + "Appears at t=5\n"
        + "Disappears at t=10\n", oval.toString());
  }

  @Test
  public void testGetHeight() {
    assertEquals(8, oval.getHeight(), EPSILON);
    assertEquals(5, rectangle.getHeight(), EPSILON);
  }

  @Test
  public void testGetWidth() {
    assertEquals(4, oval.getWidth(), EPSILON);
    assertEquals(5, rectangle.getWidth(), EPSILON);
  }

  @Test
  public void testGetDisappearTime() {
    assertEquals(10, oval.getDisappearTime(), EPSILON);
    assertEquals(25, rectangle.getDisappearTime(), EPSILON);
  }

  @Test
  public void testGetAppearTime() {
    assertEquals(5, oval.getAppearTime(), EPSILON);
    assertEquals(1, rectangle.getAppearTime(), EPSILON);
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
