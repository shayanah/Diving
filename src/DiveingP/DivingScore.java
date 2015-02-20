package DiveingP;

import java.util.Scanner;
public class DivingScore {

	private static final int judgesNumber = 7;
	//private static double[]judgesVote;
	public static double  inputValidScore()
	{
		Scanner in = new Scanner(System.in);
		double score;	
		score = in.nextDouble();
		if(score <= 10 && score >= 0)
			return score;
		else
		{
			System.out.println("The given score is not valid.");
			return -1;
		}
	}
	public static double[] inputAllScores()
	{
		double[] judgesVote = new double[judgesNumber];
		for(int i = 0 ; i < judgesNumber; i++)
		{
			do
			{
				System.out.print("Judge " +"#" + (i+1) + " score ");
				judgesVote[i] = inputValidScore();
			}
			while(judgesVote[i] == -1);
		}
		return judgesVote;
	}
	public static double inputValidDegreeOfDifficulty(double difficultyDegree)
	{
		if(difficultyDegree <= 3.8 && difficultyDegree >= 1.2)
			return difficultyDegree;
		else
		{
			System.out.println("The given Difficulty Degree is not valid");
			return -1;
		}
	}
	
	public static double calculateScore(double difficultyDegree,double []judges)
	{
		double maxIndex = findMaxIndex(judges);
		double minIndex = findMinIndex(judges);

		double sum = 0;
		for(int i=0 ; i < judges.length; i++)
		{	
			if(i != maxIndex && i != minIndex)
				sum += judges[i];
		}
		return 0.6 * difficultyDegree * sum;
	}
	private static int findMinIndex(double []judges) {
		double min = judges[0];
		int minIndex = 0;
		for(int i = 1; i < judgesNumber; i++)
		{
			if(judges[i] < min)
			{
				min = judges[i];
				minIndex = i;
			}
				
		}
		return minIndex;
	}
	private static int findMaxIndex(double []judges) {
		double max = judges[judgesNumber-1];
		int maxIndex = judgesNumber-1;
		for(int i = 0; i < judgesNumber-1; i++)
		{
			if(judges[i] > max)
			{
				max = judges[i];
				maxIndex = i;
			}
				
		}
		return maxIndex;
	}
	public static void print(){}
}
