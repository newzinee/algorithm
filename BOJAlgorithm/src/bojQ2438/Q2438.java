package bojQ2438;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/2438
 * 별찍기 -1 
 * 1 <= N <=100
 * 입력 5
 * 출력
 * *
 * **
 * ***
 * ****
 * *****
 */
public class Q2438 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		for(int i=n; i>0; i--) {
			for(int j=(i-1); j<n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
