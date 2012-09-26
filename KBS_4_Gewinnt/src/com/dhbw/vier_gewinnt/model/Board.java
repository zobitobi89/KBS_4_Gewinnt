package com.dhbw.vier_gewinnt.model;

public class Board {
	private int width;
	private int hight;
	private int [][] board;

	public void createBoard(int width, int hight){
		this.width=width;
		this.hight=hight;
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

	public int getHight() {
		return hight;
	}

	public void setHight(int hight) {
		this.hight = hight;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	public int getValue(int width, int height){
		return this.board[width][height];
	}
	
}
