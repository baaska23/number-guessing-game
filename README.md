# 🎯 Number Guessing Game
https://roadmap.sh/projects/number-guessing-game

A fun and interactive CLI-based number guessing game built in Java where players attempt to guess a randomly generated number between 1 and 100. Challenge yourself across multiple difficulty levels and track your high scores!

## 🎮 Game Features

- **Multiple Difficulty Levels**: Choose between Easy (10 chances), Medium (5 chances), or Hard (3 chances)
- **User Management**: Enter your username and track your personal scores
- **Persistent High Scores**: Your best scores are saved and displayed after each game
- **Multiple Rounds**: Play as many rounds as you want without restarting the program
- **Performance Tracking**: See how long it takes you to complete the game
- **Smart Hints**: Get feedback on whether your guess is too high or too low

## 🚀 How to Play

1. **Start the Game**: Run the program and you'll see a welcome message
2. **Select Difficulty**: Choose your preferred difficulty level:
   - Easy: 10 attempts
   - Medium: 5 attempts  
   - Hard: 3 attempts
3. **Enter Username**: Provide your username to track your scores
4. **Make Your Guess**: Enter numbers between 1 and 100
5. **Get Feedback**: The game will tell you if your guess is too high or too low
6. **Win or Lose**: Either guess correctly or run out of attempts
7. **Play Again**: Choose to play another round or quit

## 📋 Sample Gameplay

```
Welcome to the Number Guessing Game!
I'm thinking of a number between 1 and 100.

Please select the difficulty level:
1. Easy (10 chances)
2. Medium (5 chances)
3. Hard (3 chances)

Enter your choice: 2

Great! You have selected the Medium difficulty level.
Let's start the game!

Enter your username: player123

Enter your guess: 50
Incorrect! The number is less than 50.

Enter your guess: 25
Incorrect! The number is more than 25.

Enter your guess: 35
Incorrect! The number is less than 35.

Enter your guess: 30
Congratulations! You guessed the correct number in 4 attempts.

Do you want to play another round? If so, press y
```

## 🛠️ Technical Implementation

### Core Components

- **NumberGuessingGame Class**: Main game logic and user interaction
- **CalcResult Class**: Helper class for managing game state
- **File I/O**: Persistent storage of user scores in `users.txt`
- **Scanner Integration**: Command-line input handling

### Key Features Implemented

- Random number generation between 1-100
- Input validation and error handling
- Score persistence across game sessions
- Timer functionality to track game duration
- Dynamic difficulty adjustment
- User session management

## 🏗️ Project Structure

```
src/
├── main/
│   └── java/
│       └── org/
│           └── example/
│               ├── NumberGuessingGame.java
│               ├── CalcResult.java
|               |── GameApplication.java
│               └── users.txt
```

## 🎯 Future Enhancements

- **Hint System**: Additional clues for stuck players
- **Leaderboard**: Global high score rankings
- **GUI Version**: Graphical user interface option
- **Statistics**: Detailed player analytics and game history
- **Multiplayer Mode**: Compete with friends
- **Custom Ranges**: Allow players to set custom number ranges

## 🔧 Requirements

- Java 8 or higher
- Command line interface
- Write permissions for score file storage

## 📁 Installation & Setup

1. Clone this repository
2. Navigate to the project directory
3. Compile the Java files:
   ```bash
   javac src/main/java/org/example/*.java
   ```
4. Run the game:
   ```bash
   java -cp src/main/java org.example.NumberGuessingGame
   ```

## 🎨 What I Learned

Building this project helped me practice:
- Object-oriented programming principles
- File I/O operations in Java
- Exception handling and error management
- User input validation
- Game state management
- Code organization and structure
