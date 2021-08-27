package TwoPointers;

import java.util.*;

class TripletSumToZero {

  public static List<List<Integer>> searchTriplets(int[] arr) {
    // O(N^2) O(n)
    List<List<Integer>> triplets = new ArrayList<>();

    Arrays.sort(arr);

    for (int i = 0; i < arr.length - 2; i++) {
      if (i > 0 && arr[i] == arr[i - 1]) {
        continue; // skip if duplicate
      }
      searchPair(arr, -arr[i], i + 1, triplets); // X + Y = -Z
    }

    return triplets;
  }

  public static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {
    int right = arr.length - 1;
    while (left < right) {
      int currentSum = arr[left] + arr[right];
      if (currentSum == targetSum) {
        triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
        left++;
        right--;
        while (left < right && arr[left] == arr[left - 1]) { // skipping dupes
          left++;
        }
        while (left < right && arr[right] == arr[right + 1]) { // skipping dupes
          right--;
        }
      } else if (currentSum < targetSum) {
        left++;
      } else {
        right--;
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(TripletSumToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
    System.out.println(TripletSumToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
  }
}
