import java.util.*;
import java.math.*;


class Solution {
    
    PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]); 
    
    public int solution(String[][] bookTimes) {
        
        Arrays.sort(bookTimes, (x, y) -> x[0].compareTo(y[0]));
        
        int roomCnt = 0;
        for (String[] bookTime : bookTimes) {
            String[] startTime = bookTime[0].split(":");
            String[] endTime = bookTime[1].split(":");
            
            int currStartTime = sToi(startTime[0]) * 60 + sToi(startTime[1]);
            int currEndTime = sToi(endTime[0]) * 60 + sToi(endTime[1]) + 10;
            
            if (pq.isEmpty()) {
                pq.offer(new int[] {currStartTime, currEndTime});
                roomCnt++;
                continue;
            }
            
            int[] prevTime = pq.poll();
            int prevStartTime = prevTime[0];
            int prevEndTime = prevTime[1];
            
            // 이전 대실 끝난 이후에, 현재 대실이 가능한 상황이라면 -> 현재 시간으로 pq 대체
            if (prevEndTime <= currStartTime) {
                pq.offer(new int[] {currStartTime, currEndTime});
            } 
            // 이전 대실 끝난 이후에, 현재 대실이 불가능하여 방이 필요한 상황이라면 -> 새로운 방 추가
            else {
                roomCnt++;
                pq.offer(new int[] {currStartTime, currEndTime});
                pq.offer(prevTime);
            }
        }
        
        return roomCnt;
    }
    
    private int sToi(String num) {
        return Integer.parseInt(num);
    }
}