package boj.bojQ15702;

import java.util.Scanner;

/*
 * belle 180427
 * https://www.acmicpc.net/problem/15702
 * 19060 KB	228 MS
 */
class Student {
	int num;
	int score;
	Student(int num, int score) {
		this.num = num;
		this.score = score;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int problemNum = scan.nextInt();
		int studentNum = scan.nextInt();
		Student[] students = new Student[studentNum];
		int[] score = new int[problemNum];
		
		for(int i=0; i<studentNum; i++) {
			//초기화
			students[i] = new Student(0,0);
		}
		
		for(int i=0; i<problemNum; i++) {
			//점수 세팅
			score[i] = scan.nextInt();
		}
		
		for(int i=0; i<studentNum; i++) {
			students[i].num = scan.nextInt();
			for(int j=0; j<problemNum; j++) {
				String answer = scan.next();
				if(answer.equalsIgnoreCase("O")) {
					//맞았으면, 기존 점수에 지금 점수룰 더한다.
					students[i].score += score[j];
				}
			}
		}
		
		scan.close();
		
		Student maxStudent = new Student(Integer.MAX_VALUE,0);
		for(int i=0; i<studentNum; i++) {
			if(students[i].score > maxStudent.score) {
				//점수가 더 큰 학생이 maxStudent에 들어간다.
				maxStudent = students[i];
			} else if(students[i].score == maxStudent.score) {
				if(maxStudent.num > students[i].num) {
					//만약 점수가 같다면, 학생번호가 더 작은 학생이 maxStudent에 들어간다.
					maxStudent = students[i];
				}
			}
		}
		
		System.out.println(maxStudent.num + " " + maxStudent.score);
		
	}
}



