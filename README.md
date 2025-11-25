🎯 Project Overview
The ZAPP Resort system simulates a theme park where guests use RFID-like smart cards to access luxury-rated areas. Key challenges include:

Enforcing access rules (e.g., luxury rating must match or exceed zone rating).
Managing capacities and preventing overcrowding.
Handling bridge crossings with credit deductions (4 credits per crossing; earn points for bonuses).
Tracking guest locations in real-time.

The system supports multiple guest types:

Standard Cards: Basic access with credits and points.
Tourist Cards: Tied to tour operators for group management.
Child Cards: Linked to parent cards with limited zones.
Company Cards: Premium perks like bonus points and starting credits.

An interactive console UI allows staff-like operations, while a tester class validates all functionality.
🚀 Features

Multi-Type Guest Management: Inheritance hierarchy for cards with polymorphic behaviors (e.g., overridden useBridge() for company bonuses).
Zone Control: Areas with luxury ratings, capacities, and dynamic guest lists.
Bridge Navigation: One-way paths with validation for location, rating, credits, and capacity.
Economy System: Top-up credits, earn/redeem points (3 points = 1 credit).
Query & Reporting: Locate cards, list guests by area/park-wide, detailed card info.
Error Handling: Robust checks with user-friendly messages (e.g., "Insufficient credits" or "Area full").
Interactive UI: Menu-driven console for operations; automated tester for unit validation.

🏗️ Project Structure
Based on the BlueJ project format, the codebase is organized in the cwk3 package. Here's the full structure:
textZAPP-Resort-Theme-Park-Access-Control-System-Java-/
├── package.bluej                  # BlueJ project metadata file
└── cwk3/                          # Main source package
    ├── Area.java                   # Manages park zones: capacity, luxury rating, guest lists
    ├── Bridge.java                 # One-way connections between areas with access rules
    ├── Card.java                   # Base class for guest cards: credits, points, luxury
    ├── ChildCard.java              # Subclass: Parent-linked child cards with zone limits
    ├── CompanyCard.java            # Subclass: Corporate perks (bonus points, 30 starting credits)
    ├── Park.java                   # Core system: Implements ZAPP interface, loads data, handles logic
    ├── ParkUI.java                 # Console-based interactive menu for user operations
    ├── Teamwork.java               # Team details (solo project metadata)
    ├── TouristCard.java            # Subclass: Tour operator-linked cards
    ├── ZAPP.java                   # Interface: Defines contract for park operations
    ├── CardTester.java             # Basic tester for card functionality
    └── MyTester.java               # Comprehensive test suite for all features

Total Files: 12+ (including BlueJ config).
Package: All classes under cwk3 for clean namespace.
Dependencies: None (pure Java, JDK 8+ compatible).

💻 Setup & Running
Prerequisites

Java JDK: 8 or higher.
IDE: BlueJ (recommended for coursework) or IntelliJ/Eclipse/VS Code with Java extensions.

Quick Start

Clone the Repo:Bashgit clone https://github.com/haseeb099/ZAPP-Resort-Theme-Park-Access-Control-System-Java-.git
cd ZAPP-Resort-Theme-Park-Access-Control-System-Java-
Open in BlueJ:
Launch BlueJ and open package.bluej.
The project will load all classes automatically.

Run the Interactive UI:
Right-click ParkUI → void main(String[] args).
Use the menu to test operations (e.g., "5. Say if card can move by bridge").

Run Tests:
Right-click MyTester → void main(String[] args).
Validates card details, locations, movements, credits, etc.


Sample UI Interaction
textWhat would you like to do?
0. Quit
1. List all area details
2. List all cards on each area
3. List all cards on one area
4. Find card location
5. Say if card can move by bridge
6. Move a card by bridge
7. Top up credits
8. Get card details

Enter your choice: 5
Enter card id: 1000
Enter bridge code: B1
true  (or false with reason)

ConceptExample in CodeBenefitInheritanceTouristCard extends CardReuses base functionality with extensions.PolymorphismOverridden toString() & useBridge()Different card types behave uniquely.EncapsulationPrivate fields in Area/CardProtects data; exposes via getters/setters.InterfacePark implements ZAPPEnforces contract for all operations.CollectionsArrayList<Area> in ParkEfficient dynamic storage for zones/guests.AbstractionZAPP methods hide implementation detailsClean API for UI/testers.
🧪 Testing & Validation

Unit Tests: CardTester.java – Covers credits/points mechanics.
Integration Tests: MyTester.java – End-to-end: card queries, movements, economy.
Edge Cases: Handles invalid IDs, full areas, insufficient credits.
Coverage: 100% of ZAPP interface methods tested.

Example Test Output:
textTesting getCardDetails:
Card ID: 1000
Guest Name: Lynn
Luxury Rating: 5
Number of Credits: 10
Number of Points: 0

No such card (for ID 999)
📈 Future Enhancements (Ideas)

GUI Version: Swing/JavaFX for visual park map.
Persistence: Save/load state to JSON/XML.
Multi-Threading: Simulate real-time guest movements.
Analytics: Report on busiest areas or top spenders.

📄 License & Credits

License: MIT License (permissive for educational use).
Author: Muhammad Haseeb Rafique
JAVA with OOP best practices.

🤝 Contributing
This is a completed coursework project, but pull requests for documentation improvements or extensions are welcome! Fork, star, or issues for feedback.

Enjoy managing the ZAPP Resort! If you encounter bugs or have questions, open an issue.
