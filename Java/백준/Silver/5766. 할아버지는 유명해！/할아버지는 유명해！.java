import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static Map<Integer, Integer> map;
    static int N, M;

    public static void main(String[] args) throws IOException {

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N + M == 0)
                break;

            map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int person = Integer.parseInt(st.nextToken());
                    map.put(person, map.getOrDefault(person, 0) + 1);
                }
            }

            List<Map.Entry<Integer, Integer>> sortedList = map.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toList());

            ArrayList<Integer> lst = new ArrayList<>();
            int cnt = sortedList.get(1).getValue();

            for (int i = 1; i < sortedList.size(); i++) {
                int value = sortedList.get(i).getValue();
                if (value == cnt) {
                    lst.add(sortedList.get(i).getKey());
                }
            }

            lst.sort(Comparator.naturalOrder());
            for (int key : lst)
                sb.append(key).append(" ");

            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}
