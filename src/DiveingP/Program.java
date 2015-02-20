package DiveingP;

import java.util.Scanner;

public class Program {

	public static void main(String []args)
	{
		Scanner in = new Scanner(System.in);

		System.out.print("Degree of difficulty ");
		double DLevel = in.nextDouble();
		DivingScore.inputValidDegreeOfDifficulty(DLevel);
		
		double [] f = DivingScore.inputAllScores();
		

		
		double ans = DivingScore.calculateScore(DLevel,f);
		System.out.println(ans);
	}
}
