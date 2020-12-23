import java.util.ArrayList;
import java.util.Random;

public class Lab6 {
	
	//creating method randomNum to generating Random Numbers
	public static int randomNum()
	{
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		Integer r = Math.abs(rand.nextInt() % 256);
		return r;
	}
	
	//creating method RandomArray that return ArrayLists of Random Numbers 
	public static ArrayList<Integer> RandomArray(int n)
	{
		ArrayList<Integer> arrayRandom = new ArrayList<>();
		for(int i = 0; i <= n - 1; i++ )
		{
			int value = randomNum();
			arrayRandom.add(i,value);
			try
			{
				Thread.sleep(1);
			}
			catch (InterruptedException ie)
			{
				ie.printStackTrace();
			}
		}
		return arrayRandom;
	}
	
	//creating a method ShowArray that display the content of ArrayList<Integer>
	public static void ShowArray(ArrayList<Integer> x)
	{
		System.out.println(x);
	}
	
	public static void main(String [] args)
	{
		int n = 10;
		
		ArrayList<Integer> x = RandomArray(n);
		
		System.out.println("Unsorted Array : ");
		ShowArray(x);
		
		System.out.println("Sort A: ");
		ShowArray(ThreeSorts.SortA(x));
		
		System.out.println("Sort B : ");
		ShowArray(ThreeSorts.SortB(x));
		
		System.out.println("Sort C :");
		ShowArray(ThreeSorts.SortC(x));
		
		
	}
}
