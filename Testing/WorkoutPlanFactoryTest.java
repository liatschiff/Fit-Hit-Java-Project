import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Workout.FatLossPlan;
import Workout.IncreaseStrength;
import Workout.MuscleBuilding;
import Workout.WeightLoss;
import Workout.WorkoutPlan;
import Workout.WorkoutPlanFacory;

class WorkoutPlanFactoryTest {

    
	@BeforeEach
	void setUp() throws Exception {
	}


	@Test
	void getWorkoutPlanTest() {
		assertTrue("plan was not created",WorkoutPlanFacory.getWorkoutPlan("Fat Loss") instanceof FatLossPlan);
		assertTrue("plan was not created",WorkoutPlanFacory.getWorkoutPlan("Increase Strength") instanceof IncreaseStrength);
		assertTrue("plan was not created",WorkoutPlanFacory.getWorkoutPlan("Muscle Building") instanceof MuscleBuilding);
		assertTrue("plan was not created",WorkoutPlanFacory.getWorkoutPlan("Weight Loss") instanceof WeightLoss);
        assertNull("plan doesn't exist",WorkoutPlanFacory.getWorkoutPlan("not a workout plan"));
        assertNull("plan doesn't exist",WorkoutPlanFacory.getWorkoutPlan(null));
	}
}
