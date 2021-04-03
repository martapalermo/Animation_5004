import org.junit.Before;
import org.junit.Test;

import cs5004.animator.Animator;
import cs5004.animator.AnimatorModel;
import cs5004.animator.Oval;
import cs5004.animator.Rectangle;
import cs5004.animator.Shape;

import static org.junit.Assert.assertEquals;


public class AnimatorModelTest {
  private Shape r;
  private Shape c;
  private Animator model;

  @Before
  public void setUp() {
    this.r = new Rectangle(200, 200, 1, 100, 50, 100,
        1,0,0);
    this.c = new Oval(500,100, 6, 100, 60, 30, 0,
        0,1);
    this.model = new AnimatorModel();
    this.model.addShape(this.r, "r");
    this.model.addShape(this.c, "c");
    this.model.move("c", 500,400,500,100,20,70);
    this.model.move("r", 300,300,200,200,10,50);
    this.model.changeColor("c", 0, 1,0,0,0,
            1,50,80);
    this.model.scaleShape("r", 25,100,100,50,51,
            70);
    this.model.move("r", 200,200,300,300,70,100);
  }

  @Test
  public void testGetAnimation() {
    assertEquals("Shapes:\n" +
            "Name: r\n" +
            "Type: rectangle\n" +
            "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (1.0,0.0,0.0)\n" +
            "Appears at t=1\n" +
            "Disappears at t=100\n\n" +
            "Name: c\n" +
            "Type: oval\n" +
            "Center: (500.0,100.0), X radius: 30.0, Y radius: 15.0, Color: (0.0,0.0,1.0)\n" +
            "Appears at t=6\n" +
            "Disappears at t=100\n\n" +
            "Shape r moves from (200.0,200.0to (300.0,300.0) from t=10 to t=50\n" +
            "Shape c moves from (500.0,100.0to (500.0,400.0) from t=20 to t=70\n" +
            "Shape c changes color from (0.0,1.0,0.0) to (0.0,0.0,1.0) from t=50to t=80\n" +
            "Shape r scales from Width: 50.0, Height: 100.0to Width: 25.0, Height: 100.0from " +
            "t=51to t=70\n" +
            "Shape r moves from (300.0,300.0to (200.0,200.0) from t=70 to t=100",
            this.model.getAnimation());
  }
}