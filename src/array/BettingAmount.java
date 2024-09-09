package array;

public class BettingAmount {

    public static void main(String[] args) {
        System.out.println(betBalance("WWLWLLL"));
    }
    static int betBalance(String result)
    {
        int amount = 4;
        int currentBet = 1;
        for (int i = 0; i < result.length(); i++) {
            if (amount < currentBet) {
                amount = -1;
                break;
            }
            if (result.charAt(i) == 'W') {
                amount += currentBet;
                currentBet = 1;
            } else {
                amount -= currentBet;
                currentBet *= 2;
            }
        }
        return amount;
    }
}
