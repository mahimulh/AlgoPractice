package Subsets;

import java.util.*;

class Subsets {

  public static List<List<Integer>> findSubsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();

    subsets.add(new ArrayList<>());

    for (int currentNumber : nums) {
      int n = subsets.size(); // get current size of subsets
      for (int i = 0; i < n; i++) { // at the end of subsets, add new sets after adding the number to existing
                                    // subsets separately
        List<Integer> set = new ArrayList<>(subsets.get(i));
        set.add(currentNumber);
        subsets.add(set);
      }
    }
    return subsets;
  }

  // Time O(2^N * N) because the number of subsets doubles for each number (N) we
  // add
  // to existing subsets and because we are making a new subset from an existing
  // set
  // Space O(2^N * N) because same reasons as above
  public static void main(String[] args) {
    List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
    System.out.println("Here is the list of subsets: " + result);

    result = Subsets.findSubsets(new int[] { 1, 5, 3 });
    System.out.println("Here is the list of subsets: " + result);
  }
}
