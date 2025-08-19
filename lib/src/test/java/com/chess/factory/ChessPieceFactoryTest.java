package com.chess.factory;

import com.chess.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessPieceFactoryTest {

    @Test
    void shouldCreatePawnWithValidInputs() {
        ChessPiece piece = ChessPieceFactory.createChessPiece(PieceType.PAWN, "G1");
        assertInstanceOf(Pawn.class, piece);
    }

    @Test
    void shouldCreateKingWithValidInputs() {
        ChessPiece piece = ChessPieceFactory.createChessPiece(PieceType.KING, "D5");
        assertInstanceOf(King.class, piece);
    }

    @Test
    void shouldCreateQueenWithValidInputs() {
        ChessPiece piece = ChessPieceFactory.createChessPiece(PieceType.QUEEN, "A1");
        assertInstanceOf(Queen.class, piece);
    }

    @Test
    void shouldThrowExceptionForInvalidPosition() {
        assertThrows(IllegalArgumentException.class,
            () -> ChessPieceFactory.createChessPiece(PieceType.KING, "Z9"));
    }
}