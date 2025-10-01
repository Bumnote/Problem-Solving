import java.math.*;
import java.util.*;

class Solution {
    
    private final double NUM = 65536.0;
    private String lowerStr1, lowerStr2;
    private final List<String> lst1 = new ArrayList<>();
    private final List<String> lst2 = new ArrayList<>();
    private final Set<String> set = new HashSet<>();
    private final Map<String, Integer> map1 = new HashMap<>();
    private final Map<String, Integer> map2 = new HashMap<>();
    private int union, intersect;
    
    public int solution(String str1, String str2) {
        
        initString(str1, str2);
        initArray();
        int answer = solve();
        
        return answer;
    }
    
    private void initString(String str1, String str2) {
        lowerStr1 = str1.toLowerCase();
        lowerStr2 = str2.toLowerCase();
    }
    
    private void initArray() {
        
        for(int i = 0; i < lowerStr1.length() - 1; i++) {
            if (isAlpha(lowerStr1, i)) {
                lst1.add(lowerStr1.substring(i, i + 2));
            }
        }
        
        for (int i = 0; i < lowerStr2.length() - 1; i++) {
            if (isAlpha(lowerStr2, i)) {
                lst2.add(lowerStr2.substring(i, i + 2));
            }
        }
    }
    
    private int solve() {
        for (String ch : lst1) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
            set.add(ch);
        }
        
        for (String ch : lst2) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
            set.add(ch);
        }
        
        // 합집합인 경우 -> 두 lst의 요소를 더하되, 두 lst에 모두 있다면, 더 큰 값을 더한다. 
        // 교집합인 경우 -> 두 lst에 모두 있고, 더 작은 값을 더한다. 
        for (String str : set) {
            if (map1.containsKey(str) && map2.containsKey(str)) {
                union += Math.max(map1.get(str), map2.get(str));
                intersect += Math.min(map1.get(str), map2.get(str));
            } else if (map1.containsKey(str)) {
                union += map1.get(str);
            } else if (map2.containsKey(str)) {
                union += map2.get(str);
            }
        }
        
        return union == 0 ? (int) NUM : (int) (((double) intersect / union) * NUM);
    }
    
    private boolean isAlpha(String lowerStr, int idx) {
        if (Character.isAlphabetic(lowerStr.charAt(idx)) && Character.isAlphabetic(lowerStr.charAt(idx + 1))) {
            return true;
        }
        return false; 
    }
}