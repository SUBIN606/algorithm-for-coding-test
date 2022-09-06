import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int m = Integer.parseInt(reader.readLine());
        tokenizer = new StringTokenizer(reader.readLine(), " ");
        int[] countCards = new int[m];
        for (int i = 0; i < m; i++) {
            countCards[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] result = solution(cards, countCards);
        for (int count : result) {
            writer.write(count + " ");
        }
        writer.flush();
        writer.close();
    }

    /*
     * 숫자 카드 2
     *
     * N개의 숫자 카드가 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드가 몇 개 인지 구하라.
     *
     * input - 숫자카드 배열. 배열의 원소는 -10,000,000 이상 10,000,000이하. 배열의 길이는 1이상 500,000이하.
     *         숫자카드 배열에 몇 번 등장하는지 알고싶은 숫자카드들을 담은 배열
     * output - 각 수가 적힌 숫자 카드를 몇 개 가지고 있는지 출력
     *
     * 예)
     * 숫자카드 배열 - [6 3 2 10 10 10 -10 -10 7 3]
     * 몇 개 가지고 있는지 알고싶은 숫자카드 배열 - [10 9 -5 2 3 4 5 -10]
     *
     * 결과 - [3 0 0 1 2 0 0 2]
     * */
    public static int[] solution(int[] cards, int[] countCards) {

        HashMap<Integer, Integer> map = new HashMap<>();
        // 모든 카드의 개수를 센다.
        for (int card : cards) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        int[] result = new int[countCards.length];
        // 몇 개인지 알고 싶은 카드의 개수만 반환 배열에 담는다.
        for (int i = 0; i < countCards.length; i++) {
            result[i] = map.getOrDefault(countCards[i], 0);
        }

        return result;
    }
}
