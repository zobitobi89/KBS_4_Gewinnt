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
			}

			private void setStone(int column) {
				int row = -1;
				int top;
				CheckLines line_checker= new CheckLines();
				for (int i = 0; i < 6; i++) {
					if (Main.board.getValue(column, i) == 0) {
						row = i;
						break;
					}
				}
				if (row != -1) {
					top = 505 - 58 * row;
					if (Main.turn == 0) {
						BoardGui.stones_red[Main.stone_r].setBounds(
								118 + 68 * column, top, 45, 45);
						Main.board.setBoard(column, row, 1);
						Main.stone_r++;
						Main.turn = 1;
						if (line_checker.checkLines(column, row, 1)){
							BoardGui.lbl_status.setText("Red Wins");
							for(int j=0;j<7;j++)
								BoardGui.arrows[j].setEnabled(false);
						}
						else
							BoardGui.lbl_status.setText("It is Yellows Turn");
					} else {
						BoardGui.stones_yellow[Main.stone_y].setBounds(
								118 + 68 * column, top, 45, 45);
						Main.board.setBoard(column, row, 2);
						Main.stone_y++;
						Main.turn = 0;
						if (line_checker.checkLines(column, row, 2)){
							BoardGui.lbl_status.setText("Yellow Wins");
							for(int j=0;j<7;j++)
								BoardGui.arrows[j].setEnabled(false);
						}
						else
							BoardGui.lbl_status.setText("It is Reds Turn");
					}
				if (Main.stone_r==21 && Main.stone_y==21)
					BoardGui.lbl_status.setText("Draw");
				}
			}
		});
		this.setContentAreaFilled(false);
		this.setBounds(115, 20, 50, 150);
	}
}
