package com.TTT;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TicTacToeTest {

	@Test
	void testBoardSize() {
		TicTacToe game = new TicTacToe();
		int output = game.getBoardSize();
		assertEquals(9, output);
	}

	@Test
	void testEmptyBoard() {
		TicTacToe game = new TicTacToe();
		String output = game.toString();
		assertEquals("---------", output);
	}
	
	@Test
	void testMakeValidMove() {
		TicTacToe game = new TicTacToe();
		boolean output = game.makeMove('X', 1, 1);
		assertEquals(output, true);
	}
	
	@Test
	void testMakeInvalidMove() {
		TicTacToe game = new TicTacToe();
		boolean output = game.makeMove('X', 1, 3);
		assertEquals(output, false);
	}
	
	@Test
	void testIfMoveIsValid() {
		TicTacToe game = new TicTacToe();
		boolean output = game.isValid(0, 0);
		assertFalse(output);
	}


}
