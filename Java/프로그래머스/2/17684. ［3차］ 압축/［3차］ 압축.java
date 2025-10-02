import java.math.*;
import java.util.*;

class Solution {
    
    private final Map<String, Integer> map = new HashMap<>();
    private final List<Integer> lst = new ArrayList<>();
    private int LEN, count, idx; 
    
    public int[] solution(String msg) {
        
        initMap();
        int[] answer = solve(msg);
        return answer;
    }
    
    private void initMap() {
        for (int i = 65; i <= 90; i++) {
            char ch = (char) i;
            String str = String.valueOf(ch);
            map.put(str, i - 64);
        }
    }
    
    private int[] solve(String msg) {

        idx = 0; 
        count = 26; 
        LEN = msg.length(); 
        boolean flag = false;
        
        while (true) {
            
            for (int i = 1; idx + i <= LEN; i++) {
                String str = msg.substring(idx, idx + i);
                // 해당 키가 존재한다면 -> 다음 문자열까지 탐색
                if (map.containsKey(str)) {
                    if (idx + i == LEN) {
                        lst.add(map.get(str));
                        flag = true;
                        break;
                    }
                    continue;
                } 
                // 해당 키가 존재하지 않는다면 -> 사전에 추가
                else {
                    count++;
                    map.put(str, count);
                    idx += (str.length() - 1);
                    lst.add(map.get(str.substring(0, str.length() - 1)));
                    break;
                }
            }
            
            if (flag) {
                break;
            }
        }  
        
        int[] answer = new int[lst.size()];
        for (int i = 0; i < lst.size(); i++) {
            answer[i] = lst.get(i);
        }
        
        
        return answer;
    }
}