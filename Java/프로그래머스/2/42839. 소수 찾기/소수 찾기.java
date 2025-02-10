import java.io.*;
import java.util.*;

class Solution {
    
    static int MAX = 10_000_000;
    static int N; 
    static boolean[] visited;
    static boolean[] sieve = new boolean[MAX + 1];
    static StringBuilder sb = new StringBuilder();
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        
        // 에라토스테네스의 체 구현
        sieve[0] = true;
        sieve[1] = true;
        for (int i = 2; i <= Math.sqrt(MAX); i++) {
            if (!sieve[i]) {
                for (int j = i * i; j <= MAX; j+=i)
                    sieve[j] = true; // 합성수 처리 
            }
        }
                
        N = numbers.length(); // 숫자의 개수 
        visited = new boolean[N];
        
        bt(0, new ArrayList<Integer>(), numbers.toCharArray());
        
        return set.size();
    }
    
    private static void bt(int cnt, ArrayList<Integer> lst, char[] nums) {
        
        if (!lst.isEmpty() && cnt <= N) {

            for (Integer idx : lst)
                sb.append(nums[idx]);

            int num = Integer.parseInt(sb.toString());
            if (!sieve[num]) {
                set.add(num);
            }

            sb.setLength(0);
            if (cnt == N)
                return;
        }
        
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true; // 방문 처리 
                lst.add(i);
                bt(cnt + 1, lst, nums);
                lst.remove(lst.size() - 1);
                visited[i] = false; // 복원 처리
            }
        }   
    }
}