
public class Numeric {
	
	public static boolean approxEqual(double x, double y)
	{
	      final double EPSILON = 1E-10;
	      if (Math.abs(x-y)<EPSILON)
	      {
	    	  return(true);
	      }
	      return(false);
 	
	}
}
