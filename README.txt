Marta Palermo and Kate Everett
Animator Model README
CS5004, Spring 2021

- Interfaces
   - Animator: Methods such as adding/removing shapes and transforming shapes.
   - Shape: Methods to create shapes and get/set the data.
   - Event: Methods to create different events, such as Move, Change Color, and Scale, and store the data of these events.

- Classes
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
  - AnimatorModel contains a List<Shape> to keep track of the shape's in the animation and a Hashmap<String, Event> to keep track of all the 
  events that happen to each individual shape.
