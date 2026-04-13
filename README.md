Paint Brush Application (Java)

A simple yet powerful desktop drawing application built using Java Swing.
This project simulates a basic paint tool and demonstrates strong usage of Object-Oriented Programming (OOP) concepts.

Overview

The Paint Brush Application allows users to draw different shapes, sketch freely, and customize drawings using colors and styles.
It also includes advanced features like undo, erasing, and saving/loading images.

This project was developed as part of an academic assignment to apply OOP principles in a real-world GUI application.

Features

Draw Shapes:
  
  - Line
  - Rectangle
  - Oval
  - Free Hand Drawing

Customization:
  
  - Change colors (Red, Green, Blue)
  - Filled or outlined shapes
  - Solid or dotted strokes

Tools:
  
  - Eraser tool
  - Undo last action
  - Clear entire canvas

  File Handling:
  
  - Save drawing as image
  - Open saved images

  Clean Architecture:
  
  - Organized into packages:
    - "app"
    - "ui"
    - "shapes"
    - "utils"

OOP Concepts Used

- Encapsulation → Managing shape data and properties

- Inheritance → Common behavior via abstract class

- Abstraction → Abstract methods for drawing and containment

- Polymorphism → Dealing with shapes by using Interface

- Use of:
  
  - Interfaces ("MyShape")
  - Abstract Classes ("Shape")

Technologies

- Java
- Java Swing (GUI)
- AWT Graphics2D

How to Run

1. Open the project in your IDE (IntelliJ / Eclipse / NetBeans)
2. Make sure all packages are correctly structured
3. Run:

PaintApp.java
