import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        int n = topping.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : topping) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        
        Set<Integer> left = new HashSet<>();
        Set<Integer> right = new HashSet<>();
        for (int i = 1; i < n; i++) {
            right.add(topping[i]);
        }
        
        int count = 0; 
        for (int i = 0; i < n; i++) {
            int target = topping[i];
            left.add(target);
            map.put(target, map.get(target) - 1);
            if (map.get(target) == 0) {
                map.remove(target);
                right.remove(target);
            }
            
            if (left.size() == right.size()) {
                count++;
            }
        }
        
        return count;
    }
}