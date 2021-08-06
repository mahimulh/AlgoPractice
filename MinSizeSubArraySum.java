import java.util.Arrays;

class MinSizeSubArraySum {
  public static int findMinSubArray(int S, int[] arr){
    //find length of smallest contiguous subarray whose sum is greater than or equal to 'S'
    //find length of smallest subarray that is equal to or greater than S
    //O(N)
    int smallestLength = Integer.MAX_VALUE;
    int windowSum = 0;
    int windowStart = 0;
    for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
      windowSum += arr[windowEnd];
      while (windowSum >= S){ //do if currentSum bigger than S
        smallestLength = Math.min(smallestLength, windowEnd - windowStart + 1); //get smallest window
        windowSum -= arr[windowStart]; //remove from sum until smaller than S (while loop)
        windowStart++;
      }
    }
    return smallestLength;
  }
  public static void main(String[] args) {
    int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
    System.out.println("Smallest subarray length: " + result);
    result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
    System.out.println("Smallest subarray length: " + result);
    result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
    System.out.println("Smallest subarray length: " + result);
  }
}