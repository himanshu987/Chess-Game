package com.chess.model;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends ChessPiece {
    public Pawn(String position) {
        super(position);
    }

    @Override
    public List<String> getPossibleMoves() {
        List<String> moves = new ArrayList<>();

        // Pawn can only move forward one square
        if (rank < MAX_RANK) {
            addMoveIfValid(moves, file, rank + 1);
        }
        return moves;
    }
}
