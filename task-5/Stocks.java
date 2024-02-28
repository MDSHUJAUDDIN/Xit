import java.util.*;
import java.lang.*;
import java.lang.Integer;

class Stocks {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            // Update the minimum price encountered so far
            minPrice = Math.min(minPrice, price);
            // Update the maximum profit if selling at the current price yields a better profit
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of days: ");
        int n = scanner.nextInt();
        int[] prices = new int[n];
        System.out.println("Enter the prices for each day:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        Stocks stocks = new Stocks();
        int maxProfit = stocks.maxProfit(prices);
        System.out.println("Maximum profit: " + maxProfit);
    }
}

