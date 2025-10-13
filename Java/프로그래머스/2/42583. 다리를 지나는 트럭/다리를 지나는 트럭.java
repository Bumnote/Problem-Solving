import java.util.*;
import java.math.*;

class Truck {
    int weight;
    int pos;
    
    public Truck(int weight, int pos) {
        this.weight = weight;
        this.pos = pos;
    }
}

class Solution {
    
    private final Deque<Truck> bridge = new ArrayDeque<>();
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int totalTime = 0;
        int bridgeTotalWeight = 0;
        int idx = 0; 
        
        while (idx < truck_weights.length || !bridge.isEmpty()) {
            totalTime++;
            
            if (!bridge.isEmpty()) {
            Truck frontTruck = bridge.peek();
            if (totalTime - frontTruck.pos >= bridge_length) { 
                    bridgeTotalWeight -= frontTruck.weight; 
                    bridge.poll();
                }
            }
            
            if (idx < truck_weights.length && 
               bridgeTotalWeight + truck_weights[idx] <= weight &&
               bridge.size() <= bridge_length) {
                bridge.add(new Truck(truck_weights[idx], totalTime));
                bridgeTotalWeight += truck_weights[idx];
                idx++;
            }
        }
        
        return totalTime;
    }
}