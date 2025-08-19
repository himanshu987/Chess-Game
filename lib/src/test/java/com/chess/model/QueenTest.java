package com.chess.model;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class QueenTest {

    @Test
    void shouldCreateQueenWithValidPosition() {
        assertDoesNotThrow(() -> new Queen("D4"));
    }

    @Test
    void shouldReturnCorrectNumberOfMovesFromCenterPosition() {
        Queen queen = new Queen("D4");
        List<String> moves = queen.getPossibleMoves();

        assertEquals(27, moves.size());
    }

    @Test
    void shouldIncludeHorizontalMovesFromCenterPosition() {
        Queen queen = new Queen("D4");
        List<String> moves = queen.getPossibleMoves();

        assertTrue(moves.contains("A4"));
        assertTrue(moves.contains("B4"));
        assertTrue(moves.contains("C4"));
        assertTrue(moves.contains("E4"));
        assertTrue(moves.contains("F4"));
        assertTrue(moves.contains("G4"));
        assertTrue(moves.contains("H4"));
    }

    @Test
    void shouldIncludeVerticalMovesFromCenterPosition() {
        Queen queen = new Queen("D4");
        List<String> moves = queen.getPossibleMoves();

        assertTrue(moves.contains("D1"));
        assertTrue(moves.contains("D2"));
        assertTrue(moves.contains("D3"));
        assertTrue(moves.contains("D5"));
        assertTrue(moves.contains("D6"));
        assertTrue(moves.contains("D7"));
        assertTrue(moves.contains("D8"));
    }

    @Test
    void shouldIncludeDiagonalMovesFromCenterPosition() {
        Queen queen = new Queen("D4");
        List<String> moves = queen.getPossibleMoves();

        assertTrue(moves.contains("C3"));
        assertTrue(moves.contains("E5"));
        assertTrue(moves.contains("B2"));
        assertTrue(moves.contains("F6"));
        assertTrue(moves.contains("A1"));
        assertTrue(moves.contains("G7"));
    }

    @Test
    void shouldReturnLimitedMovesFromCornerPosition() {
        Queen queen = new Queen("A1");
        List<String> moves = queen.getPossibleMoves();

        assertEquals(21, moves.size());
        assertTrue(moves.contains("A8"));
        assertTrue(moves.contains("H1"));
        assertTrue(moves.contains("H8"));
    }
}