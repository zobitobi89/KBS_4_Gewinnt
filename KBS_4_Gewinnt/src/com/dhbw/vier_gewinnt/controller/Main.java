package com.dhbw.vier_gewinnt.controller;

import com.dhbw.vier_gewinnt.gui.BoardGui;
import com.dhbw.vier_gewinnt.gui.MainMenu;
import com.dhbw.vier_gewinnt.ki.PutStone;
import com.dhbw.vier_gewinnt.model.Board;

public class Main {
	public static Board board;
	public static int stone_y;
	public static int stone_r;
//	public static int turn;
	public static int ki1;
	public static int ki2;
	public static boolean gameover;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MainMenu mainmenu = new MainMenu();
		mainmenu.createmainmenu();
		board = new Board();
		board.createBoard(7, 6);
		stone_y = 0;// Anzahl gelegter Steine fuer Gelb
		stone_r = 0;// Anzahl Rot
		gameover = false;

	}

	public static class task extends Thread {
		
		public task() {
			super();
		}

		public void run() {
//			if (ki1 && ki2){
//				for (int j = 0; j < 7; j++)
//					BoardGui.arrows[j].setEnabled(false);
//				try {
//					Thread.sleep(500);
//				} catch (InterruptedException e) {
//					System.out.println(e.getMessage());
//				}
//				for (int j = 0; j < 7; j++)
//					BoardGui.arrows[j].setEnabled(true);
//			}
			if (stone_y < 21 || stone_r < 21) {
				BoardGui.arrows[PutStone.putStone()].doClick();
			}
		}

		public static void kiTurn() {
			task t = new task();
			t.start();
		}
	}

}
