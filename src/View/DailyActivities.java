package View;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Project.DailyCalBalance;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class DailyActivities extends Observable{

	private static DailyActivities dailyActivities;
	private JFrame frame;
	private DailyCalBalance dailyCalBalance;
	private JTextField weightUpdateTextField;
	private JLabel lblWeightFieldErr;
	private JLabel lblUpdateWeight;
	private double currWeight;
	private double goalWeight;

	private DailyActivities() {
		initialize();
		dailyCalBalance = new DailyCalBalance();
	}

	public static DailyActivities getDailyActivities() {
		return dailyActivities;
	}

	public JFrame getFrame() {
		return frame;
	}

	public DailyCalBalance getDailyCalBalance() {
		return dailyCalBalance;
	}
	public double getWeight() {
		return currWeight;
	}
	public void setWeight(double weight,double goal) {
		currWeight=weight;
		goalWeight=goal;
		weightUpdateTextField.setText(currWeight+"");
	}
	public static DailyActivities getInstance() {
		if(dailyActivities == null)
			dailyActivities = new DailyActivities();
		return dailyActivities;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setForeground(new Color(0, 0, 0));
		frame.setBackground(new Color(0, 0, 0));
		frame.setResizable(false);
		frame.setBounds(100, 100, 1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JButton btnNewButton = new JButton("Daily Nutrition");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DailyNutrition dn = DailyNutrition.getInstance();
				frame.setVisible(false);
				dn.getFrame().setVisible(true);
			}
		});
		btnNewButton.setBounds(179, 316, 179, 66);
		frame.getContentPane().add(btnNewButton);

		JButton btnDailyWorkout = new JButton("Daily Workout");
		btnDailyWorkout.setBackground(Color.BLACK);
		btnDailyWorkout.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDailyWorkout.setForeground(Color.WHITE);
		btnDailyWorkout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DailyWorkOut dw = DailyWorkOut.getInstance();
				frame.setVisible(false);
				dw.getFrame().setVisible(true);
			}
		});
		btnDailyWorkout.setBounds(612, 316, 179, 66);
		frame.getContentPane().add(btnDailyWorkout);

		JButton btnFinish = new JButton("Finish");
		btnFinish.setBackground(Color.BLACK);
		btnFinish.setForeground(Color.WHITE);
		btnFinish.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DialogBox dialog = new DialogBox();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);


				if(!weightUpdateTextField.getText().matches("[0-9]+[.][0-9]+|[0-9]+")) {
					dialog.getOkBtn().addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(weightUpdateTextField.getText().isEmpty()) {
								weightUpdateTextField.setText(currWeight+"");

								HomePage hp = HomePage.getInstance();
								frame.setVisible(false);
								hp.getFrame().setVisible(true);
								weightUpdateTextField.setText(currWeight+"");
								lblWeightFieldErr.setVisible(false);
								lblUpdateWeight.setForeground(Color.white);

								dialog.setVisible(false);
							}

							else {
								lblWeightFieldErr.setVisible(true);
								lblUpdateWeight.setForeground(Color.red);
								dialog.setVisible(false);
							}
						}
					});

				}
				else {
					currWeight=Double.parseDouble(weightUpdateTextField.getText());//Initialize current weight

					if(currWeight==goalWeight) {
						AchievementDialog reachedGoal = new AchievementDialog();
						reachedGoal.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

						dialog.getOkBtn().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

								setChanged();
								notifyObservers("FinishSumbitActivities");

								HomePage hp = HomePage.getInstance();
								frame.setVisible(false);
								lblWeightFieldErr.setVisible(false);
								lblUpdateWeight.setForeground(Color.white);
								hp.getFrame().setVisible(true);
								dialog.setVisible(false);
								reachedGoal.setVisible(true);
								weightUpdateTextField.setText(currWeight+"");
							}
						});
					}

					else {
						dialog.getOkBtn().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								setChanged();
								notifyObservers("FinishSumbitActivities");
								
								HomePage hp = HomePage.getInstance();
								lblWeightFieldErr.setVisible(false);
								lblUpdateWeight.setForeground(Color.white);
								frame.setVisible(false);
								hp.getFrame().setVisible(true);
								dialog.setVisible(false);
								weightUpdateTextField.setText(currWeight+"");
							}
						});
					}
				}

				dialog.getBackBtn().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						dialog.setVisible(false);
					}
				});
			}
		});		btnFinish.setBounds(377, 660, 215, 29);

		frame.getContentPane().add(btnFinish);

		JLabel lblDontWishFor = new JLabel("\"Don't wish for a good body, work for it!\"");
		lblDontWishFor.setForeground(new Color(0, 255, 255));
		lblDontWishFor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblDontWishFor.setBounds(257, 139, 480, 57);
		frame.getContentPane().add(lblDontWishFor);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBackground(Color.BLACK);
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblWeightFieldErr.setVisible(false);
				lblUpdateWeight.setForeground(Color.white);
				HomePage hp = HomePage.getInstance();
				frame.setVisible(false);
				hp.getFrame().setVisible(true);
				weightUpdateTextField.setText(currWeight+"");			}
		});
		btnHome.setBounds(69, 660, 115, 29);
		frame.getContentPane().add(btnHome);
		
		JLabel label = new JLabel("Fit & Hit");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 99));
		label.setBounds(209, 16, 532, 164);
		frame.getContentPane().add(label);
		
		lblUpdateWeight = new JLabel("Update Current Weight:");
		lblUpdateWeight.setForeground(Color.WHITE);
		lblUpdateWeight.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUpdateWeight.setBounds(377, 485, 228, 42);
		frame.getContentPane().add(lblUpdateWeight);

		weightUpdateTextField = new JTextField();
		weightUpdateTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
		weightUpdateTextField.setBackground(Color.BLACK);
		weightUpdateTextField.setForeground(Color.WHITE);
		weightUpdateTextField.setBounds(377, 520, 215, 29);
		frame.getContentPane().add(weightUpdateTextField);
		weightUpdateTextField.setColumns(10);

		lblWeightFieldErr = new JLabel("*Can only contain numbers");
		lblWeightFieldErr.setForeground(Color.RED);
		lblWeightFieldErr.setBounds(377, 565, 209, 13);
		frame.getContentPane().add(lblWeightFieldErr);
		lblWeightFieldErr.setVisible(false);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBackground(Color.BLACK);
		lblBackground.setIcon(new ImageIcon(Registration.class.getResource("/images/photoofpretywoman.jpg")));
		lblBackground.setBounds(-346, -40, 1340, 800);
		frame.getContentPane().add(lblBackground);
		
	}
}
