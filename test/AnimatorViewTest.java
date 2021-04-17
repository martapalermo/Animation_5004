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


import java.io.Writer;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Testing class for Animator View Types.
 */
public class AnimatorViewTest {
  private AnimatorModel model;
  private AnimatorModel m;
  private Appendable writer;

  @Before
  public void setUp() {
    this.m = new AnimatorModel();
    this.writer = new StringBuilder();

    this.model = new AnimatorModel(); // from small demo.txt
    Shape r = new Rectangle(200, 200, 1, 100, 50, 100,
            255, 0, 0);
    Shape c = new Oval(440, 70, 6, 100, 120, 60, 0,
            0, 255);

    this.model.addShape(r, "R");
    this.model.addShape(c, "C");

    this.model.move("R", 300, 300, 200, 200, 10, 50);
    this.model.move("C", 440, 250, 440, 70, 20, 50);
    this.model.move("C", 440, 370, 440, 250, 50, 70);
    this.model.changeColor("C", 0, 170, 85, 0, 0,
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
    IView svgView = new SVGView(this.model, this.writer, 4);
    svgView.runView();
    assertEquals("<svg width=\"500\" height=\"500\""
            + " version=\"1.1\" viewBox=\"0 0 500 500\"\n"
            + "\txmlns=\"http://www.w3.org/2000/svg\">\n"
            + "<rect id=\"R\" x=\"200\" y=\"200\" width=\"50\""
            + " height=\"100\" fill=\"rgb(255,0,0)\""
            + " visibility=\"visible\" >\n" + "\t\t<animate attributeType=\"xml\""
            + " begin=\"250ms\" dur=\"1000ms\""
            + " attributeName=\"x\" from=\"200\" to=\"300\""
            + " fill=\"freeze\" />\n"
            + "\t\t<animate attributeType=\"xml\" begin=\"250ms\""
            + " dur=\"1000ms\" attributeName=\"y\""
            + " from=\"200\" to=\"300\" fill=\"freeze\" />\n"
            + "\t\t<animate attributeType=\"xml\""
            + " begin=\"1275ms\" dur=\"475ms\" attributeName=\"width\""
            + " from=\"50\" to=\"25\" fill=\"freeze\" />\n"
            + "\t\t<animate attributeType=\"xml\" begin=\"1750ms\""
            + " dur=\"750ms\" attributeName=\"x\""
            + " from=\"300\" to=\"200\" fill=\"freeze\" />\n"
            + "\t\t<animate attributeType=\"xml\""
            + " begin=\"1750ms\" dur=\"750ms\" attributeName=\"y\""
            + " from=\"300\" to=\"200\" fill=\"freeze\" />\n"
            + "</rect>\n" + "<ellipse id=\"C\" cx=\"440\" cy=\"70\""
            + " rx=\"60\" ry=\"30\" fill=\"rgb(0,0,255)\""
            + " visibility=\"visible\" >\n"
            + "\t\t<animate attributeType=\"xml\" begin=\"500ms\" dur=\"750ms\""
            + " attributeName=\"cy\" from=\"70\" to=\"250\" fill=\"freeze\" />\n"
            + "\t\t<animate attributeType=\"xml\" begin=\"1250ms\""
            + " dur=\"500ms\" attributeName=\"cy\""
            + " from=\"250\" to=\"370\" fill=\"freeze\" />\n"
            + "\t\t<animate attributeType=\"xml\""
            + " begin=\"1250ms\" dur=\"500ms\" attributeName=\"fill\""
            + " from=\"rgb(0,0,255)\" to=\"rgb(0,170,85)\""
            + " fill=\"freeze\" />\n"
            + "\t\t<animate attributeType=\"xml\" begin=\"1750ms\" dur=\"250ms\""
            + " attributeName=\"fill\" from=\"rgb(0,170,85)\""
            + " to=\"rgb(0,255,0)\" fill=\"freeze\" />\n"
            + "</ellipse>\n" + "\n" + "</svg>", this.writer.toString());
  }

  @Test
  public void testSVGToFile() {
    try {
      Writer writ = new FileWriter("testSVG.svg");
      IView svgView = new SVGView(this.model, writ, 4);
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
      assertEquals("<svg width=\"500\" height=\"500\""
              + " version=\"1.1\" viewBox=\"0 0 500 500\"\n"
              + "\txmlns=\"http://www.w3.org/2000/svg\">\n"
              + "<rect id=\"R\" x=\"200\" y=\"200\" width=\"50\""
              + " height=\"100\" fill=\"rgb(255,0,0)\""
              + " visibility=\"visible\" >\n" + "\t\t<animate attributeType=\"xml\""
              + " begin=\"250ms\" dur=\"1000ms\""
              + " attributeName=\"x\" from=\"200\" to=\"300\""
              + " fill=\"freeze\" />\n"
              + "\t\t<animate attributeType=\"xml\" begin=\"250ms\""
              + " dur=\"1000ms\" attributeName=\"y\""
              + " from=\"200\" to=\"300\" fill=\"freeze\" />\n"
              + "\t\t<animate attributeType=\"xml\""
              + " begin=\"1275ms\" dur=\"475ms\" attributeName=\"width\""
              + " from=\"50\" to=\"25\" fill=\"freeze\" />\n"
              + "\t\t<animate attributeType=\"xml\" begin=\"1750ms\""
              + " dur=\"750ms\" attributeName=\"x\""
              + " from=\"300\" to=\"200\" fill=\"freeze\" />\n"
              + "\t\t<animate attributeType=\"xml\""
              + " begin=\"1750ms\" dur=\"750ms\" attributeName=\"y\""
              + " from=\"300\" to=\"200\" fill=\"freeze\" />\n"
              + "</rect>\n" + "<ellipse id=\"C\" cx=\"440\" cy=\"70\""
              + " rx=\"60\" ry=\"30\" fill=\"rgb(0,0,255)\""
              + " visibility=\"visible\" >\n"
              + "\t\t<animate attributeType=\"xml\" begin=\"500ms\" dur=\"750ms\""
              + " attributeName=\"cy\" from=\"70\" to=\"250\" fill=\"freeze\" />\n"
              + "\t\t<animate attributeType=\"xml\" begin=\"1250ms\""
              + " dur=\"500ms\" attributeName=\"cy\""
              + " from=\"250\" to=\"370\" fill=\"freeze\" />\n"
              + "\t\t<animate attributeType=\"xml\""
              + " begin=\"1250ms\" dur=\"500ms\" attributeName=\"fill\""
              + " from=\"rgb(0,0,255)\" to=\"rgb(0,170,85)\""
              + " fill=\"freeze\" />\n"
              + "\t\t<animate attributeType=\"xml\" begin=\"1750ms\" dur=\"250ms\""
              + " attributeName=\"fill\" from=\"rgb(0,170,85)\""
              + " to=\"rgb(0,255,0)\" fill=\"freeze\" />\n"
              + "</ellipse>\n" + "\n" + "</svg>\n", string.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testGetText() {
    IView txtView = new TextView(this.model, this.writer);
    txtView.runView();
    assertEquals("Shapes:\n" + "Name: R\n" + "Type: rectangle\n"
            + "Min corner: (200,200), Width: 50, Height: 100, Color: (255,0,0)\n"
            + "Appears at t=1\n"
            + "Disappears at t=100\n" + "\n" + "Name: C\n" + "Type: oval\n"
            + "Center: (440,70), X radius: 60, Y radius: 30, Color: (0,0,255)\n"
            + "Appears at t=6\n"
            + "Disappears at t=100\n" + "\n" + "Shape R moves from (200,200) "
            + "to (300,300) from t=10 to t=50\n"
            + "Shape C moves from (440,70) to (440,250) from t=20 to t=50\n"
            + "Shape C moves from (440,250) to (440,370) from t=50 to t=70\n"
            + "Shape C changes color from (0,0,255) to (0,170,85) from t=50 to t=70\n"
            + "Shape R scales from Width: 50, Height: 100 to Width: 25,"
            + " Height: 100 from t=51 to t=70\n"
            + "Shape R moves from (300,300) to (200,200) from t=70 to t=100\n"
            + "Shape C changes color from (0,170,85) to "
            + "(0,255,0) from t=70 to t=80", this.writer.toString());
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
      assertEquals("Shapes:\n" + "Name: R\n" + "Type: rectangle\n"
              + "Min corner: (200,200), Width: 50, Height: 100, Color: (255,0,0)\n"
              + "Appears at t=1\n"
              + "Disappears at t=100\n" + "\n" + "Name: C\n" + "Type: oval\n"
              + "Center: (440,70), X radius: 60, Y radius: 30, Color: (0,0,255)\n"
              + "Appears at t=6\n"
              + "Disappears at t=100\n" + "\n" + "Shape R moves from (200,200) "
              + "to (300,300) from t=10 to t=50\n"
              + "Shape C moves from (440,70) to (440,250) from t=20 to t=50\n"
              + "Shape C moves from (440,250) to (440,370) from t=50 to t=70\n"
              + "Shape C changes color from (0,0,255) to (0,170,85) from t=50 to t=70\n"
              + "Shape R scales from Width: 50, Height: 100 to Width: 25,"
              + " Height: 100 from t=51 to t=70\n"
              + "Shape R moves from (300,300) to (200,200) from t=70 to t=100\n"
              + "Shape C changes color from (0,170,85) to "
              + "(0,255,0) from t=70 to t=80\n", string.toString());
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

  @Test(expected = IllegalStateException.class)
  public void testSVGFailingAppendable() {
    Appendable writ = new FailingAppendable();
    IView view = new SVGView(this.model, writ,4);
    view.runView();
  }

  @Test(expected = IllegalStateException.class)
  public void testTextFailingAppendable() {
    Appendable writ = new FailingAppendable();
    IView view = new TextView(this.model, writ);
    view.runView();
  }
}