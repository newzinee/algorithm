package programmers.q42747;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42747
 * 정렬 > H-index
 */
public class Q42747 {
    public int solution(int[] citations) {

        int answer = 0;

        if(citations.length == 1) {
            if(citations[0] == 0) return 0;
            if(citations[0] > 0) return 1;
        }

        List<Integer> reverse = Arrays.stream(citations).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());

        if(reverse.get(0) == 0) return 0;
        int idx = 0;
        for(int i=0; i<reverse.size() -1; i++) {
            idx ++;
            if(reverse.get(i) >= idx && idx >= reverse.get(i+1)) {
                answer = idx; break;
            }
            if(i == reverse.size()-2) {
                answer = idx+1;
            }
        }


        return answer;
    }

    @Test
    public void test() {
        int[] citations = {3, 0, 6, 1, 5};

        Q42747 s = new Q42747();
        Assertions.assertThat(s.solution(citations)).isEqualTo(3);
    }

    @Test
    public void test1() {
        int[] citations = {5,5,5,0};

        Q42747 s = new Q42747();
        Assertions.assertThat(s.solution(citations)).isEqualTo(3);
    }

    @Test
    public void test2() {
        int[] citations = {5};

        Q42747 s = new Q42747();
        Assertions.assertThat(s.solution(citations)).isEqualTo(1);
    }

    @Test
    public void test3() {
        int[] citations = {5,5,5,5};

        Q42747 s = new Q42747();
        Assertions.assertThat(s.solution(citations)).isEqualTo(4);
    }

    @Test
    public void test4() {
        int[] citations = {2,2,2,2,2};

        Q42747 s = new Q42747();
        Assertions.assertThat(s.solution(citations)).isEqualTo(2);
    }
    @Test
    public void test5() {
        int[] citations = {0,0,0,0};

        Q42747 s = new Q42747();
        Assertions.assertThat(s.solution(citations)).isEqualTo(0);
    }
}
