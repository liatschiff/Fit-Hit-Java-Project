package View;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class UpdateProfile extends Observable {

	private static UpdateProfile update = null;
	private JFrame frame;
	private JTextField nameTextField;
	private JTextField ageTextField;
	private JTextField weightTextField;
	private JTextField goalWeighTextField;
	private JLabel lblGoalWeight;
	private JTextField heightTextField;
	private JComboBox genderComboBox;
	private JComboBox veganComboBox;
	private JLabel lblHeightCorection;
	private JLabel lblWeightCorection;
	private JLabel lblAgeCorection;
	private JLabel lblNameCorection;
	private JLabel lblVegan;
	private JLabel lblBackground;
	private JComboBox goalComboBox;
	
	private JLabel lblGoal;
	private JLabel lblGoalWeightCorection;
	

	private UpdateProfile() {
		initialize();
	}
	public static UpdateProfile getInstance() {
		if(update == null)
			update = new UpdateProfile();
		return update;
	}

	public JFrame getFrame() {
		return frame;
	}

	public JTextField getNameTextField() {
		return nameTextField;
	}
	public JTextField getAgeTextField() {
		return ageTextField;
	}
	public JTextField getWeightTextField() {
		return weightTextField;
	}
	
	public JTextField getGoalWeighTextField() {
		return goalWeighTextField;
	}
	public JTextField getHeightTextField() {
		return heightTextField;
	}
	public JComboBox getGenderComboBox() {
		return genderComboBox;
	}
	public JComboBox getVeganComboBox() {
		return veganComboBox;
	}
	
		
	public JComboBox getGoalComboBox() {
		return goalComboBox;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(-24, -37, 1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JLabel lblFitHit = new JLabel("Fit & Hit");
		lblFitHit.setHorizontalAlignment(SwingConstants.CENTER);
		lblFitHit.setForeground(Color.WHITE);
		lblFitHit.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 99));
		lblFitHit.setBounds(226, 17, 532, 164);
		frame.getContentPane().add(lblFitHit);

		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setBounds(299, 291, 69, 20);
		frame.getContentPane().add(lblName);

		JLabel lblAge = new JLabel("Age:");
		lblAge.setForeground(Color.WHITE);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAge.setBounds(299, 363, 69, 20);
		frame.getContentPane().add(lblAge);

		JLabel lblWeight = new JLabel("Current weight:");
		lblWeight.setForeground(Color.WHITE);
		lblWeight.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblWeight.setBounds(299, 401, 165, 20);
		frame.getContentPane().add(lblWeight);

		JLabel lblGender = new JLabel("Gender:");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGender.setBounds(299, 327, 91, 20);
		frame.getContentPane().add(lblGender);

		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setForeground(Color.WHITE);
		lblHeight.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHeight.setBounds(299, 486, 69, 20);
		frame.getContentPane().add(lblHeight);

		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
		nameTextField.setForeground(Color.WHITE);
		nameTextField.setBackground(Color.BLACK);
		nameTextField.setBounds(448, 289, 189, 26);
		frame.getContentPane().add(nameTextField);
		nameTextField.setColumns(10);

		genderComboBox = new JComboBox();
		genderComboBox.setBackground(Color.BLACK);
		genderComboBox.setForeground(Color.WHITE);
		genderComboBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		genderComboBox.setModel(new DefaultComboBoxModel(new String[] {"Female/Male", "Male", "Female"}));
		genderComboBox.setBounds(448, 325, 189, 26);
		frame.getContentPane().add(genderComboBox);

		lblVegan = new JLabel("Vegan:");
		lblVegan.setForeground(Color.WHITE);
		lblVegan.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblVegan.setBounds(299, 564, 69, 20);
		frame.getContentPane().add(lblVegan);

		veganComboBox = new JComboBox();
		veganComboBox.setForeground(Color.WHITE);
		veganComboBox.setBackground(Color.BLACK);
		veganComboBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		veganComboBox.setModel(new DefaultComboBoxModel(new String[] {"Yes/No", "Yes", "No"}));
		veganComboBox.setBounds(448, 562, 189, 26);
		frame.getContentPane().add(veganComboBox);

		ageTextField = new JTextField();
		ageTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
		ageTextField.setForeground(Color.WHITE);
		ageTextField.setBackground(Color.BLACK);
		ageTextField.setColumns(10);
		ageTextField.setBounds(448, 363, 189, 26);
		frame.getContentPane().add(ageTextField);

		weightTextField = new JTextField();
		weightTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
		weightTextField.setForeground(Color.WHITE);
		weightTextField.setBackground(Color.BLACK);
		weightTextField.setColumns(10);
		weightTextField.setBounds(448, 399, 189, 26);
		frame.getContentPane().add(weightTextField);

		heightTextField = new JTextField();
		heightTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
		heightTextField.setForeground(Color.WHITE);
		heightTextField.setBackground(Color.BLACK);
		heightTextField.setColumns(10);
		heightTextField.setBounds(448, 484, 189, 26);
		frame.getContentPane().add(heightTextField);
		
		lblNameCorection = new JLabel("*Name should only contain characters");
		lblNameCorection.setForeground(Color.RED);
		lblNameCorection.setBounds(652, 296, 285, 13);
		lblNameCorection.setVisible(false);
		frame.getContentPane().add(lblNameCorection);

		lblAgeCorection = new JLabel("*Age should only contain numbers");
		lblAgeCorection.setForeground(Color.RED);
		lblAgeCorection.setBounds(652, 370, 285, 13);
		lblAgeCorection.setVisible(false);
		frame.getContentPane().add(lblAgeCorection);

		lblWeightCorection = new JLabel("*weight should only contain numbers");
		lblWeightCorection.setForeground(Color.RED);
		lblWeightCorection.setBounds(652, 406, 285, 13);
		lblWeightCorection.setVisible(false);
		frame.getContentPane().add(lblWeightCorection);
		
		lblGoalWeightCorection = new JLabel("*weight should only contain numbers");
		lblGoalWeightCorection.setForeground(Color.RED);
		lblGoalWeightCorection.setBounds(660, 445, 277, 20);
		lblGoalWeightCorection.setVisible(false);
		frame.getContentPane().add(lblGoalWeightCorection);

		lblHeightCorection = new JLabel("*Height should only contain numbers");
		lblHeightCorection.setForeground(Color.RED);
		lblHeightCorection.setBounds(652, 491, 294, 13);
		lblHeightCorection.setVisible(false);
		frame.getContentPane().add(lblHeightCorection);
		
		JLabel lblUpdateYourProfile = new JLabel("Update your profile");
		lblUpdateYourProfile.setForeground(new Color(0, 255, 255));
		lblUpdateYourProfile.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblUpdateYourProfile.setBounds(377, 144, 258, 56);
		frame.getContentPane().add(lblUpdateYourProfile);
		
		lblGoal = new JLabel("Goal:");
		lblGoal.setForeground(Color.WHITE);
		lblGoal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGoal.setBounds(299, 528, 69, 20);
		frame.getContentPane().add(lblGoal);
		
		goalComboBox = new JComboBox();
		goalComboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Increase Strength", "Fat Loss", "Weight Loss", "Muscle Building"}));
		goalComboBox.setForeground(Color.WHITE);
		goalComboBox.setBackground(Color.BLACK);
		goalComboBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		goalComboBox.setBounds(448, 520, 189, 26);
		frame.getContentPane().add(goalComboBox);
		
		goalWeighTextField = new JTextField();
		goalWeighTextField.setForeground(Color.WHITE);
		goalWeighTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
		goalWeighTextField.setColumns(10);
		goalWeighTextField.setBackground(Color.BLACK);
		goalWeighTextField.setBounds(448, 442, 189, 26);
		frame.getContentPane().add(goalWeighTextField);
		
		JLabel lblGoalWeight = new JLabel("Goal weight:");
		lblGoalWeight.setForeground(Color.WHITE);
		lblGoalWeight.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGoalWeight.setBounds(299, 443, 165, 20);
		frame.getContentPane().add(lblGoalWeight);
		
		JButton btnSi = new JButton("Save Changes");
		btnSi.setBackground(Color.BLACK);
		btnSi.setForeground(Color.WHITE);
		btnSi.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int flag=0;

				if(nameTextField.getText().isEmpty())//Checking if the field is blank
				{
					lblName.setForeground(Color.red);
					lblNameCorection.setVisible(false);
					flag=1;
				} else { 
					if(!nameTextField.getText().matches("^[a-zA-Z\\s]*$")){//Checking if the input is wrong
						lblNameCorection.setVisible(true);
						lblName.setForeground(Color.red);
						flag=1; 
					}

					else {lblName.setForeground(Color.white);
					lblNameCorection.setVisible(false);}
				}

				if(ageTextField.getText().isEmpty()){//Checking if the field is blank
					lblAge.setForeground(Color.red);
					lblAgeCorection.setVisible(false);
					flag=1;
				} else { 
					if(!ageTextField.getText().matches("[0-9]+")) {//Checking if the input is wrong
						lblAgeCorection.setVisible(true);
						lblAge.setForeground(Color.red);
						flag=1; 
					}
					else {
						lblAge.setForeground(Color.white);
						lblAgeCorection.setVisible(false);
					}
				}

				if(weightTextField.getText().isEmpty()){//Checking if the field is blank
					lblWeight.setForeground(Color.red);
					lblWeightCorection.setVisible(false);
					flag=1;
				} else { 
					if(!weightTextField.getText().matches("[0-9]+[.][0-9]+|[0-9]+")) {//Checking if the input is wrong
						lblWeightCorection.setVisible(true);
						lblWeight.setForeground(Color.red);
						flag=1; 
					}
					else {
						lblWeight.setForeground(Color.white);
						lblWeightCorection.setVisible(false);
					}
				}
				
				if(goalWeighTextField.getText().isEmpty()){//Checking if the field is blank
					lblGoalWeight.setForeground(Color.red);
					lblGoalWeightCorection.setVisible(false);
					flag=1;
				} else { 
					if(!goalWeighTextField.getText().matches("[0-9]+[.][0-9]+|[0-9]+")) {//Checking if the input is wrong
						lblGoalWeightCorection.setVisible(true);
						lblGoalWeight.setForeground(Color.red);
						flag=1; 
					}
					else {
						lblGoalWeight.setForeground(Color.white);
						lblGoalWeightCorection.setVisible(false);
					}
				}


				if(heightTextField.getText().isEmpty()){//Checking if the field is blank
					lblHeight.setForeground(Color.red);
					lblHeightCorection.setVisible(false);
					flag=1;
				} else { 
					if(!heightTextField.getText().matches("[0-9]+[.][0-9]+|[0-9]+")) {//Checking if the input is wrong
						lblHeightCorection.setVisible(true);
						lblHeight.setForeground(Color.red);
						flag=1; 
					}
					else {
						lblHeight.setForeground(Color.white);
						lblHeightCorection.setVisible(false);
					}
				}

				if(veganComboBox.getSelectedIndex()==0)	{//Checking if the user chose one of the veganComboBox options
					lblVegan.setForeground(Color.red);
					flag=1;
				} else lblVegan.setForeground(Color.white);

				if(genderComboBox.getSelectedIndex()==0) {//Checking if the user chose one of the genderComboBox options
					lblGender.setForeground(Color.red);
					flag=1;
				} else lblGender.setForeground(Color.white);

				if(flag==0) {
					setChanged();
					notifyObservers("UpdateProfile");
					HomePage hp = HomePage.getInstance();
					frame.setVisible(false);
					hp.getFrame().setVisible(true);
					
					if(Double.parseDouble(weightTextField.getText())==Double.parseDouble(goalWeighTextField.getText())) {
						AchievementDialog reachedDialog=new AchievementDialog();
						reachedDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						reachedDialog.setVisible(true);
					}
				}


			}
		});
		btnSi.setBounds(390, 653, 165, 29);
		frame.getContentPane().add(btnSi);

		
		JButton button = new JButton("Home");
		button.setBackground(Color.BLACK);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 18));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//In case that the user input was wrong and he decided not to save the changes we need to change the color back to black
				lblName.setForeground(Color.white);  
				lblGender.setForeground(Color.white);
				lblAge.setForeground(Color.white);
				lblWeight.setForeground(Color.white);
				lblHeight.setForeground(Color.white);
				lblVegan.setForeground(Color.white);
				lblNameCorection.setVisible(false);
				lblAgeCorection.setVisible(false);
				lblWeightCorection.setVisible(false);
				lblHeightCorection.setVisible(false);
				
				HomePage hp = HomePage.getInstance();
				frame.setVisible(false);
				hp.getFrame().setVisible(true);
			}
		});
		button.setBounds(103, 654, 98, 26);
		frame.getContentPane().add(button);

				

		

	}

	public void setUserCurDetails(String name, String gender, int age, double weight,double goalWeight, double height, boolean isVegan, String goal) {
		nameTextField.setText(name);
		ageTextField.setText(Integer.toString(age));
		weightTextField.setText(Double.toString(weight));
		heightTextField.setText(Double.toString(height));
		genderComboBox.setSelectedItem(gender);
		goalWeighTextField.setText(Double.toString(goalWeight));
		if (isVegan) veganComboBox.setSelectedItem("Yes");
		else veganComboBox.setSelectedItem("No");
		
		goalComboBox.setSelectedItem(goal);
		/*if(increaseStrengthRadioBtn.getActionCommand().equals(goal)) increaseStrengthRadioBtn.setSelected(true);
		if(fatLossRadioBtn.getActionCommand().equals(goal)) fatLossRadioBtn.setSelected(true);
		if(weightLossRadioBtn.getActionCommand().equals(goal)) weightLossRadioBtn.setSelected(true);
		if(muscleBuildingRadioBtn.getActionCommand().equals(goal)) muscleBuildingRadioBtn.setSelected(true);
		*/
		
		lblBackground = new JLabel("");
		lblBackground.setBackground(Color.BLACK);
		lblBackground.setIcon(new ImageIcon(Registration.class.getResource("/images/photoofpretywoman.jpg")));
		lblBackground.setBounds(-346, -40, 1340, 800);
		frame.getContentPane().add(lblBackground);

				
	}
}

