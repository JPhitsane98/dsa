package j.com.problems;

import java.util.*;

/**
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        testExpectedResult1();
        testExpectedResult0();
        testExpectedResult49();
    }

    public static int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        int current = 0;
        while (left < right) {
            current = Math.min(height[left], height[right]) * (right - left);
            if(current > max){
                max = current;
            }
            if(height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return max;
    }

    private static void testExpectedResult0() {
        logResults(new int[]{0, -1, 0, -2, 0, -3, -4});
    }

    private static void testExpectedResult49() {
        logResults(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
    }

    private static void testExpectedResult1() {
        logResults(new int[]{1, 1});
    }

    private static void logResults(int[] height) {
        LoggerUtil.log(ContainerWithMostWater.class, "maxArea: " + maxArea(height));
    }
}
