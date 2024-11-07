package j.com.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target
 * You may assume that each input would have exactly one solution, and you may not use the same element twice
 */
class TwoSum {
    public static void main(String[] args) {
        testExpectedResult0and1();
        testExpectedResult0and3();
        testExpectedResult1and2();
        testExpectedResult3and4();
    }

    public static int[] twoSumArrayIteration(int[] nums, int target) {
        //O(n2)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public static int[] twoSumMap(int[] nums, int target) {
//        O(n)
        Map<Integer, Integer> mapNums = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (mapNums.containsKey(complement)) {
                return new int[]{mapNums.get(complement), i};
            }
            mapNums.put(nums[i], i);
        }
        return new int[0];
    }

    private static void testExpectedResult0and1() {
        logResults(new int[]{2, 7, 11, 15}, 9);
    }

    private static void testExpectedResult1and2() {
        logResults(new int[]{3, 2, 4}, 6);
    }

    private static void testExpectedResult0and3() {
        logResults(new int[]{1, 5, 9, 13}, 14);
    }

    private static void testExpectedResult3and4() {
        logResults(new int[]{1, 3, 7, 9, 2}, 11);
    }

    private static void logResults(int[] nums, int target) {
        LoggerUtil.log(TwoSum.class, "twoSumArrayIteration: " + Arrays.toString(twoSumArrayIteration(nums, target)),
                "twoSumMap: " + Arrays.toString(twoSumMap(nums, target)));
    }

}