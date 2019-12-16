package View;

import java.util.Observable;
import java.util.Observer;

public class MyView extends Observable implements Observer {
	
	private HomePage homePage; 
	private DailyNutrition dailyNutrition;
	private DailyWorkOut dailyWorkOut;
	private GoalChoosing goalChoosing;
	private MonthlyStatistics monthlyStatistics;
	private Registration registration;
	private UpdateProfile updateProfile;
	private DailyActivities dailyActivities;
	private MyWorkoutPlan myWorkoutPlan;
	private MyNutritionPlan myNutritionPlan;
	
	public MyView() {
		homePage = HomePage.getInstance();
		dailyNutrition = DailyNutrition.getInstance();
		dailyWorkOut = DailyWorkOut.getInstance();
		goalChoosing = GoalChoosing.getInstance();
		monthlyStatistics = MonthlyStatistics.getInstance();
		registration = Registration.getInstance();
		updateProfile = UpdateProfile.getInstance();
		dailyActivities = DailyActivities.getInstance();
		myWorkoutPlan = MyWorkoutPlan.getInstance();
		myNutritionPlan =  MyNutritionPlan.getInstance();
		
		homePage.addObserver(this);
		dailyNutrition.addObserver(this);
		dailyWorkOut.addObserver(this);
		goalChoosing.addObserver(this);
		monthlyStatistics.addObserver(this);
		registration.addObserver(this);
		updateProfile.addObserver(this);
		dailyActivities.addObserver(this);
		myWorkoutPlan.addObserver(this);
		myNutritionPlan.addObserver(this);
	}
	
	public HomePage getHomePage() {
		return homePage;
	}

	public DailyNutrition getDailyNutrition() {
		return dailyNutrition;
	}

	public DailyWorkOut getDailyWorkOut() {
		return dailyWorkOut;
	}

	public GoalChoosing getGoalChoosing() {
		return goalChoosing;
	}

	public MonthlyStatistics getMonthlyStatistics() {
		return monthlyStatistics;
	}

	public Registration getRegistration() {
		return registration;
	}

	public UpdateProfile getUpdateProfile() {
		return updateProfile;
	}
	
	public DailyActivities getDailyActivities() {
		return dailyActivities;
	}

	public MyWorkoutPlan getMyWorkoutPlan() {
		return myWorkoutPlan;
	}

	public MyNutritionPlan getMyNutritionPlan() {
		return myNutritionPlan;
	}

	@Override
	public void update(Observable o, Object message) {
		
		if(o instanceof Registration) {
			setChanged();
			notifyObservers("Registration");//set details of the user (name,age,weight,height,gender,vegan)
		}
		if(o instanceof GoalChoosing) {
			setChanged();
			notifyObservers("GoalChoosing");//update details of the user (goal weight and target)
		}
		if(o instanceof DailyNutrition) {
			setChanged();
			notifyObservers(message);//"message" is an array of foods selected by the user
		}
		if(o instanceof DailyWorkOut) {
			setChanged();
			notifyObservers(message);//"message" is an array of exercises selected by the user
		}
		if(o instanceof DailyActivities) {
			setChanged();
			notifyObservers("FinishSumbitActivities");
		}
		if(o instanceof UpdateProfile) {
			setChanged();
			notifyObservers("UpdateProfile");//update details of the user (name,age,weight,height,gender,vegan) or set Setting page fields according to message
		}
		if(o instanceof HomePage) {
			setChanged();
			notifyObservers(message); // set Setting fields before the Setting page loads or set LineChart before Statistics page loads (according to message)
			//message can be "UpdateProfileFields" or "Statistics" according to the frame that called notifyObservers()
		}	
	}


}
