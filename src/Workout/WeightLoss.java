package Workout;

import java.util.ArrayList;

public class WeightLoss extends WorkoutPlan{
	WeightLoss(){
		mainGoal="Weight Loss";
		daysPerWeek= "3 days";
		programDuration="8 Weeks";
		timePerWorkout = "60 Minutes";
		author="Liat Schiff";
		
		ArrayList<Exercise> exercises = new ArrayList<Exercise>();
		exercises.add(new Exercise("Dumbbell Bench Press",4,8));
		exercises.add(new Exercise("Ball Crunch",4,8));
		exercises.add(new Exercise("French Press",3,12));
		exercises.add(new Exercise("Glute Ham Raise",3,6));
		exercises.add(new Exercise("Barbell Hip Thrust",4,8));
		exercises.add(new Exercise("Push Up",3,8));
		exercises.add(new Exercise("Running",20,1));

		
		calorieBurned=800;
		workout=new Workout(exercises);

	}
}
