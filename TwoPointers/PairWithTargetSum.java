package TwoPointers;

class PairWithTargetSum {
  public static int[] search(int[] arr, int targetSum) {
    // T: O(N) where N is total number of elements in arr
    // S: O(1) since no extra space is taken

    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
      int currentSum = arr[left] + arr[right];
      if (currentSum == targetSum) {
        return new int[] { left, right };
      }

      if (currentSum > targetSum)
        right--;
      else {
        left++;
      }
    }

    return new int[] { -1, -1 };
  }

  public static void main(String[] args) {
    int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 6 }, 6);
    System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
    System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
  }
}