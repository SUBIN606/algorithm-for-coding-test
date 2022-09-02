import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Problem17413 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = reader.readLine();
        writer.write(solution(s));

        writer.flush();
        writer.close();
    }

    /*
     * 단어 뒤집기 2
     *
     * 문자열 S가 주어졌을 때, 이 문자열에서 단어만 뒤집으려고 한다.
     *
     * 알파벳 소문자('a'-'z'), 숫자('0'-'9'), 공백(' '), 특수 문자('<', '>')로만 이루어져 있다.
     * 문자열의 시작과 끝은 공백이 아니다.
     * '<'와 '>'가 문자열에 있는 경우 번갈아가면서 등장하며, '<'이 먼저 등장한다. 또, 두 문자의 개수는 같다.
     *
     * 태그는 '<'로 시작해서 '>'로 끝나는 길이가 3 이상인 부분 문자열이고, '<'와 '>'사이에는 알파벳 소문자와 공백만 있다.
     * 단어는 알파벳 소문자와 숫자로 이루어진 부분 문자열이고, 연속하는 두 단어는 공백 하나로 구분한다.
     *
     * 태그는 단어가 아니며, 태그와 단어 사이에는 공백이 없다.
     *
     * input - 문자열 S가 주어진다. S의 길이는 100,000이하
     * output - 문자열 S의 단어를 뒤집어서 출력한다.
     * */
    public static String solution(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        //만약 문자열에 '<'가 없으면
        if (s.indexOf('<') == -1) {
            reversePureWords(s, stack, stringBuilder);
            return stringBuilder.toString();
        }

        reverseWithBracketStr(s, stringBuilder, stack);
        return stringBuilder.toString();
    }

    private static void clearStack(Stack<Character> stack, StringBuilder stringBuilder) {
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
    }

    private static void reverseWithBracketStr(String s, StringBuilder stringBuilder, Stack<Character> stack) {
        int idx = 0;
        while (idx < s.length()) {
            //문자열의 첫 글자부터 순회한다.
            char c = s.charAt(idx);
            //글자가 '<' 혹은 '>'라면
            if (c == '<' || c == '>') {
                //stack을 비운다.
                clearStack(stack, stringBuilder);
                int start = s.indexOf('<');
                int end = s.indexOf('>') + 1;
                String substring = s.substring(start, end);
                stringBuilder.append(substring);
                s = s.substring(end);
                idx = 0;
                continue;
            }
            // 글자가 '<'가 아니면 stack에 넣는다.
            if (c == ' ') {
                clearStack(stack, stringBuilder);
                stringBuilder.append(c);
            } else {
                stack.push(c);
            }
            idx++;
        }

        clearStack(stack, stringBuilder);
    }


    private static void reversePureWords(String s, Stack<Character> stack, StringBuilder stringBuilder) {
        if (s.indexOf(' ') == -1) {
            for (int i = s.length() - 1; i > -1; i--) {
                stringBuilder.append(s.charAt(i));
            }
        } else {
            int idx = 0;
            while (idx < s.length()) {
                char c = s.charAt(idx);
                if (c == ' ') {
                    clearStack(stack, stringBuilder);
                    stringBuilder.append(c);
                } else {
                    stack.push(c);
                }
                idx++;
            }
        }
        clearStack(stack, stringBuilder);
    }
}
