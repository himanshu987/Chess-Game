package com.chess;


import com.chess.factory.ChessPieceFactory;
import com.chess.model.ChessPiece;
import com.chess.model.PieceType;

import java.util.List;

public class ChessApplication {

    private static final int REQUIRED_ARGUMENT_COUNT = 2;
    private static final int PIECE_TYPE_INDEX = 0;
    private static final int POSITION_INDEX = 1;

    public static void main(String[] args) {
        ChessApplication application = new ChessApplication();
        application.run(args);
    }

    public void run(String[] commandLineArgs) {
        if (!hasValidArgumentCount(commandLineArgs)) {
            displayUsageInstructions();
            return;
        }

        String pieceTypeInput = commandLineArgs[PIECE_TYPE_INDEX];
        String positionInput = commandLineArgs[POSITION_INDEX].toUpperCase();
        PieceType chessPieceType = PieceType.valueOf(pieceTypeInput.toUpperCase());

        try {
            ChessPiece chessPiece = ChessPieceFactory.createChessPiece(chessPieceType, positionInput);
            List<String> availableMoves = chessPiece.getPossibleMoves();
            displayPossibleMoves(pieceTypeInput, availableMoves);
        } catch (IllegalArgumentException exception) {
            displayError(exception.getMessage());
        }
    }

    private boolean hasValidArgumentCount(String[] args) {
        return args.length == REQUIRED_ARGUMENT_COUNT;
    }

    private void displayUsageInstructions() {
        System.out.println("Usage: java ChessApplication <pieceType> <position>");
        System.out.println("Examples:");
        System.out.println("  java ChessApplication King D5");
        System.out.println("  java ChessApplication Pawn G1");
        System.out.println("  java ChessApplication Queen A1");
    }

    private void displayPossibleMoves(String pieceTypeName, List<String> moves) {
        System.out.println("Possible moves for " + pieceTypeName + ": " + String.join(", ", moves));
    }

    private void displayError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }
}