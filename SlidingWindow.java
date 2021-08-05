import java.util.Arrays;

class AverageOfSubarrayOfSizeK {
  public static double[] findAverage(int K, int[] arr) {
    // brute force method O(N*K)
    double[] result = new double[arr.length - K + 1];
    // System.out.println(arr.length + " " + K);
    // 9 - 5 + 1 = 5 <- needs to be size of result array
    for (int i = 0; i <= arr.length - K; i++) {
      // i <= 9-5 = 4 (including 4 because <=), therefore i goes from 0 to 4
      double sum = 0;
      for (int j = i; j < i + K; j++) {
        // ex, j = 0; j < 0 + 5 <- goes through five values everytime
        sum += arr[j];
      }
      result[i] = sum / K;
    }
    return result;
  }

  public static void main(String[] args) {
    double[] result = AverageOfSubarrayOfSizeK.findAverage(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
    System.out.println("Average of subarrays of size K: " + Arrays.toString(result));
  }
}