import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import cs5004.animator.model.animation.Animator;
import cs5004.animator.model.animation.AnimatorModel;
import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.Shape;

import static org.junit.Assert.assertEquals;

/**
 * This class contains the unit tests for the AnimatorModel class.
 */
public class AnimatorModelTest {
  private Shape r;
  private Shape c;
  private Animator model;
  private Animator m;

  @Before
  public void setUp() {
    this.model = new AnimatorModel();

    this.r = new Rectangle(200, 200, 1, 100, 50, 100,
        1,0,0);
    this.c = new Oval(500,100, 6, 101, 60, 30, 0,
        0,1);

    this.m = new AnimatorModel();
    this.m.addShape(this.r, "r");
    this.m.addShape(this.c, "c");
  }

  @Test
  public void testGetAnimation1() {
    assertEquals("Shapes:\n"
        + "Name: r\n"
        + "Type: rectangle\n"
        + "Min corner: (200,200), Width: 50, Height: 100, Color: (1,0,0)\n"
        + "Appears at t=1\n"
        + "Disappears at t=100\n\n"
        + "Name: c\n"
        + "Type: oval\n"
        + "Center: (500,100), X radius: 30, Y radius: 15, Color: (0,0,1)\n"
        + "Appears at t=6\n"
        + "Disappears at t=101\n\n", this.m.getAnimation());
  }

  @Test
  public void testGetCurrentShapesNoneOnScreen() {
    assertEquals("[]", this.m.getCurrentShapes(200).toString());
  }

  @Test // should return only Rectangle r
  public void testGetCurrentShapesRectangleVisible() {
    assertEquals("[Name: r\n"
            + "Type: rectangle\n"
            + "Min corner: (200,200), Width: 50, Height: 100, Color: (1,0,0)\n"
            + "Appears at t=1\n"
            + "Disappears at t=100\n]", this.m.getCurrentShapes(2).toString());
  }

  @Test
  public void testGetCurrentShapesOvalVisible() {
    assertEquals("[Name: c\n"
            + "Type: oval\n"
            + "Center: (500,100), X radius: 30, Y radius: 15, Color: (0,0,1)\n"
            + "Appears at t=6\n"
            + "Disappears at t=101\n"
            + "]", this.m.getCurrentShapes(100).toString());
  }

