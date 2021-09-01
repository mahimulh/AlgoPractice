package KWayMerge;

import java.util.*;

class Node {
  int elementIndex;
  int arrayIndex;

  Node(int elementIndex, int arrayIndex) {
    this.elementIndex = elementIndex;
    this.arrayIndex = arrayIndex;
  }
}

class KthSmallestInMSortedArrays {

  public static int findKthSmallest(List<Integer[]> lists, int k) {
    PriorityQueue<Node> minHeap = new PriorityQueue<Node>(
        (a, b) -> lists.get(a.elementIndex)[a.elementIndex] - lists.get(b.elementIndex)[b.elementIndex]);

    for (int i = 0; i < lists.size(); i++) {
      if (lists.get(i) != null) {
        minHeap.add(new Node(0, i));
      }
    }

    int numberCount = 0, result = 0;

    while (!minHeap.isEmpty()) {
      Node node = minHeap.poll();
      result = lists.get(node.arrayIndex)[node.elementIndex];
      if (++numberCount == k) {
        break;
      }
      node.elementIndex++;
      if (lists.get(node.arrayIndex).length > node.elementIndex)
        minHeap.add(node);
    }

    return result;
  }

  public static void main(String[] args) {
    Integer[] l1 = new Integer[] { 2, 6, 8 };
    Integer[] l2 = new Integer[] { 3, 6, 7 };
    Integer[] l3 = new Integer[] { 1, 3, 4 };
    List<Integer[]> lists = new ArrayList<Integer[]>();
    lists.add(l1);
    lists.add(l2);
    lists.add(l3);
    int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
    System.out.print("Kth smallest number is: " + result);
  }
}
