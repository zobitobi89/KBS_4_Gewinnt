package com.dhbw.vier_gewinnt.model;

public class Board {
	private int width;
	private int height;
	private int [][] board;
	
/**
 * creates the play-board
 * @param width
 * @param height
 */
	public void createBoard(int width, int height){ 
		this.width=width;
		this.height=height;
		board = new int [width][height]; //array mit breite und h�he
	}



	public void setBoard(int [][] board) {
		this.board = board;
	}
	
	public void setBoard(int width, int height, int value) { //Zugriff auf einzelne Felder, Value=Farbe (1=rot; 2=geld; 0=nichts)
		this.board[width][height]=value;
	}

	public int getHeight() {
		return height;
	}

	public void setHight(int height) {
		this.height = height;
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
	public int [][] getBoard() {
		int [][] tmp_board=new int [this.width][this.height];
		for(int i=0;i<this.width;i++)
			for(int j=0;j<this.height;j++)
				tmp_board[i][j]=this.getValue(i, j);
		return tmp_board;
	}
	
}
