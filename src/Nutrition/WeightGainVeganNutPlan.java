package Nutrition;

import java.util.ArrayList;

public class WeightGainVeganNutPlan extends NutritionPlan {

	public WeightGainVeganNutPlan(){
		mainGoal="Weight Gain (Vegan)";
		author="Liat Schiff";
		ArrayList<Food> breakfastMeal = new ArrayList<Food>();
		breakfastMeal.add(new Food("Soy yogurt",75,"100g",3.0));
		breakfastMeal.add(new Food("Slice of bread",35,"unit",4.0));
		breakfastMeal.add(new Food("Cucumber",14,"unit",2.0));
		breakfast=new Meal(breakfastMeal,"Breakfast");
		
		ArrayList<Food> lunchMeal = new ArrayList<Food>();
		lunchMeal.add(new Food("lentils hamburger",169,"100g",3.0));
		lunchMeal.add(new Food("White rice",200,"1 cup",2.0));
		lunchMeal.add(new Food("Tomato",25,"unit",2.0));
		lunch=new Meal(lunchMeal,"Lunch");
		
		ArrayList<Food> dinnerMeal = new ArrayList<Food>();
		dinnerMeal.add(new Food("Quinoa",120,"100g",1.5));
		dinnerMeal.add(new Food("Slice of bread",35,"unit",4.0));
		dinnerMeal.add(new Food("Cashew cheese",553,"100g",1.0));
		dinner=new Meal(dinnerMeal,"Dinner");
		
		ArrayList<Food> snackMeal = new ArrayList<Food>();
		snackMeal.add(new Food("Quaker dough",160,"1 cup",1.0));
		snack = new Meal(snackMeal,"Snack");
		calcTotalCalories();
	}
}

