/**\
 * 
 * @author Bharat
 *
 */
 class GeomatricSummation {
	
	 static float sumOfGS(float a, float r, int n)
	{
		float sum = 0;
		for(int i = 0; i < n; i++)
		{
			sum = sum + a;
			a = a * r;
		}
		return sum;
	}
	 
	 public static void RunAlgorithm()
	 {
		//creating variables to calculate the Time
		long StartTime, EndTime, ElapsedTime;
		System.out.println("Testing Algorithm :" );
			
		//save the time before the algorithm
		StartTime = System.nanoTime();
			
		/**
		 * calling method
		 */
		int a = 1;
		float r = (float)(1/2.0);
		int n = 10;
		 
		System.out.printf("%.5f",sumOfGS(a,r,n));
			
		//save the time after the algorithm
		EndTime = System.nanoTime();
			
		//calculate the Difference
		ElapsedTime = EndTime - StartTime;
			
		//print it out
		System.out.println("\nThe algorithm took " + ElapsedTime + " NanoSeconds to run.");
			
		} 
	
	 public static void main(String [] args)
	 {
		 RunAlgorithm();
	 }
	 

}


