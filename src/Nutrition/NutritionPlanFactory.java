package Nutrition;

import java.util.HashMap;
import java.util.Map;

public class NutritionPlanFactory {
	private static Map<String, NutritionPlan> nutritionPlans = new HashMap<String, NutritionPlan>(){{
	    put("Weight Loss", new WeightLossNutPlan());
	    put("Weight Loss (Vegan)", new WeightLossVeganNutPlan());
	    put("Weight Gain", new WeightGainNutPlan());
	    put("Weight Gain (Vegan)", new WeightGainVeganNutPlan());
	    put("Weight Preservation", new WeightPreservationNutPlan());
	    put("Weight Preservation (Vegan)", new WeightPreservationVeganNutPlan());
	    
	}};
	
	
	public static NutritionPlan getNutritionPlan(String type) {
		return nutritionPlans.get(type);
	}


}
