

/**
 * 
 * @author Bharat
 *
 */
public class LinearSummation {
	
	/**
	 * using Recursion
	 */
	public static int linearSum(int[] A, int n)
	{
		//creating the base Condition to Terminate the recursive Case
		if(n == 1)
		{
			return A[0];
		}
		//defining the Condition
		else if(n > 0)
		{
			return linearSum(A,n-1)+A[n-1];
		}
		//defining the unwanted case
		else
		{
			return -1;
		}
	}
	
	public static void RunAlgorithm()
	{
		//creating variables to calculate the Time
		long StartTime, EndTime, ElapsedTime;
		System.out.println("Testing Algorithm :" );
		
		//save the time before the algorithm
		StartTime = System.nanoTime();
		
		/**
		 * calling the Method
		 */
		// creating the array to sum all the numbers in the array
		int[] array = {0,1,2,3,4,5,6,7,8,9,10};
		//iterating the length of the array
		int length = array.length;
		//Print it out
		System.out.println("(Using Recursion) Sum of the Numbers in the Array : " +linearSum(array, length));
		
		/**
		 * Using For Loop
		 */
		int sum = 0;
		for(int i = 1; i <= 100; i++)
		{
			sum += i;
		}
		System.out.println("(Using For Loop)The Sum of 1 - 100 is : " + sum);
		
		//save the time after the algorithm
		EndTime = System.nanoTime();
		
		//calculate the Difference
		ElapsedTime = EndTime - StartTime;
		
		//print it out
		System.out.println("The algorithm took " + ElapsedTime + " NanoSeconds to run.");
		
	}
	
	public static void main(String[] args)
	{
		RunAlgorithm();
	}
}
