package boj.bojQ2440;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2440
//별찍기3
//5
//*****
//****
//***
//**
//*
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		for(int i=n; i>0;i--) {
			for(int s=i; s>0; s--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
