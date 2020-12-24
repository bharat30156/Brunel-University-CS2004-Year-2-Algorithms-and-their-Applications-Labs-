import java.util.ArrayList;
import java.util.Random;

public class Lab8 {
	
	//Random Integer between 3 and 12
	public static void Exercise2()
	{
		System.out.println("Radom Numbers Between 3 and 12 :");
		for(int i=0;i<10;++i)
		{
			int x = CS2004.UI(3, 12);
			System.out.println(x);
		}
		
		System.out.println("Random real Numbers : ");
		for(int i = 0; i < 10; i++)
		{
			double y = CS2004.UR(-1.0, 1.0);
			System.out.println(y);
		}
	}
	
	public static void Exercise3and4()
	{
		System.out.println("Exercise 3 : ");
		ScalesSolution s = new ScalesSolution(5);// To generate random Binary String Enter length of binary String, Also we can give specific binary String like "1010"
		s.println();
		
		ArrayList<Double> weights = CS2004.ReadNumberFile("E:\\1000 Prime Numbers.txt"); //read the file to calculate the fitness function
		
		for(int i = 0; i <=  10; i++)
		{
			double x = ScalesSolution.ScalesFitness(weights);
			System.out.println(x);
		}
	
		
		/**ArrayList<Double> weights = new ArrayList<>();
		weights.add(1.0);
		weights.add(2.0);
		weights.add(3.0);
		weights.add(4.0);
		weights.add(10.0);
		
		double x = ScalesSolution.ScalesFitness(weights);
		System.out.println(x);*/
		
	}
	
	public static void main(String [] args)
	{
		//Exercise 2
		Exercise2();
		
		//Exercise 3
		Exercise3and4();
		
	}
}

