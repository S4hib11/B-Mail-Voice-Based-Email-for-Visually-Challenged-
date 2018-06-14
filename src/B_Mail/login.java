package B_Mail;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import javax.swing.JTextArea;

public class login {
	private static final String SayWhat = "kevin16";
	private JFrame frmLogIn;
	static String emailsend;
	static String passend;
	static String email3;
	static String pass3;
	static String id1 = "";
	int id2;

	public static void unique() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frmLogIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {

		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmLogIn = new JFrame();
		frmLogIn.setTitle("LOG IN");
		frmLogIn.setResizable(false);
		frmLogIn.setBounds(0, 0, 1380, 900);
		frmLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogIn.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("LOG IN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(722, 46, 319, 42);
		frmLogIn.getContentPane().add(lblNewLabel);

		JLabel lblUniqueId = new JLabel("UNIQUE ID:");
		lblUniqueId.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblUniqueId.setBounds(539, 163, 123, 53);
		frmLogIn.getContentPane().add(lblUniqueId);

		JLabel lblSpeakYour = new JLabel("* SPEAK YOUR UNIQUE ID NUMBER");
		lblSpeakYour.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSpeakYour.setBounds(605, 294, 341, 53);
		frmLogIn.getContentPane().add(lblSpeakYour);

		JLabel lblLeftClick = new JLabel("* LEFT CLICK TO PROCEED");
		lblLeftClick.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblLeftClick.setBounds(601, 373, 324, 42);
		frmLogIn.getContentPane().add(lblLeftClick);

		JTextArea response = new JTextArea();
		response.setBounds(690, 179, 130, 33);
		frmLogIn.getContentPane().add(response);
		response.setEditable(false);
		Application aap = new Application();
		aap.Applications();

		frmLogIn.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					response.setText(Application.output);
					id1 = Application.output;
					id2 = Integer.valueOf(id1);

				}

				else if (e.getButton() == MouseEvent.BUTTON1) {
					try {

						Class.forName("com.mysql.jdbc.Driver");
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/person",
								"root", "root");
						java.sql.Statement stmt = connection.createStatement();
						int out = Integer.valueOf(Application.output);
						String sql = "Select * from details where UniqueId = " + id2 + "";
						ResultSet rs = stmt.executeQuery(sql);
						while (rs.next()) {
							int id = rs.getInt("UniqueID");
							emailsend = rs.getString("Email");
							passend = rs.getString("Password");

							email3 = emailsend;
							pass3 = passend;
							System.out.println(email3);
							System.out.println(pass3);

							if (out == id) {

								System.out.println("yes");
								System.out.println(id);
								System.out.println(emailsend);
								System.out.println(passend);
								Instn i1 = new Instn();
								i1.instn();

							} else {
								response.setText("");
								// System.out.println("No");
							}
						}
						connection.close();

					} catch (Exception e1) {

						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}

				else if (e.getButton() == MouseEvent.BUTTON2) {
					Voice iTalk;
					VoiceManager vm = VoiceManager.getInstance();
					iTalk = vm.getVoice(SayWhat);
					iTalk.allocate();
					try {
						iTalk.speak("YOU ARE IN LOGIN MENU");
						iTalk.speak("SPEAK YOUR UNIQUE IDENTIFICATION NUMBER AND RIGHT CLICK TO PROCESS");
						iTalk.speak("AND LEFT CLICK TO PROCEED");

					} catch (Exception ex) {
						System.out.println("hello");

					}

				}

			}
		});
	}

	private WindowAdapter getWindowAdapter() {
		return new WindowAdapter() {

			public void windowClosing(WindowEvent we) {
				super.windowClosing(we);
				// JOptionPane.showMessageDialog(frame, "Cant Exit");
			}

			public void windowIconified(WindowEvent we) {
				frmLogIn.setState(JFrame.NORMAL);
				// JOptionPane.showMessageDialog(frame, "Cant Minimize");
			}
		};

	}
}
