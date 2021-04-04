import org.junit.Before;
import org.junit.Test;

import cs5004.animator.model.Animator;
import cs5004.animator.model.AnimatorModel;
import cs5004.animator.model.Oval;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.Shape;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;


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
    this.c = new Oval(500,100, 6, 100, 60, 30, 0,
        0,1);

    this.m = new AnimatorModel();
    this.m.addShape(this.r, "r");
    this.m.addShape(this.c, "c");
  }

  @Test
  public void testChangeColor() {
    this.m.changeColor("c", 255, 0,0,0,0,1,
        15, 100);


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

  @Test(expected = IllegalArgumentException.class) // NOT PASSING??
  // java.lang.AssertionError: Expected exception: java.lang.IllegalArgumentException
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
            + "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (1.0,0.0,0.0)\n"
            + "Appears at t=1\n"
            + "Disappears at t=100\n\n"
            + "Name: c\n"
            + "Type: oval\n"
            + "Center: (500.0,100.0), X radius: 30.0, Y radius: 15.0, Color: (0.0,0.0,1.0)\n"
            + "Appears at t=6\n"
            + "Disappears at t=100\n\n"
            + "Shape c moves from (500.0,100.0) to (165.0,150.0) from t=7 to t=30\n"
            + "Shape r moves from (200.0,200.0) to (155.0,120.0) from t=20 to t=34",
        this.m.getAnimation());
  }

  @Test
  public void testMultipleMoveDiffShapeSameTime() {
    this.m.move("r", 155, 120, 200, 200, 20, 34);
    this.m.move("c", 165, 150, 500, 100, 20, 34);
    assertEquals("Shapes:\n"
        + "Name: r\n"
        + "Type: rectangle\n"
        + "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (1.0,0.0,0.0)\n"
        + "Appears at t=1\n"
        + "Disappears at t=100\n\n"
        + "Name: c\n"
        + "Type: oval\n"
        + "Center: (500.0,100.0), X radius: 30.0, Y radius: 15.0, Color: (0.0,0.0,1.0)\n"
        + "Appears at t=6\n"
        + "Disappears at t=100\n\n"
        + "Shape r moves from (200.0,200.0) to (155.0,120.0) from t=20 to t=34\n"
        + "Shape c moves from (500.0,100.0) to (165.0,150.0) from t=20 to t=34",
        this.m.getAnimation());
  }

  @Test
  public void testMultipleMoveSameShapeUnordered() {
    this.m.move("r",150, 170, 200,200,35,45);
    this.m.move("r", 155, 120, 150, 170, 20, 34);
    assertEquals("Shapes:\n"
            + "Name: r\n"
            + "Type: rectangle\n"
            + "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (1.0,0.0,0.0)\n"
            + "Appears at t=1\n"
            + "Disappears at t=100\n\n"
            + "Name: c\n"
            + "Type: oval\n"
            + "Center: (500.0,100.0), X radius: 30.0, Y radius: 15.0, Color: (0.0,0.0,1.0)\n"
            + "Appears at t=6\n"
            + "Disappears at t=100\n\n"
            + "Shape r moves from (150.0,170.0) to (155.0,120.0) from t=20 to t=34\n"
            + "Shape r moves from (200.0,200.0) to (150.0,170.0) from t=35 to t=45",
        this.m.getAnimation());
  }

  @Test
  public void testMultipleMoveSameShape() {
    this.m.move("r",150, 170, 200,200,35,45);
    this.m.move("r", 155, 120, 150, 170, 45, 55);
    assertEquals("Shapes:\n"
            + "Name: r\n"
            + "Type: rectangle\n"
            + "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (1.0,0.0,0.0)\n"
            + "Appears at t=1\n"
            + "Disappears at t=100\n\n"
            + "Name: c\n"
            + "Type: oval\n"
            + "Center: (500.0,100.0), X radius: 30.0, Y radius: 15.0, Color: (0.0,0.0,1.0)\n"
            + "Appears at t=6\n"
            + "Disappears at t=100\n\n"
            + "Shape r moves from (200.0,200.0) to (150.0,170.0) from t=35 to t=45\n"
            + "Shape r moves from (150.0,170.0) to (155.0,120.0) from t=45 to t=55",
        this.m.getAnimation());
  }

  @Test
  public void testSingleMove() {
    this.m.move("r",150, 170, 200,200,35,45);
    assertEquals("Shapes:\n"
        + "Name: r\n"
        + "Type: rectangle\n"
        + "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (1.0,0.0,0.0)\n"
        + "Appears at t=1\n"
        + "Disappears at t=100\n\n"
        + "Name: c\n"
        + "Type: oval\n"
        + "Center: (500.0,100.0), X radius: 30.0, Y radius: 15.0, Color: (0.0,0.0,1.0)\n"
        + "Appears at t=6\n"
        + "Disappears at t=100\n\n"
        + "Shape r moves from (200.0,200.0) to (150.0,170.0) from t=35 to t=45",
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
        + "Center: (500.0,100.0), X radius: 30.0, Y radius: 15.0, Color: (0.0,0.0,1.0)\n"
        + "Appears at t=6\n"
        + "Disappears at t=100\n\n", this.m.getAnimation());
  }

  @Test
  public void testRemoveShape() {
    assertEquals("Shapes:\n", model.getAnimation()); // empty model
    // add three rectangles to make a 3 tier cake
    this.model.addShape(new Rectangle(0,0, 2, 20, 5, 1,
        255,0,0), "bottom");
    this.model.addShape(new Rectangle(1,1, 4, 20, 3,
        1, 0, 255,0), "middle");
    this.model.addShape(new Rectangle(2,2,8, 20, 1,1,
        0, 0,255), "top");
    assertEquals("Shapes:\n"
        + "Name: bottom\n"
        + "Type: rectangle\n"
        + "Min corner: (0.0,0.0), Width: 5.0, Height: 1.0, Color: (255.0,0.0,0.0)\n"
        + "Appears at t=2\n"
        + "Disappears at t=20\n\n"
        + "Name: middle\n"
        + "Type: rectangle\n"
        + "Min corner: (1.0,1.0), Width: 3.0, Height: 1.0, Color: (0.0,255.0,0.0)\n"
        + "Appears at t=4\n"
        + "Disappears at t=20\n\n"
        + "Name: top\n"
        + "Type: rectangle\n"
        + "Min corner: (2.0,2.0), Width: 1.0, Height: 1.0, Color: (0.0,0.0,255.0)\n"
        + "Appears at t=8\n"
        + "Disappears at t=20\n\n", model.getAnimation());

    this.model.removeShape("middle");
    assertEquals("Shapes:\n"
        + "Name: bottom\n"
        + "Type: rectangle\n"
        + "Min corner: (0.0,0.0), Width: 5.0, Height: 1.0, Color: (255.0,0.0,0.0)\n"
        + "Appears at t=2\n"
        + "Disappears at t=20\n\n"
        + "Name: top\n"
        + "Type: rectangle\n"
        + "Min corner: (2.0,2.0), Width: 1.0, Height: 1.0, Color: (0.0,0.0,255.0)\n"
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
    assertEquals("Shapes:\n", model.getAnimation()); // empty model
    // add three rectangles to make a 3 tier cake
    this.model.addShape(new Rectangle(0,0, 2, 20, 5, 1,
        255,0,0), "bottom");
    this.model.addShape(new Rectangle(1,1, 4, 20, 3,
        1, 0, 255,0), "middle");
    this.model.addShape(new Rectangle(2,2,8, 20, 1,1,
        0, 0,255), "top");

    assertEquals("Shapes:\n"
        + "Name: bottom\n"
        + "Type: rectangle\n"
        + "Min corner: (0.0,0.0), Width: 5.0, Height: 1.0, Color: (255.0,0.0,0.0)\n"
        + "Appears at t=2\n"
        + "Disappears at t=20\n\n"
        + "Name: middle\n"
        + "Type: rectangle\n"
        + "Min corner: (1.0,1.0), Width: 3.0, Height: 1.0, Color: (0.0,255.0,0.0)\n"
        + "Appears at t=4\n"
        + "Disappears at t=20\n\n"
        + "Name: top\n"
        + "Type: rectangle\n"
        + "Min corner: (2.0,2.0), Width: 1.0, Height: 1.0, Color: (0.0,0.0,255.0)\n"
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
    this.model.scaleShape("r", 25,100,100,50,51,
        70);
    this.model.move("r", 200,200,300,300,70,100);

    assertEquals("Shapes:\n"
            + "Name: r\n"
            + "Type: rectangle\n"
            + "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (1.0,0.0,0.0)\n"
            + "Appears at t=1\n"
            + "Disappears at t=100\n\n"
            + "Name: c\n"
            + "Type: oval\n"
            + "Center: (500.0,100.0), X radius: 30.0, Y radius: 15.0, Color: (0.0,0.0,1.0)\n"
            + "Appears at t=6\n"
            + "Disappears at t=100\n\n"
            + "Shape r moves from (200.0,200.0) to (300.0,300.0) from t=10 to t=50\n"
            + "Shape c moves from (500.0,100.0) to (500.0,400.0) from t=20 to t=70\n"
            + "Shape c changes color from (0.0,0.0,1.0) to (0.0,1.0,0.0) from t=50 to t=80\n"
            + "Shape r scales from Width: 50.0, Height: 100.0 to Width: 25.0, Height: 100.0 from "
            + "t=51 to t=70\n"
            + "Shape r moves from (300.0,300.0) to (200.0,200.0) from t=70 to t=100",
            this.model.getAnimation());
  }

}