import java.math.*;
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] numberToString = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);
            
        Arrays.sort(numberToString, (a, b) -> (b + a).compareTo(a + b));
        
        if (numberToString[0].equals("0")) {
            return "0";
        }
        
        String answer = "";
        for (String strNum : numberToString) {
            answer += strNum;
        }
        
        return answer;
    }
}