package j.com.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi],
 * merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class MergeInterval {

    public static void main(String[] args) {
        testExpectedResults1();
        testExpectedResults2();
        testExpectedResults3();
        testExpectedResults4();
    }

    public static int[][] merge(int[][] intervals) {

        if (intervals.length == 0) return intervals;

        //Sort each inner array
        for (int[] row : intervals) {
            Arrays.sort(row);
        }
        //Sort the 2D array based on the first element of each inner array
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> nonOverlappingIntervals = new ArrayList<>();

        // Start with the first interval
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];

            // Check if the intervals overlap
            if (currentInterval[1] >= nextInterval[0]) {
                // Merge the intervals
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                // No overlap, store the current interval and move to the next
                nonOverlappingIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }
        }
        nonOverlappingIntervals.add(currentInterval);
        return nonOverlappingIntervals.toArray(new int[nonOverlappingIntervals.size()][]);
    }

    public static int[][] mergeRefined(int[][] intervals) {

        //Sort the 2D array based on the first element of each inner array
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }


    private static void testExpectedResults1() {
        logResults(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }

    private static void testExpectedResults2() {
        logResults(new int[][]{{1, 3}, {2, 4}, {5, 7}, {6, 8}});
    }

    private static void testExpectedResults3() {
        logResults(new int[][]{{1, 4}, {4, 5}});
    }

    private static void testExpectedResults4() {
        logResults(new int[][]{});
    }

    private static void logResults(int[][] intervals) {
        LoggerUtil.log(FindMinimumInRotatedSortedArray.class, "merge: " + Arrays.deepToString(merge(intervals))
                , "mergeRefined: " + Arrays.deepToString(mergeRefined(intervals)));
    }
}
