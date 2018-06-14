package B_Mail;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import javax.swing.JTextArea;

public class To {
	private static final String SayWhat = "kevin16";
	private JFrame frmWhomYouWant;
	static String to;

	/**
	 * Launch the application.
	 */
	public static void new3() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					To window = new To();
					window.frmWhomYouWant.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public To() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWhomYouWant = new JFrame();
		frmWhomYouWant.setTitle("WHOM YOU WANT TO SEND?");
		frmWhomYouWant.setBounds(0, 0, 1380, 900);
		frmWhomYouWant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWhomYouWant.getContentPane().setLayout(null);

		JLabel lblTo = new JLabel("TO:");
		lblTo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTo.setBounds(459, 113, 46, 19);
		frmWhomYouWant.getContentPane().add(lblTo);

		JLabel lblNewLabel = new JLabel(" * LEFT CLICK TO PROCEED");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(519, 223, 265, 33);
		frmWhomYouWant.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("* SPEAK TO WHOM YOU WANT TO SEND E-MAIL AND RIGHT CLICK TO PROCESS");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(519, 272, 749, 33);
		frmWhomYouWant.getContentPane().add(lblNewLabel_1);

		JTextArea response = new JTextArea();
		response.setBounds(515, 113, 238, 21);
		frmWhomYouWant.getContentPane().add(response);
		response.setEditable(false);
		Application aap = new Application();
		aap.Applications();
		// System.out.println("HI!" + Application.output);

		frmWhomYouWant.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					response.setText(Application.output);
					// System.exit(0);
				}

				else if (e.getButton() == MouseEvent.BUTTON1) {
					to = Application.output.toLowerCase();
					to = to.replaceAll("\\s+", "");

					CC f4 = new CC();
					f4.new4();

				} else if (e.getButton() == MouseEvent.BUTTON2) {
					Voice iTalk;
					VoiceManager vm = VoiceManager.getInstance();
					iTalk = vm.getVoice(SayWhat);
					iTalk.allocate();
					try {

						iTalk.speak("SPEAK TO WHOM YOU WANT TO SEND E-MAIL AND RIGHT CLICK TO PROCESS");
						iTalk.speak("LEFT CLICK TO PROCEED");

					} catch (Exception ex) {
						System.out.println(" ");

					}

				}
			}
		});

	}

}
