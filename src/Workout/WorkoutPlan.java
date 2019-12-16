package Workout;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class WorkoutPlan implements Serializable {
	protected static final long serialVersionUID = 1L;//default serialVersion id
	protected String mainGoal;
	protected String daysPerWeek;
	protected String programDuration;
	protected String timePerWorkout;
	protected String author;
	
	protected double calorieBurned;
	
	protected Workout workout;

	public String getMainGoal() {
		return mainGoal;
	}

	public void setMainGoal(String mainGoal) {
		this.mainGoal = mainGoal;
	}

	public String getDaysPerWeek() {
		return daysPerWeek;
	}

	public void setDaysPerWeek(String daysPerWeek) {
		this.daysPerWeek = daysPerWeek;
	}

	public String getProgramDuration() {
		return programDuration;
	}

	public void setProgramDuration(String programDuration) {
		this.programDuration = programDuration;
	}

	public String getTimePerWorkout() {
		return timePerWorkout;
	}

	public void setTimePerWorkout(String timePerWorkout) {
		this.timePerWorkout = timePerWorkout;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getCalorieBurned() {
		return calorieBurned;
	}

	public void setCalorieBurned(double calorieBurned) {
		this.calorieBurned = calorieBurned;
	}

	public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
	}
	
	
	public double calcTotalCalories(ArrayList<String> exercises) {
		// the function gets an array of exercise names (of a specific plan) and return the total calories
		// if the array contains an exercise that is not part of the workout plan -1 is returned
		double totalCalories=0;
		int countExercises=0;
		for (int i = 0; i < exercises.size()-1; i++) { // last value in 'exercises' is a flag and shouldn't be checked
			if(exercises.get(i) != null)
				if(workout.IsContainsExercise(exercises.get(i)))
					countExercises++;
				else return -1;
		}
		totalCalories = (countExercises/7.0) * calorieBurned;
		return totalCalories;
		
	}
	
	

}
