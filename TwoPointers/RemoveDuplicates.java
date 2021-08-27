package TwoPointers;

import java.util.*;

class RemoveDuplicates {

  public static int remove(int[] arr) {
    // Two pointer approach where T O(N) and S O(1)
    int nextNonDuplicate = 1;

    for (int i = 0; i < arr.length; i++) {
      if (arr[nextNonDuplicate - 1] != arr[i]) {
        arr[nextNonDuplicate] = arr[i];
        nextNonDuplicate++;
      }
    }

    return nextNonDuplicate;
    // This works but this is T:O(N) and S:O(N). We can make S better with a
    // different approach
    // Set<Integer> nums = new HashSet<>();

    // for (int i = 0; i < arr.length; i++) {
    // if (!nums.contains(arr[i])) {
    // nums.add(arr[i]);
    // }
    // }

    // return nums.size();
  }

  public static void main(String[] args) {
    int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
    System.out.println(RemoveDuplicates.remove(arr));

    arr = new int[] { 2, 2, 2, 11 };
    System.out.println(RemoveDuplicates.remove(arr));
  }
}
