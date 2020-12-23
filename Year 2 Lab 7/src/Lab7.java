import java.util.Arrays;

public class Lab7 {
	
	public static void PrintArray(double array[][])
	{
		System.out.println(Arrays.deepToString(array));
	}
	
	public static double[][] RandomArray(int n)
	{
		double[][] matrix = new double[n][n];
		for(int row = 0; row < matrix.length; row++)
		{
			for(int column = 0; column < matrix[row].length; column++)
			{
				matrix[row][column] = 0 + (int)(Math.random() * ((100 - 0) + 1));
			}
		}
		
		return matrix;
	}
	
	public static void main(String[] args)
	{
		double [][] g = RandomArray(10);
		double [][] mst = MST.PrimsMST(g);
		PrintArray(g);
		PrintArray(mst);
	}
}
