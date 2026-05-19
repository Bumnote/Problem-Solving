class Solution {
    
    int n;
    int answer;
    boolean[] visited; 
    
    public int solution(String begin, String target, String[] words) {
        this.n = words.length;
        this.answer = Integer.MAX_VALUE;
        visited = new boolean[words.length];
        
        for (int i = 0; i < n; i++) {
            if (possibleChange(begin, words[i])) {
                visited[i] = true;
                dfs(words[i], target, 1, words);
                visited[i] = false;
            }
        }
        
        return answer != Integer.MAX_VALUE ? answer : 0;
    }
    
    private void dfs(String curr, String target, int count, String[] words) {
        
        if (curr.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            
            if (possibleChange(curr, words[i])) {
                visited[i] = true;
                dfs(words[i], target, count + 1, words);
                visited[i] = false;
            }
        }
    }
    
    private boolean possibleChange(String curr, String nxt) {
        
        if (curr.length() != nxt.length()) {
            return false;
        }
        
        int count = 0;
        for (int i = 0; i < curr.length(); i++) {
            if (curr.charAt(i) != nxt.charAt(i)) {
                count++;
            }
        }
        
        return count == 1;
    }
}