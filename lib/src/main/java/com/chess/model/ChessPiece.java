package com.chess.model;

import java.util.List;
import java.util.regex.Pattern;

public abstract class ChessPiece {
    protected static final char MIN_FILE = 'A';
    protected static final char MAX_FILE = 'H';
    protected static final int MIN_RANK = 1;
    protected static final int MAX_RANK = 8;
    private static final Pattern CHESS_POSITION_PATTERN = Pattern.compile("[A-H][1-8]");

    protected final String position;
    protected final int rank;  // Chess terminology for row (1-8)
    protected final char file; // Chess terminology for column (A-H)

    public ChessPiece(String chessPosition) {
        if (chessPosition == null || chessPosition.trim().isEmpty()) {
            throw new IllegalArgumentException("Position cannot be null or empty");
        }

        String normalizedPosition = chessPosition.trim().toUpperCase();

        if (!isValidChessPosition(normalizedPosition)) {
            throw new IllegalArgumentException(
                "Invalid chess position '" + chessPosition + "'. " +
                "Valid positions are A1-H8 (file A-H, rank 1-8)"
            );
        }

        this.position = normalizedPosition;
        this.file = normalizedPosition.charAt(0);
        this.rank = Character.getNumericValue(normalizedPosition.charAt(1));
    }

    public abstract List<String> getPossibleMoves();

    protected boolean isValidChessPosition(String chessPosition) {
        return chessPosition != null && CHESS_POSITION_PATTERN.matcher(chessPosition).matches();
    }

    protected void addMoveIfValid(List<String> moves, char targetFile, int targetRank) {
        String targetPosition = String.format("%c%d", targetFile, targetRank);
        if (isValidChessPosition(targetPosition)) {
            moves.add(targetPosition);
        }
    }
}
