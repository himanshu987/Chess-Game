package com.chess.model;

import java.util.ArrayList;
import java.util.List;

public class King extends ChessPiece {
    public King(String position) {
        super(position);
    }

    @Override
    public List<String> getPossibleMoves() {
        List<String> moves = new ArrayList<>();

        // King can move one square in any direction (8 directions)
        for (int targetRank = rank - 1; targetRank <= rank + 1; targetRank++) {
            for (char targetFile = (char)(file - 1); targetFile <= file + 1; targetFile++) {
                // Exclude current position
                if (!(targetFile == file && targetRank == rank)) {
                    addMoveIfValid(moves, targetFile, targetRank);
                }
            }
        }
        return moves;
    }
}
