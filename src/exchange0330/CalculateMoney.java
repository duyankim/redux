package Exchange0330;

public class CalculateMoney {
	Balance balance = new Balance();
	
	public double exchangeOutput (int won, double RATE, String currency) {
		double totalOutput;
		totalOutput = won / RATE;
		if (balance.checkBalance(totalOutput, currency) == true) {
			return totalOutput;
		} else {
			return 0.0;
		}
	}

	public void exchangeToKRW(double notWonChange, double RATE) {
		int wonOutput;
		wonOutput = (int)((notWonChange * RATE)/10)*10;
		System.out.printf("거스름돈: %d원%n",wonOutput);
		
		int[] wonUnit = {1000, 500, 100, 10};
		printUnitOutput(wonUnit, wonOutput, "원");
		
		System.out.println("----------------------");
	}
	
	public void printUnitOutput(int[] unit, int money, String currency) {
		int i, amount=0;
		System.out.print(currency + "환산: ");
		
		for (i=0; i < unit.length; i++) {
			amount = money / unit[i];
			System.out.println("\t" + unit[i] + currency + "\t" + amount + "개");
			money = money % unit[i];
		}	
	}
	
}
