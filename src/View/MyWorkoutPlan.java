package View;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class MyWorkoutPlan extends Observable {

	private static MyWorkoutPlan myworkoutPlan = null;
	private JFrame frame;
	private JTable table;
	
	private JLabel mainGoalLabel;
	private JLabel daysPerWeekLabel;
	private JLabel durationLabel;
	private JLabel timePerWorkoutLabel;
	private JLabel AuthorLabel;
	private JLabel caloriesBurnedLabel;
	private JLabel targetLabel;
	
	private MyWorkoutPlan() {
		initialize();
	}
	public static MyWorkoutPlan getInstance() {
		if(myworkoutPlan == null)
			myworkoutPlan = new MyWorkoutPlan();
		return myworkoutPlan;
	}
	public JFrame getFrame() {
		return frame;
	}
	public JTable getTable() {
		return table;
	}
	public JLabel getMainGoalLabel() {
		return mainGoalLabel;
	}
	public JLabel getDaysPerWeekLabel() {
		return daysPerWeekLabel;
	}
	public JLabel getDurationLabel() {
		return durationLabel;
	}
	public JLabel getTimePerWorkoutLabel() {
		return timePerWorkoutLabel;
	}
	public JLabel getAuthorLabel() {
		return AuthorLabel;
	}
	public JLabel getCaloriesBurnedLabel() {
		return caloriesBurnedLabel;
	}
	public JLabel getTargetLabel() {
		return targetLabel;
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
		lblFitHit.setBounds(216, 16, 532, 164);
		frame.getContentPane().add(lblFitHit);
		
		JLabel lblMonthlStatistics = new JLabel("Your workout plan:");
		lblMonthlStatistics.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblMonthlStatistics.setBounds(305, 151, 219, 49);
		lblMonthlStatistics.setForeground(new Color(0, 255, 255));
		frame.getContentPane().add(lblMonthlStatistics);
		        
		targetLabel = new JLabel("target");
		targetLabel.setForeground(new Color(0, 255, 255));
		targetLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		targetLabel.setBounds(526, 151, 365, 49);
		frame.getContentPane().add(targetLabel);
		
		JLabel lblMainGoal = new JLabel("Main goal:");
		lblMainGoal.setForeground(Color.WHITE);
		lblMainGoal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMainGoal.setBounds(80, 339, 100, 34);
		frame.getContentPane().add(lblMainGoal);
		
		JLabel lblDaysPerWeek = new JLabel("Days Per Week:");
		lblDaysPerWeek.setForeground(Color.WHITE);
		lblDaysPerWeek.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDaysPerWeek.setBounds(80, 389, 161, 34);
		frame.getContentPane().add(lblDaysPerWeek);
		
		JLabel lblProgramDuration = new JLabel("Program duration:");
		lblProgramDuration.setForeground(Color.WHITE);
		lblProgramDuration.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProgramDuration.setBounds(80, 439, 191, 34);
		frame.getContentPane().add(lblProgramDuration);
		
		JLabel lblTimePerWorkout = new JLabel("Time per workout:");
		lblTimePerWorkout.setForeground(Color.WHITE);
		lblTimePerWorkout.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTimePerWorkout.setBounds(80, 487, 191, 34);
		frame.getContentPane().add(lblTimePerWorkout);
		
		JLabel lblCalorieBurned = new JLabel("Calories burned:");
		lblCalorieBurned.setForeground(Color.WHITE);
		lblCalorieBurned.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCalorieBurned.setBounds(80, 537, 191, 34);
		frame.getContentPane().add(lblCalorieBurned);
		
		//// labels that contains data
		mainGoalLabel = new JLabel("main goal");
		mainGoalLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		mainGoalLabel.setBounds(261, 340, 191, 34);
		frame.getContentPane().add(mainGoalLabel);
		mainGoalLabel.setForeground(Color.white);
		
		daysPerWeekLabel = new JLabel("daysPerWeek");
		daysPerWeekLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		daysPerWeekLabel.setBounds(261, 390, 174, 34);
		frame.getContentPane().add(daysPerWeekLabel);
		daysPerWeekLabel.setForeground(Color.white);
		
		durationLabel = new JLabel("duration");
		durationLabel.setForeground(Color.WHITE);
		durationLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		durationLabel.setBounds(261, 440, 131, 34);
		frame.getContentPane().add(durationLabel);
		
		timePerWorkoutLabel = new JLabel("time");
		timePerWorkoutLabel.setForeground(Color.WHITE);
		timePerWorkoutLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		timePerWorkoutLabel.setBounds(261, 488, 131, 34);
		frame.getContentPane().add(timePerWorkoutLabel);
		
		AuthorLabel = new JLabel("author");
		AuthorLabel.setForeground(new Color(0, 255, 255));
		AuthorLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		AuthorLabel.setBounds(479, 188, 131, 34);
		frame.getContentPane().add(AuthorLabel);
		
		caloriesBurnedLabel = new JLabel("calorie");
		caloriesBurnedLabel.setForeground(Color.WHITE);
		caloriesBurnedLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		caloriesBurnedLabel.setBounds(261, 538, 131, 34);
		frame.getContentPane().add(caloriesBurnedLabel);
		
		JLabel label = new JLabel("Author:");
		label.setRequestFocusEnabled(false);
		label.setForeground(new Color(0, 255, 255));
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		label.setBounds(393, 187, 81, 34);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("Home");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomePage hp = HomePage.getInstance();
				frame.setVisible(false);
				hp.getFrame().setVisible(true);
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 18));
		button.setBackground(Color.BLACK);
		button.setBounds(390, 676, 115, 29);
		frame.getContentPane().add(button);
	
	}

	public void setFields(String mainGoal,String daysPerWeek, String duration, String timePerWorkout, String Author, String caloriesBurned, String target, String[][] dataExercise) {
		mainGoalLabel.setText(mainGoal);
		daysPerWeekLabel.setText(daysPerWeek);;
		durationLabel.setText(duration);
		timePerWorkoutLabel.setText(timePerWorkout);
		AuthorLabel.setText(Author);
		caloriesBurnedLabel.setText(caloriesBurned);
		targetLabel.setText(target);
		
        String[] columns = new String[] {
        		"Name","Sets","Reps"
        };
        
		table = new JTable(dataExercise,columns);
		table.setBounds(480, 300, 450, 320);
		table.setRowHeight(40);
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		table.enable(false);
		frame.getContentPane().add(table);
		table.setBackground(Color.black);
		table.setForeground(Color.white);
		table.getColumnModel().getColumn(0).setPreferredWidth(230);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		
		table.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBackground(Color.BLACK);
		lblBackground.setIcon(new ImageIcon(Registration.class.getResource("/images/photoofpretywoman.jpg")));
		lblBackground.setBounds(-346, -40, 1340, 800);
		frame.getContentPane().add(lblBackground);
	}
}

