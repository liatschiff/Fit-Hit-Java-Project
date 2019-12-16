package Nutrition;

import java.util.ArrayList;

public class WeightPreservationVeganNutPlan extends NutritionPlan {

	public WeightPreservationVeganNutPlan(){
			mainGoal="Weight Preservation (Vegan)";
			author="Aviv Shimoni";
			ArrayList<Food> breakfastMeal = new ArrayList<Food>();
			breakfastMeal.add(new Food("Soy yogurt",75,"100g",2.0));
			breakfastMeal.add(new Food("Slice of bread",35,"unit",2.0));
			breakfastMeal.add(new Food("cucumber",14,"unit",3.0));
			breakfast=new Meal(breakfastMeal,"Breakfast");
			
			ArrayList<Food> lunchMeal = new ArrayList<Food>();
			lunchMeal.add(new Food("grilled tofu",154,"100g",2.0));
			lunchMeal.add(new Food("white rice",200,"1 cup",2.0));
			lunchMeal.add(new Food("Tomato",25,"unit",2.0));
			lunch=new Meal(lunchMeal,"Lunch");
			
			ArrayList<Food> dinnerMeal = new ArrayList<Food>();
			dinnerMeal.add(new Food("Quinoa",120,"100g",1.0));
			dinnerMeal.add(new Food("Slice of bread",35,"unit",2.0));
			dinnerMeal.add(new Food("Cashew cheese",553,"100g",0.5));
			dinner=new Meal(dinnerMeal,"Dinner");
			
			ArrayList<Food> snackMeal = new ArrayList<Food>();
			snackMeal.add(new Food("Energy bar",100,"unit",1.0));
			snack = new Meal(snackMeal,"Snack");
			calcTotalCalories();
	}
}

