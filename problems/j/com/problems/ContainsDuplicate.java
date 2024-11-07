package j.com.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an integer array nums,
 * return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        testExpectedResultTrue();
        testExpectedResultFalse();
        testExpectedResultTrue2();
    }

    public static boolean containsDuplicateMap(int[] nums) {
        Map<Integer, Integer> mapNums = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mapNums.containsKey(nums[i])) {
                return true;
            }
            mapNums.put(nums[i], i);
        }
        return false;
    }

    public static boolean containsDuplicateSet(int[] nums) {
        Set<Integer> setNums = new HashSet<>();
        for (int num : nums) {
            if (setNums.contains(num)) {
                return true;
            }
            setNums.add(num);
        }
        return false;
    }

    private static void testExpectedResultTrue() {
        logResults(new int[]{1, 2, 3, 1});
    }

    private static void testExpectedResultTrue2() {
        logResults(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2});
    }

    private static void testExpectedResultFalse() {
        logResults(new int[]{1, 2, 3, 4});
    }

    private static void logResults(int[] nums) {
        LoggerUtil.log(ContainsDuplicate.class, "containsDuplicateMap: " + containsDuplicateMap(nums),
                "\ncontainsDuplicateSet: " + containsDuplicateSet(nums));
    }
}
