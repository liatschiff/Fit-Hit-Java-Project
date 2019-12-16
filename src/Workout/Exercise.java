package Workout;

import java.io.Serializable;

public class Exercise implements Serializable  {
	private static final long serialVersionUID = 1L;//default serialVersion id
	private String exName;
	private int sets;
	private int reps;
		
	public Exercise(String exName, int sets, int reps) {
		this.exName = exName;
		this.sets = sets;
		this.reps = reps;
	}

	public String getExName() {
		return exName;
	}

	public void setExName(String exName) {
		this.exName = exName;
	}

	public int getSets() {
		return sets;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}

	public int getReps() {
		return reps;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}
	
	
	
	

}
