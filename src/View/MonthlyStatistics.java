package View;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MonthlyStatistics extends Observable {

	private static MonthlyStatistics monthlyStatistics = null;
	private JFrame frame;
	private ChartPanel CP;
	private MonthlyStatistics() {
		initialize();
	}
	public static MonthlyStatistics getInstance() {
		if(monthlyStatistics == null)
			monthlyStatistics = new MonthlyStatistics();
		return monthlyStatistics;
	}
	public JFrame getFrame() {
		return frame;
	}

	public static MonthlyStatistics getMonthlyStatistics() {
		return monthlyStatistics;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);



		JButton btnHome = new JButton("Home");
		btnHome.setBackground(Color.BLACK);
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHome.setBounds(69, 660, 115, 29);
		frame.getContentPane().add(btnHome);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage hp = HomePage.getInstance();
				frame.setVisible(false);
				hp.getFrame().setVisible(true);
			}


		});

		JLabel label = new JLabel("Fit & Hit");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 99));
		label.setBounds(211, 16, 532, 164);
		frame.getContentPane().add(label);
		
		
		JLabel lblYourMonthlyStatistics = new JLabel("\"The BODY achieves what the MIND believes\"");
		lblYourMonthlyStatistics.setForeground(new Color(0, 255, 255));
		lblYourMonthlyStatistics.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblYourMonthlyStatistics.setBounds(243, 139, 510, 49);
		frame.getContentPane().add(lblYourMonthlyStatistics);
		
		JFreeChart lineChart = ChartFactory.createLineChart(
				"Calorie Balance",
				"Days","Calories",
				null,
				PlotOrientation.VERTICAL,
				true,true,false);

		CP = new ChartPanel(lineChart);
		CP.setPreferredSize(new Dimension(500, 500)); 

		JPanel chartPanel = new JPanel();
		chartPanel.setBounds(225, 200, 500, 500);
		frame.getContentPane().add(chartPanel);
		chartPanel.add(CP);

	}

	public void setLineChart(DefaultCategoryDataset dataset) {
		JFreeChart lineChart = ChartFactory.createLineChart(
				"Calorie Balance",
				"Days","Calories",
				dataset,
				PlotOrientation.VERTICAL,
				true,true,false);

		CP.setChart(lineChart);
	
		//background must be defined as the last component
		JLabel lblBackground = new JLabel("");
		lblBackground.setBackground(Color.BLACK);
		lblBackground.setIcon(new ImageIcon(Registration.class.getResource("/images/photoofpretywoman.jpg")));
		lblBackground.setBounds(-346, -40, 1340, 800);
		frame.getContentPane().add(lblBackground);
	}
}

