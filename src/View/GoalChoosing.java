package View;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GoalChoosing extends Observable{

	private static GoalChoosing goalChoosing=null;
	private JFrame frame;
	private JTextField targetWeightTextField;
	private JButton increaseStrengthBtn;
	private JButton fatLossBtn;
	private JButton weightLossBtn;
	private JButton muscleBuildingBtn;
	private JLabel lblWeightErr;
	private JLabel lblGoalErr;
	private JLabel lblBackground;
	private String chosenGoal;
	
	private GoalChoosing() {
		initialize();
	}
	public static GoalChoosing getInstance() {
		if(goalChoosing == null)
			goalChoosing = new GoalChoosing();
		return goalChoosing;
	}
	public JFrame getFrame() {
		return frame;
	}
	
	public JTextField getTargetWeightTextField() {
		return targetWeightTextField;
	}
	
	public String getChosenGoal() {
		return chosenGoal;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 953, 775);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		
		JButton weightLossBtn = new JButton("");
		weightLossBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				chosenGoal="Weight Loss";
				setChanged();
				notifyObservers("GoalChoosing");
				
				HomePage hp = HomePage.getInstance();
				frame.setVisible(false);
				hp.getFrame().setVisible(true);
			}
		});
		weightLossBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				weightLossBtn.setIcon(new ImageIcon(GoalChoosing.class.getResource("/images/weightlossblack.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				weightLossBtn.setIcon(new ImageIcon(GoalChoosing.class.getResource("/images/weightloss.jpg")));
			}
		});
		weightLossBtn.setIcon(new ImageIcon(GoalChoosing.class.getResource("/images/weightloss.jpg")));
		weightLossBtn.setBounds(703, 295, 215, 320);
		frame.getContentPane().add(weightLossBtn);
		
		JButton muscleBuildingBtn = new JButton("");
		muscleBuildingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				chosenGoal="Muscle Building";
				setChanged();
				notifyObservers("GoalChoosing");
				
				HomePage hp = HomePage.getInstance();
				frame.setVisible(false);
				hp.getFrame().setVisible(true);
			}
		});
		muscleBuildingBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				muscleBuildingBtn.setIcon(new ImageIcon(GoalChoosing.class.getResource("/images/musclebuildingblack.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				muscleBuildingBtn.setIcon(new ImageIcon(GoalChoosing.class.getResource("/images/Muscle Building.jpg")));
			
			}
		});
		
		JLabel lblChooseYourGoal = new JLabel("\"Action is foundational key to all success\"");
		lblChooseYourGoal.setForeground(new Color(0, 255, 255));
		lblChooseYourGoal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblChooseYourGoal.setBounds(245, 139, 459, 57);
		frame.getContentPane().add(lblChooseYourGoal);
		
		muscleBuildingBtn.setIcon(new ImageIcon(GoalChoosing.class.getResource("/images/Muscle Building.jpg")));
		muscleBuildingBtn.setBounds(473, 295, 215, 320);
		frame.getContentPane().add(muscleBuildingBtn);
		
		increaseStrengthBtn = new JButton("");
		increaseStrengthBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				chosenGoal="Increase Strength";
				setChanged();
				notifyObservers("GoalChoosing");
				
				HomePage hp = HomePage.getInstance();
				frame.setVisible(false);
				hp.getFrame().setVisible(true);
			}
		});
		
		JLabel lblPleaseChooseYour = new JLabel("Please choose your goal:");
		lblPleaseChooseYour.setForeground(Color.WHITE);
		lblPleaseChooseYour.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPleaseChooseYour.setBounds(312, 245, 490, 49);
		frame.getContentPane().add(lblPleaseChooseYour);
		
		increaseStrengthBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				increaseStrengthBtn.setIcon(new ImageIcon(GoalChoosing.class.getResource("/images/increasestrengthblack.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				increaseStrengthBtn.setIcon(new ImageIcon(GoalChoosing.class.getResource("/images/increasestrength.jpg")));
			}
		});
		
		increaseStrengthBtn.setIcon(new ImageIcon(GoalChoosing.class.getResource("/images/increasestrength.jpg")));
		increaseStrengthBtn.setBounds(248, 295, 215, 320);
		frame.getContentPane().add(increaseStrengthBtn);
		
		fatLossBtn = new JButton("");
		fatLossBtn.setActionCommand("Fat Loss");
		fatLossBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				chosenGoal="Fat Loss";
				setChanged();
				notifyObservers("GoalChoosing");
				
				HomePage hp = HomePage.getInstance();
				frame.setVisible(false);
				hp.getFrame().setVisible(true);
			}
		});
		fatLossBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				fatLossBtn.setIcon(new ImageIcon(GoalChoosing.class.getResource("/images/fatloss.jpg")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				fatLossBtn.setIcon(new ImageIcon(GoalChoosing.class.getResource("/images/fatlosscolorful.jpg")));
			}
		});
 
		fatLossBtn.setIcon(new ImageIcon(GoalChoosing.class.getResource("/images/fatlosscolorful.jpg")));
		fatLossBtn.setBounds(23, 295, 215, 320);
		frame.getContentPane().add(fatLossBtn);
		
		JLabel label_1 = new JLabel("Fit & Hit");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Comic Sans MS", Font.BOLD, 99));
		label_1.setBounds(252, 52, 499, 99);
		frame.getContentPane().add(label_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.BLACK);
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(85, 661, 89, 23);
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Registration rgs = Registration.getInstance();
				frame.setVisible(false);
				rgs.getFrame().setVisible(true);
			}
			
		});
		frame.getContentPane().add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(GoalChoosing.class.getResource("/images/classic.jpg")));
		label.setBounds(0, -11, 1000, 775);
		frame.getContentPane().add(label); 
	
		

		
	}
}
