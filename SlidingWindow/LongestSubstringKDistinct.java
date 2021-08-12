package SlidingWindow;

import java.util.*;

class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {
    // find length of longest substring with no more than K distinct characters
    // str="araaci", K=2
    // result would be 4 because "araa"
    // sliding window
    // araa -> aac -> ci , Math.max(longestLength, window), use while loop
    // a -> ar -> ara -> araa -> raac -> aac
    // 1 -> 2 -> 2 -> 2 -> 3 -> 2
    // use Map
    // O(n)
    if (str == null || str.length() == 0 || str.length() < k) {
      throw new IllegalArgumentException();
    }
    int windowStart = 0;
    int longestLength = 0;
    Map<Character, Integer> charFrequencyMap = new HashMap<>();

    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
      while (charFrequencyMap.size() > k) {
        char leftChar = str.charAt(windowStart);
        charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
        if (charFrequencyMap.get(leftChar) == 0) {
          charFrequencyMap.remove(leftChar);
        }
        windowStart++;
      }
      longestLength = Math.max(longestLength, windowEnd - windowStart + 1);
    }
    return longestLength;
  }

  public static void main(String[] args) {
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
  }
}