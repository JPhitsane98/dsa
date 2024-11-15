package j.com.problems;

/**
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
 * For example, the array nums = [0,1,2,4,5,6,7] might become:
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Given the sorted rotated array nums of unique elements,
 * return the minimum element of this array.
 * You must write an algorithm that runs in O(log n) time.
 */
public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        testExpectedResult0();
        testExpectedResult1();
        testExpectedResult11();
    }

    public static int findMin(int[] nums) {
        //O(n) execution time
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
                break;
            }
        }
        return min;
    }

    public static int findMinRefined(int[] nums) {
        //O(log n) execution time
        int left = 0;
        int right = nums.length -1;
        while (left < right){
            int mid = left+(right-left)/2;
            if(nums[mid] >  nums[right]){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return nums[left];
    }

    private static void testExpectedResult0() {
        logResults(new int[]{4, 5, 6, 7, 0, 1, 2, 3});
    }

    private static void testExpectedResult1() {
        logResults(new int[]{3,4, 5, 1, 2});
    }

    private static void testExpectedResult11() {
        logResults(new int[]{11,13,15,17});
    }

    private static void logResults(int[] nums) {
        LoggerUtil.log(FindMinimumInRotatedSortedArray.class, "findMin: " + findMin(nums)
        , "findMinRefined: " + findMinRefined(nums));
    }
}
