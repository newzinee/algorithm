package boj.bojQ1697;

import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.LinkedList;
/*
class Node {
	int data;
	int depth;
	Node next;
	Node(int data, int depth) {
		this.data = data;
		this.depth = depth;
		this.next = null;
	}
}
*/
public class Main {

	
    final static int MIN = 0;
	final static int MAX = 100000;
	
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int goal = sc.nextInt();
		sc.close();

		Set<Integer> visited = new HashSet<>();
		Node move = new Node(start, 0);
		visited.add(move.data);
		
		Queue<Node> q = new LinkedList<>();
		q.add(move);
		while(true) {
			move = q.remove();
//			System.out.print(move.data +"("+move.depth+")" + " -> ");
			if(move.data == goal) break;
			
			Node left = getLeftNode(move);
			Node mid = getMidNode(move);
			Node right = getRightNode(move);
			
			if((left.data >= MIN) && visited.add(left.data))  q.add(left);
			if((mid.data <= MAX) /*&& (mid.data <= goal)*/ && visited.add(mid.data))   q.add(mid);
			if((right.data <= MAX) /*&& (right.data <= goal)*/ && visited.add(right.data)) q.add(right);
			
		}
//		System.out.println();
//		System.out.println("data :" + move.data);
		System.out.println(move.depth);
	}

	
	private static Node getRightNode(Node move) {
		Node node = new Node(move.data, move.depth);
		node.depth = move.depth +1;
		node.data = node.data * 2;
		return node;
	}


	private static Node getMidNode(Node move) {
		Node node = new Node(move.data, move.depth);
		node.depth = move.depth +1;
		node.data = node.data + 1;
		return node;
	}

	private static Node getLeftNode(Node move) {
		Node node = new Node(move.data, move.depth);
		node.depth = move.depth +1;
		node.data = node.data -1;
		return node;
	}
	
	
}
