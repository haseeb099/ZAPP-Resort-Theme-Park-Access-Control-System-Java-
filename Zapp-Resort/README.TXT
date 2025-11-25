------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: ZAPP
PURPOSE OF PROJECT: Park Management
VERSION or DATE: 1.1
HOW TO START THIS PROJECT: Run it!
AUTHORS: Muhammad Haseeb Rafique
USER INSTRUCTIONS:
# ZAPP Resort – Theme Park Access Control System (Java OOP Coursework)

A complete object-oriented Java simulation of a luxury theme park ("ZAPP") with guest cards, restricted areas, one-way bridges, credits, points, and access control rules.

Built from scratch in **BlueJ** as coursework for **5COM2007 Object-Oriented Programming**.

### Features
- Multiple card types with inheritance & polymorphism:
  - `Card` (base class)
  - `TouristCard` – linked to tour operator
  - `ChildCard` – needs parent card
  - `CompanyCard` – bonus points on bridge use + free 30 credits
- Luxury-rated areas with capacity limits
- One-way bridges with strict access rules (luxury rating ≥ destination, enough credits, not full, correct location)
- Credit top-up and points → credits conversion (3 points = 1 credit)
- Real-time tracking of every card across all areas
- Full validation and helpful error messages
- Interactive console menu (`ParkUI`) + automated tester (`MyTester`)

### Key OOP Concepts Demonstrated
- Inheritance & method overriding
- Polymorphism (especially in `useBridge()` and `toString()`)
- Encapsulation
- Interface implementation (`ZAPP`)
- Collections (`ArrayList`) for areas, bridges, cards
- Robust error handling

### How to Run
1. Open the project in **BlueJ**
2. Right-click `ParkUI` → `void main(String[] args)`
3. Enjoy the interactive menu!

Or run the test suite:
- Right-click `MyTester` → `void main(String[] args)`

### Project Structure
├── Park.java          - Main class (implements ZAPP interface)
├── Area.java          - Park zones with capacity
├── Bridge.java        - One-way access with rules
├── Card.java          - Base card class
├── TouristCard.java
├── ChildCard.java
├── CompanyCard.java
├── ParkUI.java        - Interactive console UI
├── MyTester.java      - Comprehensive tests
└── ... (supporting files)
