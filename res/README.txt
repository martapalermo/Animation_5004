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
   - Graph
