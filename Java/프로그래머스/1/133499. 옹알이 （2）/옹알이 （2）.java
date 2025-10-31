import java.util.*;
import java.math.*;

class Solution {
    
    private final String[] words = {"aya", "ye", "woo", "ma"};
    private final String[] forbidden = {"ayaaya", "yeye", "woowoo", "mama"};
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String word : babbling) {
            answer += judge(word);
        }
        
        return answer;
    }
    
    private int judge(String word) {
        // 연속된 단어가 존재하는 경우 -> 0
        for (String forbiddenWord : forbidden) {
            if (word.contains(forbiddenWord)) {
                return 0;
            }
        }
        
        // 말할 수 있는 단어가 들어있는 경우 -> 공백으로 replace
        int wordLength = word.length(); 
        int totalLength = 0;
        for (String possibleWord : words) {
            // 해당 단어가 들어있다면 -> 단어 길이 증가 
            if (word.contains(possibleWord)) {
                int size = possibleWord.length();
                for (int i = 0; i <= wordLength - size; i++) {
                    String tmp = word.substring(i, i + size);
                    if (possibleWord.equals(tmp)) {
                        totalLength += size;
                    }
                }
            }
        }
        
        // 말할 수 있는 단어로 모두 대체되는 경우 -> 1
        if (wordLength == totalLength) {
            return 1;
        }
        
        // 다른 단어가 끼어들어있는 경우 -> 0
        return 0;
    }
}