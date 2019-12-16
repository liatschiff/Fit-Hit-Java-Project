package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Nutrition.Food;
import Workout.Exercise;
import Workout.Workout;

//import com.sun.javafx.tk.Toolkit;
//import com.sun.prism.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.MediaTracker;

import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Observable;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class DailyWorkOut extends Observable{

	private static DailyWorkOut dailyWorkOut = null;
	private JFrame frame;
	private JCheckBox chckbxEx1;
	private JCheckBox chckbxEx2;
	private JCheckBox chckbxEx3;
	private JCheckBox chckbxEx4;
	private JCheckBox chckbxEx5;
	private JCheckBox chckbxEx6;
	private JCheckBox chckbxEx7;

	private DailyWorkOut() {
		initialize();
	}
	public static DailyWorkOut getInstance() {
		if(dailyWorkOut == null)
			dailyWorkOut = new DailyWorkOut();
		return dailyWorkOut;
	}
	public JFrame getFrame() {
		return frame;
	}
	
	public JCheckBox getChckbxEx1() {
		return chckbxEx1;
	}
	public JCheckBox getChckbxEx2() {
		return chckbxEx2;
	}
	public JCheckBox getChckbxEx3() {
		return chckbxEx3;
	}
	public JCheckBox getChckbxEx4() {
		return chckbxEx4;
	}
	public JCheckBox getChckbxEx5() {
		return chckbxEx5;
	}
	public JCheckBox getChckbxEx6() {
		return chckbxEx6;
	}
	public JCheckBox getChckbxEx7() {
		return chckbxEx7;
	}
	public void clearChoices() {// the method clear all user's choices
		chckbxEx1.setSelected(false);
		chckbxEx2.setSelected(false);
		chckbxEx3.setSelected(false);
		chckbxEx4.setSelected(false);
		chckbxEx5.setSelected(false);
		chckbxEx6.setSelected(false);
		chckbxEx7.setSelected(false);
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
		
		JButton btnFinish = new JButton("Confirm");
		btnFinish.setBackground(Color.BLACK);
		btnFinish.setForeground(Color.WHITE);
		btnFinish.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> exercises = new ArrayList<String>();
				for (int i = 0; i < 7; i++) {//initiate with null
					exercises.add(null);
				}
				if(chckbxEx1.isSelected()) exercises.set(0, chckbxEx1.getText());
				if(chckbxEx2.isSelected()) exercises.set(1, chckbxEx1.getText());
				if(chckbxEx3.isSelected()) exercises.set(2, chckbxEx1.getText());
				if(chckbxEx4.isSelected()) exercises.set(3, chckbxEx1.getText());
				if(chckbxEx5.isSelected()) exercises.set(4, chckbxEx1.getText());
				if(chckbxEx6.isSelected()) exercises.set(5, chckbxEx1.getText());
				if(chckbxEx7.isSelected()) exercises.set(6, chckbxEx1.getText());
				
				exercises.add("Exercises");//flag that indicates that the array represent Exercises
				
				setChanged();
				notifyObservers(exercises);
						
				DailyActivities da = DailyActivities.getInstance();
				frame.setVisible(false);
				da.getFrame().setVisible(true);
			}
		});
		btnFinish.setBounds(417, 607, 115, 29);
		frame.getContentPane().add(btnFinish);
		
		JLabel lblDailyNutrition = new JLabel("Insirtion your daily workout:");
		lblDailyNutrition.setForeground(Color.WHITE);
		lblDailyNutrition.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblDailyNutrition.setBounds(142, 331, 490, 49);
		frame.getContentPane().add(lblDailyNutrition);
		
		chckbxEx1 = new JCheckBox("exercise 1");
		chckbxEx1.setBackground(Color.BLACK);
		chckbxEx1.setForeground(Color.WHITE);
		chckbxEx1.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxEx1.setBounds(142, 381, 231, 29);
		frame.getContentPane().add(chckbxEx1);
		chckbxEx1.setOpaque(false);
		
		chckbxEx7 = new JCheckBox("exercise");
		chckbxEx7.setBackground(Color.BLACK);
		chckbxEx7.setForeground(Color.WHITE);
		chckbxEx7.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxEx7.setBounds(636, 381, 274, 29);
		frame.getContentPane().add(chckbxEx7);
		chckbxEx7.setOpaque(false);
		
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHome.setBackground(Color.BLACK);
		btnHome.setForeground(Color.WHITE);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage hp = HomePage.getInstance();
				frame.setVisible(false);
				hp.getFrame().setVisible(true);
			}
		});
		btnHome.setBounds(105, 607, 115, 29);
		frame.getContentPane().add(btnHome);
		
		chckbxEx2 = new JCheckBox("exercise 1");
		chckbxEx2.setBackground(Color.BLACK);
		chckbxEx2.setForeground(Color.WHITE);
		chckbxEx2.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxEx2.setBounds(142, 430, 231, 29);
		frame.getContentPane().add(chckbxEx2);
		chckbxEx2.setOpaque(false);
		
		chckbxEx3 = new JCheckBox("exercise 1");
		chckbxEx3.setBackground(Color.BLACK);
		chckbxEx3.setForeground(Color.WHITE);
		chckbxEx3.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxEx3.setBounds(142, 480, 231, 29);
		frame.getContentPane().add(chckbxEx3);
		chckbxEx3.setOpaque(false);
		
		chckbxEx4 = new JCheckBox("exercise 1");
		chckbxEx4.setBackground(Color.BLACK);
		chckbxEx4.setForeground(Color.WHITE);
		chckbxEx4.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxEx4.setBounds(390, 381, 231, 29);
		frame.getContentPane().add(chckbxEx4);
		chckbxEx4.setOpaque(false);
		
		chckbxEx5 = new JCheckBox("exercise 1");
		chckbxEx5.setBackground(Color.BLACK);
		chckbxEx5.setForeground(Color.WHITE);
		chckbxEx5.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxEx5.setBounds(390, 430, 231, 29);
		frame.getContentPane().add(chckbxEx5);
		chckbxEx5.setOpaque(false);
		
		chckbxEx6 = new JCheckBox("exercise 1");
		chckbxEx6.setBackground(Color.BLACK);
		chckbxEx6.setForeground(Color.WHITE);
		chckbxEx6.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxEx6.setBounds(390, 480, 231, 29);
		frame.getContentPane().add(chckbxEx6);
		chckbxEx6.setOpaque(false);
		
		JLabel lblYouAreOne = new JLabel("\"You are one step closer to your goal!\"");
		lblYouAreOne.setForeground(new Color(0, 255, 255));
		lblYouAreOne.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblYouAreOne.setBounds(289, 141, 408, 57);
		frame.getContentPane().add(lblYouAreOne);
	}
	public void setExercises(ArrayList<Exercise> exercises) {
		//the method gets an array of Exercise and sets the exercise's name in the relevant checkbox
				
		chckbxEx1.setText(exercises.get(0).getExName());
		chckbxEx2.setText(exercises.get(1).getExName());
		chckbxEx3.setText(exercises.get(2).getExName());
		chckbxEx4.setText(exercises.get(3).getExName());
		chckbxEx5.setText(exercises.get(4).getExName());
		chckbxEx6.setText(exercises.get(5).getExName());
		chckbxEx7.setText(exercises.get(6).getExName());
	
	
	JLabel lblBackground = new JLabel("");
	lblBackground.setBackground(Color.BLACK);
	lblBackground.setIcon(new ImageIcon(Registration.class.getResource("/images/photoofpretywoman.jpg")));
	lblBackground.setBounds(-346, -40, 1340, 800);
	frame.getContentPane().add(lblBackground);
}
}


