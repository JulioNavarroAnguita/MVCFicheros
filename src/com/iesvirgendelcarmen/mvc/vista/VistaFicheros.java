package com.iesvirgendelcarmen.mvc.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class VistaFicheros {

	private JFrame frame;
	private JMenuItem mntmData;
	private JMenuItem mntmExit;
	private JMenuItem mntmAbout;
	private JTabbedPane tabbedPane;
	private JSplitPane splitPane;
	private JTextField textFieldName;
	private JTextField textFieldLastName;
	private JTextField textFieldGender;
	private JTextField textFieldRace;
	private JTextField textFieldLanguage;
	private JButton buttonLeft10;
	private JButton buttonLeft;
	private JButton buttonRight;
	private JButton buttonRight10;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista window = new Vista();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public VistaFicheros() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Application data files");
		frame.setResizable(false);
		frame.setVisible(true);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);


		JMenu mnData = new JMenu("Data");
		menuBar.add(mnData);

		mntmData = new JMenuItem("Data files");
		mnData.add(mntmData);

		mntmExit = new JMenuItem("Exit");
		mnData.add(mntmExit);



		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);

		mntmAbout = new JMenuItem("About");
		mnAbout.add(mntmAbout);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.25);
		tabbedPane.addTab("Load files", null, splitPane, null);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		panel.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		panel.add(rdbtnFemale);
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblFirstName = new JLabel("First Name");
		panel_1.add(lblFirstName);
		
		textFieldName = new JTextField();
		panel_1.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		panel_1.add(lblLastName);
		
		textFieldLastName = new JTextField();
		panel_1.add(textFieldLastName);
		textFieldLastName.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		panel_1.add(lblGender);
		
		textFieldGender = new JTextField();
		panel_1.add(textFieldGender);
		textFieldGender.setColumns(10);
		
		JLabel lblLanguage = new JLabel("Language");
		panel_1.add(lblLanguage);
		
		textFieldLanguage = new JTextField();
		panel_1.add(textFieldLanguage);
		textFieldLanguage.setColumns(10);
		
		JLabel lblRace = new JLabel("Race");
		panel_1.add(lblRace);
		
		textFieldRace = new JTextField();
		panel_1.add(textFieldRace);
		textFieldRace.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		buttonLeft10 = new JButton("<<");
		panel_2.add(buttonLeft10);
		
		buttonLeft = new JButton("<");
		panel_2.add(buttonLeft);
		
		buttonRight = new JButton(">");
		panel_2.add(buttonRight);
		
		buttonRight10 = new JButton(">>");
		panel_2.add(buttonRight10);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Table", null, scrollPane, null);
		
		
	}

	public JMenuItem getMntmData() {
		return mntmData;
	}

	public JMenuItem getMntmExit() {
		return mntmExit;
	}

	public JMenuItem getMntmAbout() {
		return mntmAbout;
	}

	public void lanzarDialogo(String frase) {
		JOptionPane dialogo = new JOptionPane();
		dialogo.showMessageDialog(frame, frase, 
				"Information application", JOptionPane.INFORMATION_MESSAGE);


	}
}
