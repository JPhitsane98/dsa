package j.com.problems;

import java.util.*;

/**
 * The median is the middle value in an ordered integer list.
 * If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far.
 */
public class FindMedianFromDataStream {

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.findMedian();
        mf.addNum(2);
        mf.findMedian();
        mf.addNum(3);
        mf.findMedian();

        System.out.println("\"=========================\" = " + "=========================");

        MedianFinderOptimized mfo = new MedianFinderOptimized();
        mfo.addNum(1);
        mf.findMedian(); // fails for only one num
        mfo.addNum(2);
        mfo.findMedian();
        mfo.addNum(3);
        mfo.findMedian();
    }
}

class MedianFinder {

    private List<Integer> nums = new ArrayList<>();

    public void addNum(int num) {
        nums.add(num);
        System.out.println(nums);
    }

    public double findMedian() {
        int middleIndex = nums.size() / 2;
        double median;
        if (nums.size() % 2 == 0) {
            median = (nums.get(middleIndex) + nums.get(middleIndex - 1)) / 2.0;
        } else {
            median = nums.get(middleIndex);
        }
        System.out.println("findMedian -> " + median);
        return median;
    }
}

class MedianFinderOptimized {

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
        System.out.println(maxHeap.toString() + minHeap);
    }

    public double findMedian() {
        double median;
        if (maxHeap.isEmpty()) return 0;
        if (maxHeap.size() == minHeap.size()) {
            median = (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            median = maxHeap.peek();
        }
        System.out.println("findMedian -> " + median);
        return median;
    }
}