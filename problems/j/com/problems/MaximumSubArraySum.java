package j.com.problems;

/**
 * Given an array sums,
 * the task is to find the subarray that has the maximum sum
 * and return its sum.
 */
public class MaximumSubArraySum {

    public static void main(String[] args) {
        testExpectedResult6();
        testExpectedResult15();
        testExpectedResultNegative1();
        testExpectedResult7();
        testExpectedResult0();
    }

    public static int maxSum(int[] nums) {
        int sum1 = 0;
        int sum2 = Integer.MIN_VALUE;

        for (int num : nums) {
            sum1 += num;
            sum2 = Math.max(sum2,sum1);

            if (sum1 < 0){
                sum1 = 0;
            }
        }
        return sum2;
    }


    private static void testExpectedResult6() {
        logResults(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }

    private static void testExpectedResult15() {
        logResults(new int[]{1,2,3,4,5});
    }

    private static void testExpectedResultNegative1() {
        logResults(new int[]{-1,-2,-3,-4,-5});
    }

    private static void testExpectedResult7() {
        logResults(new int[]{1,0,2,0,3,0,1});
    }

    private static void testExpectedResult0() {
        logResults(new int[]{0,-1,0,-2,0,-3,-4});
    }

    private static void logResults(int[] prices) {
        LoggerUtil.log(BestTimeToBuyAndSellStock.class, "maxSum: " + maxSum(prices));
    }

}
