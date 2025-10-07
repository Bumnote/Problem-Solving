import java.util.*;
import java.math.*;

class Disk implements Comparable<Disk> {
    int jobTime;
    int requestTime;
    int jobNumber;
    
    public Disk(int jobTime, int requestTime, int jobNumber) {
        this.jobTime = jobTime;
        this.requestTime = requestTime;
        this.jobNumber = jobNumber;
    }
    
    @Override
    public int compareTo(Disk o) {
        // 작업의 소요시간를 기준으로 오름차순 정렬 
        if (this.jobTime != o.jobTime) {
            return Integer.compare(this.jobTime, o.jobTime);
        } 
        // 작업의 요청시각을 기준으로 오름차순 정렬 
        else if (this.requestTime != o.requestTime) {
            return Integer.compare(this.requestTime, o.requestTime);
        }
        // 작업의 번호를 기준으로 오름차순 정렬
        return Integer.compare(this.jobNumber, o.jobNumber);
    }
}

class Solution {
    
    private final PriorityQueue<Disk> pq = new PriorityQueue<>();
    
    // 요청시각, 소요시간 
    public int solution(int[][] jobs) {
        
        // 요청 시각을 기준으로 오름차순 정렬, 소요 시간을 기준으로 오름차순 정렬 
        Arrays.sort(jobs, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });  

        int jobsIdx = 0;
        int count = 0;
        int startTime = 0;
        int endTime = 0;
        double totalTime = 0.0;
        // 모든 작업을 완료할 때까지 반복 
        while (count < jobs.length) {
            if (pq.isEmpty()) {
                pq.offer(new Disk(jobs[jobsIdx][1], jobs[jobsIdx][0], jobsIdx));
                jobsIdx++;
            } 
            
            Disk disk = pq.poll();
            count++;
            
            if (startTime < disk.requestTime) {
                startTime = disk.requestTime;
            }
            
            endTime = startTime + disk.jobTime;
            totalTime += (endTime - disk.requestTime);
            startTime = endTime;
            
            while (jobsIdx < jobs.length && jobs[jobsIdx][0] <= endTime) {
                pq.offer(new Disk(jobs[jobsIdx][1], jobs[jobsIdx][0], jobsIdx));
                jobsIdx++;
            } 
        }
        
        return (int) Math.floor(totalTime / jobs.length);
    }
}