import java.util.*;

class Node implements Comparable<Node> {
    int stage;
    int child;
    int parent;
    
    Node(int stage, int child, int parent) {
        this.stage = stage;
        this.child = child;
        this.parent = parent;
    }
    
    @Override 
    public int compareTo(Node o) {
        long f1 = (long) this.child * o.parent;
        long f2 = (long) this.parent * o.child;
        
        if (f1 == f2) {
            return Integer.compare(this.stage, o.stage);
        }
        
        return Long.compare(f2, f1);
    }
    
}

class Solution {
    public int[] solution(int N, int[] stages) {
        
        int currPerson = stages.length;
        int[] persons = new int[N + 1];
        
        for (int stage : stages) {
            persons[stage - 1]++;
        }
        
        List<Node> order = new ArrayList<>();
        
        for (int i = 1; i <= N; i++) {
            Node node = new Node(i, persons[i - 1], currPerson);
            order.add(node);
            currPerson -= persons[i - 1];
        }
        
        Collections.sort(order);
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            Node node = order.get(i);
            answer[i] = node.stage;
        }
        
        return answer;
    }
}