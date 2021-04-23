import cs5004.animator.controller.ControllerImpl;
import cs5004.animator.controller.InteractiveController;

import cs5004.animator.controller.InteractiveControllerImpl;
import cs5004.animator.model.animation.AnimatorModel;
import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.Shape;
import cs5004.animator.view.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimatorControllerTest {
  private AnimatorModel model;
  private InteractiveController controller;
  private Appendable writer;

  @Before
  public void setUp() {
    this.model = new AnimatorModel();
    this.writer = new StringBuilder();

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

    InteractiveView view = new InteractiveViewImpl(model);
    this.controller = new InteractiveControllerImpl(model, view, 100);
  }

  @Test
  public void testGetLogStart() {
    this.controller.start();
    assertEquals("Clicked start button.\n", controller.getLog().toString());
  }

  @Test
  public void testGetLogStop() {
    this.controller.stop();
    assertEquals("Clicked stop button.\n", controller.getLog().toString());
  }

  @Test
  public void testGetLogRestart() {
    this.controller.restart();
    assertEquals("Clicked restart button.\n", controller.getLog().toString());
  }

  @Test
  public void testGetLogLoop() {
    this.controller.loop();
    assertEquals("Clicked loop checkbox.\n", controller.getLog().toString());
  }

  @Test
  public void testGetLogSpeedUp() {
    this.controller.speedUp();
    assertEquals("Clicked speed-up button.\n", controller.getLog().toString());
  }

  @Test
  public void testGetLogSlowDown() {
    this.controller.slowDown();
    assertEquals("Clicked slow-down button.\n", controller.getLog().toString());
  }

  @Test
  public void testGetLogMultipleClicks() {
    this.controller.loop();
    this.controller.start();
    this.controller.stop();
    this.controller.restart();
    this.controller.stop();
    assertEquals("Clicked loop checkbox.\n"
        + "Clicked start button.\n" + "Clicked stop button.\n" + "Clicked restart button.\n"
        + "Clicked stop button.\n", controller.getLog().toString());
  }

  @Test
  public void testGetSVGController() {
    IView svgView = new SVGView(model, writer, 4);
    ControllerImpl svg = new ControllerImpl(model,svgView);
    svg.startController();
    assertEquals(
        "<svg width=\"500\" height=\"500\" version=\"1.1\" viewBox=\"0 0 500 500\"\n"
            + "\txmlns=\"http://www.w3.org/2000/svg\">\n"
            + "<rect id=\"R\" x=\"200\" y=\"200\" width=\"50\""
            + " height=\"100\" fill=\"rgb(255,0,0)\" >\n"
            + "\t\t<animate attributeType=\"xml\" begin=\"250ms\" "
            + "dur=\"1000ms\" attributeName=\"x\" from=\"200\" "
            + "to=\"300\" fill=\"freeze\" />\n"
            + "\t\t<animate attributeType=\"xml\" begin=\"250ms\" "
            + "dur=\"1000ms\" attributeName=\"y\" from=\"200\" "
            + "to=\"300\" fill=\"freeze\" />\n"
            + "\t\t<animate attributeType=\"xml\" begin=\"1275ms\" "
            + "dur=\"475ms\" attributeName=\"width\" from=\"50\" "
            + "to=\"25\" fill=\"freeze\" />\n"
            + "\t\t<animate attributeType=\"xml\" begin=\"1750ms\" "
            + "dur=\"750ms\" attributeName=\"x\" from=\"300\" "
            + "to=\"200\" fill=\"freeze\" />\n"
            + "\t\t<animate attributeType=\"xml\" begin=\"1750ms\" "
            + "dur=\"750ms\" attributeName=\"y\" from=\"300\" "
            + "to=\"200\" fill=\"freeze\" />\n" + "</rect>\n"
            + "<ellipse id=\"C\" cx=\"440\" cy=\"70\" rx=\"60\" "
            + "ry=\"30\" fill=\"rgb(0,0,255)\"  >\n"
            + "\t\t<set attributeName=\"visibility\" to=\"hidden\" "
            + "begin=\"0ms\" dur=\"150ms\" fill=\"freeze\" />\n"
            + " \t\t<set attributeName=\"visibility\" to=\"visible\" "
            + "begin =\"150ms\" dur=\"2500ms\" fill=\"freeze\" />\n"
            + "\t\t<animate attributeType=\"xml\" begin=\"500ms\" dur=\"750ms\" "
            + "attributeName=\"cy\" from=\"70\" to=\"250\" fill=\"freeze\" />\n"
            + "\t\t<animate attributeType=\"xml\" begin=\"1250ms\" dur=\"500ms\" "
            + "attributeName=\"cy\" from=\"250\" to=\"370\" fill=\"freeze\" />\n"
            + "\t\t<animate attributeType=\"xml\" begin=\"1250ms\" dur=\"500ms\" "
            + "attributeName=\"fill\" from=\"rgb(0,0,255)\" "
            + "to=\"rgb(0,170,85)\" fill=\"freeze\" />\n"
            + "\t\t<animate attributeType=\"xml\" begin=\"1750ms\" "
            + "dur=\"250ms\" attributeName=\"fill\" from=\"rgb(0,170,85)\" "
            + "to=\"rgb(0,255,0)\" fill=\"freeze\" />\n" + "</ellipse>\n"
            + "\n" + "</svg>", writer.toString());
  }

  @Test
  public void testGetTextController() {
    IView txtView = new TextView(model, writer);
    ControllerImpl txt = new ControllerImpl(model,txtView);
    txt.startController();
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

  @Test(expected = IllegalArgumentException.class)
  public void testGetSVGInvalidSpeed() throws IllegalArgumentException {
    IView svgView = new SVGView(model, writer, 0);
    ControllerImpl svg = new ControllerImpl(model, svgView);
    svg.startController();
  }

}
