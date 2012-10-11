package com.dhbw.vier_gewinnt.ki;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.dhbw.vier_gewinnt.controller.Main;
import com.dhbw.vier_gewinnt.gui.BoardGui;
import com.dhbw.vier_gewinnt.model.Board;

public class PutStone {
	private static final int MAX2FAKTOR = 1;
	private static final int MIN2FAKTOR = 1;
	private static final int MAX3FAKTOR = 100;
	private static final int MIN3FAKTOR = 500;

	private static final int POS_INFINITY = (int) Double.POSITIVE_INFINITY;
	private static final int NEG_INFINITY = (int) Double.NEGATIVE_INFINITY;

	// private static final int DIFFICULTY = 3;

	/**
	 * 
	 * @return Column where to put stone (0-6)
	 */
	public static int putStone() {
		int pos = 0;
		// pos = randomKI();
		if (Main.board.getTurn() == 1) {
			if (Main.ki1 == 9)
				pos = randomKI();
			else
				pos = alphabetaKI(Main.ki1);
		} else {
			if (Main.ki2 == 9)
				pos = randomKI();
			else
				pos = alphabetaKI(Main.ki2);
		}

		for (int j = 0; j < 7; j++)
			BoardGui.arrows[j].setEnabled(true);
		return pos;
	}

	/**
	 * 
	 * @param difficulty
	 * @return
	 */
	private static int alphabetaKI(int difficulty) {
		boolean[] options = calcOptions(Main.board);
		int[] value = new int[7];
		Board temp_board = new Board();
		temp_board.createBoard(Main.board.getWidth(), Main.board.getHeight());
		int row = 0;
		for (int i = 0; i < options.length; i++) {
			if (options[i] == true) {
				temp_board = Main.board.getBoard();
				for (int j = 0; j < 6; j++) {
					if (temp_board.getValue(i, j) == 0) {
						row = j;
						break;
					}
				}
				temp_board.setBoard(i, row, temp_board.getTurn());
				temp_board.switchTurn();
				value[i] = abmin(difficulty, NEG_INFINITY + 1,
						POS_INFINITY - 1, temp_board);
			} else {
				value[i] = NEG_INFINITY;
			}
		}
		int max = NEG_INFINITY + 1;
		// int n = 0;
		ArrayList<Integer> rand = new ArrayList<Integer>();
		for (int i = 0; i < 7; i++) {
			if (value[i] > max) {
				max = value[i];
				// n = i;
				rand.clear();
				rand.add(i);
				/*---DEBUG---Start---*/
				System.out.println("WAHL: Spalte= " + i + ", max= " + max
						+ ", Turn: "
						+ (Main.board.getTurn() == 1 ? "rot" : "gelb"));
				/*---DEBUG---End---*/
			} else if (value[i] == max) {
				rand.add(i);
				/*---DEBUG---Start---*/
				System.out.println("WAHL: Spalte= " + i + ", max= " + max
						+ ", Turn: "
						+ (Main.board.getTurn() == 1 ? "rot" : "gelb"));
				/*---DEBUG---End---*/
			}
		}
		// if (rand.isEmpty())
		// return n;
		// else {
		int r = (int) Math.round(Math.random()) * (rand.size() - 1);
		/*---DEBUG---Start---*/
		System.out.println("Endgültig: Spalte= " + rand.get(r) + ", max= "
				+ max + ", Turn: "
				+ (Main.board.getTurn() == 1 ? "rot" : "gelb"));
		/*---DEBUG---End---*/
		if (max == POS_INFINITY - 1)
			JOptionPane.showMessageDialog(null,
					"Set wherever you like, I have always won!");
		return rand.get(r);
		// }
	}

	/**
	 * 
	 * @return
	 */
	private static boolean[] calcOptions(Board cboard) {
		boolean[] options = new boolean[7];
		for (int j = 0; j < 7; j++) {
			if (cboard.getValue(j, 5) == 0)
				options[j] = true;
			else
				options[j] = false;
		}
		return options;
	}

	/**
	 * 
	 * @return
	 */
	private static int randomKI() {
		int random;
		boolean[] options = calcOptions(Main.board);
		do {
			random = (int) Math.round(Math.random() * 6);
		} while (options[random] == false);
		return random;
	}

	private static int abmax(int n, int a, int b, Board temp_board) {
		if (n == 0)
			return evaluate(temp_board);
		Board tmp_board = new Board();
		tmp_board.createBoard(Main.board.getWidth(), Main.board.getHeight());
		int row = 0;
		for (int i = 0; i < tmp_board.getWidth(); i++) {
			//
			if (tmp_board.getValue(i, 5) == 0) {
				tmp_board = temp_board.getBoard();
				for (int j = 0; j < tmp_board.getHeight(); j++) {
					if (temp_board.getValue(i, j) == 0) {
						row = j;
						break;
					}
				}
				tmp_board.setBoard(i, row, tmp_board.getTurn());
				tmp_board.switchTurn();
				//
				int w = abmin(n - 1, a, b, tmp_board);
				if (w >= b)
					return b;
				if (w > a)
					a = w;
			}
		}
		return a;
	}

	private static int abmin(int n, int a, int b, Board temp_board) {
		if (n == 0)
			return evaluate(temp_board);
		Board tmp_board = new Board();
		tmp_board.createBoard(Main.board.getWidth(), Main.board.getHeight());
		int row = 0;
		for (int i = 0; i < tmp_board.getWidth(); i++) {
			//
			if (tmp_board.getValue(i, 5) == 0) {
				tmp_board = temp_board.getBoard();
				for (int j = 0; j < tmp_board.getHeight(); j++) {
					if (tmp_board.getValue(i, j) == 0) {
						row = j;
						break;
					}
				}
				tmp_board.setBoard(i, row, tmp_board.getTurn());
				tmp_board.switchTurn();
				//
				int w = abmax(n - 1, a, b, tmp_board);
				if (w <= a)
					return a;
				if (w < b)
					b = w;
			}
		}
		return b;
	}

