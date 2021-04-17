Marta Palermo and Kate Everett
Animator README
CS5004, Spring 2021

MODEL:
- Interfaces:
   - ReadonlyAnimator: Getter methods for the model
      - Animator: Extends ReadonlyAnimator; Methods such as adding/removing shapes and transforming shapes.
   - Shape: Methods to create shapes and get/set the data.
   - Event: Methods to create different events, such as Move, Change Color, Static and Scale, and store the data of these events.

- Classes:
   - AnimatorModel: Implements Animator
   - AbstractShape: Implements Shape
      - Oval: Extends AbstractShape
      - Rectangle: Extends AbstractShape
          - Point: Shape's location coordinates
          - Color: Shape's color coordinates
          - Dimension: Shape's dimensions
          - Time: Shape's timing
    - AbstractEvent: Implements Event
       - Move: Extends AbstractEvent; Event to move a shape
       - ChangeColor: Extends AbstractEvent; Event to change a shape's color
       - Scale: Extends AbstractEvent; Event to scale a shape's dimensions
      
- Notes:
  - AnimatorModel contains a List<Shape> to keep track of the shape's in the animation and a LinkedHashMap<String, Event> to keep track of all the 
  events that happen to each individual shape.

- Updates to the Model During Part 2:
   - Added methods to copy Shape list/Event LinkedHashMap in order to create the SVG in the View.
   - Implemented AnimationBuilder inside the AnimationModel class in order to populate the model with data from text files.
   - Added a Static class to keep track of shape's data when nothing is changing in motion lines from the text files.
   
 
VIEW:
- Interfaces:
   - IView: Contains the method to start the animation for all view classes.
      - VisualView: Extends IView; Method to get shapes at current tick for the Visual view.
  
- Classes:
   - GraphicsPanel: Extends JPanel; Updates the visual view at each tick
   - GraphicsView: Extends JFrame and Implements VisualView; Implements java swing window to start visual representation of the animation.
   - SVGView: Extends WrittenView abstract class; Writes a .svg file which contains the animation information given from the model.
   - TextView: Extends WrittenView abstract class; Writes a .txt file with a description of the animation. 
   - WrittenView: Implements IView
      - writeToFile: Constructor takes a ReadonlyAnimator model and an Appendable writer object. 
      - Class writes a file (can be .svg or .txt) to an output destination.
   - EasyAnimator: final class - (temporary "controller" - like) 
      - parseCommands: method takes String array of arguments and parses input commands accordingly. 
      - getWriter: method creates appropriate Writer objects for the views that require it, takes an outfile name.
      - factoryOfViews: method creates the three types of views that will display the animation accordingly.
      - main: Static main method; runs the animations and prompts the program to create the outsource file or open a java swing window for the animation to      
        play.
     
