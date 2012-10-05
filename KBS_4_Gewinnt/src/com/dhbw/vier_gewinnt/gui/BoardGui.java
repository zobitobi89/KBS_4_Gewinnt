package com.dhbw.vier_gewinnt.gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BoardGui {

	private JFrame frmGewinnt;
	public static StoneYellow[] stones_yellow;
	public static StoneRed[] stones_red; 
	public static JLabel lbl_status;
	public static ColumnArrow[] arrows;
	// private JTable table;

	/**
	 * Launch the application.
	 */
	public void createboardgui() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoardGui window = new BoardGui();
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
	public BoardGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double s_width = screenSize.getWidth();
		double s_height = screenSize.getHeight();
		int left = (int) ((s_width - 700) / 2);
		int top = (int) ((s_height - 800) / 2);

		frmGewinnt = new JFrame();
		frmGewinnt.setTitle("4 Gewinnt - Game");
		frmGewinnt.setIconImage(Toolkit.getDefaultToolkit().getImage(
				BoardGui.class.getResource("/resources/logo.png")));
		frmGewinnt.setResizable(false);
		frmGewinnt.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmGewinnt.setBounds(left, top, 700, 800);
		frmGewinnt.getContentPane().setLayout(null);

		

		JLabel lbl_board = new JLabel("");
		// Image image_board =
		// Toolkit.getDefaultToolkit().getImage("/resources/viergewinnt_brett.png");
		// Image scaledImage = image_board.getScaledInstance(525, 450,
		// Image.SCALE_DEFAULT);
		// ImageIcon icon=new ImageIcon(scaledImage);
		// lbl_board.setIcon(icon);
		lbl_board.setIcon(new ImageIcon(BoardGui.class
				.getResource("/resources/viergewinnt_brett_clean(525).png")));
		lbl_board.setBounds(87, 175, 525, 509);
		frmGewinnt.getContentPane().add(lbl_board);

		stones_yellow = new StoneYellow[21];
		for (int i = 0; i < stones_yellow.length; i++) {
			stones_yellow[i] = new StoneYellow();
			stones_yellow[i].setBounds(625, 600 - 20 * i, 45, 45);
			frmGewinnt.getContentPane().add(stones_yellow[i]);
		}

		stones_red = new StoneRed[21];
		for (int i = 0; i < stones_red.length; i++) {
			stones_red[i] = new StoneRed();
			stones_red[i].setBounds(30, 600 - 20 * i, 45, 45);
			frmGewinnt.getContentPane().add(stones_red[i]);
		}

		arrows = new ColumnArrow[7];
		for (int i = 0; i < arrows.length; i++) {
			arrows[i] = new ColumnArrow(i);
			arrows[i].setBounds(115 + i * 68, 20, 50, 150);
			frmGewinnt.getContentPane().add(arrows[i]);
		}
		
		lbl_status = new JLabel("It is Reds Turn",JLabel.CENTER);
		lbl_status.setFont(new Font("Serif", Font.BOLD, 48));
		lbl_status.setBounds(87,700,525,40);
		frmGewinnt.getContentPane().add(lbl_status);
		
		JLabel lbl_background = new JLabel(new ImageIcon(BoardGui.class
				.getResource("/resources/holz1.png")));
		lbl_background.setBounds(0,0,700,800);
		frmGewinnt.getContentPane().add(lbl_background);

		frmGewinnt.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				MainMenu mainmenu = new MainMenu();
				mainmenu.createmainmenu();
				frmGewinnt.dispose();
			}
		});
	}
}
