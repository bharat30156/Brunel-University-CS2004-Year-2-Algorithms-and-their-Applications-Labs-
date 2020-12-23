import java.util.Arrays;

/**
 * 
 * @author bharat30156
 *
 */

public class PrefixAlgorithmApproach2 {
	
	public static double[] PrefixAverageAlgorithm(double [] X )
	{
		if(X == null || X.length == 0)
			return null;
		
		double s = 0;
		for(int i = 0; i <= X.length - 1; i++) 
		{
			s = s + X[i];
			X[i] = s/(i + 1);
		}
		
		return X;
	}
	
	public static void RunAlgorithm()
	{
		long StartTime, EndTime, ElapsedTime;
		
		System.out.println("Testing the Algorithm : ");
		StartTime = System.nanoTime();
		
		double [] A = {7, 3, -1, 2, 9 ,0, 0.8, 52, 2.2, 900};
		System.out.println(Arrays.toString(PrefixAverageAlgorithm(A)));
		
		EndTime = System.nanoTime();
		
		//calculating Elapsed Time
		ElapsedTime = EndTime - StartTime;
		
		System.out.println("The Algorithm took " + ElapsedTime + " NanoSeconds To Run.");
	}
	public static void main (String[] args)
	{
		RunAlgorithm();
	}
}
