package com.dhbw.vier_gewinnt.gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.dhbw.vier_gewinnt.controller.Main;

public class BoardGui {

	private JFrame frmGewinnt;
	public static StoneYellow[] stones_yellow;
	public static StoneRed[] stones_red;
	public static StoneWin[] stones_win;
	public static JLabel lbl_status;
	public static JLabel lbl_message;
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

		JButton btn_backtomenu = new JButton();
		btn_backtomenu.setIcon(new ImageIcon(BoardGui.class
				.getResource("/resources/home_icon1.png")));
		btn_backtomenu.setContentAreaFilled(false);
		btn_backtomenu.setBorderPainted(false);
		btn_backtomenu.setFocusPainted(false);
		btn_backtomenu.setBounds(600, 25, 75, 75);
		btn_backtomenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openMenu();
			}
		});
		frmGewinnt.getContentPane().add(btn_backtomenu);

		JButton btn_restart = new JButton();
		btn_restart.setIcon(new ImageIcon(BoardGui.class
				.getResource("/resources/reset_arrow1.png")));
		btn_restart.setContentAreaFilled(false);
		btn_restart.setBorderPainted(false);
		btn_restart.setFocusPainted(false);
		btn_restart.setBounds(25, 25, 75, 75);
		btn_restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					resetStones();
					resetBoard();
			}
		});
		frmGewinnt.getContentPane().add(btn_restart);
		
		stones_win = new StoneWin[12];
		for (int i = 0; i < stones_win.length; i++) {
			stones_win[i] = new StoneWin();
			stones_win[i].setBounds(30, 600 - 20 * i, 45, 45);
			frmGewinnt.getContentPane().add(stones_win[i]);
			stones_win[i].setVisible(false);
		}

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

		lbl_status = new JLabel("It is Reds Turn", JLabel.CENTER);
		lbl_status.setFont(new Font("Serif", Font.BOLD, 48));
		lbl_status.setBounds(87, 700, 525, 40);
		frmGewinnt.getContentPane().add(lbl_status);

		lbl_message = new JLabel("", JLabel.CENTER);
		lbl_message.setFont(new Font("Serif", Font.BOLD, 32));
		lbl_message.setBounds(87, 620, 525, 80);
		frmGewinnt.getContentPane().add(lbl_message);
		
		JLabel lbl_background = new JLabel(new ImageIcon(
				BoardGui.class.getResource("/resources/holz1.png")));
		lbl_background.setBounds(0, 0, 700, 800);
		frmGewinnt.getContentPane().add(lbl_background);

		frmGewinnt.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				openMenu();
			}
		});

		if (Main.ki1>0 && Main.board.getTurn() == 1)
			Main.task.kiTurn();
	}

	protected void resetBoard() {
		for (int i = 0; i < 7; i++)
			for (int j = 0; j < 6; j++)
				Main.board.setBoard(i, j, 0);
		Main.stone_r = 0;
		Main.stone_y = 0;
		Main.board.setTurn(1);
		Main.gameover=false;
		if(Main.ki1>0)
			Main.task.kiTurn();
	}

	protected void resetStones() {
		for (int i = 0; i < stones_win.length; i++) {
			stones_win[i].setBounds(30, 600 - 20 * i, 45, 45);
			stones_win[i].setVisible(false);
		}
		for (int i = 0; i < stones_yellow.length; i++) {
			stones_yellow[i].setBounds(625, 600 - 20 * i, 45, 45);
			stones_red[i].setBounds(30, 600 - 20 * i, 45, 45);	
		}		
		for (int i = 0; i < arrows.length; i++) {
			arrows[i].setEnabled(true);
		}
		lbl_message.setText("");
		lbl_status.setText("It is Reds Turn");

		
	}

	protected void openMenu() {
		MainMenu mainmenu = new MainMenu();
		mainmenu.createmainmenu();
		// Main.task.interrupted();
		Main.ki1 = 0;
		Main.ki2 = 0;
		frmGewinnt.setVisible(false);
		frmGewinnt.dispose();
		frmGewinnt = null;		
	}
}