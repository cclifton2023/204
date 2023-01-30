package assignment1;
//import java.io.*;
//import java.lang.*;
import java.util.*;
import java.util.regex.*;
import java.rmi.*;

public class PasswordCheckerUtility 
{
	PasswordCheckerUtility()
	{
		
	}
	public static void comparePasswords​(java.lang.String password, java.lang.String passwordConfirm) throws UnmatchedException
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
	public static boolean comparePasswordsWithReturn​(java.lang.String password, java.lang.String passwordConfirm)
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
	public static boolean isValidLength​(java.lang.String password) throws LengthException
	{
		if (password.length() < 6) //if the password is not at least 6 characters
			throw new LengthException();
		else
			return true;
	}
	public static boolean hasUpperAlpha​(java.lang.String password) throws NoUpperAlphaException
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
	public static boolean hasLowerAlpha​(java.lang.String password) throws NoLowerAlphaException
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
	public static boolean hasDigit​(java.lang.String password) throws NoDigitException
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
	public static boolean hasSpecialChar​(java.lang.String password) throws NoSpecialCharacterException
	{
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		
		if (matcher.matches())
			throw new NoSpecialCharacterException();
		else
			return true;
	}
	public static boolean NoSameCharInSequence​(java.lang.String password) throws InvalidSequenceException
	{
		
	}
	public static boolean isValidPassword​(java.lang.String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException,InvalidSequenceException
	{
		if(isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasDigit(password) && hasSpecialChar(password) && NoSameCharInSequence(password))
			return true;
		else
			return false;
	}
	public static boolean hasBetweenSixAndNineChars​(java.lang.String password)
	{
		if (password.length() >= 6 && password.length() <= 9) //if the password is between 6-9 (inclusive)
			return true;
		else
			return false;
	}
	public static boolean isWeakPassword​(java.lang.String password) throws WeakPasswordException
	{
		
	}
	public static java.util.ArrayList<java.lang.String> getInvalidPasswords​(java.util.ArrayList<java.lang.String> passwords)
	{
		
	}
}
