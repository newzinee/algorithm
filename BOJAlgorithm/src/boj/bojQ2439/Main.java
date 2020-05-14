package boj.bojQ2439;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2439
//별찍기 2
// 5
//    *
//   **
//  ***
// ****
//*****
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	// 1<=n<=10
		sc.close();
		
		for(int i=n; i>0; i--) {
			int j=(i-1);
			for(int m=j;m>0;m--) {
				System.out.print(" ");
			}
			for(int k=0; k<(n-j);k++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}
}
