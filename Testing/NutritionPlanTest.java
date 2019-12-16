import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Nutrition.Food;
import Nutrition.Meal;
import Nutrition.NutritionPlan;
import Nutrition.WeightLossNutPlan;

class NutritionPlanTest {
	private NutritionPlan nutritionPlan ;

	@BeforeEach
	void setUp() throws Exception {
		nutritionPlan= new WeightLossNutPlan();
	}
	
	@Test
	void calcTotalCaloriesTest() throws NoSuchMethodException, Exception, IllegalArgumentException{
		
		Method method = NutritionPlan.class.getDeclaredMethod("calcTotalCalories", null);
		method.setAccessible(true);
		method.invoke(nutritionPlan, null);
		assertEquals("TotalCalories was not calculate properly",(Double)1053.8,(Double)nutritionPlan.getTotalCalories());	
	}
	@Test
	void calcTotalCaloriesArrayTest() {
		
		/*
		 WeightLossNutPlan:
		"yogurt":56, quantity:2.0
		"slice of light bread":35, quantity:2.0
		"cucumber",14, quantity:1.0		
		"grilled fish":150, quantity:2.0
		"white rice":200, quantity:1.0
		"tomato":25, quantity:1.0
		"Omelette - one egg":110, quantity:1.0
		"slice of light bread":35, quantity:2.0
		"feta cheese":264, quantity:0.2
		"energy bar":100, quantity: 1.0
		 */
		ArrayList<String> foods = new ArrayList<String>();

		foods.add("yogurt");
		foods.add("slice of light bread");
		foods.add("cucumber");
		foods.add("grilled fish");
		foods.add("white rice");
		foods.add("tomato");
		foods.add("Omelette - one egg");
		foods.add("slice of light bread");
		foods.add("feta cheese");
		foods.add("energy bar");
		foods.add("200");//other
		assertEquals("Full array error",(Double)1253.8, (Double)nutritionPlan.calcTotalCalories(foods));
		foods.clear();
		
		foods.add("yogurt");
		foods.add(null);
		foods.add("cucumber");
		foods.add("grilled fish");
		foods.add(null);
		foods.add("tomato");
		foods.add("Omelette - one egg");
		foods.add("slice of light bread");
		foods.add("feta cheese");
		foods.add(null);
		foods.add("200");//other
		assertEquals("partial array error",(Double)883.8, (Double)nutritionPlan.calcTotalCalories(foods));
		foods.clear();
		
		foods.add(null);
		foods.add(null);
		foods.add(null);
		foods.add(null);
		foods.add(null);
		foods.add(null);
		foods.add(null);
		foods.add(null);
		foods.add(null);
		foods.add(null);
		foods.add("0");//other
		assertEquals("Empty array error",(Double)0.0, (Double)nutritionPlan.calcTotalCalories(foods));
		foods.clear();
		
		foods.add("Not a Food");// wrong input
		foods.add("slice of light bread");
		foods.add("cucumber");
		foods.add("grilled fish");
		foods.add("white rice");
		foods.add("tomato");
		foods.add("Omelette - one egg");
		foods.add("slice of light bread");
		foods.add("feta cheese");
		foods.add("energy bar");
		foods.add("200");
		assertEquals("Wrong array error",(Double)1141.8, (Double)nutritionPlan.calcTotalCalories(foods));
		foods.clear();
	}

}