  @Test
  public void testGetCurrentShapesBothVisible() {
    assertEquals("[Name: r\n"
            + "Type: rectangle\n"
            + "Min corner: (200,200), Width: 50, Height: 100, Color: (1,0,0)\n"
            + "Appears at t=1\n"
            + "Disappears at t=100\n"
            + ", Name: c\n"
            + "Type: oval\n"
            + "Center: (500,100), X radius: 30, Y radius: 15, Color: (0,0,1)\n"
            + "Appears at t=6\n"
            + "Disappears at t=101\n"
            + "]", this.m.getCurrentShapes(25).toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testScaleShapeNullName() throws IllegalArgumentException {
    this.m.scaleShape(null, 60, 8, 30,60,
        40, 60);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testScaleShapeEmptyName() throws IllegalArgumentException {
    this.m.scaleShape("", 60, 8, 30,60,
        40, 60);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testScaleShapeInvalidName() throws IllegalArgumentException {
    this.m.scaleShape("h", 60, 8, 30,60,
        40, 60);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testScaleShapeSimultaneousScale() throws IllegalArgumentException {
    this.m.scaleShape("c", 60, 8, 30,60,
        40, 60);
    this.m.scaleShape("c", 60, 8, 30,60,
        40, 60);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testScaleShapeStopOutOfAppearWindow1() throws IllegalArgumentException {
    this.m.scaleShape("c", 12, 10, 30,60,
        60, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testScaleShapeStopOutOfAppearWindow() throws IllegalArgumentException {
    this.m.scaleShape("c", 12, 10, 30,60,
        50, 103);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testScaleShapeStartOutOfAppearWindow1() throws IllegalArgumentException {
    this.m.scaleShape("c", 12, 10, 30,60,
        102, 60);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testScaleShapeStartOutOfAppearWindow() throws IllegalArgumentException {
    this.m.scaleShape("c", 12, 10, 30,60,
        5, 60);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testScaleShapeHeightNegative() throws IllegalArgumentException {
    this.m.scaleShape("c", 12, -10, 30,60,
        40, 60);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testScaleShapeWidthNegative() throws IllegalArgumentException {
    this.m.scaleShape("c", -43, 65, 30,60,
        40, 60);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testScaleShapeBothNegative() throws IllegalArgumentException {
    this.m.scaleShape("c", -13, -50, 30,60,
        40, 60);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testScaleShapeHeightZero() throws IllegalArgumentException {
    this.m.scaleShape("c", 12, 0, 30,60,
        40, 60);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testScaleShapeWidthZero() throws IllegalArgumentException {
    this.m.scaleShape("c", 0, 65, 30,60,
        40, 60);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testScaleShapeBothZero() throws IllegalArgumentException {
    this.m.scaleShape("c", 0, 0, 30,60,
        40, 60);
  }

  @Test
  public void testScaleShapeHeight() {
    this.m.scaleShape("c", 60, 8, 30,60,
        40, 60);
    assertEquals("Shapes:\n"
        + "Name: r\n"
        + "Type: rectangle\n"
        + "Min corner: (200,200), Width: 50, Height: 100, Color: (1,0,0)\n"
        + "Appears at t=1\n"
        + "Disappears at t=100\n\n"
        + "Name: c\n"
        + "Type: oval\n"
        + "Center: (500,100), X radius: 30, Y radius: 15, Color: (0,0,1)\n"
        + "Appears at t=6\n"
        + "Disappears at t=101\n\n"
        + "Shape c scales from Width: 60, Height: 30 to Width: 60, Height: 8 from t=40"
        + " to t=60", m.getAnimation());
  }

  @Test
  public void testScaleShapeWidth() {
    this.m.scaleShape("c", 70, 30, 30,60,
        40, 60);
    assertEquals("Shapes:\n"
        + "Name: r\n"
        + "Type: rectangle\n"
        + "Min corner: (200,200), Width: 50, Height: 100, Color: (1,0,0)\n"
        + "Appears at t=1\n"
        + "Disappears at t=100\n\n"
        + "Name: c\n"
        + "Type: oval\n"
        + "Center: (500,100), X radius: 30, Y radius: 15, Color: (0,0,1)\n"
        + "Appears at t=6\n"
        + "Disappears at t=101\n\n"
        + "Shape c scales from Width: 60, Height: 30 to Width: 70, Height: 30 from t=40"
        + " to t=60", m.getAnimation());
  }

  @Test
  public void testScaleAllShape() {
    this.m.scaleShape("c", 10, 15, 30,60,
        40, 60);
    assertEquals("Shapes:\n"
            + "Name: r\n"
            + "Type: rectangle\n"
            + "Min corner: (200,200), Width: 50, Height: 100, Color: (1,0,0)\n"
            + "Appears at t=1\n"
            + "Disappears at t=100\n\n"
            + "Name: c\n"
            + "Type: oval\n"
            + "Center: (500,100), X radius: 30, Y radius: 15, Color: (0,0,1)\n"
            + "Appears at t=6\n"
            + "Disappears at t=101\n\n"
            + "Shape c scales from Width: 60, Height: 30 to Width: 10, Height: 15 from t=40"
            + " to t=60", m.getAnimation());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorNullName() throws IllegalArgumentException {
    this.m.changeColor(null, 175, 0,0,0,0,1,
        15, 80);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorEmptyName() throws IllegalArgumentException {
    this.m.changeColor("", 175, 0,0,0,0,1,
        15, 80);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorWrongName() throws IllegalArgumentException {
    this.m.changeColor("s", 175, 0,0,0,0,1,
        15, 80);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorSimultaneously() throws IllegalArgumentException {
    this.m.changeColor("c", 175, 0,0,0,0,1,
        15, 80);
    this.m.changeColor("c", 255, 0,0,0,0,1,
        15, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorStopOutOfDisappearWindow() throws IllegalArgumentException {
    this.m.changeColor("c", 255, 0,0,0,0,1,
        56, 200);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorStopOutOfDisappearWindow1() throws IllegalArgumentException {
    this.m.changeColor("c", 255, 0,0,0,0,1,
        56, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorStartOutOfAppearWindow1() throws IllegalArgumentException {
    this.m.changeColor("c", 255, 0,0,0,0,1,
        123, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorStartOutOfAppearWindow() throws IllegalArgumentException {
    this.m.changeColor("c", 255, 0,0,0,0,1,
        4, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorStopLessThanStart() throws IllegalArgumentException {
    this.m.changeColor("c", 255, 0,0,0,0,1,
        89, 10);
  }

  // CONFUSED BY THIS TESTQ!!!!
  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorSameStartStopTime() throws IllegalArgumentException {
    this.m.changeColor("c", 255, 0,0,0,0,1,
        15, 15);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorAllOutOfRGBRange() throws IllegalArgumentException {
    this.m.changeColor("r", 256, 300, 650, 0,0,
        1, 40, 89);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorAllNegative() throws IllegalArgumentException {
    this.m.changeColor("r", -210, -20, -200, 0,0,
        1, 56, 99);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorNegativeBlue() throws IllegalArgumentException {
    this.m.changeColor("c", 210, 20, -255, 0,0,
        1, 56, 99);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorOutOfRGBRangeBlue() throws IllegalArgumentException {
    this.m.changeColor("r", 230, 178, 500, 0,0,
        1, 56, 99);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorNegativeGreen() throws IllegalArgumentException {
    this.m.changeColor("c", 230, -20, 0, 0,0,
        1, 56, 99);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorOutOfRGBRangeGreen() throws IllegalArgumentException {
    this.m.changeColor("c", 230, 300, 0, 0,0,
        1, 56, 99);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorNegativeRed() throws IllegalArgumentException {
    this.m.changeColor("r", -150, 0,0,1, 0,0,
        15, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorOutOfRGBRangeRed() throws IllegalArgumentException {
    this.m.changeColor("r", 270, 0,0,1, 0,0,
        15, 100);
  }

  @Test
  public void testChangeColor() {
    this.m.changeColor("c", 255, 0,0,0,0,1,
        15, 100);

    assertEquals("Shapes:\n"
        + "Name: r\n"
        + "Type: rectangle\n"
        + "Min corner: (200,200), Width: 50, Height: 100, Color: (1,0,0)\n"
        + "Appears at t=1\n"
        + "Disappears at t=100\n\n"
        + "Name: c\n"
        + "Type: oval\n"
        + "Center: (500,100), X radius: 30, Y radius: 15, Color: (0,0,1)\n"
        + "Appears at t=6\n"
        + "Disappears at t=101\n\n"
        + "Shape c changes color from (0,0,1) to (255,0,0) from t=15 to t=100",
        m.getAnimation());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveEmptyName() throws IllegalArgumentException {
    this.m.move("", 200, 200, 1, 100, 50, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveNullName() throws IllegalArgumentException {
    this.m.move(null, 200, 200, 1, 100, 50, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveWrongName() throws IllegalArgumentException {
    this.m.move("t", 200, 200, 1, 100, 50, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveSameShape() throws IllegalArgumentException {
    this.m.move("r", 155, 120, 200, 200, 20, 34);
    this.m.move("r", 180, 140, 155, 120, 20, 34);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveStopOutOfAppearWindow2() throws IllegalArgumentException {
    this.m.move("r",155, 120, 200, 200, 20, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveStopOutOfAppearWindow1() throws IllegalArgumentException {
    this.m.move("r",155, 120, 200, 200, 20, 101);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveStartOutOfAppearWindow2() throws IllegalArgumentException {
    this.m.move("c", 140, 22, 500, 100, 103, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveStartOutOfAppearWindow1() throws IllegalArgumentException {
    this.m.move("c", 140, 22, 500, 100, 4, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveStopLessThanStartTick() throws IllegalArgumentException {
    this.m.move("c", 140, 22, 500, 100, 20, 10);
  }

  @Test
  public void testMultipleMoveDiffShapeDiffTime() {
    this.m.move("r", 155, 120, 200, 200, 20, 34);
    this.m.move("c", 165, 150, 500, 100, 7, 30);
    assertEquals("Shapes:\n"
            + "Name: r\n"
            + "Type: rectangle\n"
            + "Min corner: (200,200), Width: 50, Height: 100, Color: (1,0,0)\n"
            + "Appears at t=1\n"
            + "Disappears at t=100\n\n"
            + "Name: c\n"
            + "Type: oval\n"
            + "Center: (500,100), X radius: 30, Y radius: 15, Color: (0,0,1)\n"
            + "Appears at t=6\n"
            + "Disappears at t=101\n\n"
            + "Shape c moves from (500,100) to (165,150) from t=7 to t=30\n"
            + "Shape r moves from (200,200) to (155,120) from t=20 to t=34",
        this.m.getAnimation());
  }

  @Test
  public void testMultipleMoveDiffShapeSameTime() {
    this.m.move("r", 155, 120, 200, 200, 20, 34);
    this.m.move("c", 165, 150, 500, 100, 20, 34);
     assertEquals("Shapes:\n"
        + "Name: r\n"
        + "Type: rectangle\n"
        + "Min corner: (200,200), Width: 50, Height: 100, Color: (1,0,0)\n"
        + "Appears at t=1\n"
        + "Disappears at t=100\n\n"
        + "Name: c\n"
        + "Type: oval\n"
        + "Center: (500,100), X radius: 30, Y radius: 15, Color: (0,0,1)\n"
        + "Appears at t=6\n"
        + "Disappears at t=101\n\n"
        + "Shape r moves from (200,200) to (155,120) from t=20 to t=34\n"
        + "Shape c moves from (500,100) to (165,150) from t=20 to t=34",
        this.m.getAnimation());
  }

  @Test
  public void testMultipleTransformSameShapeUnordered() {
    this.m.move("r",150, 170, 200,200,35,45);
    this.m.changeColor("r", 0, 0, 1, 1,0,0, 20, 34);
    assertEquals("Shapes:\n"
            + "Name: r\n"
            + "Type: rectangle\n"
            + "Min corner: (200,200), Width: 50, Height: 100, Color: (1,0,0)\n"
            + "Appears at t=1\n"
            + "Disappears at t=100\n\n"
            + "Name: c\n"
            + "Type: oval\n"
            + "Center: (500,100), X radius: 30, Y radius: 15, Color: (0,0,1)\n"
            + "Appears at t=6\n"
            + "Disappears at t=101\n\n"
            + "Shape r changes color from (1,0,0) to (0,0,1) from t=20 to t=34\n"
            + "Shape r moves from (200,200) to (150,170) from t=35 to t=45",
        this.m.getAnimation());
  }

  @Test
  public void testMultipleMoveSameShape() {
    this.m.move("r",150, 170, 200,200,35,45);
    this.m.move("r", 155, 120, 150, 170, 46, 55);
    assertEquals("Shapes:\n"
            + "Name: r\n"
            + "Type: rectangle\n"
            + "Min corner: (200,200), Width: 50, Height: 100, Color: (1,0,0)\n"
            + "Appears at t=1\n"
            + "Disappears at t=100\n\n"
            + "Name: c\n"
            + "Type: oval\n"
            + "Center: (500,100), X radius: 30, Y radius: 15, Color: (0,0,1)\n"
            + "Appears at t=6\n"
            + "Disappears at t=101\n\n"
            + "Shape r moves from (200,200) to (150,170) from t=35 to t=45\n"
            + "Shape r moves from (150,170) to (155,120) from t=46 to t=55",
        this.m.getAnimation());
  }

  @Test
  public void testSingleMove() {
    this.m.move("r",150, 170, 200,200,35,45);
    assertEquals("Shapes:\n"
        + "Name: r\n"
        + "Type: rectangle\n"
        + "Min corner: (200,200), Width: 50, Height: 100, Color: (1,0,0)\n"
        + "Appears at t=1\n"
        + "Disappears at t=100\n\n"
        + "Name: c\n"
        + "Type: oval\n"
        + "Center: (500,100), X radius: 30, Y radius: 15, Color: (0,0,1)\n"
        + "Appears at t=6\n"
        + "Disappears at t=101\n\n"
        + "Shape r moves from (200,200) to (150,170) from t=35 to t=45",
        this.m.getAnimation());
  }

  @Test(expected = NoSuchElementException.class)
  public void testRemoveShapeEmptyModel() throws NoSuchElementException {
    this.model.removeShape("c");
  }

  @Test(expected = NoSuchElementException.class)
  public void testRemoveShapeNoSuchElement() throws NoSuchElementException {
    this.m.removeShape("t");
  }

  @Test
  public void testRemoveShape2() {
    this.m.removeShape("r");
    assertEquals("Shapes:\n"
        + "Name: c\n"
        + "Type: oval\n"
        + "Center: (500,100), X radius: 30, Y radius: 15, Color: (0,0,1)\n"
        + "Appears at t=6\n"
        + "Disappears at t=101\n\n", this.m.getAnimation());
  }

  @Test
  public void testRemoveShape() {
    assertEquals("Shapes:\n", model.getAnimation());
    this.model.addShape(new Rectangle(0,0, 2, 20, 5, 1,
        255,0,0), "bottom");
    this.model.addShape(new Rectangle(1,1, 4, 20, 3,
        1, 0, 255,0), "middle");
    this.model.addShape(new Rectangle(2,2,8, 20, 1,1,
        0, 0,255), "top");
    assertEquals("Shapes:\n"
        + "Name: bottom\n"
        + "Type: rectangle\n"
        + "Min corner: (0,0), Width: 5, Height: 1, Color: (255,0,0)\n"
        + "Appears at t=2\n"
        + "Disappears at t=20\n\n"
        + "Name: middle\n"
        + "Type: rectangle\n"
        + "Min corner: (1,1), Width: 3, Height: 1, Color: (0,255,0)\n"
        + "Appears at t=4\n"
        + "Disappears at t=20\n\n"
        + "Name: top\n"
        + "Type: rectangle\n"
        + "Min corner: (2,2), Width: 1, Height: 1, Color: (0,0,255)\n"
        + "Appears at t=8\n"
        + "Disappears at t=20\n\n", model.getAnimation());

    this.model.removeShape("middle");
    assertEquals("Shapes:\n"
        + "Name: bottom\n"
        + "Type: rectangle\n"
        + "Min corner: (0,0), Width: 5, Height: 1, Color: (255,0,0)\n"
        + "Appears at t=2\n"
        + "Disappears at t=20\n\n"
        + "Name: top\n"
        + "Type: rectangle\n"
        + "Min corner: (2,2), Width: 1, Height: 1, Color: (0,0,255)\n"
        + "Appears at t=8\n"
        + "Disappears at t=20\n\n", model.getAnimation());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShapeNullAndEmpty() throws IllegalArgumentException {
    this.model.addShape(null, "");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShapeNullAndNull() throws IllegalArgumentException {
    this.model.addShape(null, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShapeAlreadyExisting() throws IllegalArgumentException {
    this.model.addShape(this.c, "c");
    this.model.addShape(this.r, "c");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShapeNullShape() throws IllegalArgumentException {
    this.model.addShape(null, "c");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShapeEmptyName() throws IllegalArgumentException {
    this.model.addShape(new Rectangle(5,9,5, 20, 1, 8,
        150, 255, 150), "");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShapeNullName() throws IllegalArgumentException {
    this.model.addShape(new Oval(5,5,10, 200, 4, 10,
        150, 20, 150), null);
  }

  @Test
  public void testEmptyGetAnimation() {
    assertEquals("Shapes:\n", model.getAnimation());
  }

  @Test()
  public void testAddShape() {
    assertEquals("Shapes:\n", model.getAnimation());
    this.model.addShape(new Rectangle(0,0, 2, 20, 5, 1,
        255,0,0), "bottom");
    this.model.addShape(new Rectangle(1,1, 4, 20, 3,
        1, 0, 255,0), "middle");
    this.model.addShape(new Rectangle(2,2,8, 20, 1,1,
        0, 0,255), "top");

    assertEquals("Shapes:\n"
        + "Name: bottom\n"
        + "Type: rectangle\n"
        + "Min corner: (0,0), Width: 5, Height: 1, Color: (255,0,0)\n"
        + "Appears at t=2\n"
        + "Disappears at t=20\n\n"
        + "Name: middle\n"
        + "Type: rectangle\n"
        + "Min corner: (1,1), Width: 3, Height: 1, Color: (0,255,0)\n"
        + "Appears at t=4\n"
        + "Disappears at t=20\n\n"
        + "Name: top\n"
        + "Type: rectangle\n"
        + "Min corner: (2,2), Width: 1, Height: 1, Color: (0,0,255)\n"
        + "Appears at t=8\n"
        + "Disappears at t=20\n\n", model.getAnimation());

  }

  @Test
  public void testGetAnimation() {
    this.model.addShape(this.r, "r");
    this.model.addShape(this.c, "c");
    this.model.move("c", 500,400,500,100,20,70);
    this.model.move("r", 300,300,200,200,10,50);
    this.model.changeColor("c", 0, 1,0,0,0,
        1,50,80);
    this.model.scaleShape("r", 25,100,100,50,51, 70);
    this.model.move("r", 200,200,300,300,70,100);

    assertEquals("Shapes:\n"
            + "Name: r\n"
            + "Type: rectangle\n"
            + "Min corner: (200,200), Width: 50, Height: 100, Color: (1,0,0)\n"
            + "Appears at t=1\n"
            + "Disappears at t=100\n\n"
            + "Name: c\n"
            + "Type: oval\n"
            + "Center: (500,100), X radius: 30, Y radius: 15, Color: (0,0,1)\n"
            + "Appears at t=6\n"
            + "Disappears at t=101\n\n"
            + "Shape r moves from (200,200) to (300,300) from t=10 to t=50\n"
            + "Shape c moves from (500,100) to (500,400) from t=20 to t=70\n"
            + "Shape c changes color from (0,0,1) to (0,1,0) from t=50 to t=80\n"
            + "Shape r scales from Width: 50, Height: 100 to Width: 25, Height: 100 from "
            + "t=51 to t=70\n"
            + "Shape r moves from (300,300) to (200,200) from t=70 to t=100",
            this.model.getAnimation());
  }
}