package View;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class DialogBox extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnOk;
	private JButton btnGoBack;
		
	/**
	 * Create the dialog.
	 */
	public DialogBox() {
		setBackground(Color.BLACK);
		setResizable(false);
		setBounds(100, 70, 619, 260);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Are you sure?");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(15, 42, 309, 21);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Once you press the Finish Button you won't be able to edit this day data again.");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(15, 64, 659, 39);
		contentPanel.add(lblNewLabel_1);
		
		btnOk = new JButton("yes, I'm sure");
		btnOk.setForeground(Color.WHITE);
		btnOk.setBackground(Color.BLACK);
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnOk.setBounds(215, 127, 143, 21);
		contentPanel.add(btnOk);
		
		btnGoBack = new JButton("Go Back");
		btnGoBack.setForeground(Color.WHITE);
		btnGoBack.setBackground(Color.BLACK);
		btnGoBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnGoBack.setBounds(215, 164, 143, 21);
		contentPanel.add(btnGoBack);
	}
	
	public JButton getOkBtn() {
		return btnOk;
	}
	
	public JButton getBackBtn() {
		return btnGoBack;
	}
	
}
