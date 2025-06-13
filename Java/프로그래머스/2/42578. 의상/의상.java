import java.util.*;

class Solution {

  public int solution(String[][] clothes) {

    Map<String, Integer> map = new HashMap<>();
    for (String[] cloth : clothes) {
      String type = cloth[1];
      map.put(type, map.getOrDefault(type, 0) + 1);
    }

    int answer = 1;
    for (Integer value : map.values()) {
      System.out.println("value: " + value);
      answer *= (1 + value);
    }

    return answer - 1;
  }
}