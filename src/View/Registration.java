package View;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.awt.event.ActionEvent;

public class Registration extends Observable {

	private static Registration registration=null;
	private JFrame frame;
	private JTextField nameTextField;
	private JTextField ageTextField;
	private JTextField weightTextField;
	private JTextField heightTextField;
	private JComboBox genderComboBox;
	private JComboBox veganComboBox;
	private JLabel lblAge;
	private JLabel lblName;
	private JLabel lblWeight;
	private JLabel lblHeight;
	private JLabel lblGender;
	private JLabel lblVegan;
	private JLabel lblNameCorection;
	private JLabel lblAgeCorection;
	private JLabel lblWeightCorection;
	private JLabel lblHeightCorection;
	private JLabel lblBackground;
	private JLabel lblGoalWeight;
	private JTextField goalWeightTextField;
	private JLabel lblGoalWeightCorection;

	private Registration() {
		initialize();
	}
	public static Registration getInstance() {
		if(registration == null)
			registration = new Registration();
		return registration;
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
	
	public JTextField getGoalWeightTextField() {
		return goalWeightTextField;
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

		lblName = new JLabel("Name:"); // index 1
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setBounds(332, 337, 69, 20);
		frame.getContentPane().add(lblName);

		lblAge = new JLabel("Age:"); // index 2
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAge.setForeground(Color.WHITE);
		lblAge.setBounds(332, 413, 69, 20);
		frame.getContentPane().add(lblAge);

		lblWeight = new JLabel("Weight:");// index 3
		lblWeight.setForeground(Color.WHITE);
		lblWeight.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblWeight.setBounds(332, 454, 87, 18);
		frame.getContentPane().add(lblWeight);

		lblGender = new JLabel("Gender:");// index 4
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGender.setBounds(332, 377, 100, 20);
		frame.getContentPane().add(lblGender);

		lblHeight = new JLabel("Height:");// index 5
		lblHeight.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHeight.setForeground(Color.WHITE);
		lblHeight.setBounds(332, 533, 69, 20);
		frame.getContentPane().add(lblHeight);

		nameTextField = new JTextField(); // index 6
		nameTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
		nameTextField.setForeground(new Color(255, 255, 255));
		nameTextField.setBackground(new Color(0, 0, 0));
		nameTextField.setBounds(457, 335, 153, 26);
		frame.getContentPane().add(nameTextField);
		nameTextField.setColumns(10);

		genderComboBox = new JComboBox(); // index 7
		genderComboBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		genderComboBox.setForeground(new Color(255, 255, 255));
		genderComboBox.setBackground(new Color(0, 0, 0));
		genderComboBox.setModel(new DefaultComboBoxModel(new String[] {"Female/Male", "Male", "Female"}));
		genderComboBox.setBounds(457, 375, 153, 26);
		frame.getContentPane().add(genderComboBox);

		JButton btnSi = new JButton("Next"); // index 8
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
					if(!nameTextField.getText().matches("^[a-zA-Z\\s]*$")){//Checking if the input is wrong. another optional regex for name like ben-ari is "^[\\p{L} .'-]+$"
						lblNameCorection.setVisible(true);
						lblName.setForeground(Color.red);
						flag=1; 
					}

					else {
						lblName.setForeground(Color.white);
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
				if(goalWeightTextField.getText().isEmpty()){//Checking if the field is blank
					lblGoalWeight.setForeground(Color.red);
					lblGoalWeightCorection.setVisible(false);
					flag=1;
				} else { 
					if(!goalWeightTextField.getText().matches("[0-9]+[.][0-9]+|[0-9]+")) {//Checking if the input is wrong
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
					notifyObservers("Registration");
					GoalChoosing gc = GoalChoosing.getInstance();
					frame.setVisible(false);
					gc.getFrame().setVisible(true);
				}


			}
		});
		btnSi.setBounds(457, 653, 115, 29);
		frame.getContentPane().add(btnSi);

		JLabel lblNewLabel = new JLabel("\"Join Us And Change Your Life!\"");// index 9
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel.setBounds(321, 148, 490, 49);
		frame.getContentPane().add(lblNewLabel);

		lblVegan = new JLabel("Vegan:");// index 10
		lblVegan.setForeground(Color.WHITE);
		lblVegan.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblVegan.setBounds(332, 569, 69, 20);
		frame.getContentPane().add(lblVegan);

		veganComboBox = new JComboBox();
		veganComboBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		veganComboBox.setBackground(new Color(0, 0, 0));
		veganComboBox.setForeground(new Color(255, 255, 255));
		veganComboBox.setModel(new DefaultComboBoxModel(new String[] {"Yes/No", "Yes", "No"}));// index 0
		veganComboBox.setBounds(457, 567, 153, 26);
		frame.getContentPane().add(veganComboBox);

		ageTextField = new JTextField();// index 11
		ageTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
		ageTextField.setBackground(new Color(0, 0, 0));
		ageTextField.setForeground(new Color(255, 255, 255));
		ageTextField.setColumns(10);
		ageTextField.setBounds(457, 411, 153, 26);
		frame.getContentPane().add(ageTextField);

		weightTextField = new JTextField();// index 12
		weightTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
		weightTextField.setBackground(new Color(0, 0, 0));
		weightTextField.setForeground(new Color(255, 255, 255));
		weightTextField.setColumns(10);
		weightTextField.setBounds(457, 451, 153, 26);
		frame.getContentPane().add(weightTextField);

		heightTextField = new JTextField();// index 13
		heightTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
		heightTextField.setForeground(new Color(255, 255, 255));
		heightTextField.setBackground(new Color(0, 0, 0));
		heightTextField.setColumns(10);
		heightTextField.setBounds(457, 531, 153, 26);
		frame.getContentPane().add(heightTextField);

		lblNameCorection = new JLabel("*Name should only contain characters");
		lblNameCorection.setBounds(635, 338, 306, 20);
		lblNameCorection.setVisible(false);
		lblNameCorection.setForeground(Color.red);
		frame.getContentPane().add(lblNameCorection);


		lblAgeCorection = new JLabel("*Age should only contain numbers");
		lblAgeCorection.setBounds(635, 414, 248, 20);
		lblAgeCorection.setVisible(false);
		lblAgeCorection.setForeground(Color.red);
		frame.getContentPane().add(lblAgeCorection);


		lblWeightCorection = new JLabel("*Weight should only contain numbers");
		lblWeightCorection.setBounds(635, 454, 277, 20);
		lblWeightCorection.setVisible(false);
		lblWeightCorection.setForeground(Color.red);
		frame.getContentPane().add(lblWeightCorection);
		
		lblGoalWeightCorection = new JLabel("*Weight should only contain numbers");
		lblGoalWeightCorection.setBounds(635, 490, 277, 20);
		lblGoalWeightCorection.setVisible(false);
		lblGoalWeightCorection.setForeground(Color.red);
		frame.getContentPane().add(lblGoalWeightCorection);

		lblHeightCorection = new JLabel("*Height should only contain numbers");
		lblHeightCorection.setBounds(635, 534, 277, 20);
		lblHeightCorection.setVisible(false);
		lblHeightCorection.setForeground(Color.red);
		frame.getContentPane().add(lblHeightCorection);
		
		
		lblGoalWeight = new JLabel("Goal weight:");
		lblGoalWeight.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGoalWeight.setForeground(Color.WHITE);
		lblGoalWeight.setBounds(332, 492, 115, 20);
		frame.getContentPane().add(lblGoalWeight);
		
		goalWeightTextField = new JTextField();
		goalWeightTextField.setForeground(Color.WHITE);
		goalWeightTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
		goalWeightTextField.setColumns(10);
		goalWeightTextField.setBackground(Color.BLACK);
		goalWeightTextField.setBounds(457, 490, 153, 26);
		frame.getContentPane().add(goalWeightTextField);
		
		lblBackground = new JLabel("");
		lblBackground.setBackground(Color.BLACK);
		lblBackground.setIcon(new ImageIcon(Registration.class.getResource("/images/photoofpretywoman.jpg")));
		lblBackground.setBounds(-346, -40, 1340, 800);
		frame.getContentPane().add(lblBackground);
		
	}
}

