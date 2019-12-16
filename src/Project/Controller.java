package Project;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import org.jfree.data.category.DefaultCategoryDataset;

import Nutrition.Food;
import View.MyView;
import Workout.Exercise;

public class Controller implements Observer {

	private User model; //model
	private MyView view; //view
	public Controller(){
		model = new User();
		view = new MyView();

		model.addObserver(this);
		view.addObserver(this);

		//insert here commands to occur when first page loads
		//load user's previous details (if exist)
		model.readDetails();
		if(model.getName()!=null) { //user has previous details in the HD
			updateUserDetailsInFrames();
			view.getHomePage().getFrame().setVisible(true);
		}
		else view.getRegistration().getFrame().setVisible(true);

	}
	
	
	public User getModel() {
		return model;
	}
	public void setModel(User model) {
		this.model = model;
	}
	public MyView getView() {
		return view;
	}
	public void setView(MyView view) {
		this.view = view;
	}

	@Override
	public void update(Observable o, Object message) {
		if(o instanceof MyView) {
			if (message instanceof String) {
				if (((String)message).equals("Registration")) {
					String name = view.getRegistration().getNameTextField().getText(); 
					String gender = view.getRegistration().getGenderComboBox().getSelectedItem().toString();
					int age = Integer.parseInt(view.getRegistration().getAgeTextField().getText());
					double weight = Double.parseDouble(view.getRegistration().getWeightTextField().getText());
					double goalWeight=Double.parseDouble(view.getRegistration().getGoalWeightTextField().getText());
					double height = Double.parseDouble(view.getRegistration().getHeightTextField().getText());
					boolean isVegan;
					if(view.getRegistration().getVeganComboBox().getSelectedItem().toString().equals("Yes"))
						isVegan = true;
					else isVegan = false;
					model.setUserDetails(name, gender, age, weight,goalWeight, height, isVegan);
					
				}
				if (((String)message).equals("GoalChoosing")) {
					
					String goal = view.getGoalChoosing().getChosenGoal();
					setUserGoal(goal);
					
					//model.setGoalWeight(Double.parseDouble(view.getGoalChoosing().getTargetWeightTextField().getText()));
					
					updateUserDetailsInFrames();
					model.saveDetails(); // save details in disk
				}
				if (((String)message).equals("FinishSumbitActivities")) {
										
					// start a new day
					DailyCalBalance d = new DailyCalBalance();
					d.setCalorieOut(model.getBMR());
					model.getCalBalances().add(d);
					
					model.setWeight(view.getDailyActivities().getWeight());
					view.getHomePage().setCurWeight(model.getWeight());
					//clear user's previous choice
					view.getDailyNutrition().clearChoices();
					view.getDailyWorkOut().clearChoices();	
					
					model.saveDetails();//save user's details in the HD
				}
				if (((String)message).equals("UpdateProfile")) {
					String name = view.getUpdateProfile().getNameTextField().getText(); 
					String gender = view.getUpdateProfile().getGenderComboBox().getSelectedItem().toString();
					int age = Integer.parseInt(view.getUpdateProfile().getAgeTextField().getText());
					double weight = Double.parseDouble(view.getUpdateProfile().getWeightTextField().getText());
					double goalWeight = Double.parseDouble(view.getUpdateProfile().getGoalWeighTextField().getText());
					double height = Double.parseDouble(view.getUpdateProfile().getHeightTextField().getText());
					boolean isVegan;
					if(view.getUpdateProfile().getVeganComboBox().getSelectedItem().toString().equals("Yes"))
						isVegan = true;
					else isVegan = false;
					
					model.setUserDetails(name, gender, age, weight,goalWeight, height, isVegan);
					
					String goal = view.getUpdateProfile().getGoalComboBox().getSelectedItem().toString();
					setUserGoal(goal);
					
					
					model.saveDetails();// save details in disk
					updateUserDetailsInFrames();
					
					view.getHomePage().setCurWeight(weight);
				}
				if (((String)message).equals("Statistics")) {
					//update user's calories in Statistics page
					DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
					for (int i = 0; i < model.getCalBalances().size()-1; i++) {
						dataset.addValue( model.getCalBalances().get(i).getCalorieIn() , "Calorie intake" , (i+1) + "" );
						dataset.addValue( model.getCalBalances().get(i).getCalorieOut() , "Calorie expenditure" , (i+1) + "" );
						dataset.addValue( model.getCalBalances().get(i).getCalorieBalance() , "Calorie balance" , (i+1) + "" );
					}
								
					view.getMonthlyStatistics().setLineChart(dataset);
				}				
			}
			
			if (message instanceof ArrayList<?>) {
				if(((ArrayList<String>)message).get(((ArrayList<String>)message).size()-1).equals("Foods")) {
					model.addDailyCalorieIn((ArrayList<String>)message);
				}
				else if(((ArrayList<String>)message).get(((ArrayList<String>)message).size()-1).equals("Exercises")) {
					model.addDailyCalorieOut((ArrayList<String>)message);
				}
				
			}
		}

	}
	
