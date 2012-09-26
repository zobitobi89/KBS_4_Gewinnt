package com.dhbw.vier_gewinnt.controller;

import com.dhbw.vier_gewinnt.gui.MainMenu;
import com.dhbw.vier_gewinnt.model.Board;

public class Main {
	public static Board board;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainMenu mainmenu = new MainMenu();
		mainmenu.createmainmenu();
		board= new Board();
		board.createBoard(7, 6);
		
		
	}

}
