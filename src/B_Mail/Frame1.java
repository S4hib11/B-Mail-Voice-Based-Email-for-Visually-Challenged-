package B_Mail;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JWindow;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Frame1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;
	public static int randomInt = 0;
	/**
	 * Launch the application.
	 */

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public static boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		/*
		 * if (matcher.matches()) { //your Logic Random randomGenerator = new Random();
		 * randomInt = randomGenerator.nextInt(1000); } else {
		 * JOptionPane.showMessageDialog(null, "Not a Valid Email Address");
		 * 
		 * }
		 */
		return matcher.find();

	}

	public static void NewWindow() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 frame = new Frame1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame1() {
		setResizable(false);
		setTitle("REGISTER YOURSELF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1380, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRegistration = new JLabel(" REGISTRATION");
		lblRegistration.setBounds(477, 28, 213, 39);
		lblRegistration.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		contentPane.add(lblRegistration);

		JLabel lblName = new JLabel("NAME:");
		lblName.setBounds(365, 111, 66, 14);
		contentPane.add(lblName);

		JLabel lblEmail = new JLabel("E-MAIL:");
		lblEmail.setBounds(365, 165, 101, 17);
		contentPane.add(lblEmail);

		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setBounds(365, 217, 101, 25);
		contentPane.add(lblPassword);

		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setBounds(424, 299, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String name2 = textField.getText();
				String email2 = textField_1.getText();
				String pass2 = textField_2.getText();
				if (validate(email2)) {
					Random randomGenerator = new Random();
					randomInt = randomGenerator.nextInt(1000);

					try {

						Class.forName("com.mysql.jdbc.Driver");
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/person",
								"root", "root");
						java.sql.Statement stmt = connection.createStatement();
						stmt.executeUpdate(
								"INSERT INTO details Values('" + email2 + "','" + pass2 + "','" + randomInt + "')");
						connection.close();
						Success s = new Success();
						s.id();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Not a Valid Email Address");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");

				}

				;
			}
		});
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.setBounds(601, 299, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");

			}
		});
		contentPane.add(btnNewButton_1);

		textField = new JTextField();
		textField.setBounds(623, 108, 169, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(623, 163, 169, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(623, 219, 169, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

	}
}
