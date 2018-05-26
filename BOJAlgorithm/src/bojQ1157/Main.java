package bojQ1157;

import java.util.Scanner;

//https://www.acmicpc.net/problem/1157
//단어공부
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		scan.close();
		
		int count[] = new int[26];
		for(int i=0; i<count.length; i++) {
			count[i] = 0;
		}
		
		str = str.toLowerCase();
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			count[c-'a'] += 1;
		}
		
		int cnt = 0;
		for(int i=0; i<count.length;i++) {
			cnt += count[i];
		}
		
//		for(int i=0; i<count.length;i++) 
//			System.out.print((char)(i+'A') + " ");
//		System.out.println();
//		for(int i=0; i<count.length;i++) 
//			System.out.print(count[i] + " ");
		
		if(cnt == 0) {
			System.out.println('?');
			return;
		}
		int max = -1;
		int index = 0;
		for(int i=0; i<count.length;i++) {
			if(count[i] == 0) continue;
			if(max < count[i]) {
				max = count[i];
				index = i;
			} else if(max == count[i]) {
				index = '?' - 'A';
			}
		}
		
//		System.out.println();
//		System.out.println("max: " + max);
//		System.out.println("index: " +index);
		
		System.out.println((char)(index+'A'));
	}
}
