package TopKElements;

import java.util.*;

class FrequencySort {

  public static String sortCharacterByFrequency(String str) {
    Map<Character, Integer> characterFrequencyMap = new HashMap<>();

    for (char chr : str.toCharArray()) {
      characterFrequencyMap.put(chr, characterFrequencyMap.getOrDefault(chr, 0) + 1);
    }

    PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
        (a, b) -> b.getValue() - a.getValue());

    maxHeap.addAll(characterFrequencyMap.entrySet());
    System.out.println(maxHeap);
    StringBuilder sortedString = new StringBuilder(str.length());

    while (!maxHeap.isEmpty()) {
      Map.Entry<Character, Integer> entry = maxHeap.poll();
      for (int i = 0; i < entry.getValue(); i++) {
        sortedString.append(entry.getKey());
      }
    }

    return sortedString.toString();
  }

  public static void main(String[] args) {
    String result = FrequencySort.sortCharacterByFrequency("Programming");
    System.out.println("Here is the given string after sorting characters by frequency: " + result);

    result = FrequencySort.sortCharacterByFrequency("abcbab");
    System.out.println("Here is the given string after sorting characters by frequency: " + result);
  }
}
