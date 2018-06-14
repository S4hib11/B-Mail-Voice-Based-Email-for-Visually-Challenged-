package B_Mail;

import net.sourceforge.javaflacencoder.FLACFileWriter;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.darkprograms.speech.microphone.Microphone;
import com.darkprograms.speech.recognizer.GSpeechDuplex;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import B_Mail.App;
import B_Mail.Application;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextArea;

public class Message {
	private static final String SayWhat = "kevin16";
	private JFrame frame;
	private JTextField textField_1;
	static String message;

	/**
	 * Launch the application.
	 */
	public static void msg() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Message window = new Message();
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
	public Message() {
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

		JLabel lblMessage = new JLabel("MESSAGE:");
		lblMessage.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMessage.setBounds(203, 144, 278, 43);
		frame.getContentPane().add(lblMessage);

		JLabel lblLeftClickTo = new JLabel("* LEFT CLICK TO SEND EMAIL");
		lblLeftClickTo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblLeftClickTo.setBounds(203, 402, 351, 55);
		frame.getContentPane().add(lblLeftClickTo);

		JLabel lblRightClick = new JLabel("* RIGHT CLICK TO ENTER MESSAGE AND PROCESS");
		lblRightClick.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblRightClick.setBounds(203, 457, 530, 31);
		frame.getContentPane().add(lblRightClick);

		JTextArea response = new JTextArea();
		response.setBounds(203, 242, 518, 115);
		frame.getContentPane().add(response);
		response.setEditable(false);
		Application aap = new Application();
		aap.Applications();
		System.out.println("HI!" + Application.output);
		frame.addWindowListener(getWindowAdapter());

		frame.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {

					response.setText(Application.output);
					// System.exit(0);
					message = Application.output;
				}

				else if (e.getButton() == MouseEvent.BUTTON1) {

					// response.setText("Your Message is"+ Application.output);
					App a = new App();
					App.mail();

				}

				else if (e.getButton() == MouseEvent.BUTTON2) {
					Voice iTalk;
					VoiceManager vm = VoiceManager.getInstance();
					iTalk = vm.getVoice(SayWhat);
					iTalk.allocate();
					try {

						iTalk.speak("RIGHT CLICK TO ENTER MESSAGE AND PROCESS");
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
