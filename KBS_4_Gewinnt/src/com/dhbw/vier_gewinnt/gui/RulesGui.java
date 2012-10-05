package com.dhbw.vier_gewinnt.gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double s_width = screenSize.getWidth();
		double s_height = screenSize.getHeight();
		int left = (int) ((s_width - 450) / 2);
		int top = (int) ((s_height - 300) / 2);
		
		frmGewinnt = new JFrame();
		frmGewinnt.setIconImage(Toolkit.getDefaultToolkit().getImage(RulesGui.class.getResource("/resources/logo.png")));
		frmGewinnt.setTitle("4 Gewinnt - Rules");
		frmGewinnt.setBounds(left, top, 450, 300);
		frmGewinnt.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmGewinnt.getContentPane().setLayout(null);
		
		JLabel lbl_rules = new JLabel("<html>\r\n<body>\r\n<span style=\"font-size:14px\"><b>Rules</b></span>\r\n<br>\r\n<br>\r\n<div style=\"text-align:justify\">\r\n\"4 Gewinnt\" is a board game for two players.\r\n<br>\r\nEach player is assigned to one color (either red or yellow).\r\nThe first player (red) starts the game, by dropping one token in any coloumn.\r\nNow it's the second player's (yellow) turn to drop a token anywhere.\r\nTo win the game, one player needs to connect four of his tokens, either vertically, horizontally or diagonally.\r\n</div>\r\n</body>\r\n</html>");
		lbl_rules.setVerticalAlignment(SwingConstants.TOP);
		lbl_rules.setBounds(10, 11, 414, 145);
		frmGewinnt.getContentPane().add(lbl_rules);
		
		JLabel lbl_enjoy = new JLabel("<html>\r\n<body>\r\n<span style=\"font-size:11px\"><b>Enjoy!</b></span>\r\n</body>\r\n</html>");
		lbl_enjoy.setBounds(194, 205, 45, 17);
		frmGewinnt.getContentPane().add(lbl_enjoy);
		
		JLabel lbl_red = new JLabel("");
		lbl_red.setIcon(new ImageIcon(RulesGui.class.getResource("/resources/Stein_rot(100).png")));
		lbl_red.setBounds(20, 153, 100, 100);
		frmGewinnt.getContentPane().add(lbl_red);
		
		JLabel lbl_yellow = new JLabel("");
		lbl_yellow.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_yellow.setIcon(new ImageIcon(RulesGui.class.getResource("/resources/Stein_gelb(100).png")));
		lbl_yellow.setBounds(321, 153, 100, 100);
		frmGewinnt.getContentPane().add(lbl_yellow);
		
		JLabel lbl_background = new JLabel(new ImageIcon(BoardGui.class
				.getResource("/resources/holz1.png")));
		lbl_background.setBounds(0,0,700,800);
		frmGewinnt.getContentPane().add(lbl_background);
		
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
