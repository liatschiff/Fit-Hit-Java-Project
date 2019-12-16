package Workout;

import java.util.HashMap;
import java.util.Map;

public class WorkoutPlanFacory {
	
	static Map<String, WorkoutPlan> workoutPlans = new HashMap<String, WorkoutPlan>(){{
	    put("Fat Loss", new FatLossPlan());
	    put("Increase Strength", new IncreaseStrength());
	    put("Muscle Building", new MuscleBuilding());
	    put("Weight Loss", new WeightLoss());
	    
	}};
	
	
	public static WorkoutPlan getWorkoutPlan(String type) {
		return workoutPlans.get(type);
	}

}
