package TwoHeaps;

import java.util.*;

class MedianOfAStream {

  PriorityQueue<Integer> maxHeap;
  PriorityQueue<Integer> minHeap;

  public MedianOfAStream() {
    maxHeap = new PriorityQueue<>((a, b) -> b - a);
    minHeap = new PriorityQueue<>((a, b) -> a - b);
  }

  public void insertNum(int num) {
    if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
      maxHeap.add(num);
    } else {
      minHeap.add(num);
    }

    if (maxHeap.size() > minHeap.size() + 1) {
      minHeap.add(maxHeap.poll());
    } else if (maxHeap.size() < minHeap.size()) {
      maxHeap.add(minHeap.poll());
    }
  }

  public double findMedian() {

    if (maxHeap.size() == minHeap.size()) {
      return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
    }
    // because it is bigger by one number than minHeap
    return maxHeap.peek();
  }
  // Time of insertNum is O(logN) due to insertion in the heap. Time of
  // findMedian() is O(1) since median is found from top of heaps
  // Space is O(N) because we are storing all the numbers

  public static void main(String[] args) {
    MedianOfAStream medianOfAStream = new MedianOfAStream();
    medianOfAStream.insertNum(3);
    medianOfAStream.insertNum(1);
    System.out.println("The median is: " + medianOfAStream.findMedian());
    medianOfAStream.insertNum(5);
    System.out.println("The median is: " + medianOfAStream.findMedian());
    medianOfAStream.insertNum(4);
    System.out.println("The median is: " + medianOfAStream.findMedian());
  }
}
