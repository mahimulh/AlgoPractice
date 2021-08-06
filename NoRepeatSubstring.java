import java.util.*;

class NoRepeatSubstring {
  public static int findLength(String str) {
    //length of longest subtring with no repeating characters
    //use HashMap to store the distinct characters
    //aabccbb
    //O(n) time and O(k) space where k is distinct chars
    int windowStart = 0;
    int maxLength = 0;
    Map<Character, Integer> charIndexMap = new HashMap<>();
    for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
      char rightChar = str.charAt(windowEnd);
      if(charIndexMap.containsKey(rightChar)){
        windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
      }
      charIndexMap.put(rightChar, windowEnd);
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }

    return maxLength;
  }
  public static void main(String[] args) {
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
  }
}
