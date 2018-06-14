package B_Mail;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import B_Mail.Frame1;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Success extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public int random = Frame1.randomInt;

	/**
	 * Launch the application.
	 */
	public static void id() {
		try {
			Success dialog = new Success();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Success() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		contentPanel.setLayout(null);
		{
			JLabel lblSuccess = new JLabel("SUCCESS!!!");
			lblSuccess.setBounds(101, 80, 159, 25);
			contentPanel.add(lblSuccess);
		}
		{
			JLabel lblYourUniqueId = new JLabel("YOUR UNIQUE ID IS: " + random);
			lblYourUniqueId.setBounds(123, 175, 201, 44);
			getContentPane().add(lblYourUniqueId);

		}

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						login.unique();

					}
				});

			}

		}
	}
}
