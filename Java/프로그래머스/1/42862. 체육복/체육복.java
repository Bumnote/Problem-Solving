import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(visited, true);
        Arrays.sort(reserve);
        
        Set<Integer> set = new HashSet<>();
        for (int num : lost) {
            visited[num] = false;
            set.add(num);
        }
        
        Arrays.sort(reserve);
        for (int num : reserve) {
            boolean flag = true;
            visited[num] = true;
            if (set.contains(num)) {
                continue;
            }
            
            if (inRange(num - 1, n) && flag && !visited[num - 1]) {
                visited[num - 1] = true;
                flag = false;
            }
            
            if (inRange(num + 1, n) && flag && !visited[num + 1]) {
                visited[num + 1] = true;
                continue;
            }
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean inRange(int x, int n) {
        return 1 <= x && x <= n;
    }   
}