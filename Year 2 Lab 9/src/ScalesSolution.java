import java.util.*;

public class ScalesSolution
{
	private String scasol;
	static private Random rand = new Random();
	
	//Creates a new scales solution based on a string parameter
	//The string parameter is checked to see if it contains all zeros and ones
	//Otherwise the random binary string generator is used (n = length of parameter)
	public ScalesSolution(String s) {
		boolean ok = true;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char si = s.charAt(i);
			if (si != '0' && si != '1')
				ok = false;
		}
		if (ok) {
			scasol = s;
		} else {
			scasol = RandomBinaryString(n);
		}
	}

	private static String RandomBinaryString(int n)
	{
		String s = "";
		//Code goes here
		//Create a random binary string of just ones and zeros of length n
		for(int i = 0; i < n; i++){
			s += rand.nextInt(2);
		}
		return(s);
	}
	
	public ScalesSolution(int n) 
	{
		scasol = RandomBinaryString(n);	
	}
	
	//This is the fitness function for the Scales problem
	//This function returns -1 if the number of weights is less than
	//the size of the current solution
	public double ScalesFitness(ArrayList<Double> weights)
	{
		if (scasol.length() > weights.size()) return(-1);
		double lhs = 0.0, rhs = 0.0;
		int n = scasol.length();
		
		//Check each element of scasol for a 0 (lhs) and 1 (rhs) add the weight wi
		//to variables lhs and rhs as appropriate
		for(int i = 0; i < scasol.length(); i++){
			if(scasol.charAt(i) == '1')
			{
				rhs+=weights.get(i);
			} else lhs+=weights.get(i);
		}
		return(Math.abs(lhs-rhs));
	}
	
	//Display the string without a new line
	public void print()
	{
		System.out.print(scasol);
	}
	//Display the string with a new line
	public void println()
	{
		print();
		System.out.println();
	}
	
	//change a random entry in the string
	public void smallChange(){
		int idx = CS2004.UI(0, scasol.length()-1);
		char c;
		//switch char;
		if(scasol.charAt(idx) == '0') c = '1';
		else c = '0';
		scasol = scasol.substring(0, idx) + c + scasol.substring(idx+1);
	}
	
	public String getScasol(){
		return this.scasol;
	}
}
