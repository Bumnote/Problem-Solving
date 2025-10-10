import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]), L = Integer.parseInt(input[1]);
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < L; i++) {
            String id = br.readLine();
            if (map.containsKey(id)) {
                map.remove(id);
                map.put(id, i);
            } else {
                map.put(id, i);
            }
        }

        PriorityQueue<Student> pq = new PriorityQueue<>((a, b) -> a.idx - b.idx);
        for (String s : map.keySet()) {
            pq.offer(new Student(s, map.get(s)));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            if (!pq.isEmpty()) {
                sb.append(pq.poll().id + "\n");
            }
        }
        System.out.println(sb);
    }

    static class Student {
        String id;
        int idx;

        public Student(String id, int idx) {
            this.id = id;
            this.idx = idx;
        }
    }
}