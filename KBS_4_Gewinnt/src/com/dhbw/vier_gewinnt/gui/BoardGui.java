package com.dhbw.vier_gewinnt.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class BoardGui {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public void createboardgui() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoardGui window = new BoardGui();
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
	public BoardGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setBounds(10, 11, 424, 210);
		table.setRowHeight(30);
		frame.getContentPane().add(table);
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, "", null, null, null, null, ""},
				{null, null, null, "", "", "", null},
				{null, null, null, null, null, null, null},
				{null, null, "", null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(6).setResizable(false);
		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
			MainMenu mainmenu = new MainMenu();
			mainmenu.createmainmenu();
			frame.dispose();
			}
			});
	}
}
