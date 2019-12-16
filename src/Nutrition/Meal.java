package Nutrition;

import java.io.Serializable;
import java.util.ArrayList;

public class Meal implements Serializable {

	private static final long serialVersionUID = 1L;//default serialVersion id
	private ArrayList<Food> foods = new ArrayList<Food>();
	private String type;
	
	public Meal(ArrayList<Food> foods, String type) {
		this.foods = foods;
		this.type = type;
	}

	public ArrayList<Food> getFoods() {
		return foods;
	}

	public void setFoods(ArrayList<Food> foods) {
		this.foods = foods;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public double getFoodCalories(String foodName) { //the method get a food name and return it's calorie value, on failure return -1
		for (Food food : foods) {
			if(food.getName().equals(foodName)) {
				return food.getCalories() * food.getQuantity();	
			}
		}
		return -1;
	}
}
