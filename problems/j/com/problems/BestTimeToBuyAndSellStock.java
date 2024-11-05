package j.com.problems;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the i-th day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction.
 * If you cannot achieve any profit, return 0
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        testExpectedResult5();
        testExpectedResult0();
    }

    public static int profitUsingArrayIteration(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;

        for (int price : prices) {
            if(price < minPrice){
                minPrice = price;
            }
            else if(price - minPrice > profit){
                profit = price - minPrice;
            }
        }

        return profit;
    }


    private static void testExpectedResult5() {
        logResults(getLogger(), new int[]{7,1,5,3,6,4});
    }

    private static void testExpectedResult0() {
        logResults(getLogger(), new int[]{7,5,4,3,1});
    }

    private static Logger getLogger() {
        return Logger.getLogger(BestTimeToBuyAndSellStock.class.getName());
    }

    private static void logResults(Logger log, int[] prices) {
        log.log(Level.INFO, "profitUsingArrayIteration: " + profitUsingArrayIteration(prices));
    }
}
