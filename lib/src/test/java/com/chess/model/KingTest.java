package com.chess.model;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class KingTest {

    @Test
    void shouldCreateKingWithValidPosition() {
        assertDoesNotThrow(() -> new King("D5"));
    }

    @Test
    void shouldReturnCorrectMovesFromCenterPosition() {
        King king = new King("D5");
        List<String> moves = king.getPossibleMoves();

        assertEquals(8, moves.size());
        assertTrue(moves.contains("C4"));
        assertTrue(moves.contains("C5"));
        assertTrue(moves.contains("C6"));
        assertTrue(moves.contains("D4"));
        assertTrue(moves.contains("D6"));
        assertTrue(moves.contains("E4"));
        assertTrue(moves.contains("E5"));
        assertTrue(moves.contains("E6"));
    }

    @Test
    void shouldReturnLimitedMovesFromCornerPosition() {
        King king = new King("A1");
        List<String> moves = king.getPossibleMoves();

        assertEquals(3, moves.size());
        assertTrue(moves.contains("A2"));
        assertTrue(moves.contains("B1"));
        assertTrue(moves.contains("B2"));
    }

    @Test
    void shouldReturnLimitedMovesFromEdgePosition() {
        King king = new King("H4");
        List<String> moves = king.getPossibleMoves();

        assertEquals(5, moves.size());
        assertTrue(moves.contains("G3"));
        assertTrue(moves.contains("G4"));
        assertTrue(moves.contains("G5"));
        assertTrue(moves.contains("H3"));
        assertTrue(moves.contains("H5"));
    }
}