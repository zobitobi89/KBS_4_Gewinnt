package com.dhbw.vier_gewinnt.ki;

import com.dhbw.vier_gewinnt.controller.Main;

public class CheckLines {

	public boolean checkLines(int posx, int posy, int player) {
		
		return 	countStones(posx - 1, posy, -1, 0, player)		+ 
				countStones(posx + 1, posy, 1, 0, player) >= 3 		||
				
				countStones(posx, posy - 1, 0, -1, player) 		+ 
				countStones(posx, posy + 1, 0, 1, player) >= 3 		|| 
				
				countStones(posx - 1, posy - 1, -1, -1, player)	+ 
				countStones(posx + 1, posy + 1, 1, 1, player) >= 3 	|| 
				
				countStones(posx - 1, posy + 1, -1, 1, player) 	+ 
				countStones(posx + 1, posy - 1, 1, -1, player) >= 3;
	}

	public int countStones(int x, int y, int xdir, int ydir, int player) {
		
		if (x >= 0 && x < Main.board.getWidth() && y >= 0 && y < Main.board.getHight()) {
			if (Main.board.getValue(x, y) == player)
				return countStones(x + xdir, y + ydir, xdir, ydir, player) + 1;
		}
		return 0;
		
	}

}
