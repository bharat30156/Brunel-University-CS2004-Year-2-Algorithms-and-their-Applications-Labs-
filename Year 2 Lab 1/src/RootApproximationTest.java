import javax.swing.JOptionPane;
import java.util.Random;

public class RootApproximationTest {
	
	public static void RunAlgorithm()
	{
		//creating variables to calculate the Time
		long StartTime, EndTime, ElapsedTime;
		System.out.println("Testing Algorithm :" );
		
		//save the time before the algorithm
		StartTime = System.nanoTime();
		
		/**
		 * calling the code
		 */
		//create the instance of Random Class
		Random rand = new Random();
				
		//Generate the random Integers to Calculate Square Root
		int Rand_int = rand.nextInt(100);
		
	  /*boolean done = false;
		while(!done)
		{
			String input = JOptionPane.showInputDialog("Enter a Number");
			if(input == null)
			{
				done = true;
			}
			else
			{
				double x = Double.parseDouble(input);
				HeronsAlgorithm HA = new HeronsAlgorithm(x);
				double y = HA.getRoot();
						
				System.out.println("Square Root of " + x + " = " + y);
			}
		}*/
				
		String str = String.valueOf(Rand_int);
		double z = Double.parseDouble(str);
				
		//creating the object
		HeronsAlgorithm Ha = new HeronsAlgorithm(z);
		double m = Ha.getRoot();
				
		//print it out
		System.out.println("Square Root of" + z + " = " + m);
		
		//save the time after the algorithm
		EndTime = System.nanoTime();
		
		//calculate the Difference
		ElapsedTime = EndTime - StartTime;
		
		//print it out
		System.out.println("The algorithm took " + ElapsedTime + " NanoSeconds to run.");
		
	}
	
	public static void main(String [] args)
	{
		RunAlgorithm();
	}
}

