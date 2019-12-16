package Project;

import java.io.Serializable;

public class DailyCalBalance implements Serializable{
	private static final long serialVersionUID = 1L;//default serialVersion id
	private double calorieIn;
	private double calorieOut;
	private double calorieBalance;
	
	public DailyCalBalance() {
		this.calorieIn = 0;
		this.calorieOut = 0;
		calorieBalance = 0;
	}

	public double getCalorieIn() {
		return calorieIn;
	}

	public void setCalorieIn(double calorieIn) {
		this.calorieIn = calorieIn;
		calorieBalance=calorieIn-calorieOut;
	}

	public double getCalorieOut() {
		return calorieOut;
	}

	public void setCalorieOut(double calorieOut) {
		this.calorieOut = calorieOut;
		calorieBalance=calorieIn-calorieOut;
	}

	public double getCalorieBalance() {
		return calorieBalance;
	}

	
	
	
	
	
	
	
	
	
}
