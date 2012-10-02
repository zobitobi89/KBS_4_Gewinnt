package com.dhbw.vier_gewinnt.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import com.dhbw.vier_gewinnt.controller.Main;

public class MainMenu {

	private JFrame frmGewinnt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public void createmainmenu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
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
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double s_width = screenSize.getWidth();
		double s_height = screenSize.getHeight();
		int left = (int) ((s_width - 300) / 2);
		int top = (int) ((s_height - 220) / 2);
		
		frmGewinnt = new JFrame();
		frmGewinnt.setTitle("4 Gewinnt - Menu");
		frmGewinnt.setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenu.class.getResource("/resources/logo.png")));
		frmGewinnt.setResizable(false);
		frmGewinnt.setBounds(left, top, 300, 220);
		frmGewinnt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGewinnt.getContentPane().setLayout(null);
		
		JButton btn_play = new JButton("Play");
		btn_play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BoardGui boardgui = new BoardGui();
				boardgui.createboardgui();
				resetBoard();
				frmGewinnt.dispose();
			}
		});
		btn_play.setBounds(185, 148, 89, 23);
		frmGewinnt.getContentPane().add(btn_play);
		
		JLabel lbl_player1 = new JLabel("Player 1");
		lbl_player1.setBounds(30, 30, 75, 20);
		frmGewinnt.getContentPane().add(lbl_player1);
		lbl_player1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_player1.setBackground(Color.WHITE);
		
		JLabel lbl_player2 = new JLabel("Player 2");
		lbl_player2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_player2.setBackground(Color.WHITE);
		lbl_player2.setBounds(30, 70, 75, 20);
		frmGewinnt.getContentPane().add(lbl_player2);
		
		JLabel lbl_fieldsize = new JLabel("Fieldsize");
		lbl_fieldsize.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_fieldsize.setBackground(Color.WHITE);
		lbl_fieldsize.setBounds(30, 110, 75, 20);
		frmGewinnt.getContentPane().add(lbl_fieldsize);
		
		JCheckBox cbx_ki1 = new JCheckBox("KI");
		buttonGroup_1.add(cbx_ki1);
		cbx_ki1.setBounds(217, 31, 49, 23);
		cbx_ki1.setContentAreaFilled(false);
		cbx_ki1.setBorderPainted(false);
		frmGewinnt.getContentPane().add(cbx_ki1);
		
		JCheckBox cbx_ki2 = new JCheckBox("KI");
		cbx_ki2.setSelected(true);
		buttonGroup_2.add(cbx_ki2);
		cbx_ki2.setBounds(217, 71, 49, 23);
		cbx_ki2.setContentAreaFilled(false);
		cbx_ki2.setBorderPainted(false);
		frmGewinnt.getContentPane().add(cbx_ki2);
		
		JCheckBox cbx_human1 = new JCheckBox("Human");
		cbx_human1.setSelected(true);
		buttonGroup_1.add(cbx_human1);
		cbx_human1.setBounds(145, 31, 70, 23);
		cbx_human1.setContentAreaFilled(false);
		cbx_human1.setBorderPainted(false);
		frmGewinnt.getContentPane().add(cbx_human1);
		
		JCheckBox cbx_human2 = new JCheckBox("Human");
		buttonGroup_2.add(cbx_human2);
		cbx_human2.setBounds(145, 71, 70, 23);
		cbx_human2.setContentAreaFilled(false);
		cbx_human2.setBorderPainted(false);
		frmGewinnt.getContentPane().add(cbx_human2);
		
		JRadioButton rbtn_8x8 = new JRadioButton("8 x 8");
		buttonGroup.add(rbtn_8x8);
		rbtn_8x8.setBounds(217, 111, 57, 23);
		rbtn_8x8.setContentAreaFilled(false);
		rbtn_8x8.setBorderPainted(false);
		frmGewinnt.getContentPane().add(rbtn_8x8);
		
		JRadioButton rbtn_7x6 = new JRadioButton("7 x 6");
		buttonGroup.add(rbtn_7x6);
		rbtn_7x6.setSelected(true);
		rbtn_7x6.setBounds(145, 111, 60, 23);
		rbtn_7x6.setContentAreaFilled(false);
		rbtn_7x6.setBorderPainted(false);
		frmGewinnt.getContentPane().add(rbtn_7x6);
		
		JButton btn_rules = new JButton("Rules");
		btn_rules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RulesGui createrules = new RulesGui();
				createrules.createrules();
				frmGewinnt.dispose();
			}
		});
		btn_rules.setBounds(30, 148, 89, 23);
		frmGewinnt.getContentPane().add(btn_rules);
		
		JButton btn_about = new JButton("?");
		btn_about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AboutGui createabout = new AboutGui();
				createabout.createaboutgui();
				frmGewinnt.dispose();
			}
		});
		btn_about.setSelectedIcon(null);
		btn_about.setIcon(null);
		btn_about.setBounds(245, 1, 49, 23);
		frmGewinnt.getContentPane().add(btn_about);
		
		JLabel lbl_background = new JLabel(new ImageIcon(BoardGui.class
				.getResource("/resources/holz1.png")));
		lbl_background.setBounds(0,0,700,800);
		frmGewinnt.getContentPane().add(lbl_background);
	}

	private void resetBoard() {
		for(int i=0;i<7;i++)
			for (int j=0;j<6;j++)
				Main.board.setBoard(i,j,0);
		Main.stone_r=0;
		Main.stone_y=0;
		Main.turn=0;
	}
}
