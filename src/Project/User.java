package Project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Observable;

import Nutrition.Meal;
import Nutrition.NutritionPlan;
import Nutrition.NutritionPlanFactory;
import Workout.Workout;
import Workout.WorkoutPlan;
import Workout.WorkoutPlanFacory;

public class User extends Observable {

	private String name;
	private int age;
	private String gender;
	private boolean  vegan; 
	private double height=0;//cm
	private double weight=0;//kg
	private double goalWeight;//kg
	private double BMR=0;//BMR - How much calories burned per day at rest time 

	private NutritionPlan myNutritionPlan;
	private WorkoutPlan myWorkoutPlan;
	private ArrayList<DailyCalBalance> calBalances;
	//private ArrayList<Workout> myWorkouts;
	//private ArrayList<Meal> myMeals;

	private void calcBMR(){
		if (gender.equals("Female"))
			BMR=(weight*10)+(height*6.25) - (age*5) - 101;
		else if (gender.equals("Male"))
			BMR=(weight*10)+(height*6.25) - (age*5) - 95;
	}
	public User() {
		calBalances = new ArrayList<DailyCalBalance>();
		DailyCalBalance d = new DailyCalBalance();
		calBalances.add(d);//initiate the first day
		getCalBalances().get(0).setCalorieOut(getBMR());// sets the user's first day with his BMR
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
		calcBMR();
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
		calcBMR();
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
		calcBMR();
	}
	public double getGoalWeight() {
		return goalWeight;
	}

	public void setGoalWeight(double goalWeight) {
		this.goalWeight = goalWeight;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getBMR() {
		return BMR;
	}

	public boolean isVegan() {
		return vegan;
	}

	public void setVegan(boolean vegan) {
		this.vegan = vegan;
	}

	public NutritionPlan getMyNutritionPlan() {
		return myNutritionPlan;
	}

	public ArrayList<DailyCalBalance> getCalBalances() {
		return calBalances;
	}

	public void setCalBalances(ArrayList<DailyCalBalance> calBalances) {
		this.calBalances = calBalances;
	}

	public void selectNutritionPlan(String type){
		myNutritionPlan=NutritionPlanFactory.getNutritionPlan(type);
	}
	public WorkoutPlan getMyWorkoutPlan() {
		return myWorkoutPlan;
	}
	public void selectWorkoutPlan(String type){
		myWorkoutPlan=WorkoutPlanFacory.getWorkoutPlan(type);
	}
	public void addDailyCalorieIn(ArrayList<String> foods) { //the method gets an array of foods and sets CalorieIn of recent day  
		DailyCalBalance d;
		d = calBalances.get(calBalances.size()-1);//get the last value of the array (recent day)

		double calories = myNutritionPlan.calcTotalCalories(foods);
		d.setCalorieIn(calories);
	}
	public void addDailyCalorieOut(ArrayList<String> exercises) { //the method gets an array of exercises and sets CalorieOut of recent day 
		DailyCalBalance d = calBalances.get(calBalances.size()-1);//get the last value of the array (recent day)
		double calories = myWorkoutPlan.calcTotalCalories(exercises);
		calories += BMR;
		d.setCalorieOut(calories);
	}
	public void setUserDetails(String name, String gender, int age, double weight,double goalWeight, double height, boolean isVegan) { 
		// the method sets the user's personal information
		setName(name);
		setGender(gender);
		setAge(age);
		setWeight(weight);
		setGoalWeight(goalWeight);
		setHeight(height);
		setVegan(isVegan); 

	}

	public void saveDetails() {
		ObjectOutputStream oos = null;
		try
		{
			String fileName = "UserDetails.txt";

			// Open an FileOutputStream: can write a java object to a file
			oos = new ObjectOutputStream(new FileOutputStream(fileName));

			// Write the entire user's details to the file
			oos.writeObject(name);
			oos.writeObject(age);
			oos.writeObject(gender);
			oos.writeObject(vegan);
			oos.writeObject(height);
			oos.writeObject(weight);
			oos.writeObject(goalWeight);
			oos.writeObject(BMR);
			oos.writeObject(myNutritionPlan);
			oos.writeObject(myWorkoutPlan);
			oos.writeObject(calBalances);

		} catch(Exception e)
		{
			e.printStackTrace();
		}       
		finally
		{
			// Close the file object after we are done using it (mandatory action)
			if (oos != null)
				try {
					oos.close();
				} catch (IOException e) {					
					e.printStackTrace();
				}  
		}
	}
	
	public void readDetails() {
		ObjectInputStream ois = null;
	      try
	      {
	        String fileName = "UserDetails.txt";

	        // Open an ObjectInputStream: can read a java object from a file (the file has to be written by ObjectOutputStream
	        ois = new ObjectInputStream(new FileInputStream(fileName));
	        
	        // Read user's details from the file       
	    	name = (String) ois.readObject();
	    	age = (int) ois.readObject();
	    	gender = (String) ois.readObject();
	    	vegan = (boolean) ois.readObject();
	    	height = (double) ois.readObject();
	    	weight = (double) ois.readObject();
	    	goalWeight = (double) ois.readObject();
	    	BMR = (double) ois.readObject();
	    	myNutritionPlan = (NutritionPlan) ois.readObject();
	    	myWorkoutPlan = (WorkoutPlan) ois.readObject();
	    	calBalances   = (ArrayList<DailyCalBalance>) ois.readObject();    
	        
	      }
	      catch(FileNotFoundException e)
	      {
	         return;
	      }
	      catch(Exception e)
	      {
	         e.printStackTrace();
	      }
	      finally
	      {
	    	  // Close the file object after we are done using it (mandatory action)
	    	  if (ois != null)
				try {
					ois.close();
				} catch (IOException e) {				
					e.printStackTrace();
				}
	      }
	}



}
