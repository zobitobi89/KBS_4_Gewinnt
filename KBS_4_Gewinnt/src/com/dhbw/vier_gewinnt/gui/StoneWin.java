package com.dhbw.vier_gewinnt.gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class StoneWin extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StoneWin() {
		this.setIcon(new ImageIcon(StoneWin.class
				.getResource("/resources/Stein_transp(45).png")));
		this.setBounds(30, 600, 45, 45);
	}

}
