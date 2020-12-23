/**
 * 
 * @author Bharat
 *
 */
public class HeronsAlgorithm {
	
	private double a;
	private double xnew;
	private double xold;
	//constructs Herons algorithm for a given number 
	public HeronsAlgorithm(double aNumber)
	{
		a = aNumber;
		xold = 1;
		xnew = a;
	}
	
	public double nextGuess()
	{
		xold = xnew;
		if(xold != 0)
		{
			xnew =(xold + a / xold) / 2;
		}
		return xnew;
	}
	
	public double getRoot()
	{
		while(!Numeric.approxEqual(xnew, xold))
		{
			nextGuess();
		}
		return xnew;
	}
	
	
	
	
	

}

