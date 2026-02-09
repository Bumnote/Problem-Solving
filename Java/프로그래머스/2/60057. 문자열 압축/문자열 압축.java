import java.util.*;

class Solution {
    public int solution(String s) {
        
        int length = s.length();
        int answer = length;
        
        for (int i = 1; i <= length / 2; i++) {
            int result = compressWord(s, i);
            answer = Math.min(answer, result);
        }
    
        return answer;
    }
    
    public int compressWord(String s, int sliceLength) {
        StringBuilder sb = new StringBuilder();
        String prev = s.substring(0, sliceLength);
        int count = 1;

        for (int idx = sliceLength; idx + sliceLength <= s.length(); idx += sliceLength) {
            String curr = s.substring(idx, idx + sliceLength);

            if (prev.equals(curr)) {
                count++;
            } else {
                if (count > 1) {
                    sb.append(count);
                }
                sb.append(prev);

                prev = curr;
                count = 1;
            }
        }

        // 마지막 prev 처리
        if (count > 1) {
            sb.append(count);
        }
        sb.append(prev);

        // sliceLength로 나누고 남은 문자열 처리
        int remainder = s.length() % sliceLength;
        if (remainder != 0) {
            sb.append(s.substring(s.length() - remainder));
        }

        return sb.length();
    }
}