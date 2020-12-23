public class PrefixAlgorithmApproach1 {
	
static int[] array = {10,11,91,801,800,802,803};
	
	// creating method to calculate the maximum value in the array
	public static int getMax()
	{
		//Initializing the max value in the array
		int maxValue = array[0];
		
		// using for loop to iterate the array
		for(int i = 1;  i < array.length; ++i)
			if(array[i] > maxValue)
				maxValue = array[i];
		
		//returning MaxValue
		return maxValue;
	}
	
	//creating the method to calculate the Elapsed of the algorithm 
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
		System.out.println("Max VAlue in the array " + getMax());	
		//save the time after the algorithm
		EndTime = System.nanoTime();
		
		//calculate the Difference
		ElapsedTime = EndTime - StartTime;
		
		//print it out
		System.out.println("The algorithm took " + ElapsedTime + " NanoSeconds to run.");
		
	}
	
	public static void main(String[] args)
	{
		//Calling the RunAlgorithm method
		RunAlgorithm();
		
	}
}

