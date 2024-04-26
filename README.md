# Vinho de Pacote

Vinho de Pacote is a game developed during the Code for All_ Bootcamp's game week challenge. Inspired by the classic game Pacman. This project was developed in the 4th week of the bootcamp.
Website: [here](https://teamvinhodepacote.itch.io/vinhodepacote).

![Vinho de Pacote Banner](https://img.itch.zone/aW1nLzE1MDc3ODQyLmpwZw==/original/VVLBIn.jpg)

## Description

In Vinho de Pacote, players control a character resembling Pacman as they navigate through a maze-like environment filled with coins to collect and avoid obstacles. The game features:

- Intuitive controls
- Coin collection mechanics
- Unique maze design
- Game over and scoring system

### Technologies Used

- Java
- SimpleGraphics library

## How to Play

1. Use the arrow keys to navigate Pacman through the maze.
2. Collect as many coins as possible while avoiding collisions with walls and enemies.
3. Each collected coin adds to your score.
4. Be cautious! Colliding with enemies results in losing a life.

### Code Structure

- `Pacman.java`: Contains the implementation of the Pacman character including movement and collision detection.
- `Main.java`: Initializes the game and handles the main menu.
- `Heart.java`: Represents the heart lives in the game.
- `Grid.java`: Manages the grid layout, maze generation, and game initialization.
- `Ghost.java`: Implements the behavior of enemy ghosts.
- `Coin.java`: Represents the coins that Pacman collects in the game.
