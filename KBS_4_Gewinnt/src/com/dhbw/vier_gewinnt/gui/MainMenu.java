package com.dhbw.vier_gewinnt.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class MainMenu {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 220);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Play");
		btnNewButton.setBounds(185, 148, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblPlayer = new JLabel("Player 1");
		lblPlayer.setBounds(30, 30, 57, 20);
		frame.getContentPane().add(lblPlayer);
		lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPlayer.setBackground(Color.WHITE);
		
		JLabel lblPlayer_1 = new JLabel("Player 2");
		lblPlayer_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPlayer_1.setBackground(Color.WHITE);
		lblPlayer_1.setBounds(30, 70, 57, 20);
		frame.getContentPane().add(lblPlayer_1);
		
		JLabel lblFieldsize = new JLabel("Fieldsize");
		lblFieldsize.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFieldsize.setBackground(Color.WHITE);
		lblFieldsize.setBounds(30, 110, 59, 20);
		frame.getContentPane().add(lblFieldsize);
		
		JCheckBox chckbxKi = new JCheckBox("KI");
		buttonGroup_1.add(chckbxKi);
		chckbxKi.setBounds(217, 31, 49, 23);
		frame.getContentPane().add(chckbxKi);
		
		JCheckBox checkBox = new JCheckBox("KI");
		buttonGroup_2.add(checkBox);
		checkBox.setBounds(217, 71, 49, 23);
		frame.getContentPane().add(checkBox);
		
		JCheckBox chckbxHuman = new JCheckBox("Human");
		buttonGroup_1.add(chckbxHuman);
		chckbxHuman.setBounds(145, 31, 70, 23);
		frame.getContentPane().add(chckbxHuman);
		
		JCheckBox checkBox_1 = new JCheckBox("Human");
		buttonGroup_2.add(checkBox_1);
		checkBox_1.setBounds(145, 71, 70, 23);
		frame.getContentPane().add(checkBox_1);
		
		JRadioButton rdbtnX = new JRadioButton("8 x 8");
		buttonGroup.add(rdbtnX);
		rdbtnX.setBounds(217, 111, 57, 23);
		frame.getContentPane().add(rdbtnX);
		
		JRadioButton radioButton = new JRadioButton("7 x 6");
		buttonGroup.add(radioButton);
		radioButton.setSelected(true);
		radioButton.setBounds(145, 111, 60, 23);
		frame.getContentPane().add(radioButton);
	}
}
