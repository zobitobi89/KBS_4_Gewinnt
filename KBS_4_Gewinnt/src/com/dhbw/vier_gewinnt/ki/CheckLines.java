package com.dhbw.vier_gewinnt.ki;

import com.dhbw.vier_gewinnt.controller.Main;
import com.dhbw.vier_gewinnt.model.Board;

public class CheckLines {

	public static Board tmp_board = new Board();

	public boolean checkLines(int posx, int posy, int player) {
		tmp_board.createBoard(7, 6);
		for (int i = 0; i < 7; i++)
			for (int j = 0; j < 6; j++)
				tmp_board.setBoard(i, j, 0);
		boolean z1 = false;
		boolean z2 = false;
		boolean z3 = false;
		boolean z4 = false;

		if (countStones(posx - 1, posy, -1, 0, player)
				+ countStones(posx + 1, posy, 1, 0, player) >= 3) {
			noticeFourStones(posx - 1, posy, -1, 0, player);
			noticeFourStones(posx + 1, posy, 1, 0, player);
			tmp_board.setBoard(posx, posy, 1);
			z1 = true;
		}

		if (countStones(posx, posy - 1, 0, -1, player)
				+ countStones(posx, posy + 1, 0, 1, player) >= 3) {
			noticeFourStones(posx, posy - 1, 0, -1, player);
			noticeFourStones(posx, posy + 1, 0, 1, player);
			tmp_board.setBoard(posx, posy, 1);
			z2 = true;
		}

		if (countStones(posx - 1, posy - 1, -1, -1, player)
				+ countStones(posx + 1, posy + 1, 1, 1, player) >= 3) {
			noticeFourStones(posx - 1, posy - 1, -1, -1, player);
			noticeFourStones(posx + 1, posy + 1, 1, 1, player);
			tmp_board.setBoard(posx, posy, 1);
			z3 = true;
		}

		if (countStones(posx - 1, posy + 1, -1, 1, player)
				+ countStones(posx + 1, posy - 1, 1, -1, player) >= 3) {
			noticeFourStones(posx - 1, posy + 1, -1, 1, player);
			noticeFourStones(posx + 1, posy - 1, 1, -1, player);
			tmp_board.setBoard(posx, posy, 1);
			z4 = true;
		}
		return z1 || z2 || z3 || z4;

	}

	public int countStones(int x, int y, int xdir, int ydir, int player) {

		if (x >= 0 && x < Main.board.getWidth() && y >= 0
				&& y < Main.board.getHight()) {
			if (Main.board.getValue(x, y) == player)
				return countStones(x + xdir, y + ydir, xdir, ydir, player) + 1;
		}
		return 0;

	}

	public void noticeFourStones(int x, int y, int xdir, int ydir, int player) {
		if (x >= 0 && x < Main.board.getWidth() && y >= 0
				&& y < Main.board.getHight()) {
			if (Main.board.getValue(x, y) == player) {
				tmp_board.setBoard(x, y, 1);
				noticeFourStones(x + xdir, y + ydir, xdir, ydir, player);
			}
		}

	}

}
