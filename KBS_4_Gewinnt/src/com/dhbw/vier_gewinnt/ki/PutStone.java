package com.dhbw.vier_gewinnt.ki;

import com.dhbw.vier_gewinnt.controller.Main;
import com.dhbw.vier_gewinnt.model.Board;

public class PutStone {
	private static final int MAX2FAKTOR = 1;
	private static final int MIN2FAKTOR = 1;
	private static final int MAX3FAKTOR = 100;
	private static final int MIN3FAKTOR = 500;

	private static final int POS_INFINITY = (int) Double.POSITIVE_INFINITY;
	private static final int NEG_INFINITY = (int) Double.NEGATIVE_INFINITY;

	/**
	 * 
	 * @return Column where to put stone (0-6)
	 */
	public static int putStone() {
		int pos = 0;
		pos = randomKI();
		// TODO: Add other KIs
		return pos;
	}
	
	/**
	 * 
	 * @return
	 */
	private static boolean[] calcOptions() {
		boolean[] options = new boolean[7];
		for (int j = 0; j < 7; j++) {
				if (Main.board.getValue(j, 5) == 0)
					options[j]=true;				
				else
					options[j]=false;				
		}
		return options;
	}

	/**
	 * 
	 * @return
	 */
	private static int randomKI() {
		int random;
		boolean[] options = calcOptions();
		do{
			random = (int) Math.round(Math.random() * 6);
		}while (options[random]==false);
		return random;
	}

	private int abmax(int n, int a, int b) {
		if (n == 0)
			return evaluate(Main.board); // TODO: Change
		for (int i = 1; i <= n; i++) {
			int w = abmin(n - 1, a, b);
			if (w >= b)
				return b;
			if (w > a)
				a = w;
		}
		return a;
	}

	private int abmin(int n, int a, int b) {
		if (n == 0)
			return evaluate(Main.board); // TODO: Change
		for (int i = 1; i <= n; i++) {
			int w = abmax(n - 1, a, b);
			if (w <= a)
				return a;
			if (w < b)
				b = w;
		}
		return b;
	}

	private int evaluate(Board tmp_board) {
		Board board = tmp_board;
		int min2er = 0;
		int max2er = 0;
		int min3er = 0;
		int max3er = 0;

		for (int x = 0; x < board.getWidth(); x++) {
			for (int y = 0; y < board.getHight(); y++) {
				// Noch 4 Chips nach oben moeglich?
				if (board.getHight() - y >= 4) {
					// 4 gleiche Chips?
					if (isRow(board, 1, x, y, 0, 1) == 4)
						return POS_INFINITY; // gewonnen
					else if (isRow(board, 2, x, y, 0, 1) == 4)
						return NEG_INFINITY; // verloren
					// 3 gleiche Chips?
					else if (isRow(board, 1, x, y, 0, 1) == 3)
						max3er++;
					else if (isRow(board, 2, x, y, 0, 1) == 3)
						min3er++;
					// 2 gleiche Chips?
					else if (isRow(board, 1, x, y, 0, 1) == 2)
						max2er++;
					else if (isRow(board, 2, x, y, 0, 1) == 2)
						min2er++;
				}
				// Noch 4 Chips nach rechts oben moeglich?
				if ((board.getHight() - y >= 4) && (board.getWidth() - x >= 4)) {
					// 4 gleiche Chips nach rechts oben?
					if (isRow(board, 1, x, y, 1, 1) == 4)
						return POS_INFINITY; // gewonnen
					else if (isRow(board, 2, x, y, 1, 1) == 4)
						return NEG_INFINITY; // verloren
					// 3 gleiche Chips uebereinander?
					else if (isRow(board, 1, x, y, 1, 1) == 3)
						max3er++;
					else if (isRow(board, 2, x, y, 1, 1) == 3)
						min3er++;
					// 2 gleiche Chips uebereinander?
					else if (isRow(board, 1, x, y, 1, 1) == 2)
						max2er++;
					else if (isRow(board, 2, x, y, 1, 1) == 2)
						min2er++;
				}
				// Noch 4 Chips nach rechts moeglich?
				if (board.getWidth() - x >= 4) {
					if (isRow(board, 1, x, y, 1, 0) == 4)
						return POS_INFINITY; // gewonnen
					else if (isRow(board, 2, x, y, 1, 0) == 4)
						return NEG_INFINITY; // verloren
					// 3 gleiche Chips uebereinander?
					else if (isRow(board, 1, x, y, 1, 0) == 3)
						max3er++;
					else if (isRow(board, 2, x, y, 1, 0) == 3)
						min3er++;
					// 2 gleiche Chips uebereinander?
					else if (isRow(board, 1, x, y, 1, 0) == 2)
						max2er++;
					else if (isRow(board, 2, x, y, 1, 0) == 2)
						min2er++;
				}
				// Noch 4 Chips nach rechts unten moeglich?
				if ((board.getWidth() - x >= 4) && (y >= 3)) {
					if (isRow(board, 1, x, y, 1, -1) == 4)
						return POS_INFINITY; // gewonnen
					else if (isRow(board, 2, x, y, 1, -1) == 4)
						return NEG_INFINITY; // verloren
					// 3 gleiche Chips uebereinander?
					else if (isRow(board, 1, x, y, 1, -1) == 3)
						max3er++;
					else if (isRow(board, 2, x, y, 1, -1) == 3)
						min3er++;
					// 2 gleiche Chips uebereinander?
					else if (isRow(board, 1, x, y, 1, -1) == 2)
						max2er++;
					else if (isRow(board, 2, x, y, 1, -1) == 2)
						min2er++;
				}
			}

		}
		return MAX2FAKTOR * max2er + MAX3FAKTOR * max3er - MIN2FAKTOR * min2er
				- MIN3FAKTOR * min3er;

	}

	private static int isRow(Board board, int player, int x, int y, int dx,
			int dy) {
		int num = 0;
		// 4 freie oder von spieler belegte Felder in Richtung (dx,dy)?
		if (((board.getValue(x, y) == player) || (board.getValue(x, y) == 0))
				&& ((board.getValue(x + 1 * dx, y + 1 * dy) == player) || (board
						.getValue(x + 1 * dx, y + 1 * dy) == 0))
				&& ((board.getValue(x + 2 * dx, y + 2 * dy) == player) || (board
						.getValue(x + 2 * dx, y + 2 * dy) == 0))
				&& ((board.getValue(x + 3 * dx, y + 3 * dy) == player) || (board
						.getValue(x + 3 * dx, y + 3 * dy) == 0))) {

			// zaehle Anzahl von spieler belegter Felder
			for (int i = 0; i < 4; i++)
				if (board.getValue(x + i * dx, y + i * dy) == player)
					num++;
		}
		return num;
	}

}
