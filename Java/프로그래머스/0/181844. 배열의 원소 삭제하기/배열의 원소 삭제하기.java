import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        
        int size = arr.length;
        int existNumberLength = size;
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < delete_list.length; j++) {
                if (arr[i] == delete_list[j]) {
                    arr[i] = -1;
                    existNumberLength--;
                }
            }
        }
        
        int[] answer = new int[existNumberLength];
        int idx = 0; 
        for (int i = 0; i < size; i++) {
            if (arr[i] == -1) continue;
            answer[idx++] = arr[i];
        }
        
        return answer;
    }
}