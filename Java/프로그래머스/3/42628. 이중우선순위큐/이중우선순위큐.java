import java.math.*;
import java.util.*;

class Solution {
    
    private final Map<Integer, Integer> map = new HashMap<>();
    private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    public int[] solution(String[] operations) {
        
        for (String operation : operations) {
            String[] tmp = operation.split(" ");
            char command = tmp[0].charAt(0);
            int num = Integer.parseInt(tmp[1]);
            // 숫자를 삽입하는 명령어 
            if (command == 'I') {
                map.put(num, map.getOrDefault(num, 0) + 1);
                maxHeap.offer(num);
                minHeap.offer(num);
            } 
            // 
            else {
                // 큐에서 최댓값을 삭제하는 경우 -> maxHeap에서 제거 
                if (num == 1) {
                    while (!maxHeap.isEmpty()) {
                        int maxNum = maxHeap.poll();
                        // 실제 숫자가 존재하는 경우 -> 1 감소
                        if (map.containsKey(maxNum) && map.get(maxNum) > 0) {
                            map.put(maxNum, map.get(maxNum) - 1);
                            break;
                        } 
                        // 실제 숫자가 존재하지 않거나, 빈 큐인 경우 -> pass 
                        continue;
                    }
                }
                // 큐에서 최솟값을 삭제하는 경우 -> minHeap에서 제거
                else {
                    while (!minHeap.isEmpty()) {
                        int minNum = minHeap.poll();
                        // 실제 숫자가 존재하는 경우 -> 1 감소 
                        if (map.containsKey(minNum) && map.get(minNum) > 0) {
                            map.put(minNum, map.get(minNum) - 1);
                            break;
                        }
                        // 실제 숫자가 존재하지 않거나, 빈 큐인 경우 -> pass 
                        continue;
                    }   
                }
            }
        }
        
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
        int count = 0;
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                count++;
                maxNum = Math.max(maxNum, entry.getKey());
                minNum = Math.min(minNum, entry.getKey());
            }
        }
        
        if (count == 0) {
            return new int[] {0, 0};
        }
 
        return new int[] {maxNum, minNum};
    }
}