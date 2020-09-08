package com.TTT;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
	
	private Scanner scanner = new Scanner(System.in);
	private char[][] board;
	private String player1, player2;

	public TicTacToe() {
		initializeBoard();		
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
		if(player.equals("p1")) {
			System.out.println(player + " (X), where would you like to move: ");
			mark = 'X';
		}else {
			System.out.println(player + " (O), where would you like to move: ");
			mark = 'O';
		}
		row = scanner.nextInt();
		col = scanner.nextInt();
		
		makeMove(mark, row - 1, col - 1);
		
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


	
	

}
