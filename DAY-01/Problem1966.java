import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testCaseCount; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int k = Integer.parseInt(tokenizer.nextToken());

            StringTokenizer tokenizer2 = new StringTokenizer(reader.readLine());
            int[] priorities = new int[n];
            for (int j = 0; j < n; j++) {
                priorities[j] = Integer.parseInt(tokenizer2.nextToken());
            }
            System.out.println(solution(n, k, priorities));
        }
    }

    /*
     * 이 프린터기는 다음과 같은 조건에 따라 인쇄를 하게 된다.
     * 현재 Queue의 가장 앞에 있는 문서의 ‘중요도’를 확인한다.
     * 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면,
     * 이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다. 그렇지 않다면 바로 인쇄를 한다.
     *
     * 예를 들어 Queue에 4개의 문서(A B C D)가 있고, 중요도가 2 1 4 3 라면 C를 인쇄하고, 다음으로 D를 인쇄하고 A, B를 인쇄하게 된다.
     * 현재 Queue에 있는 문서의 수와 중요도가 주어졌을 때, 어떤 한 문서가 몇 번째로 인쇄되는지 알아내는 것이다.
     */


    // input - 첫 줄에 테스트케이스의 수가 주어진다.
    //         테스트 케이스의 첫 줄은 문서의 개수와 몇 번째로 인쇄될지 궁금한 문서가 현재 큐에서 몇 번째에 있는지,
    //         두 번째 줄에는 N개 문서의 중요도가 차례대로 주어진다.
    // output - 문서가 몇 번재로 인쇄되는지 출력한다.
    public static int solution(int n, int k, int[] priorities) {
        Queue<Integer> queue = new PriorityQueue(Collections.reverseOrder());
        for (int i = 0; i < priorities.length; i++) {
            queue.add(priorities[i]);
        }

        int count = 1;
        while (!queue.isEmpty()) {
            for (int i = 0; i < n; i++) {
                if (priorities[i] == queue.peek()) {
                    if (i == k) {
                        return count;
                    }
                    queue.poll();
                    count++;
                }
            }
        }
        return count;
    }

}
