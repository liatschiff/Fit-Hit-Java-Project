package View;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class HomePage extends Observable {

	private static HomePage homePage=null;
	private JFrame frame;
	private JLabel curWeightLabel;
	private JLabel goalWeightlabel;
	private JLabel lblBackground;

	
	private HomePage() {
		initialize();	
	}
	public static HomePage getInstance() {
		if(homePage == null)
			homePage = new HomePage();
		return homePage;
	}

	public JFrame getFrame() {
		return frame;
	}
	public JLabel getCurWeightLabel() {
		return curWeightLabel;
	}
	public JLabel getGoalWeightlabel() {
		return goalWeightlabel;
	}
	


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblFitHit = new JLabel("Fit & Hit");
		lblFitHit.setHorizontalAlignment(SwingConstants.CENTER);
		lblFitHit.setForeground(Color.WHITE);
		lblFitHit.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 99));
		lblFitHit.setBounds(226, 17, 532, 164);
		frame.getContentPane().add(lblFitHit);
		
		JButton btnShowYourMonthly = new JButton("Monthly statistics");
		btnShowYourMonthly.setBackground(Color.BLACK);
		btnShowYourMonthly.setForeground(Color.WHITE);
		btnShowYourMonthly.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnShowYourMonthly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setChanged();
				notifyObservers("Statistics");
				
				MonthlyStatistics ms = MonthlyStatistics.getInstance();
				frame.setVisible(false);
				ms.getFrame().setVisible(true);
			}
		});
		btnShowYourMonthly.setBounds(357, 376, 250, 37);
		frame.getContentPane().add(btnShowYourMonthly);
		
		JButton btnUpdate = new JButton("Update Profile");
		btnUpdate.setBackground(Color.BLACK);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateProfile up = UpdateProfile.getInstance();
				frame.setVisible(false);
				up.getFrame().setVisible(true);
			}
		});
		btnUpdate.setBounds(357, 572, 250, 37);
		frame.getContentPane().add(btnUpdate);
		
		JLabel lblYourWeight = new JLabel("Your weight:");
		lblYourWeight.setForeground(Color.WHITE);
		lblYourWeight.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblYourWeight.setBounds(212, 197, 152, 56);
		frame.getContentPane().add(lblYourWeight);
		
		JLabel lblYourGoal = new JLabel("Your goal:");
		lblYourGoal.setForeground(Color.WHITE);
		lblYourGoal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblYourGoal.setBounds(571, 197, 113, 56);
		frame.getContentPane().add(lblYourGoal);
		
		JButton btnShowMyNutrititon = new JButton("Nutrititon plan");
		btnShowMyNutrititon.setBackground(Color.BLACK);
		btnShowMyNutrititon.setForeground(Color.WHITE);
		btnShowMyNutrititon.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnShowMyNutrititon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MyNutritionPlan np = MyNutritionPlan.getInstance();
				frame.setVisible(false);
				np.getFrame().setVisible(true);
			}
		});
		btnShowMyNutrititon.setBounds(357, 445, 250, 37);
		frame.getContentPane().add(btnShowMyNutrititon);
		
		JButton btnShowMyWorkout = new JButton("Workout plan");
		btnShowMyWorkout.setBackground(Color.BLACK);
		btnShowMyWorkout.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnShowMyWorkout.setForeground(Color.WHITE);
		btnShowMyWorkout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MyWorkoutPlan wp = MyWorkoutPlan.getInstance();
				frame.setVisible(false);
				wp.getFrame().setVisible(true);
			}
		});
		btnShowMyWorkout.setBounds(357, 509, 250, 37);
		frame.getContentPane().add(btnShowMyWorkout);
		
		
		curWeightLabel = new JLabel("weight");
		curWeightLabel.setForeground(Color.WHITE);
		curWeightLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		curWeightLabel.setBounds(357, 206, 95, 40);
		frame.getContentPane().add(curWeightLabel);
		
		goalWeightlabel = new JLabel("weight");
		goalWeightlabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		goalWeightlabel.setForeground(Color.WHITE);
		goalWeightlabel.setBounds(686, 206, 104, 40);
		frame.getContentPane().add(goalWeightlabel);
		
		JButton btnAilyActivitiesInsertion = new JButton("Daily activities insertion");
		btnAilyActivitiesInsertion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DailyActivities da = DailyActivities.getInstance();
				frame.setVisible(false);
				da.getFrame().setVisible(true);
			}
		});
		btnAilyActivitiesInsertion.setForeground(Color.WHITE);
		btnAilyActivitiesInsertion.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAilyActivitiesInsertion.setBackground(Color.BLACK);
		btnAilyActivitiesInsertion.setBounds(357, 312, 250, 37);
		frame.getContentPane().add(btnAilyActivitiesInsertion);
		
		lblBackground = new JLabel("");
		lblBackground.setBackground(Color.BLACK);
		lblBackground.setIcon(new ImageIcon(Registration.class.getResource("/images/photoofpretywoman.jpg")));
		lblBackground.setBounds(-346, -40, 1340, 800);
		frame.getContentPane().add(lblBackground);
		
	
		 
	}
	
	public void setCurWeight(double curWeight) {
		curWeightLabel.setText(Double.toString(curWeight));	
	}
	
	public void setGoalWeight(double goalWeight) {
		goalWeightlabel.setText(Double.toString(goalWeight));	
	}
}

