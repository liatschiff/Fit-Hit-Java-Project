package Nutrition;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class NutritionPlan implements Serializable {

	protected static final long serialVersionUID = 1L;//default serialVersion id
	protected String mainGoal;
	protected String author;
	protected Meal breakfast;
	protected Meal lunch;
	protected Meal dinner;
	protected Meal snack;
	protected double totalCalories; 
	
	protected void calcTotalCalories() { //calculate the total calories of the nutrition plan
		totalCalories=0;
		for(Food f : breakfast.getFoods()) {
			totalCalories += f.getCalories() * f.getQuantity();
		}
		for(Food f : lunch.getFoods()) {
			totalCalories += f.getCalories() * f.getQuantity();
		}
		for(Food f : dinner.getFoods()) {
			totalCalories += f.getCalories() * f.getQuantity();
		}
		for(Food f : snack.getFoods()) {
			totalCalories += f.getCalories() * f.getQuantity();
		}
	}
	public double calcTotalCalories(ArrayList<String> foods) {
		// the function gets an array of food names (of a specific plan) and return the total calories
		double totalCalories=0;
		for (int i = 0; i < foods.size(); i++) {
			switch (i) {
			case 0:
			case 1:
			case 2:// 0-2: breakfast
				if(foods.get(i) != null) 
					if(breakfast.getFoodCalories(foods.get(i)) > 0) totalCalories += breakfast.getFoodCalories(foods.get(i));
				break;
			case 3:
			case 4:
			case 5:// 3-5:lunch
				if(foods.get(i) != null) 
					if(lunch.getFoodCalories(foods.get(i)) > 0)
						totalCalories += lunch.getFoodCalories(foods.get(i));
				break;
			case 6:
			case 7:
			case 8:// 6-8: dinner
				if(foods.get(i) != null)
					if(dinner.getFoodCalories(foods.get(i)) > 0)
						totalCalories += dinner.getFoodCalories(foods.get(i));
				break;
			case 9://snack
				if(foods.get(i) != null)
					if(snack.getFoodCalories(foods.get(i)) > 0)
						totalCalories += snack.getFoodCalories(foods.get(i));
				break;
			case 10: //other
				totalCalories += Double.parseDouble(foods.get(i));
				break;
			default:
				break;
			}			
		}
		
		return totalCalories;
		
	}

	public String getMainGoal() {
		return mainGoal;
	}

	public String getAuthor() {
		return author;
	}

	public Meal getBreakfast() {
		return breakfast;
	}

	public Meal getLunch() {
		return lunch;
	}

	public Meal getDinner() {
		return dinner;
	}

	public Meal getSnack() {
		return snack;
	}

	public double getTotalCalories() {
		return totalCalories;
	}
	
	
	
}
