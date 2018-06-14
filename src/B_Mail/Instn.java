package B_Mail;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.audio.JavaClipAudioPlayer;

public class Instn {
	private static final String SayWhat = "kevin16";

	private JFrame frmWelcome;
	String abc = RecvTxtEmail.from;

	public static void instn() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Instn window = new Instn();
					window.frmWelcome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Instn() {
		initialize();
	}

	private void initialize() {
		frmWelcome = new JFrame();
		frmWelcome.setTitle("WELCOME!");
		frmWelcome.setResizable(false);
		frmWelcome.setBounds(0, 0, 1380, 900);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcome.getContentPane().setLayout(null);

		JLabel lblLeftClick = new JLabel("* LEFT CLICK TO SEND EMAIL");
		lblLeftClick.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblLeftClick.setBounds(493, 215, 507, 47);
		frmWelcome.getContentPane().add(lblLeftClick);

		JLabel lblrightClickTo = new JLabel("* RIGHT CLICK TO CLOSE APPLICATION ");
		lblrightClickTo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblrightClickTo.setBounds(490, 273, 477, 47);
		frmWelcome.getContentPane().add(lblrightClickTo);

		JLabel lblWelcome = new JLabel("WELCOME!");
		lblWelcome.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblWelcome.setBounds(493, 141, 250, 40);
		frmWelcome.getContentPane().add(lblWelcome);
		/*
		 * frmWelcome.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		 * frmWelcome.setResizable(false);
		 * frmWelcome.addWindowListener(getWindowAdapter());
		 */
		frmWelcome.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {

					System.exit(0);

				}

				else if (e.getButton() == MouseEvent.BUTTON1) {

					To f1 = new To();
					f1.new3();
				}

				else if (e.getButton() == MouseEvent.BUTTON2) {
					Voice iTalk;
					VoiceManager vm = VoiceManager.getInstance();
					iTalk = vm.getVoice(SayWhat);
					iTalk.allocate();
					try {
						iTalk.speak("YOU ARE IN LOGIN MENU");
						iTalk.speak("LEFT CLICK TO SEND EMAIL");
						iTalk.speak("RIGHT CLICK TO CLOSE APPLICATION");

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
				frmWelcome.setState(JFrame.NORMAL);
				// JOptionPane.showMessageDialog(frame, "Cant Minimize");
			}
		};

	}
}
