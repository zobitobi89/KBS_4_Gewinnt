package com.dhbw.vier_gewinnt.model;

public class Board {
	private int width;
	private int height;
	private int[][] board;
	private int turn;

	/**
	 * creates the play-board
	 * 
	 * @param width
	 * @param height
	 */
	public void createBoard(int width, int height) {
		this.width = width;
		this.height = height;
		board = new int[width][height]; // array mit breite und h�he
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	public void setBoard(int width, int height, int value) { // Zugriff auf
																// einzelne
																// Felder,
																// Value=Farbe
																// (1=rot;
																// 2=geld;
																// 0=nichts)
		this.board[width][height] = value;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getValue(int width, int height) {
		return this.board[width][height];
	}

	public int[][] getBoardField() {
		int[][] tmp_board = new int[this.width][this.height];
		for (int i = 0; i < this.width; i++)
			for (int j = 0; j < this.height; j++)
				tmp_board[i][j] = this.getValue(i, j);
		return tmp_board;
	}

	public Board getBoard() {
		Board b = new Board();
		int[][] tmp_board = new int[this.width][this.height];
		for (int i = 0; i < this.width; i++)
			for (int j = 0; j < this.height; j++)
				tmp_board[i][j] = this.getValue(i, j);
		b.setBoard(tmp_board);
		b.setHeight(this.height);
		b.setWidth(this.width);
		b.setTurn(this.turn);
		return b;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public void switchTurn() {
		if (this.turn==1)
			this.turn=2;
		else
			this.turn=1;
	}

}
