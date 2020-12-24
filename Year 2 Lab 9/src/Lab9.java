import java.util.ArrayList;

public class Lab9 {
	static final String PRIME_FILEPATH = "E:\\1000 Prime Numbers.txt";
	
	//Random mutation hill climbing implementation
	public static ScalesSolution RMHC(ArrayList<Double> weights, int n, int iter)
	{
		ScalesSolution sol = new ScalesSolution(n);
		ScalesSolution oldSol = new ScalesSolution(sol.getScasol());
		double fitness;
		double oldFitness;
		
		for(int i = 0; i < iter; i++)
		{
			oldSol = new ScalesSolution(sol.getScasol());
			oldFitness = sol.ScalesFitness(weights);
			oldSol.smallChange();
			fitness = oldSol.ScalesFitness(weights);
			
			if(fitness < oldFitness)
			{
				sol = new ScalesSolution(oldSol.getScasol());
			}
		}
		
		return sol;
	}
	
	public static void main (String [] args)
	{
		ScalesSolution s1 = new ScalesSolution(10);
		ArrayList<Double> arr = CS2004.ReadNumberFile(PRIME_FILEPATH);
		
		s1 = RMHC(arr, 1000, 500);
		
		System.out.println(s1.ScalesFitness(arr));
	}

}
