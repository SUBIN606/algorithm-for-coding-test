import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Problem9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            int len = Integer.parseInt(reader.readLine());
            String[] clothes = new String[len];
            for (int j = 0; j < len; j++) {
                clothes[j] = reader.readLine();
            }
            writer.write(solution(clothes) + "\n");
        }
        writer.flush();
        writer.close();
    }

    /*
     * 패션왕 신해빈
     *
     * 해빈이는 패션에 매우 민감해서 한번 입었던 옷들의 조합을 절대 다시 입지 않는다.
     * 예를 들어 오늘 해빈이가 안경, 코트, 상의, 신발을 입었다면, 다음날은 바지를 추가로 입거나 안경대신 렌즈를 착용하거나 해야한다.
     * 해빈이가 가진 의상들이 주어졌을때 과연 해빈이는 알몸이 아닌 상태로 며칠동안 밖에 돌아다닐 수 있을까?
     *
     * input - 의상의 이름과 종류가 공백으로 구분된 원소가 들어있는 배열
     * output - 얼마나 많은 조합을 할 수 있는가
     * */
    public static int solution(String[] clothes) {
        return Arrays.stream(clothes)
                .map(str -> str.split(" "))
                .collect(Collectors.toMap(arr -> arr[1], arr -> 1, Integer::sum))
                .values()
                .stream()
                .reduce(1, (i, a) -> i *= (a + 1)) - 1;
    }

}
