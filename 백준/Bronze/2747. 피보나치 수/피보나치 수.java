import java.util.*;

public class Main {
	
	public static int Pivo(int a, int b , int n ) {
		if(n==1) {
			return b;
		}
		
		int answer = a+b;
		a= b ;
		b =answer; 
		return Pivo(a,b,n-1);
		
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = 0;
		int b= 1;
		System.out.printf("%d",Pivo(a,b,n));
	}
}
