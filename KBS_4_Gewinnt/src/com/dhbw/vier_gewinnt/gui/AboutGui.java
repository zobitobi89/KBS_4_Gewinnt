package com.dhbw.vier_gewinnt.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class AboutGui {

	private JFrame frmGewinnt;

	/**
	 * Launch the application.
	 */
	public void createaboutgui() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutGui window = new AboutGui();
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
	public AboutGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGewinnt = new JFrame();
		frmGewinnt.setResizable(false);
		frmGewinnt.setTitle("4 Gewinnt - About");
		frmGewinnt.setIconImage(Toolkit.getDefaultToolkit().getImage(AboutGui.class.getResource("/resources/logo.png")));
		frmGewinnt.setBounds(100, 100, 254, 281);
		frmGewinnt.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmGewinnt.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AboutGui.class.getResource("/resources/4_Gewinnt Logo_3.png")));
		lblNewLabel.setBounds(10, 11, 228, 172);
		frmGewinnt.getContentPane().add(lblNewLabel);
		
		JLabel lblVersion = new JLabel("<html>\r\n<body>\r\nVersion\r\n<br>\r\n0.1\r\n</body>\r\n</html>");
		lblVersion.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblVersion.setBounds(10, 220, 31, 22);
		frmGewinnt.getContentPane().add(lblVersion);
		
		JLabel lblNewLabel_1 = new JLabel("<html>\r\n<body>\r\n<b>Created by</b>\r\n<br>\r\n<span style=\"font-size:7px\">\r\nTobias Zogrotzky\r\n<br>\r\nPhilipp Goetze\r\n<br>\r\nSebastian Boehm\r\n</span>\r\n</body>\r\n</html>");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1.setBounds(163, 198, 75, 44);
		frmGewinnt.getContentPane().add(lblNewLabel_1);
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
