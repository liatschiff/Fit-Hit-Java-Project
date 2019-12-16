import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Workout.Exercise;
import Workout.FatLossPlan;
import Workout.MuscleBuilding;
import Workout.Workout;

class WorkoutTest {

	Workout workout;
	
	@BeforeEach
	void setUp() throws Exception {
		ArrayList<Exercise> exercises = new ArrayList<Exercise>();
		exercises.add(new Exercise("Squat",4,5));
		exercises.add(new Exercise("Trap Bar Deadlift",3,6));
		exercises.add(new Exercise("Stiff Legged Deadlift",3,6));
		exercises.add(new Exercise("Bulgarian Split Squat",4,8));
		exercises.add(new Exercise("Bench Press",4,5));
		exercises.add(new Exercise("Strict Overhead Press",4,5));
		exercises.add(new Exercise("Weighted Chin Up",4,5));
		workout =new Workout(exercises);
	}


	@Test
	public void IsContainsExerciseTest() {
	assertTrue("exercise was not found",workout.IsContainsExercise("Squat"));
	assertTrue("exercise was not found",workout.IsContainsExercise("Bench Press"));
	assertTrue("exercise was not found",workout.IsContainsExercise("Weighted Chin Up"));
	assertFalse("exercise was not found",workout.IsContainsExercise("Not exercise"));

	}

}