	private void updateUserDetailsInFrames() {
		//update user's weight in HomePage
		view.getHomePage().setCurWeight(model.getWeight());
		view.getHomePage().setGoalWeight(model.getGoalWeight());

		//update user's weight in DailyActivities page
		view.getDailyActivities().setWeight(model.getWeight(),model.getGoalWeight());
		
		//update user's Foods in DailyNutrition page
		ArrayList<Food> foods = new ArrayList<>();
		foods.add(model.getMyNutritionPlan().getBreakfast().getFoods().get(0));
		foods.add(model.getMyNutritionPlan().getBreakfast().getFoods().get(1));
		foods.add(model.getMyNutritionPlan().getBreakfast().getFoods().get(2));

		foods.add(model.getMyNutritionPlan().getLunch().getFoods().get(0));
		foods.add(model.getMyNutritionPlan().getLunch().getFoods().get(1));
		foods.add(model.getMyNutritionPlan().getLunch().getFoods().get(2));
		
		foods.add(model.getMyNutritionPlan().getDinner().getFoods().get(0));
		foods.add(model.getMyNutritionPlan().getDinner().getFoods().get(1));
		foods.add(model.getMyNutritionPlan().getDinner().getFoods().get(2));
		
		foods.add(model.getMyNutritionPlan().getSnack().getFoods().get(0));
		
		view.getDailyNutrition().setFoods(foods);
		
		//update user's exercises in DailyWorkout page
		ArrayList<Exercise> exercises = new ArrayList<>();
		exercises.add(model.getMyWorkoutPlan().getWorkout().getExercises().get(0));
		exercises.add(model.getMyWorkoutPlan().getWorkout().getExercises().get(1));
		exercises.add(model.getMyWorkoutPlan().getWorkout().getExercises().get(2));
		exercises.add(model.getMyWorkoutPlan().getWorkout().getExercises().get(3));
		exercises.add(model.getMyWorkoutPlan().getWorkout().getExercises().get(4));
		exercises.add(model.getMyWorkoutPlan().getWorkout().getExercises().get(5));
		exercises.add(model.getMyWorkoutPlan().getWorkout().getExercises().get(6));
		
		view.getDailyWorkOut().setExercises(exercises);
		
		
		//update user's workout plan in MyWorkoutPlan page
		String workoutMainGoal = model.getMyWorkoutPlan().getMainGoal();
		String daysPerWeek = model.getMyWorkoutPlan().getDaysPerWeek();
		String duration = model.getMyWorkoutPlan().getProgramDuration();
		String timePerWorkout = model.getMyWorkoutPlan().getTimePerWorkout();
		String workoutAuthor = model.getMyWorkoutPlan().getAuthor();
		String caloriesBurned = Double.toString(model.getMyWorkoutPlan().getCalorieBurned());
		String target = model.getMyWorkoutPlan().getMainGoal();
		
	   String[][] dataExercise = new String[][] {
            {"Name","Sets","Reps"},
            {model.getMyWorkoutPlan().getWorkout().getExercises().get(0).getExName(), Integer.toString(model.getMyWorkoutPlan().getWorkout().getExercises().get(0).getSets()), Integer.toString(model.getMyWorkoutPlan().getWorkout().getExercises().get(0).getReps())},
            {model.getMyWorkoutPlan().getWorkout().getExercises().get(1).getExName(), Integer.toString(model.getMyWorkoutPlan().getWorkout().getExercises().get(1).getSets()), Integer.toString(model.getMyWorkoutPlan().getWorkout().getExercises().get(1).getReps()) },
            {model.getMyWorkoutPlan().getWorkout().getExercises().get(2).getExName(), Integer.toString(model.getMyWorkoutPlan().getWorkout().getExercises().get(2).getSets()), Integer.toString(model.getMyWorkoutPlan().getWorkout().getExercises().get(2).getReps())},
            {model.getMyWorkoutPlan().getWorkout().getExercises().get(3).getExName(), Integer.toString(model.getMyWorkoutPlan().getWorkout().getExercises().get(3).getSets()), Integer.toString(model.getMyWorkoutPlan().getWorkout().getExercises().get(3).getReps())},
            {model.getMyWorkoutPlan().getWorkout().getExercises().get(4).getExName(), Integer.toString(model.getMyWorkoutPlan().getWorkout().getExercises().get(4).getSets()), Integer.toString(model.getMyWorkoutPlan().getWorkout().getExercises().get(4).getReps())},
            {model.getMyWorkoutPlan().getWorkout().getExercises().get(5).getExName(), Integer.toString(model.getMyWorkoutPlan().getWorkout().getExercises().get(5).getSets()), Integer.toString(model.getMyWorkoutPlan().getWorkout().getExercises().get(5).getReps())},
            {model.getMyWorkoutPlan().getWorkout().getExercises().get(6).getExName(), Integer.toString(model.getMyWorkoutPlan().getWorkout().getExercises().get(6).getSets()), Integer.toString(model.getMyWorkoutPlan().getWorkout().getExercises().get(6).getReps())},
        };
		view.getMyWorkoutPlan().setFields(workoutMainGoal, daysPerWeek, duration, timePerWorkout, workoutAuthor, caloriesBurned, target, dataExercise);
		
		//update user's nutrition plan in MyNutritiontPlan page
		
		String nutritionMainGoal = model.getMyNutritionPlan().getMainGoal();
		String nutritionAuthor = model.getMyNutritionPlan().getAuthor();
		String calories = Double.toString(model.getMyNutritionPlan().getTotalCalories());
		
        String[][] dataBreakfast = new String[][] {
            {"Name","Calories","Serving Size","Quantity"},
            {model.getMyNutritionPlan().getBreakfast().getFoods().get(0).getName(), model.getMyNutritionPlan().getBreakfast().getFoods().get(0).getCalories() + "", model.getMyNutritionPlan().getBreakfast().getFoods().get(0).getServingSize(), model.getMyNutritionPlan().getBreakfast().getFoods().get(0).getQuantity() +""},
            {model.getMyNutritionPlan().getBreakfast().getFoods().get(1).getName(), model.getMyNutritionPlan().getBreakfast().getFoods().get(1).getCalories() + "", model.getMyNutritionPlan().getBreakfast().getFoods().get(1).getServingSize(), model.getMyNutritionPlan().getBreakfast().getFoods().get(2).getQuantity() +""},
            {model.getMyNutritionPlan().getBreakfast().getFoods().get(2).getName(), model.getMyNutritionPlan().getBreakfast().getFoods().get(2).getCalories() + "", model.getMyNutritionPlan().getBreakfast().getFoods().get(2).getServingSize(), model.getMyNutritionPlan().getBreakfast().getFoods().get(1).getQuantity() +""},
        };
        
        String[][] dataLunch = new String[][] {
            {"Name","Calories","Serving Size","Quantity"},
            {model.getMyNutritionPlan().getLunch().getFoods().get(0).getName(), model.getMyNutritionPlan().getLunch().getFoods().get(0).getCalories() + "", model.getMyNutritionPlan().getLunch().getFoods().get(0).getServingSize(), model.getMyNutritionPlan().getBreakfast().getFoods().get(0).getQuantity() +""},
            {model.getMyNutritionPlan().getLunch().getFoods().get(1).getName(), model.getMyNutritionPlan().getLunch().getFoods().get(1).getCalories() + "", model.getMyNutritionPlan().getLunch().getFoods().get(1).getServingSize(), model.getMyNutritionPlan().getBreakfast().getFoods().get(2).getQuantity() +""},
            {model.getMyNutritionPlan().getLunch().getFoods().get(2).getName(), model.getMyNutritionPlan().getLunch().getFoods().get(2).getCalories() + "", model.getMyNutritionPlan().getLunch().getFoods().get(2).getServingSize(), model.getMyNutritionPlan().getBreakfast().getFoods().get(1).getQuantity() +""},
        };
        String[][] dataDinner = new String[][] {
            {"Name","Calories","Serving Size","Quantity"},
            {model.getMyNutritionPlan().getDinner().getFoods().get(0).getName(), model.getMyNutritionPlan().getDinner().getFoods().get(0).getCalories() + "", model.getMyNutritionPlan().getDinner().getFoods().get(0).getServingSize(), model.getMyNutritionPlan().getBreakfast().getFoods().get(0).getQuantity() +""},
            {model.getMyNutritionPlan().getDinner().getFoods().get(1).getName(), model.getMyNutritionPlan().getDinner().getFoods().get(1).getCalories() + "", model.getMyNutritionPlan().getDinner().getFoods().get(1).getServingSize(), model.getMyNutritionPlan().getBreakfast().getFoods().get(2).getQuantity() +""},
            {model.getMyNutritionPlan().getDinner().getFoods().get(2).getName(), model.getMyNutritionPlan().getDinner().getFoods().get(2).getCalories() + "", model.getMyNutritionPlan().getDinner().getFoods().get(2).getServingSize(), model.getMyNutritionPlan().getBreakfast().getFoods().get(1).getQuantity() +""},
        };
        String[][] dataSnack = new String[][] {
            {"Name","Calories","Serving Size","Quantity"},
            {model.getMyNutritionPlan().getSnack().getFoods().get(0).getName(), model.getMyNutritionPlan().getSnack().getFoods().get(0).getCalories() + "", model.getMyNutritionPlan().getSnack().getFoods().get(0).getServingSize(), model.getMyNutritionPlan().getBreakfast().getFoods().get(0).getQuantity() +""},
        };
        
		view.getMyNutritionPlan().setFields(nutritionMainGoal, nutritionAuthor, calories, dataBreakfast, dataLunch, dataDinner, dataSnack);
		
		//update user's details in UpdateProfile page
		String name = model.getName();
		String gender = model.getGender();
		int age = model.getAge();
		double weight = model.getWeight();
		double goalWeight=model.getGoalWeight();
		double height = model.getHeight();
		boolean isVegan = model.isVegan();
		String goal = model.getMyWorkoutPlan().getMainGoal();
		view.getUpdateProfile().setUserCurDetails(name, gender, age, weight,goalWeight, height, isVegan,goal);

		
	}
	
	private void setUserGoal(String goal) {
		model.selectWorkoutPlan(goal);

		//'Fat Loss' and 'Weight Loss' choices get "Weight Loss" nutrition plan
		//'Muscle Building' choice get "Weight Gain" nutrition plan
		//'Increase Strength' choice get "Weight Preservation" nutrition plan
		if(goal.equals("Fat Loss") || goal.equals("Weight Loss"))
			goal = "Weight Loss";
		else if(goal.equals("Muscle Building"))
			goal = "Weight Gain";
		else goal = "Weight Preservation"; 

		if (model.isVegan()) goal = goal + " (Vegan)";
		model.selectNutritionPlan(goal);

	}
}
