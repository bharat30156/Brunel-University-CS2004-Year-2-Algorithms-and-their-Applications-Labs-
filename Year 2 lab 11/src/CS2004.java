import java.util.*;
import java.io.*;

//Some useful code that we will probably reuse in later laboratories...
public class CS2004 
{
	//Shared random object
	static private Random rand;
	static private int randSeed = 0;
	
	//Create a uniformly distributed random integer between aa and bb inclusive
	static public int UI(int aa,int bb)
	{
		int a = Math.min(aa,bb);
		int b = Math.max(aa,bb);
		if (rand == null) 
		{
			rand = new Random(randSeed);
			rand.setSeed(System.nanoTime());
		}
		int d = b - a + 1;
		int x = rand.nextInt(d) + a;
		return(x);
	}
	
	//Create a uniformly distributed random double between a and b inclusive
	static public double UR(double a,double b)
	{
		if (rand == null) 
		{
			rand = new Random(randSeed);
			rand.setSeed(System.nanoTime());
		}
		return((b-a)*rand.nextDouble()+a);
	}
	
	//This method reads in a text file and parses all of the numbers in it
	//This code is not very good and can be improved!
	//But it should work!!!
	//It takes in as input a string filename and returns an array list of Doubles
	static public ArrayList<Double> ReadNumberFile(String filename)
	{
		ArrayList<Double> res = new ArrayList<Double>();
		Reader r;
		try
		{
			r = new BufferedReader(new FileReader(filename));
			StreamTokenizer stok = new StreamTokenizer(r);
			stok.parseNumbers();
			stok.nextToken();
			while (stok.ttype != StreamTokenizer.TT_EOF) 
			{
				if (stok.ttype == StreamTokenizer.TT_NUMBER)
				{
					res.add(stok.nval);
				}
				stok.nextToken();
			}
		}
		catch(Exception E)
		{
			System.out.println("+++ReadFile: "+E.getMessage());
		}
	    return(res);
	}
	
	/*
	 public static void main(String args[]) {
		
		//spare code - keep for coderunner
		/*
		for(int i=0;i<10;++i)
		{
			int x = CS2004.UI(-1, 1);
			System.out.println(x);
		}
		*/
		/*
		ArrayList<Double> arr = ReadNumberFile("H:\\eclipseWorkspace\\CS2004_Lab8\\res\\1000 Primes.txt");
		ScalesSolution scalesSolution = new ScalesSolution(1000);
		ArrayList<Long> times = new ArrayList<Long>();
		long startTime;
		
		for (int i = 0; i < 10; i++) {
			startTime = System.currentTimeMillis();
			
			//generate new solution
			scalesSolution = new ScalesSolution(1000); 
			
			//test solutions
			while (scalesSolution.ScalesFitness(arr) > 100) {
				scalesSolution.println();
				scalesSolution = new ScalesSolution(1000);
				System.out.println(scalesSolution.ScalesFitness(arr));
			}
			times.add(System.currentTimeMillis()-startTime);
		}
		
		for(long l: times){
			System.out.print(l + ", ");
		}
		
	}
	*/
	
}