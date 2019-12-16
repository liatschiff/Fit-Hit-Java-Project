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
import java.awt.Dimension;

public class MyNutritionPlan extends Observable {

	private static MyNutritionPlan myNutritionPlan = null;
	private JFrame frame;
	private JTable table;
	private JTable tableBreakfast;
	private JTable tableLunch;
	private JTable tableDinner;
	private JTable tableSnack;
	private JLabel authorLabel;
	private JLabel caloriesLabel;
	private JLabel goalLabel;
	private JTable table_1;

	private MyNutritionPlan() {
		initialize();
	}
	public static MyNutritionPlan getInstance() {
		if(myNutritionPlan == null)
			myNutritionPlan = new MyNutritionPlan();
		return myNutritionPlan;
	}
	public JFrame getFrame() {
		return frame;
	}

	public JLabel getAuthorLabel() {
		return authorLabel;
	}

	public JLabel getCaloriesLabel() {
		return caloriesLabel;
	}

	public static MyNutritionPlan getMyNutritionPlan() {
		return myNutritionPlan;
	}
	public JTable getTable() {
		return table;
	}
	public JTable getTableBreakfast() {
		return tableBreakfast;
	}
	public JTable getTableLunch() {
		return tableLunch;
	}
	public JTable getTableDinner() {
		return tableDinner;
	}
	public JTable getTableSnack() {
		return tableSnack;
	}

	public JLabel getGoalLabel() {
		return goalLabel;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JLabel lblFitHit = new JLabel("Fit & Hit");
		lblFitHit.setHorizontalAlignment(SwingConstants.CENTER);
		lblFitHit.setForeground(Color.WHITE);
		lblFitHit.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 99));
		lblFitHit.setBounds(223, 16, 532, 164);
		frame.getContentPane().add(lblFitHit);

		JLabel lblMonthlStatistics = new JLabel("My Nutrition Plan:");
		lblMonthlStatistics.setForeground(new Color(0, 255, 255));
		lblMonthlStatistics.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblMonthlStatistics.setBounds(322, 152, 219, 49);
		frame.getContentPane().add(lblMonthlStatistics);

		JButton btnHome = new JButton("Home");
		btnHome.setBackground(Color.BLACK);
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHome.setForeground(Color.WHITE);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage hp = HomePage.getInstance();
				frame.setVisible(false);
				hp.getFrame().setVisible(true);
			}
		});
		btnHome.setBounds(428, 686, 89, 23);
		frame.getContentPane().add(btnHome);

		JLabel label = new JLabel("Breakfast:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(61, 282, 100, 34);
		frame.getContentPane().add(label);

		JLabel lblLunch = new JLabel("Lunch:");
		lblLunch.setForeground(Color.WHITE);
		lblLunch.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLunch.setBounds(61, 478, 94, 34);
		frame.getContentPane().add(lblLunch);

		JLabel lblDinner = new JLabel("Dinner:");
		lblDinner.setForeground(Color.WHITE);
		lblDinner.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDinner.setBounds(509, 282, 94, 34);
		frame.getContentPane().add(lblDinner);

		JLabel lblSnack = new JLabel("Snack:");
		lblSnack.setForeground(Color.WHITE);
		lblSnack.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSnack.setRequestFocusEnabled(false);
		lblSnack.setBounds(509, 478, 94, 34);
		frame.getContentPane().add(lblSnack);



		JLabel lblTotalCalories = new JLabel("Total calories:");
		lblTotalCalories.setForeground(Color.WHITE);
		lblTotalCalories.setRequestFocusEnabled(false);
		lblTotalCalories.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTotalCalories.setBounds(509, 602, 131, 34);
		frame.getContentPane().add(lblTotalCalories);

		goalLabel = new JLabel("New label");
		goalLabel.setForeground(new Color(0, 255, 255));
		goalLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		goalLabel.setBounds(516, 159, 318, 34);
		frame.getContentPane().add(goalLabel);

		caloriesLabel = new JLabel("calories");
		caloriesLabel.setForeground(Color.WHITE);
		caloriesLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		caloriesLabel.setBounds(656, 602, 131, 34);
		frame.getContentPane().add(caloriesLabel);

		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setForeground(new Color(0, 255, 255));
		lblAuthor.setRequestFocusEnabled(false);
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblAuthor.setBounds(409, 195, 81, 34);
		frame.getContentPane().add(lblAuthor);

		authorLabel = new JLabel("author");
		authorLabel.setForeground(new Color(0, 255, 255));
		authorLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		authorLabel.setBounds(482, 195, 145, 34);
		frame.getContentPane().add(authorLabel);
		
	}

	public void setFields(String mainGoal,String author, String calories, String[][] dataBreakfast,String[][] dataLunch,String[][] dataDinner,String[][] dataSnack) {
		authorLabel.setText(author);
		caloriesLabel.setText(calories);
		goalLabel.setText(mainGoal);

		String[] columns = new String[] {
				"Name", "Calories", "Serving Size", "Quantity"
		};
		
		tableBreakfast = new JTable(dataBreakfast,columns);
		tableBreakfast.setFont(new Font("Tahona",Font.BOLD,14));
		tableBreakfast.setForeground(Color.white);
		tableBreakfast.setEnabled(false);
		tableBreakfast.setBounds(61, 311, 400, 120);
		tableBreakfast.setRowHeight(30);
		tableBreakfast.setFont(new Font("Tahoma", Font.BOLD, 13));
		tableBreakfast.setBackground(Color.black);
		tableBreakfast.getColumnModel().getColumn(0).setPreferredWidth(120);
	

		frame.getContentPane().add(tableBreakfast);

		tableLunch = new JTable(dataLunch,columns);
		tableLunch.setEnabled(false);
		tableLunch.setBounds(61, 509, 400, 120);
		tableLunch.setRowHeight(30);
		tableLunch.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(tableLunch);
		tableLunch.getColumnModel().getColumn(0).setPreferredWidth(120);
		tableLunch.setBackground(Color.black);
		tableLunch.setForeground(Color.white);

		tableDinner = new JTable(dataDinner,columns);
		tableDinner.setEnabled(false);
		tableDinner.setBounds(509, 311, 400, 120);
		tableDinner.setFont(new Font("Tahoma", Font.BOLD, 13));
		tableDinner.setRowHeight(30);
		frame.getContentPane().add(tableDinner);
		tableDinner.getColumnModel().getColumn(0).setPreferredWidth(120);
		tableDinner.setBackground(Color.black);
		tableDinner.setForeground(Color.white);

		tableSnack = new JTable(dataSnack,columns);
		tableSnack.setEnabled(false);
		tableSnack.setPreferredScrollableViewportSize(new Dimension(555, 400));
		tableSnack.setFont(new Font("Tahoma", Font.BOLD, 13));
		tableSnack.setBounds(509, 509, 400, 60);
		tableSnack.setRowHeight(30);
		frame.getContentPane().add(tableSnack);	
		tableSnack.getColumnModel().getColumn(0).setPreferredWidth(120);
		tableSnack.setBackground(Color.black);
		tableSnack.setForeground(Color.white);

		JLabel lblBackground = new JLabel("");
		lblBackground.setBackground(Color.BLACK);
		lblBackground.setIcon(new ImageIcon(Registration.class.getResource("/images/photoofpretywoman.jpg")));
		lblBackground.setBounds(-346, -40, 1340, 800);
		frame.getContentPane().add(lblBackground);

	}
}

