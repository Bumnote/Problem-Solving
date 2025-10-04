import java.util.*;
import java.math.*;

class Solution {
    

    private final Deque<Integer> dq = new ArrayDeque<>();
    
    public int solution(int n, int k) {
    
        changeKNumbers(n, k);
        int answer = solve();
        
        return answer; 
    }
    
    private void changeKNumbers(int n, int k) {
        while (n > 0) {
            dq.offerFirst(n % k);
            n /= k;
        }
    }
    
    private int solve() {
        int count = 0;
         
        String number = "";
        for (Integer num : dq) {
            // 숫자가 0이 아닌 경우 
            if (num != 0) {
                number += String.valueOf(num);
            }
            // 숫자가 0인 경우 
            else {                          
                if (number != "" && isPrime(Long.parseLong(number))) {
                    count++;
                }
                number = "";
            }
        }
        
        if (number != "" && isPrime(Long.parseLong(number))) {
            count++;
        }
        
        return count;
    }
    
    private boolean isPrime(long num) {
        if (num == 0 || num == 1) {
            return false; 
        }
        
        if (num == 2) {
            return true;
        }
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}


    