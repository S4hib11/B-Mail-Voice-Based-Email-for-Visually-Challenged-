package B_Mail;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.audio.JavaClipAudioPlayer;
import javax.swing.JTextArea;

public class CC {
	private static final String SayWhat = "kevin16";

	private JFrame frmSendACopy;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void new4() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CC window = new CC();
					window.frmSendACopy.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSendACopy = new JFrame();
		frmSendACopy.setTitle("Send A Copy");
		frmSendACopy.setBounds(0, 0, 1380, 900);
		frmSendACopy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSendACopy.getContentPane().setLayout(null);

		JLabel lblCc = new JLabel("CC:");
		lblCc.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCc.setBounds(351, 209, 46, 24);
		frmSendACopy.getContentPane().add(lblCc);

		JLabel lblNewLabel = new JLabel(" * LEFT CLICK TO PROCEED");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(449, 287, 336, 33);
		frmSendACopy.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("* RIGHT CLICK TO PROCESS");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(457, 342, 392, 33);
		frmSendACopy.getContentPane().add(lblNewLabel_1);

		JTextArea response = new JTextArea();
		response.setBounds(450, 209, 428, 22);
		frmSendACopy.getContentPane().add(response);
		response.setEditable(false);
		Application aap = new Application();
		aap.Applications();

		/*
		 * frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		 * frame.setResizable(false); frame.addWindowListener(getWindowAdapter());
		 */
		frmSendACopy.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					response.setText(Application.output);
				}

				else if (e.getButton() == MouseEvent.BUTTON1) {
					sub f5 = new sub();
					f5.sub();

				} else if (e.getButton() == MouseEvent.BUTTON2) {
					Voice iTalk;
					VoiceManager vm = VoiceManager.getInstance();
					iTalk = vm.getVoice(SayWhat);
					iTalk.allocate();
					try {
						iTalk.speak(" RIGHT CLICK TO WHOM YOU WANT TO SEND MAIL COPY AND PROCESS");
						iTalk.speak(" LEFT CLICK TO PROCEED");

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
			}

			public void windowIconified(WindowEvent we) {
				frmSendACopy.setState(JFrame.NORMAL);

			}
		};
	}
}
