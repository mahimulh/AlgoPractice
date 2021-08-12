package SlidingWindow;

import java.util.*;

class MaxFruitCountOf2Types {
  public static int findLength(char[] arr) {
    // char array where each char is a fruit
    // you have two baskets, put only one type of fruit (char) into baskets
    // return the total fruits in both baskets
    // O(n)
    int windowStart = 0;
    int maxFruits = 0;
    Map<Character, Integer> charFrequencyMap = new HashMap<>();
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      char rightChar = arr[windowEnd];
      charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
      while (charFrequencyMap.size() > 2) { // 2 because two types of fruit backets max
        char leftChar = arr[windowStart];
        charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
        if (charFrequencyMap.get(leftChar) == 0) {
          charFrequencyMap.remove(leftChar);
        }
        windowStart++;
      }
      maxFruits = Math.max(maxFruits, windowEnd - windowStart + 1);
    }
    return maxFruits;
  }

  public static void main(String[] args) {
    System.out.println(
        "Maximum number of fruits: " + MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
    System.out.println(
        "Maximum number of fruits: " + MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
  }
}