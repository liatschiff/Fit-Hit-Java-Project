package Nutrition;

import java.util.ArrayList;

public class WeightPreservationNutPlan  extends NutritionPlan{

	public WeightPreservationNutPlan(){
		mainGoal="Weight Preservation";
		author="Liat Schiff";
		ArrayList<Food> breakfastMeal = new ArrayList<Food>();
		breakfastMeal.add(new Food("Yogurt",56,"100g",2.5));
		breakfastMeal.add(new Food("Slice of bread",35,"unit",2.0));
		breakfastMeal.add(new Food("Cucumber",14,"unit",2.0));
		breakfast=new Meal(breakfastMeal,"Breakfast");
		
		ArrayList<Food> lunchMeal = new ArrayList<Food>();
		lunchMeal.add(new Food("Grilled fish",150,"100g",2.0));
		lunchMeal.add(new Food("White rice",200,"1 cup",2.0));
		lunchMeal.add(new Food("Tomato",25,"unit",2.0));
		lunch=new Meal(lunchMeal,"Lunch");
		
		ArrayList<Food> dinnerMeal = new ArrayList<Food>();
		dinnerMeal.add(new Food("Egg",110,"unit",2.0));
		dinnerMeal.add(new Food("Slice of bread",35,"unit",2.0));
		dinnerMeal.add(new Food("Feta cheese",264,"100g",0.5));
		dinner=new Meal(dinnerMeal,"Dinner");
		
		ArrayList<Food> snackMeal = new ArrayList<Food>();
		snackMeal.add(new Food("Energy bar",100,"unit",1.0));
		snack = new Meal(snackMeal,"Snack");
		calcTotalCalories();
	}
}

