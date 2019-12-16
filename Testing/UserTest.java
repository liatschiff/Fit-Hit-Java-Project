import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Nutrition.NutritionPlan;
import Project.DailyCalBalance;
import Project.User;
import Workout.WorkoutPlan;

class UserTest {
	private User user;

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
	}

	@Test
	public void addDailyCalorieInTest() {
		
		ArrayList<String> foods=new ArrayList<String>();
		assertEquals("CalorieIn was not initialize to 0",(Double)0.0,(Double)user.getCalBalances().get(0).getCalorieIn());
		
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
		user.addDailyCalorieIn(foods);
		assertEquals("calorieIn was not calculate properly",(Double)1253.8,(Double)user.getCalBalances().get(0).getCalorieIn());
		foods.clear();
		
		DailyCalBalance d = new DailyCalBalance();
		user.getCalBalances().add(d);// start a new day
		
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
		foods.add("0");//other
		foods.add("Foods");//flag
		user.addDailyCalorieIn(foods);
		assertEquals("calorieIn was not calculate properly",(Double)1053.8,(Double)user.getCalBalances().get(1).getCalorieIn());
	}
	@Test
	public void addDailyCalorieOutTest() {
		ArrayList<String> exercises = new ArrayList<String>();
		double expected, actual;
		
		assertEquals("CalorieIn was not initialize to 0",(Double)0.0,(Double)user.getCalBalances().get(0).getCalorieOut());
			
		exercises.add("Dumbbell Bench Press");
		exercises.add("Standing Cable Fly");
		exercises.add("Incline Bench Press");
		exercises.add("Overhead Press");
		exercises.add("Lateral Raise");
		exercises.add("Skullcrusher");
		exercises.add("Hanging Leg Raise");
		exercises.add("Exercises");//flag
		user.addDailyCalorieOut(exercises);
		expected =user.getMyWorkoutPlan().getCalorieBurned() + user.getBMR(); 
		actual = user.getCalBalances().get(0).getCalorieOut();

		assertEquals("calorieOut was not calculate properly",(Double)expected,(Double)actual);
				
		exercises.clear();
		
		DailyCalBalance d = new DailyCalBalance();
		user.getCalBalances().add(d);// start a new day
		
		exercises.add("Dumbbell Bench Press");
		exercises.add("Standing Cable Fly");
		exercises.add("Incline Bench Press");
		exercises.add("Overhead Press");
		exercises.add("Lateral Raise");
		exercises.add("Skullcrusher");
		exercises.add(null);
		user.addDailyCalorieOut(exercises);
		expected =((6.0/7.0) *user.getMyWorkoutPlan().getCalorieBurned()) + user.getBMR(); 
		actual = user.getCalBalances().get(1).getCalorieOut();
		assertEquals("calorieOut was not calculate properly",(Double)expected,(Double)actual);
	}
	
	@Test
	public void saveDetailsTest() {
		user.saveDetails();
		
		ObjectOutputStream oos = null;
		try
		{
			String fileName = "UserDetails.txt";
			
			// Open an FileOutputStream: can write a java object to a file
			oos = new ObjectOutputStream(new FileOutputStream(fileName));
			assertNotNull("File was not written properly", oos);

		} catch(Exception e)
		{
			e.printStackTrace();
		}       
		finally
		{
			// Close the file object
			if (oos != null)
				try {
					oos.close();
				} catch (IOException e) {					
					e.printStackTrace();
				}  
		}		
	}
	
	@Test
	public void readDetailsTest() {
		user.saveDetails();
		user.readDetails();
		assertEquals("File was not read properly","yaniv",user.getName());
		assertEquals("File was not read properly",20,user.getAge());
		assertEquals("File was not read properly","Male",user.getGender());
		assertEquals("File was not read properly",true,user.isVegan());
		assertEquals("File was not read properly",(Double)170.0,(Double)user.getHeight());
		assertEquals("File was not read properly",(Double)70.0,(Double)user.getWeight());
		assertEquals("File was not read properly",(Double)100.0,(Double)user.getGoalWeight());
		assertEquals("File was not read properly",(Double)1567.5,(Double)user.getBMR());
		assertEquals("File was not read properly","Weight Loss",user.getMyNutritionPlan().getMainGoal());
		assertEquals("File was not read properly","Fat Loss",user.getMyWorkoutPlan().getMainGoal());
		assertEquals("File was not read properly",(Double)0.0,(Double)user.getCalBalances().get(0).getCalorieIn());

		
		//test if changes are saved
		user.setName("New name");
		user.getCalBalances().get(0).setCalorieIn(100.0);
		user.saveDetails();
		user.readDetails();
		assertEquals("File was not read properly","New name",user.getName());
		assertEquals("File was not read properly",(Double)100.0,(Double)user.getCalBalances().get(0).getCalorieIn());
		
		//test if file was not found
		user.setName("previous name");
		File file = new File("UserDetails.txt");
		assertTrue(file.delete()); // test if file was successfully deleted
		user.readDetails();
		assertEquals("File was not read properly","previous name",user.getName());		
	}
}


