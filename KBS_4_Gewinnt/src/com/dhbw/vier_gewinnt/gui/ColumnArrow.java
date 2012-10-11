package com.dhbw.vier_gewinnt.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.dhbw.vier_gewinnt.controller.Main;
import com.dhbw.vier_gewinnt.ki.CheckLines;

public class ColumnArrow extends JButton {

	/**
* 
*/

	private static final long serialVersionUID = 1L;

	public ColumnArrow(final int column) {
		this.setIcon(new ImageIcon(BoardGui.class
				.getResource("/resources/pfeil(50).png")));
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setStone(column);
				if (!Main.gameover) {
					if (Main.ki1>0 && Main.board.getTurn() == 1 || Main.ki2>0 && Main.board.getTurn() == 2){
						for (int j = 0; j < 7; j++)
							BoardGui.arrows[j].setEnabled(false);
						Main.task.kiTurn();

					}
				}
			}
		});
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setBounds(115, 20, 50, 150);
	}

	public void setStone(int column) {
		for (int j = 0; j < 7; j++)
			BoardGui.arrows[j].setEnabled(false);
		int row = -1;
		int top;
		int balance;
		balance=getBalance(column);
		CheckLines line_checker = new CheckLines();
		for (int i = 0; i < 6; i++) {
			if (Main.board.getValue(column, i) == 0) {
				row = i;
				break;
			}
		}
		if (row != -1) {
			top = 505 - 58 * row + 1;
			if (Main.board.getTurn() == 1) {
				BoardGui.stones_red[Main.stone_r].setBounds(118 + 68 * column
						+ balance, top, 45, 45);
				Main.board.setBoard(column, row, 1);
				Main.stone_r++;
				Main.board.setTurn(2);
				if (line_checker.checkLines(column, row, 1)) {
					BoardGui.lbl_status.setText("Red Wins");
					Main.gameover = true;
					int z = 0;
					for (int r = Main.board.getHeight() - 1; r >= 0; r--) {
						for (int c = 0; c < Main.board.getWidth(); c++) {
							if (CheckLines.tmp_board.getValue(c, r) == 1) {
								BoardGui.stones_win[z].setBounds(118 + 68 * c+getBalance(c),
										505 - 58 * r + 1, 45, 45);
								BoardGui.stones_win[z].setVisible(true);
								z++;
							}
						}
						System.out.println();
					}
				} else
					BoardGui.lbl_status.setText("It is Yellows Turn");
			} else {
				BoardGui.stones_yellow[Main.stone_y].setBounds(118 + 68
						* column + balance, top, 45, 45);
				Main.board.setBoard(column, row, 2);
				Main.stone_y++;
				Main.board.setTurn(1);
				if (line_checker.checkLines(column, row, 2)) {
					BoardGui.lbl_status.setText("Yellow Wins");
					Main.gameover = true;

					int z = 0;
					for (int r = Main.board.getHeight() - 1; r >= 0; r--) {
						for (int c = 0; c < Main.board.getWidth(); c++) {
							if (CheckLines.tmp_board.getValue(c, r) == 1) {
								BoardGui.stones_win[z].setBounds(118 + 68 * c,
										505 - 58 * r + 1, 45, 45);
								BoardGui.stones_win[z].setVisible(true);
								z++;
							}
						}
						System.out.println();
					}
				} else
					BoardGui.lbl_status.setText("It is Reds Turn");
			}
			if (Main.stone_r == 21 && Main.stone_y == 21) {
				BoardGui.lbl_status.setText("Draw");
				Main.gameover = true;
			}
		}
		// try {
		// Thread.sleep(500);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		if (!Main.gameover)
			for (int j = 0; j < 7; j++)
				BoardGui.arrows[j].setEnabled(true);
	}

	private int getBalance(int column) {
		int balance;
		switch (column) {
		case 0:
			balance = 0;
			break;
		case 1:
			balance = 1;
			break;
		case 2:
			balance = 1;
			break;
		case 3:
			balance = 2;
			break;
		case 4:
			balance = 2;
			break;
		case 5:
			balance = 0;
			break;
		case 6:
			balance = 0;
			break;
		default:
			balance=0;
			break;
		}
		return balance;
	}

}