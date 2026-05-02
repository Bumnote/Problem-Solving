import java.util.*;

class Solution {
    
    public int solution(int n, int[] stations, int w) {
        
        int distance = (2 * w) + 1;
        int count = calculateMachineCount(1, stations[0] - w - 1, distance);
        for (int i = 0; i < stations.length - 1; i++) {
            int left = stations[i] + w + 1;
            int right = stations[i + 1] - w - 1;
            int result = calculateMachineCount(left, right, distance);
            count += result;
        }
        
        count += calculateMachineCount(stations[stations.length - 1] + w + 1, n, distance);
    
        return count;
    }
    
    private int calculateMachineCount(int left, int right, int distance) {
        if (left > right) {
            return 0;
        }
        int diff = right - left + 1;
        int quote = diff / distance;
        int remain = diff % distance;
        return remain == 0 ? quote : quote + 1;
    }
}