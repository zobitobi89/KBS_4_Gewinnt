package com.dhbw.vier_gewinnt.gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class StoneRed extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StoneRed() {
		this.setIcon(new ImageIcon(StoneRed.class
				.getResource("/resources/Stein_rot(45).png")));
		this.setBounds(30, 600, 45, 45);
	}

}
