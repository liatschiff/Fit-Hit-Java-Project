package Workout;

import java.io.Serializable;
import java.util.ArrayList;

public class Workout implements Serializable {
	private static final long serialVersionUID = 1L;//default serialVersion id
	private ArrayList<Exercise> exercises = new ArrayList<Exercise>();

	public Workout(ArrayList<Exercise> exercises) {
		this.exercises=exercises;

	}

	public ArrayList<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(ArrayList<Exercise> exercises) {
		this.exercises = exercises;
	}

	public boolean IsContainsExercise(String exerciseName) { //the method get an exercise name and return true if the exercise is part of the workout
		for(Exercise ex: exercises) {
			if(exerciseName.equals(ex.getExName())) return true;
		}
		return false;
	}
}
