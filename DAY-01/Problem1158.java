import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1158 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        writer.write("<");
        String result = String.join(", ", Arrays.stream(solution(n, k))
                .mapToObj(String::valueOf)
                .toArray(String[]::new));
        writer.write(result);
        writer.write(">");
        writer.flush();
        writer.close();
    }

    /*
     * 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
     * 이제 순서대로 K번째 사람을 제거한다.
     * 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
     * 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
     * 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다.
     *
     * N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
     */

    // input - 첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다.
    // output - 요세푸스 순열을 <3, 6, 2, 7, 5, 1, 4> 와 같은 형식으로 출력한다.
    public static int[] solution(int n, int k) {
        int[] answer = new int[n];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n ; i++) {
            queue.add(i);
        }

        int idx = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < k-1; i++) {
                Integer poll = queue.poll();
                queue.add(poll);
            }
            Integer poll = queue.poll();
            answer[idx] = poll;
            idx++;
        }

        return answer;
    }

}
