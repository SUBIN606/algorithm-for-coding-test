import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        String[] neverHeardPeoples = new String[n];
        for (int i = 0; i < n; i++) {
            neverHeardPeoples[i] = reader.readLine();
        }

        String[] neverSeenPeoples = new String[m];
        for (int i = 0; i < m; i++) {
            neverSeenPeoples[i] = reader.readLine();
        }

        String[] result = solution(neverHeardPeoples, neverSeenPeoples);
        writer.write(result.length + "\n");
        for (String name : result) {
            writer.write(name + "\n");
        }
        writer.flush();
        writer.close();
    }

    /*
     * 듣보잡
     *
     * 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어진다.
     * 듣도 보도 못한 사람의 명단을 구하라.
     *
     * input - 듣도 못한 사람의 배열, 보도 못한 사람의 배열
     * output - 두 배열의 교집합을 사전순으로 반환
     * */
    public static String[] solution(String[] neverHeardPeoples, String[] neverSeenPeoples) {
        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, neverHeardPeoples);

        ArrayList<String> intersection = new ArrayList<>();
        for (String name : neverSeenPeoples) {
            if (set.contains(name)) {
                intersection.add(name);
            }
        }

        Collections.sort(intersection);

        return intersection.toArray(String[]::new);
    }

}
