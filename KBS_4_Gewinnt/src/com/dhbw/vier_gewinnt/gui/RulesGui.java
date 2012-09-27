package com.dhbw.vier_gewinnt.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class RulesGui {

	private JFrame frmGewinnt;

	/**
	 * Launch the application.
	 */
	public void createrules() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RulesGui window = new RulesGui();
					window.frmGewinnt.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RulesGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGewinnt = new JFrame();
		frmGewinnt.setIconImage(Toolkit.getDefaultToolkit().getImage(RulesGui.class.getResource("/resources/logo.png")));
		frmGewinnt.setTitle("4 Gewinnt - Rules");
		frmGewinnt.setBounds(100, 100, 450, 300);
		frmGewinnt.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmGewinnt.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html>\r\n<body>\r\n<span style=\"font-size:14px\"><b>Rules</b></span>\r\n<br>\r\n<br>\r\n<div style=\"text-align:justify\">\r\n\"4 Gewinnt\" is a board game for two players.\r\n<br>\r\nEach player is assigned to one color (either red or yellow).\r\nThe first player (red) starts the game, by dropping one token in any coloumn.\r\nNow it's the second player's (yellow) turn to drop a token anywhere.\r\nTo win the game, one player needs to connect four of his tokens, either vertically, horizontally or diagonally.\r\n</div>\r\n</body>\r\n</html>");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(10, 11, 414, 145);
		frmGewinnt.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html>\r\n<body>\r\n<span style=\"font-size:11px\"><b>Enjoy!</b></span>\r\n</body>\r\n</html>");
		lblNewLabel_1.setBounds(194, 205, 45, 17);
		frmGewinnt.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(RulesGui.class.getResource("/resources/reddot.png")));
		lblNewLabel_2.setBounds(20, 153, 103, 83);
		frmGewinnt.getContentPane().add(lblNewLabel_2);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setIcon(new ImageIcon(RulesGui.class.getResource("/resources/yellowdot.png")));
		label.setBounds(321, 153, 103, 82);
		frmGewinnt.getContentPane().add(label);
		frmGewinnt.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
			MainMenu mainmenu = new MainMenu();
			mainmenu.createmainmenu();
			frmGewinnt.dispose();
			}
			});
	}
}
