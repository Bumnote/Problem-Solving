class Solution {
    public String solution(String s) {
        String[] input = s.split(" ");
        
        int MIN = Integer.MAX_VALUE;
        int MAX = Integer.MIN_VALUE;
        for (String elem : input) {
            int num = Integer.parseInt(elem);
            MIN = MIN > num ? num : MIN;
            MAX = MAX < num ? num : MAX;
        }
        
        return String.format("%d %d", MIN, MAX);
    }
}