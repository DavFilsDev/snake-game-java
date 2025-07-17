# 🐍 Java Snake Game – OOP Project

This project is a **classic Snake Game** built using **Java and Swing**, applying clean **Object-Oriented Programming (OOP)** principles to strengthen your understanding and skills.

---

## 🎯 Objectives

- Practice Java OOP: classes, enums, encapsulation, events, interfaces.
- Build a fully functional game with graphical interface.
- Use Git with a feature-based branching strategy like in real-world projects.

---

## 🧱 Project Structure

```

snake-game/
│
├── Game.java                # Main method (entry point)
├── GameWindow\.java          # JFrame setup
├── GamePanel.java           # JPanel with game logic/rendering
│
├── Snake.java               # Snake logic (movement, growth)
├── SnakeSegment.java        # Represents a segment of the snake
├── Direction.java           # Enum for UP, DOWN, LEFT, RIGHT
│
├── Food.java                # Food logic and random position
│
├── GameState.java           # Enum: RUNNING, PAUSED, GAME\_OVER
├── InputHandler.java        # Keyboard input handling
│
└── utils/
└── GameUtils.java       # Utility functions (e.g. collisions)

````

---

## 🧠 Features (Step-by-Step Branches)

| Feature | Branch | Description |
|--------|--------|-------------|
| 🛠️ Core Game Setup | `feature/core-setup` | Game loop, window, panel |
| 🐍 Snake Movement | `feature/snake-movement` | Snake moves with keys |
| 🍎 Food System | `feature/food-system` | Snake eats food to grow |
| 🎮 Game State | `feature/game-state` | Pause / Resume / Game Over |
| 🎹 Input Control | `feature/input-handler` | Handle keys (arrows, ESC, R, Q) |
| 🧮 Score System | `feature/score-system` | Track and display score |
| 💥 Collisions | `feature/collision-logic` | Wall and self-collision detection |
| 🖼️ Interface Polish | `feature/interface-enhancement` | Restart, quit, simple UI polish |

---

## 🚀 How to Run

1. Clone the project:

```bash
git clone https://github.com/your-username/snake-game-java.git
cd snake-game-java
````

2. Open in **IntelliJ IDEA** or any Java IDE.

3. Run `Game.java`.

---

## 💡 Requirements

* Java 8 or higher
* Swing (included in Java SE)
* IntelliJ IDEA (recommended)
* Git for version control

---

## 🧪 Development Branch Strategy

You should always:

1. Create a new feature branch from `dev`:

```bash
git checkout dev
git checkout -b feature/<your-feature-name>
```

2. After your code is ready and tested, create a Pull Request to merge into `dev`.

3. Only stable, complete features from `dev` will be merged into `main`.

---

## 📜 License

MIT – Do what you want with this project, just mention the author if you reuse or modify it.

---

## 👨‍💻 Author

Made by [David](https://github.com/DavFilsDev)

---
