import java.util.*;
import java.io.*;

class Solution {

  private final Set<String> cache = new HashSet<>();
  private final Deque<String> dq = new ArrayDeque<>();

  private final int cacheHitTime = 1;
  private final int cacheMissTime = 5;

  public int solution(int cacheSize, String[] cities) {
    if (cacheSize == 0) {
      return cities.length * cacheMissTime;
    }

    int totalTime = 0;
    for (String city : cities) {
      city = city.toUpperCase();

      if (cache.contains(city)) {
        totalTime += cacheHitTime;
        dq.remove(city);
        dq.add(city);
      } else {
        totalTime += cacheMissTime;

        if (dq.size() == cacheSize) {
          String removedCity = dq.poll();
          cache.remove(removedCity);
        }

        cache.add(city);
        dq.add(city);
      }
    }
    return totalTime;
  }
}