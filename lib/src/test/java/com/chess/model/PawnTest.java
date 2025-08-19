package com.chess.model;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @Test
    void shouldCreatePawnWithValidPosition() {
        assertDoesNotThrow(() -> new Pawn("G1"));
    }

    @Test
    void shouldReturnOneForwardMoveFromStartingPosition() {
        Pawn pawn = new Pawn("G1");
        List<String> moves = pawn.getPossibleMoves();

        assertEquals(1, moves.size());
        assertTrue(moves.contains("G2"));
    }

    @Test
    void shouldReturnOneForwardMoveFromMiddlePosition() {
        Pawn pawn = new Pawn("D4");
        List<String> moves = pawn.getPossibleMoves();

        assertEquals(1, moves.size());
        assertTrue(moves.contains("D5"));
    }

    @Test
    void shouldReturnNoMovesFromTopRank() {
        Pawn pawn = new Pawn("E8");
        List<String> moves = pawn.getPossibleMoves();

        assertEquals(0, moves.size());
    }

    @Test
    void shouldReturnOneForwardMoveFromNearTopPosition() {
        Pawn pawn = new Pawn("C7");
        List<String> moves = pawn.getPossibleMoves();

        assertEquals(1, moves.size());
        assertTrue(moves.contains("C8"));
    }
}