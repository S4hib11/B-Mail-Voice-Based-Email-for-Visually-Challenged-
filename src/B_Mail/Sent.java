package B_Mail;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sent extends JFrame {
	private static final String SayWhat = "kevin16";
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void s() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sent frame = new Sent();
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
	public Sent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1380, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEmailSentSuccessfully = new JLabel("EMAIL SENT SUCCESSFULLY!!");
		lblEmailSentSuccessfully.setBounds(412, 160, 478, 109);
		lblEmailSentSuccessfully.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(lblEmailSentSuccessfully);

		JLabel lblNewLabel = new JLabel("* LEFT CLICK TO SEND ANOTHER EMAIL");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(426, 322, 408, 38);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("* RIGHT CLICK TO LOGOUT");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(426, 389, 363, 38);
		contentPane.add(lblNewLabel_1);

		contentPane.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					System.exit(0);
				}

				else if (e.getButton() == MouseEvent.BUTTON1) {

					To ob = new To();
					ob.new3();
				} else if (e.getButton() == MouseEvent.BUTTON2) {
					Voice iTalk;
					VoiceManager vm = VoiceManager.getInstance();
					iTalk = vm.getVoice(SayWhat);
					iTalk.allocate();
					try {
						iTalk.speak("E MAIL SENT SUCCESSFULLY!!");
						iTalk.speak("LEFT CLICK TO SEND ANOTHER E MAIL");
						iTalk.speak("RIGHT CLICK TO LOG OUT");

					} catch (Exception ex) {
						System.out.println(" ");

					}

				}
			}
		});

	}

}
