import java.util.ArrayList;

public class Main {
	
	final static double TARGET_RANGE = 95000;
	final static int ITER = 10000; // no need to put this over ~20000
	static double ACCEPTABLE_DIFFERENCE = TARGET_RANGE/1000;
	
	public static void main (String[] ags)
	{
		Exercise1();
		Exercise2();
	}
	
	public static void Exercise1()
	{
		double r = Cannon.GetMaxRange(40.0, 1575.0);
		System.out.println(r);
		ArrayList<Double> xt = Cannon.GetX();
		ArrayList<Double> yt = Cannon.GetY();
		System.out.println(xt.size());
		System.out.println(yt.size());
	}
 	
	//hill climbing method to solve 10.4
	public static void Exercise2()
	{
		long start = System.currentTimeMillis();
		CannonSolution cannonTest = rmhcRange(40, 1500, ITER);
		System.out.println("Time Taken = " + (System.currentTimeMillis() - start));
		cannonTest.print();
		System.out.println();
		
		System.out.println(ACCEPTABLE_DIFFERENCE);
	}
	
	//random mutation hill climbing solution for cannon Range
	public static CannonSolution rmhcRange(double angle, double startingVelocity, int iter)
	{
		CannonSolution rtnSoln =  new CannonSolution(angle, startingVelocity);
		CannonSolution testSoln = new CannonSolution(rtnSoln);
		double testFitness;
		double rtnSolnFitness = rtnSoln.checkFitness(TARGET_RANGE);
		
		for(int i = 0; i < iter; i++)
		{
			testSoln = new CannonSolution(rtnSoln);
			testSoln.rhmcSmallMod();
			testFitness = testSoln.checkFitness(TARGET_RANGE);
			
			if(testFitness < rtnSolnFitness)
			{
				rtnSoln = new CannonSolution(testSoln);
				rtnSolnFitness = testFitness;
			}
		}
		
		return rtnSoln;
	}
	
	//this is faster and less accurate. Both methods need to be rewritten for robustness. 
	public static CannonSolution rmhcRangeLimited(double angle, double startingVelocity, int iter)
	{
		CannonSolution rtnSoln = new CannonSolution(angle, startingVelocity);
		CannonSolution testSoln = new CannonSolution(rtnSoln);
		double testFitness;
		double rtnSolnFitness = rtnSoln.checkFitness(TARGET_RANGE);
			
		for(int i = 0; i < iter; i++)
		{
			testSoln = new CannonSolution(rtnSoln);
			testSoln.rhmcSmallMod();
			testFitness = testSoln.checkFitness(TARGET_RANGE);
			
			if(testFitness < rtnSolnFitness)
			{	
				rtnSoln = new CannonSolution(testSoln);
				rtnSolnFitness = testFitness;
			}
			
			//this is the only difference between this and the top solution
			double breakVal = Math.abs(rtnSoln.getCannonarnge() - ACCEPTABLE_DIFFERENCE);
			if(breakVal <= ACCEPTABLE_DIFFERENCE) 
			{
				System.out.println(breakVal);
				break;
			}
		}
			
		return rtnSoln;
	}	

}
