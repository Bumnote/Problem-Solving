import java.util.*;

class Solution {

    private int[] uf;
    private final Set<Integer> set = new HashSet<>();
    
    public int solution(int n, int[][] computers) {
     
        // uf 배열 초기화 
        uf = new int[n];
        for (int i = 0; i < n; i++) {
            uf[i] = i;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (computers[i][j] == 1 && find(i) != find(j)) {
                    union(i, j);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            set.add(find(i));
        }
        
        return set.size();
    }
    
        
    private int find(int x) {
        if (uf[x] != x) {
            uf[x] = find(uf[x]);
        } 
        return uf[x];
    }
    
    private void union(int x, int y) {
        
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX == rootY) {
            return;
        }
        
        if (rootX > rootY) {
            int tmp = rootX;
            rootX = rootY;
            rootY = tmp;
        }
        
        uf[rootY] = rootX;
    }
}