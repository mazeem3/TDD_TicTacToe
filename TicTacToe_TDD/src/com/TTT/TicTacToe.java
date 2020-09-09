package com.TTT;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
	
	private Scanner scanner = new Scanner(System.in);
	private char[][] board;
	private String player1, player2;
	private boolean gameStatus = true;

	public TicTacToe() {
		System.out.println("Welcome, here is your board!");
		initializeBoard();
		displayBoard();
		this.player1 = null;
		this.player2 = null;

	}

	private void initializeBoard() {
		this.board = new char[3][3];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = '-';
			}
		}	
	}

	public int getBoardSize() {
		return this.board.length*this.board[0].length;
	}

	@Override
	public String toString() {
        String val = "";
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				val+=board[i][j];
			}
		}
		return val;
	}

	public void displayBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
				if(j<2) {
					System.out.print(",");
				}
			}
			System.out.println();
		}
	}

	public String createPlayer() {
		System.out.println("Enter name for Player 1:");
		this.player1 = scanner.nextLine();
		System.out.println("Enter name for Player 2:");
		this.player2 = scanner.nextLine();
		
		while(player1.equals(player2)) {
			System.out.println("Player name is already taken, enter new name: ");
			this.player2 = scanner.nextLine();
		}
		return "Successfully created players";
	}

	public void askPlayer(String player) { 
		int row, col;
		char mark;
		do {
			if(player.equals("p1")) {
				System.out.println(this.player1 + " (X), where would you like to move: ");
				mark = 'X';
			}else {
				System.out.println(this.player2 + " (O), where would you like to move: ");
				mark = 'O';
			}
			row = scanner.nextInt();
			col = scanner.nextInt();
		}while(isValid(row,col));	
		makeMove(mark, row - 1, col - 1);	
	}

	public boolean isValid(int row, int col) {
		if(row < 1 && row > 3 && col < 1 && col > 3 && isEmpty(row, col))
			return true;
		
		return false;
	}

	private boolean isEmpty(int row, int col) {
		if(board[row][col] != '-')
			return false;
		return true;
	}

	public boolean makeMove(char mark, int i, int j) {
		mark = Character.toUpperCase(mark);
		if(mark != 'X' && mark != 'O') {
			System.out.println("Invalid character");
			return false;
		}else {	
			if(i <= 2 && i >= 0 && j <= 2 && j >= 0) {
				if(this.board[i][j] == '-') {
					this.board[i][j] = mark;
					return true;
				}else{
					System.out.println("Position already taken.");
					return false;
				}
			}else{
				System.out.println("Invalid Position.");
				return false;
			}	
		}
	}
	
	public void play() {
		int counter = 0;
		createPlayer();
		
		while(isActive()) {
			if(counter % 2 == 0) {
				askPlayer("p1");
			}else {
				askPlayer("p2");
			}
				
			counter++;
			displayBoard();
			checkForWinner(counter);
		}
		
	}

	private boolean checkForWinner(int counter) {
		for (int row = 0; row < board.length; row++) {
			if(board[row][0] == board[row][1] && board[row][2] == board[row][0] && board[row][0] != '-') {
				declareWinner(board[row][0]);
			}
		}
		for (int col = 0; col < board.length; col++) {
			if(board[0][col] == board[1][col] && board[2][col] == board[0][col] && board[0][col] != '-') {
				declareWinner(board[0][col]);
			}
		}
		if((board[0][0] == board[1][1] && board[2][2] == board[1][1] && board[1][1] != '-') ||
				(board[2][0] == board[1][1] && board[0][2] == board[1][1] && board[1][1] != '-')) {
			declareWinner(board[1][1]);
		}
		if(counter >= 9 && isActive()) {
			System.out.println("Game is a draw.");
			gameStatus = false;
		}
		return false;
		
	}

	private void declareWinner(char c) {
		if(Character.toLowerCase(c) == 'x') {
			System.out.println(this.player1+", is the Winner!");
		}else {
			System.out.println(this.player2+", is the Winner!");
		}
		gameStatus=false;		
	}

	private boolean isActive() {
		return this.gameStatus;
	}


	
	

}
