package B_Mail;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextArea;

public class sub {
	private static final String SayWhat = "kevin16";
	private JFrame frame;
	private JTextField textField_1;
	static String subject;

	/**
	 * Launch the application.
	 */
	public static void sub() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sub window = new sub();
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
	public sub() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1380, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("SUBJECT:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(283, 131, 105, 34);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel2 = new JLabel(" * LEFT CLICK TO PROCEED");
		lblNewLabel2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel2.setBounds(519, 224, 265, 33);
		frame.getContentPane().add(lblNewLabel2);

		JLabel lblNewLabel_1 = new JLabel("* RIGHT CLICK TO ADD SUBJECT AND PROCESS");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(519, 267, 558, 33);
		frame.getContentPane().add(lblNewLabel_1);

		JTextArea response = new JTextArea();
		response.setBounds(466, 138, 388, 22);
		frame.getContentPane().add(response);
		response.setEditable(false);
		Application aap = new Application();
		aap.Applications();

		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
		frame.addWindowListener(getWindowAdapter());

		frame.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					response.setText(Application.output);
					// System.exit(0);
					subject = Application.output;
				}

				else if (e.getButton() == MouseEvent.BUTTON1) {
					Message m1 = new Message();
					m1.msg();

				}

				else if (e.getButton() == MouseEvent.BUTTON2) {
					Voice iTalk;
					VoiceManager vm = VoiceManager.getInstance();
					iTalk = vm.getVoice(SayWhat);
					iTalk.allocate();
					try {
						iTalk.speak("RIGHT CLICK TO ADD SUBJECT AND PROCESS");
						iTalk.speak("LEFT CLICK TO PROCEED");

					} catch (Exception ex) {
						System.out.println(" ");

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
				frame.setState(JFrame.NORMAL);
				// JOptionPane.showMessageDialog(frame, "Cant Minimize");
			}
		};

	}
}
