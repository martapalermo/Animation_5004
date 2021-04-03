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
  private Shape o;
  private Shape rectangle;
  private Shape r;

  private final double EPSILON = 0.01;

  @Before
  public void setUp() {
    this.oval = new Oval(0,0,5,10,4,
        8, 0, 0,128); // navy blue oval
    this.o = new Oval(0,0,5,10,4,
        8, 0, 0,128);
    o.setName("oval Larry");

    this.rectangle = new Rectangle(4,3,1,25,5,5,
        255,99,71); // tomato red rectangle
    this.r = new Rectangle(4,3,1,25,5,5,
        255,99,71);
    r.setName("rectangle Frank");
  }

  @Test
  public void testToStringRectangle() {
    assertEquals("Name: " + "\n" + "Type: rectangle\n"
        + "Min corner: (4.0,3.0), Width: 5.0, Height: 5.0, Color: (255.0,71.0,99.0)\n"
        + "Appears at t=1\n" + "Disappears at t=25\n", rectangle.toString());
  }

  @Test
  public void testToStringRectangleWithGivenName() {
    assertEquals("Name: rectangle Frank" + "\n" + "Type: rectangle\n"
        + "Min corner: (4.0,3.0), Width: 5.0, Height: 5.0, Color: (255.0,71.0,99.0)\n"
        + "Appears at t=1\n" + "Disappears at t=25\n", r.toString());
  }

  @Test
  public void testToStringRectangleWithNewName() {
    rectangle.setName("Tomato red rectangle");
    assertEquals("Name: Tomato red rectangle" + "\n" + "Type: rectangle\n"
        + "Min corner: (4.0,3.0), Width: 5.0, Height: 5.0, Color: (255.0,71.0,99.0)\n"
        + "Appears at t=1\n" + "Disappears at t=25\n", rectangle.toString());
  }

  @Test
  public void testToStringOval() {
    assertEquals("Name: " + "\n" + "Type: oval\n" + "Center: (0.0,0.0), "
        + "X radius: 2.0, Y radius: 4.0, Color: (0.0,128.0,0.0)\n" + "Appears at t=5\n"
        + "Disappears at t=10\n", oval.toString());
  }

  @Test
  public void testToStringOvalWithGivenName() {
    assertEquals("Name: oval Larry" + "\n" + "Type: oval\n" + "Center: (0.0,0.0), "
        + "X radius: 2.0, Y radius: 4.0, Color: (0.0,128.0,0.0)\n" + "Appears at t=5\n"
        + "Disappears at t=10\n", o.toString());
  }

  @Test
  public void testToStringOvalWithNewName() {
    oval.setName("Navy oval");
    assertEquals("Name: Navy oval" + "\n" + "Type: oval\n" + "Center: (0.0,0.0), "
        + "X radius: 2.0, Y radius: 4.0, Color: (0.0,128.0,0.0)\n" + "Appears at t=5\n"
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

//  @Test
//  public void testGetColor() {
//    assertEquals("(0.0, 0.0, 128.0)", oval.getColor());
//    assertEquals("(255.0, 99.0, 71.0)", rectangle.getColor());
//  }

  @Test
  public void testGetRed() {
    assertEquals(0, oval.getRed(), EPSILON);
    assertEquals(255, rectangle.getRed(), EPSILON);
  }

  @Test
  public void testGetGreen() {
    assertEquals(128.0, oval.getGreen(), EPSILON);
    assertEquals(71.0, rectangle.getGreen(), EPSILON);
  }

  @Test
  public void testGetBlue() {
    assertEquals(0, oval.getBlue(), EPSILON);
    assertEquals(99.0, rectangle.getBlue(), EPSILON);
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

  @Test(expected = IllegalArgumentException.class)
  public void testSetColorGreaterThanBlue() throws IllegalArgumentException {
    rectangle.setColor(47, 92, 670);
    oval.setColor(56, 0, 278);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetColorNegativeBlue() throws IllegalArgumentException {
    rectangle.setColor(198, 200, -255);
    oval.setColor(9, 17, -150);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetColorGreaterThanGreen() throws IllegalArgumentException {
    rectangle.setColor(0, 258, 110);
    oval.setColor(220, 500, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetColorNegativeGreen() throws IllegalArgumentException {
    rectangle.setColor(190, -50, 255);
    oval.setColor(55, -255, 0);
  }

  // value greater than 255
  @Test(expected = IllegalArgumentException.class)
  public void testSetColorGreaterThanRed() throws IllegalArgumentException {
    rectangle.setColor(300, 158, 117);
    oval.setColor(256, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetColorNegativeRed() throws IllegalArgumentException {
    rectangle.setColor(-153, 0, 255);
    oval.setColor(-25, 120, 89);
  }

//  @Test
//  public void testSetColor() {
//    assertEquals("(255.0, 99.0, 71.0)", rectangle.getColor());
//    assertEquals("(0.0, 0.0, 128.0)", oval.getColor());
//
//    rectangle.setColor(255,255,0); // yellow
//    oval.setColor(255,140,105); // salmon
//    assertEquals("(255.0, 255.0, 0.0)", rectangle.getColor());
//    assertEquals("(255.0, 140.0, 105.0)", oval.getColor());
//  }


  @Test(expected = IllegalArgumentException.class)
  public void testSetDimensionZeroHeight() throws IllegalArgumentException {
    rectangle.setDimension(4,0);
    oval.setDimension(9,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetDimensionNegativeHeight() throws IllegalArgumentException {
    rectangle.setDimension(10,-15);
    oval.setDimension(2,-6);
  }

  @Test
  public void testSetDimensionHeight() {
    assertEquals(5, rectangle.getHeight(), EPSILON);
    assertEquals(8, oval.getHeight(), EPSILON);
    rectangle.setDimension(5,9);
    oval.setDimension(4,22);
    assertEquals(9, rectangle.getHeight(), EPSILON);
    assertEquals(22, oval.getHeight(), EPSILON);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetDimensionZeroWidth() throws IllegalArgumentException {
    rectangle.setDimension(0, 25);
    oval.setDimension(0,2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetDimensionAllZero() throws IllegalArgumentException {
    rectangle.setDimension(0,0);
    oval.setDimension(0,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetDimensionAllNegative() throws IllegalArgumentException {
    rectangle.setDimension(-2, -10);
    oval.setDimension(-15, -20);
  }

  @Test
  public void testSetDimensionValidInput() {
    assertEquals(5, rectangle.getHeight(), EPSILON);
    assertEquals(5, rectangle.getWidth(), EPSILON);

    assertEquals(8, oval.getHeight(), EPSILON);
    assertEquals(4, oval.getHeight(), EPSILON);
    rectangle.setDimension(10,15);

    oval.setDimension(22,22);
    assertEquals(15, rectangle.getHeight(), EPSILON);
    assertEquals(10, rectangle.getWidth(), EPSILON);

    assertEquals(22, oval.getHeight(), EPSILON);
    assertEquals(22, oval.getWidth(), EPSILON);
  }

  @Test(expected = IllegalArgumentException.class) 
  public void testSetDimensionNegativeWidth() throws IllegalArgumentException {
    rectangle.setDimension(-1, 5);
    oval.setDimension(-10, 22);
  }

  @Test
  public void testSetDimensionWidth() {
    assertEquals(5, rectangle.getWidth(), EPSILON);
    assertEquals(4, oval.getWidth(), EPSILON);
    rectangle.setDimension(7, 5);
    oval.setDimension(5,8);
    assertEquals(7, rectangle.getWidth(), EPSILON);
    assertEquals(5, oval.getWidth(), EPSILON);
  }

  @Test
  public void testSetPositionRectangle() {
    assertEquals(4, rectangle.getX(), EPSILON);
    assertEquals(3, rectangle.getY(), EPSILON);
    rectangle.setPos(1,6);
    assertEquals(1, rectangle.getX(), EPSILON);
    assertEquals(6, rectangle.getY(), EPSILON);
  }

  @Test
  public void testSetPositionOval() {
    assertEquals(0, oval.getX(), EPSILON);
    assertEquals(0, oval.getY(), EPSILON);
    oval.setPos(7,10);
    assertEquals(7, oval.getX(), EPSILON);
    assertEquals(10, oval.getY(), EPSILON);
  }

}
