package bojQ1697;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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

public class Q1697 {
	//범위 설정
	final static int MIN = 0;
	final static int MAX = 100000;
	
	public void start(int start, int goal) {
		//방문했던 노드는 다시 방문하지 않기 위해 set에 넣어줌
		Set<Integer> visited = new HashSet<>();
		Node move = new Node(start, 0);
		visited.add(move.data);
		
		Queue<Node> q = new LinkedList<>();
		q.add(move);
		while(true) {
			move = q.remove();
			System.out.print(move.data +"("+move.depth+")" + " -> ");
			if(move.data == goal) break;
			
			Node left = getLeftNode(move);
			Node mid = getMidNode(move);
			Node right = getRightNode(move);
			
			if((left.data >= MIN) && visited.add(left.data))  q.add(left);
			if((mid.data <= MAX) && visited.add(mid.data))   q.add(mid);
			if((right.data <= MAX) && visited.add(right.data)) q.add(right);
			
		}
		System.out.println();
		System.out.println("depth: " + move.depth);
		
		/*
		Iterator<Integer> iter = visited.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		*/
	}

	//오른쪽 자식노드 *2
	private Node getRightNode(Node move) {
		Node node = new Node(move.data, move.depth);
		node.depth = move.depth +1;
		node.data = node.data * 2;
		return node;
	}


	//가운데 자식 노드 +1
	private Node getMidNode(Node move) {
		Node node = new Node(move.data, move.depth);
		node.depth = move.depth +1;
		node.data = node.data + 1;
		return node;
	}

	//왼쪽 자식 노드 -1
	private Node getLeftNode(Node move) {
		Node node = new Node(move.data, move.depth);
		node.depth = move.depth +1;
		node.data = node.data -1;
		return node;
	}
}
