package assignment1;

public class UnmatchedException extends Exception
{
	public UnmatchedException() 
	{
		super("The passwords do not match");
	}
}
//Throw this exception from the GUI, not the utility class.