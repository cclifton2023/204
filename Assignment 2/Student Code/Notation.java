package assignment2;
import java.util.*;
/*
 * Author @Caitlyn Clifton
 * Dr David Kuijt
 * CMSC 204
 */

/*
 * infix - each binary operator appears between its operands a + b 
 * prefix - each binary operator appears before its operands + a b 
 * postfix - each binary operator appears after its operands a b +
   Balanced expressions: delimiters paired correctly
 */
public class Notation extends java.lang.Object
{
	public Notation()
	{
		
	}
	public static double evaluatePostfixExpression(java.lang.String postfixExpr) throws InvalidNotationFormatException
	{
		//evaluates a postfix expression from a string to a double
	}
	public static java.lang.String convertPostfixToInfix(java.lang.String postfix) throws InvalidNotationFormatException
	{
		//Convert the Postfix expression to the Infix expression
		MyStack<String> stack = new MyStack<String>();
		
		char[] postfixChar = postfix.toCharArray();
		char c = ' ';
		try {
			for(int i = 0; i < postfixChar.length; i++)
			{
				c = postfixChar[i];
				if(c == '+' || c == '-' || c == '*' || c == '/' || c == '%')
				{
					if(stack.size() < 2)
						throw new InvalidNotationFormatException();
					else
					{
						String value = stack.pop();
						stack.push("(" + stack.pop() + c + value + ")");
					}
				}
				else //If the current character is an operand, push it on the stack
				{
					if(c != ' ')
						stack.push(String.valueOf(c));
				}
			}
			if(stack.size() > 1)
				throw new InvalidNotationFormatException();
		}
		catch(StackUnderflowException | StackOverflowException e)
		{
			e.getMessage();
		}
		return stack.toString();
	}
	public static java.lang.String convertInfixToPostfix(java.lang.String infix) throws InvalidNotationFormatException
	{
		//Convert an infix expression into a postfix expression
		MyStack<String> stack = new MyStack<String>();
		MyQueue<String> queue = new MyQueue<String>();
		char[] infixChar = infix.toCharArray();
		char c = ' ';
		
		try 
		{
			for(int i = 0; i < infixChar.length; i++)
			{
				if(c == '(') //If the current character in the infix is a left parenthesis, push it onto the stack 
					stack.push(String.valueOf(c));
				else if(c == ')')
				{
					while(!(stack.top().equals("(")))
					{
						if(stack.isEmpty())
							throw new InvalidNotationFormatException();
						else
						{
							queue.enqueue(stack.pop());
							if(stack.top().equals("("))
								stack.pop();
						}
					}
				}
				else if(c == '*' || c == '/' || c == '%' || c == '+' || c == '-') //operators
				{
					if(stack.size() < 2)
						throw new StackUnderflowException();
					else
					{
						String value = stack.pop();
						String str = "(" + stack.pop() + c + value + ")";
						queue.enqueue(str);
						stack.push(str);
					}
				}
				else
				{
					if(Character.isDigit(c)) //If the current character in the infix is a digit, copy it to the postfix solution queue
						queue.enqueue(String.valueOf(c));
				}
			}
		}
		catch(StackUnderflowException | StackOverflowException | QueueOverflowException e)
		{
			e.getMessage();
		}
		/*
		 * Read the infix expression from left to right and do the following: 


When the infix expression has been read, Pop any remaining operators and insert them in postfix solution queue.

		 */
		return queue.toString();
	}
}