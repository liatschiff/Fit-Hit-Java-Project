import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Nutrition.NutritionPlan;
import Nutrition.NutritionPlanFactory;
import Nutrition.WeightGainNutPlan;
import Nutrition.WeightGainVeganNutPlan;
import Nutrition.WeightLossNutPlan;
import Nutrition.WeightLossVeganNutPlan;
import Nutrition.WeightPreservationNutPlan;
import Nutrition.WeightPreservationVeganNutPlan;
import Workout.FatLossPlan;
import Workout.IncreaseStrength;
import Workout.MuscleBuilding;
import Workout.WeightLoss;
import Workout.WorkoutPlanFacory;

class NutritionPlanFactoryTest {
	
	@BeforeEach
	void setUp() throws Exception {

	}

	@Test
	void getNutritionPlanTest() {
		assertTrue("plan was not created",NutritionPlanFactory.getNutritionPlan("Weight Loss") instanceof WeightLossNutPlan);
		assertTrue("plan was not created",NutritionPlanFactory.getNutritionPlan("Weight Loss (Vegan)") instanceof WeightLossVeganNutPlan);
		assertTrue("plan was not created",NutritionPlanFactory.getNutritionPlan("Weight Gain") instanceof WeightGainNutPlan);
		assertTrue("plan was not created",NutritionPlanFactory.getNutritionPlan("Weight Gain (Vegan)") instanceof WeightGainVeganNutPlan);
		assertTrue("plan was not created",NutritionPlanFactory.getNutritionPlan("Weight Preservation") instanceof WeightPreservationNutPlan);
		assertTrue("plan was not created",NutritionPlanFactory.getNutritionPlan("Weight Preservation (Vegan)") instanceof WeightPreservationVeganNutPlan);
		assertNull("plan doesn't exist",WorkoutPlanFacory.getWorkoutPlan("not a nutrition plan"));
        assertNull("plan doesn't exist",WorkoutPlanFacory.getWorkoutPlan(null));
        
        
        
	}

}
