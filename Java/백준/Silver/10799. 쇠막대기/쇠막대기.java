import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {

        char[] arr = br.readLine().toCharArray();

        int cnt = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            // 열린 괄호라면 -> 개수 증가
            if (arr[i] == '(') cnt++;
            // 닫힌 괄호라면 -> 케이스 분류
            else if (arr[i] == ')') {
                // 이전 괄호가 열린 괄호인 경우 -> 레이저
                if (arr[i - 1] == '(') {
                    cnt--;
                    ans += cnt;
                }
                // 이전 괄호가 닫힌 괄호인 경우 -> 막대기 종료
                else {
                    cnt--;
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}

