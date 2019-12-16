import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Nutrition.Food;
import Nutrition.Meal;

class MealTest {
	private Meal meal;

	@BeforeEach
	void setUp() throws Exception {
		ArrayList<Food> breakfastMeal = new ArrayList<Food>();
		breakfastMeal.add(new Food("yogurt",56,"100g",2.0));
		breakfastMeal.add(new Food("slice of light bread",35,"unit",2.0));
		breakfastMeal.add(new Food("cucumber",14,"unit",1.0));
		meal=new Meal(breakfastMeal,"Breakfast");
	}

	@Test
	void getFoodCaloriesTest() { //the method "getFoodCalories" get a food name and return it's calorie value, on failure return -1
		
		assertEquals("Food (quantity > 1) not found",(Double)112.0,(Double)meal.getFoodCalories("yogurt"));
		assertEquals("Food (quantity 1) not found",(Double)14.0,(Double)meal.getFoodCalories("cucumber"));
		assertEquals("Wrong Input",(Double)(-1.0),(Double)meal.getFoodCalories("Not a Food"));
		
	}

}
