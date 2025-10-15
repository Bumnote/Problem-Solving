import java.util.*;
import java.math.*;

class Solution {
    
    private final String[] arr = {"A", "E", "I", "O", "U"};
    private int totalCount; 
    private int answer; 
    
    public int solution(String word) {
        totalCount = 0;
        bt(new ArrayList<>(), word);
        return answer;
    }
    
    private void bt(List<String> strList, String word) {
    
        if (strList.size() == 5) {
            if (isWord(word, strList)) {
                answer = totalCount;
            }
            return; 
        }
        
        
        for (int i = 0; i < 5; i++) {
            strList.add(arr[i]);
            totalCount++;
            if (isWord(word, strList)) {
                answer = totalCount;
            }
            bt(strList, word);
            strList.remove(strList.size() - 1);
        }
    }
    
    private boolean isWord(String word, List<String> strList) {
        String target = "";
        for (String str : strList) {
            target += str;
        }
        
        return word.equals(target);
    }
}