import java.util.Random;

/**
 * GenerateNumberNotInArray class that implements a generate method that returns
 * a number with a constraint on the digit size, that is not in the array given.
 * 
 * @author Jeff
 *
 */
public class GenerateNumberNotInArray 
{
	public GenerateNumberNotInArray()
	{
		
	}
	
	/**
	 * Generates random number with a size constraint, given by digitConstraint,
	 * that is not in the array given. 
	 * 0 < digitConstraint < 10 (minimum 1 and maximum 9 digits long)
	 * 
	 * @param digitConstraint
	 * @param array
	 * @return generatedNumber that is not in the array given
	 * @return -1 if digitConstraint is not in the range 1-9
	 */
	
	public int generate (int digitConstraint, int[] array)
	{
		//Checks digitConstraint interval is right otherwise return -1
		if (digitConstraint <= 0 || digitConstraint >= 10)
			return -1;
		
		int zeroConstraint = findZeroConstraint(digitConstraint);
		
		//variables that help with the finding of a number between a min and a max
		int min = zeroConstraint;
		int max = findNineConstraint(digitConstraint);
		
		int randomNum = findCorrectNumber(min, max, array);
		System.out.println(" " + min + " " + max);
		return randomNum;			
	}
	
	private int findCorrectNumber(int min, int max, int[] array) 
	{
		//creates a new Random instance
		Random rand = new Random();
		
		int randomNum = rand.nextInt((max - min) + 1) + min;
		
		while(isInArray(randomNum, array))
		{
			randomNum = rand.nextInt((max - min) + 1) + min;
		}
		
		return randomNum;
	}

	/**
	 * Finds if a number is in the array
	 * 
	 * @param randomNum
	 * @param array
	 * @return true if number is in array
	 * @return false if number is not in array
	 */
	private boolean isInArray(int randomNum, int[] array) 
	{
		for (int i=0 ; i<array.length ; i++)
		{
			if(randomNum == array[i])
				return true;
		}
		return false;
	}

	/**
	 * Finds a value that is defined as a nine followed by digitConstraint nines
	 * 
	 * @param digitConstraint
	 * @return 9 followed by digitConstraint nines
	 */
	private int findNineConstraint(int digitConstraint) 
	{
		int returnValue = 0;
		while(digitConstraint != 0)
		{
			digitConstraint -= 1;
			returnValue *= 10;
			returnValue += 9;
		}
		return returnValue;
	}

	/**
	 * Finds a value that is defined as a one followed by digitConstraint zeros
	 * 
	 * @param digitConstraint
	 * @return 1 followed by digitConstraint zeros
	 */
	private int findZeroConstraint(int digitConstraint)
	{
		int returnValue = 1;
		while(digitConstraint != 0)
		{
			digitConstraint -= 1;
			returnValue *= 10;
		}
		return returnValue/10;
	}
}

