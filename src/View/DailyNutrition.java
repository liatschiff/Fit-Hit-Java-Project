package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Nutrition.Food;

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
import java.awt.Color;

public class DailyNutrition extends Observable{

	private static DailyNutrition dailyNutrition=null;
	private JFrame frame;
	private JTextField textFieldExtraCalories;

	private JCheckBox chckbxBreakfast1;
	private JCheckBox chckbxBreakfast2;
	private JCheckBox chckbxBreakfast3;
	private JCheckBox chckbxLunch1;
	private JCheckBox chckbxLunch2;
	private JCheckBox chckbxLunch3;
	private JCheckBox chckbxDinner1;
	private JCheckBox chckbxDinner2;
	private JCheckBox chckbxDinner3;
	private JCheckBox chckbxSnack;
	private JLabel lblOtherCalCorrect;
	private JLabel lblInsirtionYourDaily;
	private JLabel lblfoodIsFuel;

	public JFrame getFrame() {
		return frame;
	}

	public JCheckBox getChckbxBreakfast1() {
		return chckbxBreakfast1;
	}

	public JTextField getTextFieldExtraCalories() {
		return textFieldExtraCalories;
	}

	public JCheckBox getChckbxBreakfast2() {
		return chckbxBreakfast2;
	}

	public JCheckBox getChckbxBreakfast3() {
		return chckbxBreakfast3;
	}

	public JCheckBox getChckbxLunch1() {
		return chckbxLunch1;
	}

	public JCheckBox getChckbxLunch2() {
		return chckbxLunch2;
	}

	public JCheckBox getChckbxLunch3() {
		return chckbxLunch3;
	}

	public JCheckBox getChckbxDinner1() {
		return chckbxDinner1;
	}

	public JCheckBox getChckbxDinner2() {
		return chckbxDinner2;
	}

	public JCheckBox getChckbxDinner3() {
		return chckbxDinner3;
	}

	public JCheckBox getChckbxSnack() {
		return chckbxSnack;
	}

