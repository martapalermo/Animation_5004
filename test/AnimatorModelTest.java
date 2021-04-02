import org.junit.Before;
import org.junit.Test;

import cs5004.animator.Animator;
import cs5004.animator.AnimatorModel;
import cs5004.animator.Oval;
import cs5004.animator.Rectangle;
import cs5004.animator.Shape;


public class AnimatorModelTest {
  private Shape r;
  private Shape c;
  private Animator model;

  @Before
  public void setUp() {
    this.r = new Rectangle(200, 200, 1, 100, 50, 100, 1,0,0);
    this.c = new Oval(500,100, 6, 100, 60, 30, 0,0,1);
    this.model = new AnimatorModel();
    this.model.addShape(this.r, "r");
    this.model.addShape(this.c, "c");
    this.model.move("c", 500,400,500,100,20,70);
    this.model.move("r", 300,300,200,200,10,50);
  }

  @Test
  public void testGetAnimation() {
    System.out.println(this.model.getAnimation());
  }
}