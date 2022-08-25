import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Problem2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int answer = solution(n);
        writer.write(answer + "");
        writer.flush();
        writer.close();
    }

    /*
     * 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여 있다.
     * 제일 위에 있는 카드를 바닥에 버린다. 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
     * 같은 동작을 카드가 한 장 남을 때까지 반복한다.
     *
     * N이 주어졌을 때, 제일 마지막에 남게 되는 카드를 구하는 프로그램을 작성하시오.
     */
    public static int solution(int n) {
        // 큐를 만든다.
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            // 큐의 가장 앞의 요소를 버린다.
            queue.poll();
            // 그다음 큐의 가장 앞의 요소를 맨 뒤로 옮긴다.
            Integer poll = queue.poll();
            queue.add(poll);
        }

        return queue.poll();
    }

}
