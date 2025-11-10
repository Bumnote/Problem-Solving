import java.io.*;
import java.util.*;

class Main {
    
    private static final Scanner sc = new Scanner(System.in);
    private static final String str = "LoveisKoreaUniversity";
    
    public static void main(String[] args) {
        
        int n = sc.nextInt();
        
        for (int i = 1; i <= n; i++) {
            System.out.print(str + " ");
        }
    }
}