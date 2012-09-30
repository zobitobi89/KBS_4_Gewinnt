package com.dhbw.vier_gewinnt.controller;

import com.dhbw.vier_gewinnt.gui.MainMenu;
import com.dhbw.vier_gewinnt.model.Board;

public class Main {
	public static Board board;
	public static int stone_y;
	public static int stone_r;
	public static int turn;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MainMenu mainmenu = new MainMenu();
		mainmenu.createmainmenu();
		board= new Board();
		board.createBoard(7, 6);
		stone_y=0;
		stone_r=0;
		turn=0; //0 - red, 1 - yellow
		
		
	}

}
