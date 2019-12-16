import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Workout.Exercise;
import Workout.FatLossPlan;
import Workout.WorkoutPlan;

class WorkoutPlanTest {

	WorkoutPlan workoutPlan;
	@BeforeEach
	void setUp() throws Exception {
		workoutPlan=new FatLossPlan();
	}

	@Test
	void calcTotalCaloriesTest() {
		// the function "calcTotalCalories" gets an array of exercise names (of a specific plan) and return the total calories
	
		ArrayList<String> exercises = new ArrayList<String>();
		exercises.add("Dumbbell Bench Press");
		exercises.add("Standing Cable Fly");
		exercises.add("Incline Bench Press");
		exercises.add("Overhead Press");
		exercises.add("Lateral Raise");
		exercises.add("Skullcrusher");
		exercises.add("Hanging Leg Raise");
		assertEquals("Full array error",(Double)workoutPlan.getCalorieBurned(),(Double)workoutPlan.calcTotalCalories(exercises));
		exercises.clear();
		
		exercises.add("Dumbbell Bench Press");
		exercises.add("Standing Cable Fly");
		exercises.add("Incline Bench Press");
		exercises.add(null);
		exercises.add("Lateral Raise");
		exercises.add("Skullcrusher");
		exercises.add(null);
		assertEquals("partial array error",(Double)((5.0/7.0)*workoutPlan.getCalorieBurned()),(Double)workoutPlan.calcTotalCalories(exercises));
		exercises.clear();
	
		exercises.add(null);
		exercises.add(null);
		exercises.add(null);
		exercises.add(null);
		exercises.add(null);
		exercises.add(null);
		exercises.add(null);
		assertEquals("empty array error",(Double)0.0,(Double)workoutPlan.calcTotalCalories(exercises));
		exercises.clear();
		
		exercises.add("Not an exercise");
		exercises.add("Standing Cable Fly");
		exercises.add("Incline Bench Press");
		exercises.add("Overhead Press");
		exercises.add("Lateral Raise");
		exercises.add("Skullcrusher");
		exercises.add("Hanging Leg Raise");
		assertEquals("wrong input error",(Double)(-1.0),(Double)workoutPlan.calcTotalCalories(exercises));
		exercises.clear();
	}
	
	

}
