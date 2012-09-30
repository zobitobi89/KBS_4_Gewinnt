package com.dhbw.vier_gewinnt.gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class StoneYellow extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StoneYellow() {
		this.setIcon(new ImageIcon(StoneYellow.class
				.getResource("/resources/Stein_gelb(45).png")));
		this.setBounds(625, 600, 45, 45);
	}
}
