package Workout;

import java.util.ArrayList;

public class MuscleBuilding extends WorkoutPlan {
	
	MuscleBuilding(){
		mainGoal="Muscle Building";
		daysPerWeek= "6 days";
		programDuration="8 Weeks";
		timePerWorkout = "60-75 Minutes";
		author="Aviv Shimoni";
		
		ArrayList<Exercise> exercises = new ArrayList<Exercise>();
		exercises.add(new Exercise("Pin Press",4,8));
		exercises.add(new Exercise("Seated Lateral Raise",3,12));
		exercises.add(new Exercise("Low Incline Dumbbell Bench Press",4,8));
		exercises.add(new Exercise("Chin Up",4,8));
		exercises.add(new Exercise("One Arm Dumbbell Row",4,10));
		exercises.add(new Exercise("Sumo Deadlift",5,5));
		exercises.add(new Exercise("Seated Calf Raise",4,12));
		
		calorieBurned=600;
		
		workout=new Workout(exercises);

	}
}
