import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Observable;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Nutrition.NutritionPlan;
import Project.Controller;
import Project.DailyCalBalance;
import Project.User;
import View.DailyNutrition;
import View.MyView;
import Workout.WorkoutPlan;

class SystemTest {
	/*This class tests the sequence of entering user's food intake and workout*/
	
	private User user;
	private Controller controller; // controller contains User and MyView attributes

	@BeforeEach
	void setUp() throws Exception {
		File file = new File("UserDetails.txt");
		file.delete(); // delete file from previous tests
		user = new User();
		user.setName("yaniv");
		user.setGender("Male");
		user.setAge(20);
		user.setVegan(true);
		user.setHeight(170.0);
		user.setWeight(70.0);
		user.setGoalWeight(100.0);
		user.selectNutritionPlan("Weight Loss");
		user.selectWorkoutPlan("Fat Loss");
		
		controller = new Controller();
		controller.setModel(user);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		File file = new File("UserDetails.txt");
		file.delete(); // delete file created during tests
	}

	@Test
	void DailyActivityInsertionTest() throws IllegalAccessException, RuntimeException, Exception {
		//simulate the user's food intake from the DailyNutrition page
		ArrayList<String> foods=new ArrayList<String>();
		foods.add("Yogurt");
		foods.add("Slice of bread");
		foods.add("Cucumber");
		foods.add("Grilled fish");
		foods.add("White rice");
		foods.add("Tomato");
		foods.add("Egg");
		foods.add("Slice of bread");
		foods.add("Feta cheese");
		foods.add("Energy bar");
		foods.add("200");//other
		foods.add("Foods");//flag
		
		//simulate pressing 'Confirm' button in DailyNutrition page
		Method method = Observable.class.getDeclaredMethod("setChanged", null);
		method.setAccessible(true);
		method.invoke(controller.getView().getDailyNutrition(), null);//setChanged();
		controller.getView().getDailyNutrition().notifyObservers(foods);
		
		assertEquals("calorieIn was not calculate properly",(Double)1253.8,(Double)user.getCalBalances().get(0).getCalorieIn());
		
		//simulate the user's workout from the DailyWorkout page
		ArrayList<String> exercises = new ArrayList<String>();
		exercises.add("Dumbbell Bench Press");
		exercises.add("Standing Cable Fly");
		exercises.add("Incline Bench Press");
		exercises.add("Overhead Press");
		exercises.add("Lateral Raise");
		exercises.add("Skullcrusher");
		exercises.add("Hanging Leg Raise");
		exercises.add("Exercises");//flag
		
		//simulate pressing 'Confirm' button in DailyWorkout page
		method.invoke(controller.getView().getDailyWorkOut(), null);//setChanged();
		controller.getView().getDailyWorkOut().notifyObservers(exercises);
		
		double expected =user.getMyWorkoutPlan().getCalorieBurned() + user.getBMR(); 
		double actual = user.getCalBalances().get(0).getCalorieOut(); 
		assertEquals("calorieOut was not calculate properly",(Double)expected,(Double)actual);
		
		//start a new day and save user's details in disk (simulate pressing 'Finish' button in DailyActivities page)
		
		method.invoke(controller.getView().getDailyActivities(), null);//setChanged();
		controller.getView().getDailyActivities().notifyObservers("FinishSumbitActivities");
		controller.getModel().setWeight(70.0);
		controller.getModel().saveDetails();
		
		//test that the file was created and it's readable and the data was saved correctly
		ObjectInputStream ois = null;
	      try
	      {
	        String fileName = "UserDetails.txt";

	       ois = new ObjectInputStream(new FileInputStream(fileName));
	       assertNotNull("File was not created properly", ois);//test that a 'UserDetails.txt' has been created
	       // Read user's details from the file 
	       // name=  (String) ois.readObject();
	       
			assertEquals("File was not read properly","yaniv",(String) ois.readObject());
			assertEquals("File was not read properly",20,(int) ois.readObject());
			assertEquals("File was not read properly","Male",(String) ois.readObject());
			assertEquals("File was not read properly",true,(boolean) ois.readObject());
			assertEquals("File was not read properly",(Double)170.0,(Double) ois.readObject());
			assertEquals("File was not read properly",(Double)70.0,(Double)ois.readObject());
			assertEquals("File was not read properly",(Double)100.0,(Double) ois.readObject());
			assertEquals("File was not read properly",(Double)1567.5,(Double) ois.readObject());
			assertEquals("File was not read properly","Weight Loss",((NutritionPlan)ois.readObject()).getMainGoal());
			assertEquals("File was not read properly","Fat Loss",((WorkoutPlan)ois.readObject()).getMainGoal());
	     
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
