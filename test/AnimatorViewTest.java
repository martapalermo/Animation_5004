import cs5004.animator.EasyAnimator;
import cs5004.animator.model.animation.AnimatorModel;
import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.Shape;

import cs5004.animator.view.IView;
import cs5004.animator.view.SVGView;
import cs5004.animator.view.TextView;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class AnimatorViewTest {
  private AnimatorModel model;
  private AnimatorModel m;
  private Appendable writer;
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
   this.model.scaleShape("R", 25, 100, 100, 50,
        51, 70);
    this.model.move("R", 200, 200, 300, 300, 70, 100);
    this.model.changeColor("C", 0, 255, 0, 0, 170,
        85, 70, 80);
    this.model.setBounds(0, 0, 500, 500);
  }

  @Test
  public void testGetSVG() {
    IView svgView = new SVGView(this.model, this.writer, 5);
    svgView.runView();
    assertEquals("", this.writer.toString());
  }

  @Test
  public void testSVGToFile() {
    try {
      Writer writ = new FileWriter("testSVG.svg");
      IView svgView = new SVGView(this.model, writ, 4 );
      svgView.runView();
      writ.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    StringBuilder string = new StringBuilder();
    try {
      FileReader reader = new FileReader("testSVG.svg");
      Scanner scan = new Scanner(reader);

      while (scan.hasNextLine()) {
        string.append(scan.nextLine()).append("\n");
      }

      reader.close();
      scan.close();
      assertEquals("", string.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testGetText() {
    IView txtView = new TextView(this.model, this.writer);
    txtView.runView();
    assertEquals("", this.writer.toString());
  }

  @Test
  public void testTextToFile() {
    try {
      Writer writ = new FileWriter("testText.txt");
      IView txtView = new TextView(this.model, writ);
      txtView.runView();
      writ.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    StringBuilder string = new StringBuilder();
    try {
      FileReader reader = new FileReader("testText.txt");
      Scanner scan = new Scanner(reader);

      while (scan.hasNextLine()) {
        string.append(scan.nextLine()).append("\n");
      }

      reader.close();
      scan.close();
      assertEquals("", string.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSVGEmptyModel() {
    new SVGView(this.m, this.writer, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTextEmptyModel() {
    new TextView(this.m, this.writer);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSVGNullModel() {
    new SVGView(null, this.writer, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTextNullModel() {
    new TextView(null, this.writer);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSVGNullWriter() {
    new SVGView(this.model, null, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTextNullWriter() {
    new TextView(this.model, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSVGZeroSpeed() {
    new SVGView(this.model, this.writer, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSVGNegativeSpeed() {
    new SVGView(this.model, this.writer, -4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidViewType() {
    String[] args = new String[]{"test.txt", "loopback", "out.txt", "3"};
    EasyAnimator.factoryOfViews(args, this.model, this.writer);
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