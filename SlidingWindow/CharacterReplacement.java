package SlidingWindow;

import java.util.*;

class CharacterReplacement {
  public static int findLength(String str, int k) {
    // The above algorithm’s time complexity will be O(N), where ‘N’ is the number
    // of letters in the input string.
    // As we expect only the lower case letters in the input string, we can conclude
    // that the space complexity will be O(26) to store each letter’s frequency in
    // the HashMap, which is asymptotically equal to O(1).

    if (str.length() == 0)
      return 0;

    Map<Character, Integer> charFrequencyMap = new HashMap<>();

    int windowStart = 0;
    int maxLength = 0;
    int maxRepeatCharCount = 0;

    // String="aabccbb", k=2
    // 1 -> 2 -> 2 -> 2
    // 0>2? -> 0>2? -> 1>2?
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
      maxRepeatCharCount = Math.max(maxRepeatCharCount, charFrequencyMap.get(rightChar));

      if (windowEnd - windowStart + 1 - maxRepeatCharCount > k) {
        char leftChar = str.charAt(windowStart);
        charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
        windowStart++;
      }
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }
    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println(CharacterReplacement.findLength("aabccbb", 2));
    System.out.println(CharacterReplacement.findLength("abbcb", 1));
    System.out.println(CharacterReplacement.findLength("abccde", 1));
  }
}