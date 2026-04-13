import java.util.*;

class Solution {
    
    int n, m, candidateCount;
    boolean[] isKey;
    Set<String> key; 
    String[][] relation; 
    
    public int solution(String[][] relation) {
        
        n = relation.length;
        m = relation[0].length;
        isKey = new boolean[m];
        key = new HashSet<>();
        this.relation = relation;
        
        int specific = 0; 
        // 1. 고유키 찾기
        for (int i = 0 ; i < m; i++) {
            Set<String> set = new HashSet<>();
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (!set.contains(relation[j][i])) {
                    set.add(relation[j][i]);
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                key.add(String.valueOf(i));
                isKey[i] = true; 
                specific++;
            }
        }
        
        // 2. 후보키 찾기
        int candidate = m - specific;
        for (int cnt = 2; cnt <= candidate; cnt++) {
            bt(0, cnt, new ArrayList<Integer>());
        }
        
    
        return key.size();
    }
    
    private void bt(int cnt, int targetCount, List<Integer> lst) {
        
        if (cnt == targetCount) {
            isCandidateKey(lst);
            return;
        }
        
        for (int i = 0; i < m; i++) {
            if (!lst.isEmpty() && lst.get(lst.size() - 1) >= i) {
                continue;
            }
            if (!isKey[i]) {
                isKey[i] = true;
                lst.add(i);
                bt(cnt + 1, targetCount, lst);
                lst.remove(lst.size() - 1);
                isKey[i] = false;
            }
        }
    }
    
    private boolean isCandidateKey(List<Integer> lst) {
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            String tmp = "";
            for (Integer num : lst) {
                tmp += String.valueOf(relation[i][num]);
            }
            if (set.contains(tmp)) {
                return false;
            }
            set.add(tmp);
        }
        
        for (String k : key) {
            boolean isSubset = true;
            for (char c : k.toCharArray()) {
                if (!lst.contains(c - '0')) {
                    isSubset = false;
                    break;
                }
            }
            if (isSubset) {
                return false;
            }
        }
        
        String keyNumber = "";
        for (Integer num : lst) {
            keyNumber += num.toString();
        }
        
        key.add(keyNumber);
        return true;
    } 
}