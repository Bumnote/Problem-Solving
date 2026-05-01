import java.util.*; 

class Solution {
    
    public String solution(String X, String Y) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (char ch : Y.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        List<Character> lst = new ArrayList<>();
        
        for (char ch : X.toCharArray()) {
            if (map.getOrDefault(ch, 0) > 0) {
                lst.add(ch);
                map.put(ch, map.get(ch) - 1);
            }
        }
        
        if (lst.isEmpty()) return "-1";
        
        lst.sort(Collections.reverseOrder());
        if (lst.get(0) == '0') return "0";
        
        StringBuilder sb = new StringBuilder();
        for (char ch : lst) {
            sb.append(ch);
        }
        
        return sb.toString();
    }
}