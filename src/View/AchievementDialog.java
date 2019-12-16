package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class AchievementDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public AchievementDialog() {
		/* getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null); */
		
		setBackground(Color.BLACK);
		setResizable(false);
		setBounds(100, 100, 619, 260);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblCongratulationsYouve = new JLabel("Congratulations !");
		lblCongratulationsYouve.setForeground(Color.MAGENTA);
		lblCongratulationsYouve.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblCongratulationsYouve.setBounds(27, 16, 309, 33);
		contentPanel.add(lblCongratulationsYouve);
		
		JLabel lblYouveAchievedYour = new JLabel("You've achieved your goal!");
		lblYouveAchievedYour.setBackground(Color.BLACK);
		lblYouveAchievedYour.setForeground(Color.WHITE);
		lblYouveAchievedYour.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblYouveAchievedYour.setBounds(27, 70, 309, 21);
		contentPanel.add(lblYouveAchievedYour);
		
		JLabel lblMaybeItIs_1 = new JLabel("Maybe it is time to achieve the next target?");
		lblMaybeItIs_1.setForeground(Color.WHITE);
		lblMaybeItIs_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaybeItIs_1.setBounds(27, 89, 659, 39);
		contentPanel.add(lblMaybeItIs_1);
		
		JButton btnYesIWant = new JButton("yes, I want to update");
		btnYesIWant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateProfile up= UpdateProfile.getInstance();
				setVisible(false);
				HomePage hp = HomePage.getInstance();
				hp.getFrame().setVisible(false);
				up.getFrame().setVisible(true);
			}
		});
		btnYesIWant.setForeground(Color.WHITE);
		btnYesIWant.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnYesIWant.setBackground(Color.BLACK);
		btnYesIWant.setBounds(27, 162, 246, 21);
		contentPanel.add(btnYesIWant);
		
		JButton btnNoNextTime = new JButton("No, next time");
		btnNoNextTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNoNextTime.setForeground(Color.WHITE);
		btnNoNextTime.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNoNextTime.setBackground(Color.BLACK);
		btnNoNextTime.setBounds(375, 162, 190, 21);
		contentPanel.add(btnNoNextTime);
	}
}
