package bojQ1697;


import org.junit.Test;

public class Q1697Test {
	int start;
	int goal;
	
//	@Test
	public void test4() {
		int start = 8000;
		int goal = 12378;
		Q1697 problem = new Q1697();
		problem.start(start, goal);
	}
//	@Test
	public void test3() {
		int start = 0;
		int goal = 0;
		Q1697 problem = new Q1697();
		problem.start(start, goal);
	}
	
//	@Test
	public void test2() {
		int start = 99;
		int goal = 1;
		Q1697 problem = new Q1697();
		problem.start(start, goal);
	}
	
	@Test
	public void test1() {
		int start = 5;
		int goal = 17;
		Q1697 problem = new Q1697();
		problem.start(start, goal);	//4
	}
	
}
