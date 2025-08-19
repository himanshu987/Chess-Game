package com.chess.model;

import java.util.ArrayList;
import java.util.List;

public class Queen extends ChessPiece {
    public Queen(String position) {
        super(position);
    }

    @Override
    public List<String> getPossibleMoves() {
        List<String> moves = new ArrayList<>();

        // Horizontal moves (same rank, different files)
        for (char targetFile = MIN_FILE; targetFile <= MAX_FILE; targetFile++) {
            if (targetFile != file) {
                addMoveIfValid(moves, targetFile, rank);
            }
        }

        // Vertical moves (same file, different ranks)
        for (int targetRank = MIN_RANK; targetRank <= MAX_RANK; targetRank++) {
            if (targetRank != rank) {
                addMoveIfValid(moves, file, targetRank);
            }
        }

        // Diagonal moves in all four directions
        for (int offset = 1; offset <= 8; offset++) {
            // Up-right diagonal
            addMoveIfValid(moves, (char)(file + offset), rank + offset);
            // Up-left diagonal
            addMoveIfValid(moves, (char)(file - offset), rank + offset);
            // Down-right diagonal
            addMoveIfValid(moves, (char)(file + offset), rank - offset);
            // Down-left diagonal
            addMoveIfValid(moves, (char)(file - offset), rank - offset);
        }

        return moves;
    }
}