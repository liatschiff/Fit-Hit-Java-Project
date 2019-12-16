package Workout;

import java.util.ArrayList;

public class FatLossPlan extends WorkoutPlan {
	
	public FatLossPlan(){
		mainGoal="Fat Loss";
		daysPerWeek= "5-6 days";
		programDuration="8 Weeks";
		timePerWorkout = "60-90 Minutes";
		author="Yaniv Naor";
		
		ArrayList<Exercise> exercises = new ArrayList<Exercise>();
		exercises.add(new Exercise("Dumbbell Bench Press",4,8));
		exercises.add(new Exercise("Standing Cable Fly",3,12));
		exercises.add(new Exercise("Incline Bench Press",4,8));
		exercises.add(new Exercise("Overhead Press",4,8));
		exercises.add(new Exercise("Lateral Raise",3,12));
		exercises.add(new Exercise("Skullcrusher",3,12));
		exercises.add(new Exercise("Hanging Leg Raise",4,10));
		
		calorieBurned=900;
		
		workout=new Workout(exercises);
	}
	
	
	
}
