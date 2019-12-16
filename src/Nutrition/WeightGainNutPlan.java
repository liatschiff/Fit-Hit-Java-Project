package Nutrition;

import java.util.ArrayList;

public class WeightGainNutPlan extends NutritionPlan {

	public WeightGainNutPlan(){
		mainGoal="Weight Gain";
		author="Adar hevdeli";
		ArrayList<Food> breakfastMeal = new ArrayList<Food>();
		breakfastMeal.add(new Food("Boiled egg",97,"unit",2.0));
		breakfastMeal.add(new Food("Slice of bread",51,"unit",2.0));
		breakfastMeal.add(new Food("Cottage cheese",95,"100g",0.2));
		breakfast=new Meal(breakfastMeal,"Breakfast");
		
		ArrayList<Food> lunchMeal = new ArrayList<Food>();
		lunchMeal.add(new Food("Beef",171,"100g",3.0));
		lunchMeal.add(new Food("Potatoes",86,"100g",3.0));
		lunchMeal.add(new Food("Broccoli pie",40,"100g",2.0));
		lunch=new Meal(lunchMeal,"Lunch");
		
		ArrayList<Food> dinnerMeal = new ArrayList<Food>();
		dinnerMeal.add(new Food("Pasta",338,"100g",2.0));
		dinnerMeal.add(new Food("Salmon",208,"100g",2.0));
		dinnerMeal.add(new Food("Cucumber",14,"unit",1.0));
		dinner=new Meal(dinnerMeal,"Dinner");
		
		ArrayList<Food> snackMeal = new ArrayList<Food>();
		snackMeal.add(new Food("Quaker dough",160,"1 cup",1.0));
		snack = new Meal(snackMeal,"Snack");
		
		calcTotalCalories();
	
	}
}