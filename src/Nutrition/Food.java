package Nutrition;

import java.io.Serializable;

public class Food implements Serializable{

	private static final long serialVersionUID = 1L;//default serialVersion id
	private String name;
	private double calories;
	private String servingSize;
	private double quantity; 
	public Food(String name, int calories,String servingSize,double quantity) {
		this.name = name;
		this.calories = calories;
		this.servingSize=servingSize;
		this.quantity=quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public String getServingSize() {
		return servingSize;
	}
	public void setServingSize(String servingSize) {
		this.servingSize = servingSize;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	
	
	
}
