import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Problem9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = reader.readLine();
        String bomb = reader.readLine();
        writer.write(solution(s, bomb));
        writer.flush();
        writer.close();
    }

    /*
     * 문자열 폭발
     *
     * 폭발 문자열이 폭발하면 그 문자는 문자열에서 사라지며, 남은 문자열은 합쳐지게 된다.
     * 폭발은
     * 1. 문자열이 폭발 문자열을 포함하고 있는 경우에, 모든 폭발 문자열이 폭발하게 된다. 남은 문자열을 순서대로 이어 붙여 새로운 문자열을 만든다.
     * 2. 새로 생긴 문자열에 폭발 문자열이 포함되어 있을 수도 있다.
     * 3. 폭발은 폭발 문자열이 문자열에 없을 때까지 계속된다.
     * 과 같은 과정으로 진행된다.
     *
     * 모든 폭발이 끝난 후에 어떤 문자열이 남는지 구하라. 만약 남아있는 문자가 없는 경우 "FRULA"를 반환하라.
     * 폭발 문자열은 같은 문자를 두 개 이상 포함하지 않는다.
     *
     * input - 문자열. 문자열 길이는 1 이상, 1,000,000 이하
     *         폭발 문자열. 길이는 1 이상, 36 이하
     *         (문자열은 알파펫 소문자와 대문자, 숫자로만 이루어져 있다.)
     * output - 모든 폭발이 끝난 후 남은 문자열
     * */
    public static String solution(String s, String bomb) {
        ArrayList<Character> list = new ArrayList<>();

        // 첫 번째 글자부터 순회한다.
        for (int i = 0; i < s.length(); i++) {
            // 리스트에 문자를 넣는다.
            char c = s.charAt(i);
            list.add(c);

            // 리스트의 길이가 폭발 문자열의 길이와 크거나 같으면
            if (list.size() >= bomb.length()) {
                boolean flag = true;
                // 폭발 문자열을 포함하고 있는지 확인한다.
                for (int j = 0; j < bomb.length(); j++) {
                    if (list.get(list.size() + j - bomb.length()) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                // 포함하고 있다면 폭발 문자열을 제거한다.
                if (flag) {
                    for (int j = 0; j < bomb.length(); j++) {
                        list.remove(list.size() - 1);
                    }
                }
            }
        }

        if (list.isEmpty()) {
            return "FRULA";
        }

        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

//    첫 번째 풀이.. 시간초과, stack 사용 안 함
//    public static String solution(String s, String bomb) {
//        StringBuilder stringBuilder = new StringBuilder(s);
//        int indexOf = stringBuilder.indexOf(bomb);
//        while (indexOf != -1) {
//            stringBuilder.replace(indexOf, indexOf + bomb.length(), "");
//            indexOf = stringBuilder.indexOf(bomb);
//        }
//
//        if (stringBuilder.isEmpty() ) {
//            return "FRULA";
//        }
//
//        return stringBuilder.toString();
//    }

}
