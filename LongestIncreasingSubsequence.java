package pack;

import java.util.Random;

public class LongestIncreasingSubsequence
{
	static int lISV;
	
	//For the subsequence 0-n of the sequence array, the longest increasing subsequence ending at n is returned
	static int recursiveSolver(int sequenceArray[], int n)
	{
		//The longest subsequence for a single element array is 1
		if (n == 1)
			return 1;
		
		int currentIncreasingSubsequence = 1;	//Essentially this represents the largest increasing subsequence of the sequence i compares itself to 
		int maxIncreasingSubsequenceSoFar = 1;	//Every element of the array has a largest increasing subsequence of 1 by default
		
		//takes the subset up to n and
		for (int i = 1; i < n; i++)
		{
			//What is the current largest increasing subsequence ending at point i
			currentIncreasingSubsequence = recursiveSolver(sequenceArray, i);
			
			//If this value is is greater than the value of i being compared to and i's subsequence is greater than the maxIncreasingSubsequenceSoFar
			if (sequenceArray[i-1] < sequenceArray[n-1] && currentIncreasingSubsequence + 1 > maxIncreasingSubsequenceSoFar) 
				maxIncreasingSubsequenceSoFar = currentIncreasingSubsequence + 1; 
		}
		
		//at every element of the array, this is changed if the value is greater than all those before it
		if (lISV < maxIncreasingSubsequenceSoFar) 
			lISV = maxIncreasingSubsequenceSoFar; 
		
		//Returns the largest increasing subsequence ending at point n
		return maxIncreasingSubsequenceSoFar;
	}
	
	//Used to call the recursive function to get the longest increasing subsequence
	static int callRecursiveSolver(int testSequence[], int n)
	{
		lISV = 1;
		
		recursiveSolver(testSequence, n);
		
		return lISV;
	}
	
	//The following creates a test sequence and prints the longest increasing subsequence of said testSequence
	//Because there are n elements and O(n) linear time is required for each n element, we know that the time complexity is (at worst) O(n^2)
	//So this will take a while to run the larger the testsequence is
	public static void main(String[] args)
	{
		Random rand = new Random(); 
		
		int [] testSequence = new int[20];
		
		int n = testSequence.length;
		
		System.out.print("The sequence is {");
		for (int i = 0; i < n; i++)
		{
			testSequence[i] = rand.nextInt(100);
			System.out.print(testSequence[i]);
			
			if(i != n-1)
				System.out.print(", ");
			else
				System.out.print("}\n");
		}
		
		int lIS = callRecursiveSolver(testSequence, n);
		
		System.out.println("The longest increasing subsequence of is " + lIS);
	}
}
