
import cs5004.animator.EasyAnimator;
import cs5004.animator.model.animation.AnimatorModel;
import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.Shape;

import cs5004.animator.view.GraphicsView;
import cs5004.animator.view.IView;
import cs5004.animator.view.SVGView;
import cs5004.animator.view.TextView;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class AnimatorViewTest {
  private AnimatorModel model;
  private AnimatorModel m;
  private IView view;
  private StringBuilder writer;
  private Shape r;
  private Shape c;

  @Before
  public void setUp() {
    this.m = new AnimatorModel();
    this.writer = new StringBuilder();

    this.model = new AnimatorModel(); // from small demo.txt

    this.r = new Rectangle(200, 200, 1, 100, 50, 100,
        255, 0, 0);
    this.c = new Oval(440, 70, 6, 100, 120, 60, 0,
        0, 255);

    this.model.addShape(this.r, "R");
    this.model.addShape(this.c, "C");

    this.model.move("R", 300, 300, 200, 200, 10,50);
    this.model.move("C", 440, 250, 440, 70, 20, 50);
    this.model.move("C", 440, 370, 440, 250, 50, 70);
    this.model.changeColor("C", 0, 170, 85, 0,0,
        255, 50, 70);
  // this.model.scaleShape("R", 25, 100, 50, 100,
    //    51, 70);
    this.model.move("R", 200, 200, 300, 300, 70, 100);
    this.model.changeColor("C", 0, 255, 0, 0, 170,
        85, 70, 80);
    this.model.setBounds(0, 0, 500, 500);
//    String [] args = {"svg"};
//    this.view = new SVGView(this.model, this.writer, 3);
//    this.view.runView();
  }

//  @Test
//  public void testGetSVG() {
//    //assertEquals("", this.model.getAnimation());
//    assertEquals("", this.writer());
//  }

  @Test
  public void testSVGToFile() {
    try {
      IView svgView = new SVGView(this.model, new FileWriter("testSVG.svg"), 4 );
      svgView.runView();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testTextToFile() {
    try {
      IView textView = new TextView(this.model, new FileWriter("testText.txt"));
      textView.runView();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

//  @Test
//  public void testGraphicVisual() {
//    IView graphics = new GraphicsView(this.model, 4);
//
//    assertEquals("", );
  }

  //getShapes at tick for graphics visual


//}


// divide test in 3:
// model, text view, svg view
/*

create models for both views
and run "create svg" to get string that can be compared

create model, render something from views and only test what gives you strings

test the factory - with invalid viewType
 */