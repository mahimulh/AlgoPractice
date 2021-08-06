import java.util.Arrays;

class MaxSumSubArrayOfSizeK {
  public static int findMaxSumSubArray(int k, int [] arr) {
    //sliding window O(N)
    if(arr.length == 0) return -1;
    if(arr.length == 1) return arr[0];
    int result = Integer.MIN_VALUE;
    int windowStart = 0;
    int windowSum = 0;
    for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
      windowSum += arr[windowEnd];
      if(windowEnd >= k - 1){ //checking if windowEnd near end of window
        result = Math.max(result, windowSum);
        windowSum -= arr[windowStart];
        windowStart++;
      }
    }
    return result;
  }
  public static void main(String[] args) {
    System.out.println("Maximum sum of a subarray of size K: "
        + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
    System.out.println("Maximum sum of a subarray of size K: "
        + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
  }
}