# Chess Game

A Java command-line application that calculates possible moves for chess pieces on an empty 8x8 chessboard.

## Supported Pieces
- **Pawn**: Moves 1 step forward vertically
- **King**: Moves 1 step in all 8 directions  
- **Queen**: Moves across the board in all 8 directions

## Usage
```bash
./gradlew run --args="<pieceType> <position>"
```

### Examples
```bash
./gradlew run --args="King D5"
./gradlew run --args="Pawn G1"  
./gradlew run --args="Queen A1"
```

## Requirements
- Java 18+
- Gradle

## Running Tests
```bash
./gradlew test
```

