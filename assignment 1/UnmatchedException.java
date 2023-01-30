package assignment1;

public class UnmatchedException extends Exception
{
	public UnmatchedException() 
	{
		System.out.println("The passwords do not match");
	}
}
//Throw this exception from the GUI, not the utility class.