	private DailyNutrition() {
		initialize();
	}
	public static DailyNutrition getInstance() {
		if(dailyNutrition == null)
			dailyNutrition = new DailyNutrition();
		return dailyNutrition;
	}
	public void clearChoices() {// the method clear all user's choices
		chckbxBreakfast1.setSelected(false);
		chckbxBreakfast2.setSelected(false);
		chckbxBreakfast3.setSelected(false);
		chckbxLunch1.setSelected(false);
		chckbxLunch2.setSelected(false);
		chckbxLunch3.setSelected(false);
		chckbxDinner1.setSelected(false);
		chckbxDinner2.setSelected(false);
		chckbxDinner3.setSelected(false);
		chckbxSnack.setSelected(false);
		textFieldExtraCalories.setText("0");
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
		lblFitHit.setBounds(226, 16, 532, 164);
		frame.getContentPane().add(lblFitHit);

		JButton btnFinish = new JButton("Confirm");
		btnFinish.setForeground(Color.WHITE);
		btnFinish.setBackground(Color.BLACK);
		btnFinish.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int flag=0;

				if(textFieldExtraCalories.getText().isEmpty()) //Check if the field is blank
				{
					textFieldExtraCalories.setText("0");
					flag=0;

				}
				else {
					if(!textFieldExtraCalories.getText().toString().matches("[0-9]+[.][0-9]+|[0-9]+")) {//Check if textFieldExtraCalories input is wrong
						lblOtherCalCorrect.setText("*Can only contain numbers");
						lblOtherCalCorrect.setVisible(true);
						flag=1;
					}
				}
				if(flag==0) {
					lblOtherCalCorrect.setVisible(false);
					ArrayList<String> foodChoices = new ArrayList<String>();
					for (int i = 0; i < 11; i++) {
						foodChoices.add(null);
					}
					if(chckbxBreakfast1.isSelected()) foodChoices.set(0, chckbxBreakfast1.getText());
					if(chckbxBreakfast2.isSelected()) foodChoices.set(1, chckbxBreakfast2.getText());
					if(chckbxBreakfast3.isSelected()) foodChoices.set(2, chckbxBreakfast3.getText());
					if(chckbxLunch1.isSelected()) foodChoices.set(3, chckbxLunch1.getText());
					if(chckbxLunch2.isSelected()) foodChoices.set(4, chckbxLunch2.getText());
					if(chckbxLunch3.isSelected()) foodChoices.set(5, chckbxLunch3.getText());
					if(chckbxDinner1.isSelected()) foodChoices.set(6, chckbxDinner1.getText());
					if(chckbxDinner2.isSelected()) foodChoices.set(7, chckbxDinner2.getText());
					if(chckbxDinner3.isSelected()) foodChoices.set(8, chckbxDinner3.getText());
					if(chckbxSnack.isSelected()) foodChoices.set(9, chckbxSnack.getText());

					foodChoices.set(10, textFieldExtraCalories.getText());

					foodChoices.add("Foods");//flag that indicates that the array represent foods

					setChanged();
					notifyObservers(foodChoices);

					DailyActivities da = DailyActivities.getInstance();
					frame.setVisible(false);
					da.getFrame().setVisible(true);

				}}
		});
		btnFinish.setBounds(451, 607, 115, 29);
		frame.getContentPane().add(btnFinish);

		JLabel lblBreakfast = new JLabel("Breakfast:");
		lblBreakfast.setForeground(Color.WHITE);
		lblBreakfast.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBreakfast.setBounds(43, 349, 94, 34);
		frame.getContentPane().add(lblBreakfast);

		JLabel lblLunch = new JLabel("Lunch:");
		lblLunch.setForeground(Color.WHITE);
		lblLunch.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLunch.setBounds(235, 349, 94, 34);
		frame.getContentPane().add(lblLunch);

		JLabel lblDinner = new JLabel("Dinner:");
		lblDinner.setForeground(Color.WHITE);
		lblDinner.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDinner.setBounds(407, 349, 94, 34);
		frame.getContentPane().add(lblDinner);

		JLabel lblSnack = new JLabel("Snack:");
		lblSnack.setForeground(Color.WHITE);
		lblSnack.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSnack.setBounds(580, 349, 94, 34);
		frame.getContentPane().add(lblSnack);

		chckbxBreakfast1 = new JCheckBox("Food 1");
		chckbxBreakfast1.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxBreakfast1.setForeground(Color.WHITE);
		chckbxBreakfast1.setBounds(43, 381, 186, 29);
		frame.getContentPane().add(chckbxBreakfast1);
		chckbxBreakfast1.setOpaque(false);

		chckbxBreakfast2 = new JCheckBox("Food 2");
		chckbxBreakfast2.setBackground(Color.BLACK);
		chckbxBreakfast2.setForeground(Color.WHITE);
		chckbxBreakfast2.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxBreakfast2.setBounds(43, 430, 186, 29);
		frame.getContentPane().add(chckbxBreakfast2);
		chckbxBreakfast2.setOpaque(false);


		chckbxBreakfast3 = new JCheckBox("Food 3");
		chckbxBreakfast3.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxBreakfast3.setBackground(Color.BLACK);
		chckbxBreakfast3.setForeground(Color.WHITE);
		chckbxBreakfast3.setBounds(43, 480, 186, 29);
		frame.getContentPane().add(chckbxBreakfast3);
		chckbxBreakfast3.setOpaque(false);


		chckbxLunch1 = new JCheckBox("Food 1");
		chckbxLunch1.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxLunch1.setBackground(Color.BLACK);
		chckbxLunch1.setForeground(Color.WHITE);
		chckbxLunch1.setBounds(232, 381, 164, 29);
		frame.getContentPane().add(chckbxLunch1);
		chckbxLunch1.setOpaque(false);

		chckbxLunch2 = new JCheckBox("Food 1");
		chckbxLunch2.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxLunch2.setBackground(Color.BLACK);
		chckbxLunch2.setForeground(Color.WHITE);
		chckbxLunch2.setBounds(232, 430, 164, 29);
		frame.getContentPane().add(chckbxLunch2);
		chckbxLunch2.setOpaque(false);
		
		chckbxLunch3 = new JCheckBox("Food 1");
		chckbxLunch3.setBackground(Color.BLACK);
		chckbxLunch3.setForeground(Color.WHITE);
		chckbxLunch3.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxLunch3.setBounds(232, 480, 164, 29);
		frame.getContentPane().add(chckbxLunch3);
		chckbxLunch3.setOpaque(false);
		
		chckbxDinner1 = new JCheckBox("Food 1");
		chckbxDinner1.setBackground(Color.BLACK);
		chckbxDinner1.setForeground(Color.WHITE);
		chckbxDinner1.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxDinner1.setBounds(403, 381, 164, 29);
		frame.getContentPane().add(chckbxDinner1);
		chckbxDinner1.setOpaque(false);
		
		chckbxDinner2 = new JCheckBox("Food 1");
		chckbxDinner2.setBackground(Color.BLACK);
		chckbxDinner2.setForeground(Color.WHITE);
		chckbxDinner2.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxDinner2.setBounds(403, 430, 164, 29);
		frame.getContentPane().add(chckbxDinner2);
		chckbxDinner2.setOpaque(false);
		
		chckbxDinner3 = new JCheckBox("Food 1");
		chckbxDinner3.setBackground(Color.BLACK);
		chckbxDinner3.setForeground(Color.WHITE);
		chckbxDinner3.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxDinner3.setBounds(403, 480, 164, 29);
		frame.getContentPane().add(chckbxDinner3);
		chckbxDinner3.setOpaque(false);
		
		chckbxSnack = new JCheckBox("Food 1");
		chckbxSnack.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxSnack.setForeground(Color.WHITE);
		chckbxSnack.setBackground(Color.BLACK);
		chckbxSnack.setBounds(578, 381, 164, 29);
		frame.getContentPane().add(chckbxSnack);
		chckbxSnack.setOpaque(false);
		
		textFieldExtraCalories = new JTextField();
		textFieldExtraCalories.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldExtraCalories.setBackground(Color.BLACK);
		textFieldExtraCalories.setForeground(Color.WHITE);
		textFieldExtraCalories.setText("0");
		textFieldExtraCalories.setColumns(10);
		textFieldExtraCalories.setBounds(717, 380, 171, 29);
		frame.getContentPane().add(textFieldExtraCalories);

		JLabel lblOtherenterThe = new JLabel("Other: (enter the calorices)");
		lblOtherenterThe.setForeground(Color.WHITE);
		lblOtherenterThe.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOtherenterThe.setBounds(717, 349, 261, 34);
		frame.getContentPane().add(lblOtherenterThe);

		JButton btnHome = new JButton("Home");
		btnHome.setBackground(Color.BLACK);
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomePage hp = HomePage.getInstance();
				frame.setVisible(false);
				hp.getFrame().setVisible(true);
			}
		});
		btnHome.setBounds(105, 607, 115, 29);
		frame.getContentPane().add(btnHome);

		lblOtherCalCorrect = new JLabel("*Can only contain numbers");
		lblOtherCalCorrect.setForeground(Color.RED);
		lblOtherCalCorrect.setBounds(717, 422, 208, 13);
		lblOtherCalCorrect.setVisible(false);
		frame.getContentPane().add(lblOtherCalCorrect);
		
		lblInsirtionYourDaily = new JLabel("Insirtion your daily nutrition:");
		lblInsirtionYourDaily.setForeground(Color.WHITE);
		lblInsirtionYourDaily.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblInsirtionYourDaily.setBounds(43, 302, 490, 49);
		frame.getContentPane().add(lblInsirtionYourDaily);
		
		lblfoodIsFuel = new JLabel("\"I don't diet, I eat right\"");
		lblfoodIsFuel.setForeground(new Color(0, 255, 255));
		lblfoodIsFuel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblfoodIsFuel.setBounds(352, 141, 393, 57);
		frame.getContentPane().add(lblfoodIsFuel);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBackground(Color.BLACK);
		lblBackground.setIcon(new ImageIcon(Registration.class.getResource("/images/photoofpretywoman.jpg")));
		lblBackground.setBounds(-346, -40, 1340, 800);
		frame.getContentPane().add(lblBackground);
		
		
		
	}

	public void setFoods(ArrayList<Food> foods) {
		//the method gets an array of foods and sets the food's name in the relevant checkbox
		//index: 0-2: breakfast, 3-5: lunch 6-8: dinner, 9: snack

		chckbxBreakfast1.setText(foods.get(0).getName());
		chckbxBreakfast2.setText(foods.get(1).getName());
		chckbxBreakfast3.setText(foods.get(2).getName());

		chckbxLunch1.setText(foods.get(3).getName());
		chckbxLunch2.setText(foods.get(4).getName());
		chckbxLunch3.setText(foods.get(5).getName());

		chckbxDinner1.setText(foods.get(6).getName());
		chckbxDinner2.setText(foods.get(7).getName());
		chckbxDinner3.setText(foods.get(8).getName());

		chckbxSnack.setText(foods.get(9).getName());
		
		
	}
	

}


