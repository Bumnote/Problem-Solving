import java.util.*;

class Solution {
    
    private Set<Character> set = new HashSet<>();
    
    public String solution(String s, String skip, int index) {
        
        for (char ch : skip.toCharArray()) {
            set.add(ch);
        }
        
        String answer = "";
        for (char ch : s.toCharArray()) {
            int idx = 1;
            int cnt = 0;
            while (true) {
                char nxt = (char) (ch + idx);
                if (nxt > 'z') {
                    ch = 'a';
                    idx = 0;
                    nxt = 'a';
                }
                
                if (set.contains(nxt)) {
                    idx++;
                    continue;
                }
                
                idx++;
                cnt++;
                if (cnt == index) {
                    answer += String.valueOf(nxt);
                    break;
                }
            }
        }
        
        return answer;
    }
}