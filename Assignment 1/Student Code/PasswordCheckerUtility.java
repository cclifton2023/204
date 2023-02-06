package assignment1;
//import java.io.*;
//import java.lang.*;
import java.util.*;
import java.util.regex.*;
//import java.rmi.*;

public class PasswordCheckerUtility extends java.lang.Object
{
	PasswordCheckerUtility()
	{
		
	}
	public static void comparePasswords(java.lang.String password, java.lang.String passwordConfirm) throws UnmatchedException
	{
		if (password.length() != passwordConfirm.length())
			throw new UnmatchedException();
		else
		{
			for (int i = 0; i < password.length(); i++)
			{
				if(password.charAt(i) != passwordConfirm.charAt(i))
					throw new UnmatchedException();
			}
		}
	}
	public static boolean comparePasswordsWithReturn(java.lang.String password, java.lang.String passwordConfirm)
	{
		if (password.length() != passwordConfirm.length())
			return false;
		else
		{
			for (int i = 0; i < password.length(); i++)
			{
				if(password.charAt(i) != passwordConfirm.charAt(i))
					return false;
			}
			return true;
		}
	}
	public static boolean isValidLength(java.lang.String password) throws LengthException
	{
		if (password.length() < 6) //if the password is not at least 6 characters
			throw new LengthException();
		else
			return true;
	}
	public static boolean hasUpperAlpha(java.lang.String password) throws NoUpperAlphaException
	{
		int count = 0;
		for (int i = 0; i < password.length(); i++)
		{
			if(Character.isUpperCase(password.charAt(i)))
			{
				count++;
			}
		}
		if (count == 0)
			throw new NoUpperAlphaException();
		else
			return true;
	}
	public static boolean hasLowerAlpha(java.lang.String password) throws NoLowerAlphaException
	{
		int count = 0;
		for (int i = 0; i < password.length(); i++)
		{
			if(Character.isLowerCase(password.charAt(i)))
			{
				count++;
			}
		}
		if (count == 0)
			throw new NoLowerAlphaException();
		else
			return true;
	}
	public static boolean hasDigit(java.lang.String password) throws NoDigitException
	{
		int count = 0;
		for (int i = 0; i < password.length(); i++)
		{
			if(Character.isDigit(password.charAt(i)))
			{
				count++;
			}
		}
		if (count == 0)
			throw new NoDigitException();
		else
			return true;
	}
	public static boolean hasSpecialChar(java.lang.String password) throws NoSpecialCharacterException
	{
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		
		if (matcher.matches())
			throw new NoSpecialCharacterException();
		else
			return true;
	}
	public static boolean NoSameCharInSequence(java.lang.String password) throws InvalidSequenceException
	{
		char c;
		for (int i = 0; i < password.length() - 2; i++)
		{
			c = password.charAt(i);
			if (c == password.charAt(i+1) && c == password.charAt(i+2))
				throw new InvalidSequenceException();
		}
		return true;
	}
	public static boolean isValidPassword(java.lang.String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{
		try 
		{
			isValidLength(password);
			hasUpperAlpha(password);
			hasLowerAlpha(password);
			hasDigit(password);
			hasSpecialChar(password);
			NoSameCharInSequence(password);
		}
		catch(LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException | 
				NoSpecialCharacterException | InvalidSequenceException e)
		{
			e.getMessage();
		}
		finally
		{
			if(isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasDigit(password) && hasSpecialChar(password) && NoSameCharInSequence(password))
				return true;
		}
		return false;
	}
	public static boolean hasBetweenSixAndNineChars(java.lang.String password)
	{
		if (password.length() >= 6 && password.length() <= 9) //if the password is between 6-9 (inclusive)
			return true;
		else
			return false;
	}
	public static boolean isWeakPassword(java.lang.String password) throws WeakPasswordException
	{
		boolean valid = false;
		try 
		{
			valid = isValidPassword(password);
		}
		catch(LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException | 
				NoSpecialCharacterException | InvalidSequenceException e)
		{
			e.getMessage();
		}
		finally
		{
			if (valid && hasBetweenSixAndNineChars(password))
				throw new WeakPasswordException();
		}
		return false;
	}
 	public static ArrayList<java.lang.String> getInvalidPasswords(ArrayList<java.lang.String> passwords)
	{
		ArrayList<java.lang.String> invPasswords = new ArrayList<java.lang.String>();
		String invalid = "";
		
		for(int i = 0; i < passwords.size(); i++)
		{
			try
			{
				invalid = passwords.get(i);
				isValidPassword(invalid);
				
			}
			catch(LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException | 
					NoSpecialCharacterException | InvalidSequenceException e)
			{
				invPasswords.add(invalid + " -> " + e.getMessage());
			}
		}
		return invPasswords;
	}
}