	/*
	 * private static int minimaxWert(Board temp_board, int tiefe, int alpha,
	 * int beta) {
	 * 
	 * Board tmp_board; int minimax_tmp; int minimax_lokal; // Initialisiere
	 * bisher besten gefundenen Wert
	 * 
	 * if (temp_board.getZug()) // Ist Computer (MAX) am Zug? minimax_lokal =
	 * alpha; else minimax_lokal = beta;
	 * 
	 * // Abbruch bei erreichter Maximaltiefe, aktuelle Situation // wird mit
	 * Funktion bewertung() bewertet. if (tiefe == 0) return
	 * evaluate(tmp_board); // Ansonsten untersuche (rek.) alle möglichen Zuege
	 * else { for (int spalte = 0; spalte < BREITE; spalte++) { tmp_board =
	 * temp_board.copy(); if (tmp_board.wirfChip(spalte)) { // gueltiger Zug?
	 * minimax_tmp = minimaxWert(tmp_board, tiefe - 1, alpha, beta); // Merke
	 * min./max. Bewertung, je nachdem wer am Zug ist if (temp_board.getZug()) {
	 * minimax_lokal = java.lang.Math.max(minimax_tmp, minimax_lokal); alpha =
	 * minimax_lokal; if (alpha >= beta) return beta; } else { minimax_lokal =
	 * java.lang.Math.min(minimax_tmp, minimax_lokal); beta = minimax_lokal; if
	 * (beta <= alpha) return alpha; } ; } ; } ; return minimax_lokal; }
	 * 
	 * }
	 */

	private static int evaluate(Board tmp_board) {
		Board board = tmp_board;
		int min2er = 0;
		int max2er = 0;
		int min3er = 0;
		int max3er = 0;

		int player1 = tmp_board.getTurn();
		int player2;
		if (player1 == 1)
			player2 = 2;
		else
			player2 = 1;
		for (int x = 0; x < board.getWidth(); x++) {
			for (int y = 0; y < board.getHeight(); y++) {
				// Still 4 Stones vertical possible?
				if (board.getHeight() - y >= 4) {
					// 4 Stones in a row?
					if (isRow(board, player1, x, y, 0, 1) == 4)
						return POS_INFINITY - 1; // WIN
					else if (isRow(board, player2, x, y, 0, 1) == 4)
						return NEG_INFINITY + 1; // LOSE
					// 3 Stones in a row?
					else if (isRow(board, player1, x, y, 0, 1) == 3)
						max3er++;
					else if (isRow(board, player2, x, y, 0, 1) == 3)
						min3er++;
					// 2 Stones in a row?
					else if (isRow(board, player1, x, y, 0, 1) == 2)
						max2er++;
					else if (isRow(board, player2, x, y, 0, 1) == 2)
						min2er++;
				}
				// Still 4 Stones diagonal NorthEast possible?
				if ((board.getHeight() - y >= 4) && (board.getWidth() - x >= 4)) {
					// 4 Stones in a row?
					if (isRow(board, player1, x, y, 1, 1) == 4)
						return POS_INFINITY - 1; // WIN
					else if (isRow(board, player2, x, y, 1, 1) == 4)
						return NEG_INFINITY + 1; // LOSE
					// 3 Stones in a row?
					else if (isRow(board, player1, x, y, 1, 1) == 3)
						max3er++;
					else if (isRow(board, player2, x, y, 1, 1) == 3)
						min3er++;
					// 2 Stones in a row?
					else if (isRow(board, player1, x, y, 1, 1) == 2)
						max2er++;
					else if (isRow(board, player2, x, y, 1, 1) == 2)
						min2er++;
				}
				// Still 4 Stones horizontal possible?
				if (board.getWidth() - x >= 4) {
					// 4 Stones in a row?
					if (isRow(board, player1, x, y, 1, 0) == 4)
						return POS_INFINITY - 1; // WIN
					else if (isRow(board, player2, x, y, 1, 0) == 4)
						return NEG_INFINITY + 1; // LOSE
					// 3 Stones in a row?
					else if (isRow(board, player1, x, y, 1, 0) == 3)
						max3er++;
					else if (isRow(board, player2, x, y, 1, 0) == 3)
						min3er++;
					// 2 Stones in a row?
					else if (isRow(board, player1, x, y, 1, 0) == 2)
						max2er++;
					else if (isRow(board, player2, x, y, 1, 0) == 2)
						min2er++;
				}
				// Still 4 Stones diagonal SouthEast possible?
				if ((board.getWidth() - x >= 4) && (y >= 3)) {
					// 4 Stones in a row?
					if (isRow(board, player1, x, y, 1, -1) == 4)
						return POS_INFINITY - 1; // WIN
					else if (isRow(board, player2, x, y, 1, -1) == 4)
						return NEG_INFINITY + 1; // LOSE
					// 3 Stones in a row?
					else if (isRow(board, player1, x, y, 1, -1) == 3)
						max3er++;
					else if (isRow(board, player2, x, y, 1, -1) == 3)
						min3er++;
					// 2 Stones in a row?
					else if (isRow(board, player1, x, y, 1, -1) == 2)
						max2er++;
					else if (isRow(board, player2, x, y, 1, -1) == 2)
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
