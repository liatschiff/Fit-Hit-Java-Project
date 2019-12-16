package Workout;

import java.util.ArrayList;

public class IncreaseStrength extends WorkoutPlan {
	
	public IncreaseStrength(){
		mainGoal="Increase Strength";
		daysPerWeek= "12 days";
		programDuration="12 Weeks";
		timePerWorkout = "75 Minutes";
		author="Adar Hevdeli";
		
		ArrayList<Exercise> exercises = new ArrayList<Exercise>();
		exercises.add(new Exercise("Squat",4,5));
		exercises.add(new Exercise("Trap Bar Deadlift",3,6));
		exercises.add(new Exercise("Stiff Legged Deadlift",3,6));
		exercises.add(new Exercise("Bulgarian Split Squat",4,8));
		exercises.add(new Exercise("Bench Press",4,5));
		exercises.add(new Exercise("Strict Overhead Press",4,5));
		exercises.add(new Exercise("Weighted Chin Up",4,5));
		
		calorieBurned=700;
		
		workout=new Workout(exercises);
	}

}
