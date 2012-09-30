package com.dhbw.vier_gewinnt.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
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
		
		JButton btnNewButton = new JButton("Play");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BoardGui boardgui = new BoardGui();
				boardgui.createboardgui();
				resetBoard();
				frmGewinnt.dispose();
			}
		});
		btnNewButton.setBounds(185, 148, 89, 23);
		frmGewinnt.getContentPane().add(btnNewButton);
		
		JLabel lblPlayer = new JLabel("Player 1");
		lblPlayer.setBounds(30, 30, 75, 20);
		frmGewinnt.getContentPane().add(lblPlayer);
		lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPlayer.setBackground(Color.WHITE);
		
		JLabel lblPlayer_1 = new JLabel("Player 2");
		lblPlayer_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPlayer_1.setBackground(Color.WHITE);
		lblPlayer_1.setBounds(30, 70, 75, 20);
		frmGewinnt.getContentPane().add(lblPlayer_1);
		
		JLabel lblFieldsize = new JLabel("Fieldsize");
		lblFieldsize.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFieldsize.setBackground(Color.WHITE);
		lblFieldsize.setBounds(30, 110, 75, 20);
		frmGewinnt.getContentPane().add(lblFieldsize);
		
		JCheckBox chckbxKi = new JCheckBox("KI");
		buttonGroup_1.add(chckbxKi);
		chckbxKi.setBounds(217, 31, 49, 23);
		frmGewinnt.getContentPane().add(chckbxKi);
		
		JCheckBox checkBox = new JCheckBox("KI");
		checkBox.setSelected(true);
		buttonGroup_2.add(checkBox);
		checkBox.setBounds(217, 71, 49, 23);
		frmGewinnt.getContentPane().add(checkBox);
		
		JCheckBox chckbxHuman = new JCheckBox("Human");
		chckbxHuman.setSelected(true);
		buttonGroup_1.add(chckbxHuman);
		chckbxHuman.setBounds(145, 31, 70, 23);
		frmGewinnt.getContentPane().add(chckbxHuman);
		
		JCheckBox checkBox_1 = new JCheckBox("Human");
		buttonGroup_2.add(checkBox_1);
		checkBox_1.setBounds(145, 71, 70, 23);
		frmGewinnt.getContentPane().add(checkBox_1);
		
		JRadioButton rdbtnX = new JRadioButton("8 x 8");
		buttonGroup.add(rdbtnX);
		rdbtnX.setBounds(217, 111, 57, 23);
		frmGewinnt.getContentPane().add(rdbtnX);
		
		JRadioButton radioButton = new JRadioButton("7 x 6");
		buttonGroup.add(radioButton);
		radioButton.setSelected(true);
		radioButton.setBounds(145, 111, 60, 23);
		frmGewinnt.getContentPane().add(radioButton);
		
		JButton btnAbout = new JButton("Rules");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RulesGui createrules = new RulesGui();
				createrules.createrules();
				frmGewinnt.dispose();
			}
		});
		btnAbout.setBounds(30, 148, 89, 23);
		frmGewinnt.getContentPane().add(btnAbout);
		
		JButton button = new JButton("?");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AboutGui createabout = new AboutGui();
				createabout.createaboutgui();
				frmGewinnt.dispose();
			}
		});
		button.setSelectedIcon(null);
		button.setIcon(null);
		button.setBounds(245, 1, 49, 23);
		frmGewinnt.getContentPane().add(button);
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
