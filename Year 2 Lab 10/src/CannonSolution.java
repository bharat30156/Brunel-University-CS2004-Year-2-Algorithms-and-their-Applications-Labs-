import java.util.Random;

/**
 * 
 * @author Bharat
 *
 */
public class CannonSolution {
	
	final static double CANNON_ANGLE_LOWER_LIMIT = 25;
	final static double CANNON_ANGLE_UPPER_LIMIT = 55;
	static double cannonAngleIncrement = (CANNON_ANGLE_UPPER_LIMIT- CANNON_ANGLE_LOWER_LIMIT)/100;
	final static double CANNON_STARTING_VELOCITY_LOWER_LIMIT = 1500;
	final static double CANNON_STARTING_VELOCITY_UPPER_LIMIT = 1650;
	static double cannonStartingVelocityIncrement = (CANNON_STARTING_VELOCITY_UPPER_LIMIT -
			CANNON_STARTING_VELOCITY_LOWER_LIMIT)/100;
	
	double cannonRange;
	double cannonAngle;
	double cannonStartingVelocity;
	
	static private Random rand = new Random();
	
	public CannonSolution()
	{
		randomiseAngle();
		randomiseStartingVelocity();
		this.cannonRange = Cannon.GetMaxRange(this.cannonAngle, this.cannonStartingVelocity);
	}
	
	public CannonSolution(double angle, double startingVelocity)
	{
		this.cannonAngle = angle;
		this.cannonStartingVelocity = startingVelocity;
		this.cannonRange = Cannon.GetMaxRange(angle, startingVelocity);
	}
	
	public CannonSolution(CannonSolution original)
	{
		this.cannonAngle = original.cannonAngle;
		this.cannonStartingVelocity = original.cannonStartingVelocity;
		this.cannonRange = original.cannonRange;
	}
	
	public double getCannonarnge()
	{
		return this.cannonRange;
	}
	
	public void print()
	{
		System.out.println("Angle: " + this.cannonAngle);
		System.out.println("Starting Velocity: " + this.cannonStartingVelocity);
		System.out.println("Range: " + this.cannonRange);
	}
	
	static void checkRand()
	{
		if(rand == null)
		{
			rand =  new Random();
		}
	}
	
	void checkAngleIsInRange()
	{
		if(this.cannonAngle > CANNON_ANGLE_UPPER_LIMIT) this.cannonAngle = CANNON_ANGLE_UPPER_LIMIT;
		if(this.cannonAngle < CANNON_ANGLE_LOWER_LIMIT) this.cannonAngle = CANNON_ANGLE_LOWER_LIMIT;
	}
	
	void checkStartingVelocityIsRange()
	{
		if(this.cannonStartingVelocity > CANNON_STARTING_VELOCITY_UPPER_LIMIT) this.cannonStartingVelocity = CANNON_STARTING_VELOCITY_UPPER_LIMIT;
		if(this.cannonStartingVelocity < CANNON_STARTING_VELOCITY_LOWER_LIMIT) this.cannonStartingVelocity = CANNON_STARTING_VELOCITY_LOWER_LIMIT;
	}
	
	static public double randomDouble(double min, double max)
	{
		return (max - min) * rand.nextDouble() + min;
	}
	
	public void randomise()
	{
		this.randomiseAngle(); // is refrence to current obkect necessary
	}
	
	public void randomiseAngle()
	{
		this.cannonAngle = randomDouble(CANNON_ANGLE_LOWER_LIMIT, CANNON_ANGLE_UPPER_LIMIT);
	}
	
	public void randomiseStartingVelocity()
	{
		this.cannonStartingVelocity = randomDouble(CANNON_STARTING_VELOCITY_LOWER_LIMIT, CANNON_STARTING_VELOCITY_UPPER_LIMIT);
	}
	
	//This function return -1 if the solution is invalid , otherwise fitness is prop to return val
	public double checkFitness(double targetRange)
	{
		this.cannonRange =  Cannon.GetMaxRange(this.cannonAngle, this.cannonStartingVelocity);
		return Math.abs(this.cannonRange - targetRange);
	}
	
	//random Mutation hill Climbing methods
	public void rhmcSmallMod()
	{
		if(rand.nextBoolean()) rhmcSmallModAngle();
		else rhmcSmallModStartingVelocity();
	}
	
	public void rhmcSmallModAngle()
	{
		int coeff = 1;
		if(rand.nextBoolean()) coeff =  -1;
		this.cannonAngle += coeff*cannonAngleIncrement;
		checkAngleIsInRange();
	}
	
	public void rhmcSmallModStartingVelocity()
	{
		int coeff = 1;
		if(rand.nextBoolean()) coeff = -1;
		this.cannonStartingVelocity += coeff*cannonStartingVelocityIncrement;
		checkStartingVelocityIsRange();
	}
	

}
