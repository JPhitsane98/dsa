package j.com.problems;

import java.util.*;

/**
 * Given an integer array nums,
 * return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and uses only constant space(no division)
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static int[] productExceptSelfNotMeetingRequirement(int[] nums) {
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j <= i - 1; j++) {
                product *= nums[j];
            }
            for (int j = nums.length - 1; j >= i + 1; j--) {
                product *= nums[j];
            }
            answer[i] = product;
        }
        return answer;
    }

    public static int[] productExceptSelfMeetingRequirement(int[] nums) {
        int[] answer = new int[nums.length];

        int prefixProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            answer[i] = prefixProduct;
            prefixProduct *= nums[i];
        }

        int suffixProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return answer;
    }

    private static void test1() {
        //{24,12,8,6}
        logResults(new int[]{1, 2, 3, 4});
    }

    private static void test2() {
        //{0,0,9,0,0}
        logResults(new int[]{-1, 1, 0, -3, 3});
    }

    private static void logResults(int[] nums) {
        LoggerUtil.log(ProductOfArrayExceptSelf.class, "productExceptSelfNotMeetingRequirement: " + Arrays.toString(productExceptSelfNotMeetingRequirement(nums))
                , "productExceptSelfMeetingRequirement: " + Arrays.toString(productExceptSelfMeetingRequirement(nums)));
    }
}
