package com.dhbw.vier_gewinnt.model;

public class Board {
	private int [][] board;

	public void createBoard(int width, int hight){
		board = new int [width][hight];
	}

	public int [][] getBoard() {
		return board;
	}

	public void setBoard(int [][] board) {
		this.board = board;
	}
	
	public void setBoard(int width, int hight, int value) {
		this.board[width][hight]=value;
	}
	
}
