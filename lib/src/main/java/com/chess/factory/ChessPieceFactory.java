package com.chess.factory;


import com.chess.model.ChessPiece;
import com.chess.model.King;
import com.chess.model.Pawn;
import com.chess.model.PieceType;
import com.chess.model.Queen;

public class ChessPieceFactory {
    public static ChessPiece createChessPiece(PieceType pieceType, String position) {
        return switch (pieceType) {
            case PAWN -> new Pawn(position);
            case KING -> new King(position);
            case QUEEN -> new Queen(position);
            default -> throw new IllegalArgumentException("Unsupported piece type. Use Pawn, King, or Queen");
        };
    }
}