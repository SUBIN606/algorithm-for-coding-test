import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Problem9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            writer.write(solution(reader.readLine()) ? "YES\n" : "NO\n");
        }

        writer.flush();
        writer.close();
    }

    /*
     * 괄호
     *
     * 괄호 문자열은 두 개의 괄호 기호인 '(' 와 ')' 만으로 구성되어 있는 문자열이다.
     * 입력으로 주어진 괄호 문자열이 VPS(Valid PS)인지 아닌지를 판단해서 그 결과를 YES와 NO로 나타내시오.
     *
     * input - 괄호 문자열이 주어진다. 길이는 2 이상 50 이하이다.
     * output - 괄호 문자열이 VPS이면 "YES"를 아니면 "NO"를 반환한다.
     * */
    public static boolean solution(String ps) {
        Stack<Character> stack = new Stack<>();
        for (char c : ps.toCharArray()) {
            // 여는 괄호가 나오면 스택에 추가한다.
            if (c == '(') {
                stack.push(c);
            }

            // 닫는 괄호가 나오면
            if (c == ')') {
                // 스택이 이미 비었는데 닫는 괄호가 나왔다는 것은 비정상이므로 바로 false 반환.
                if (stack.isEmpty()) {
                    return false;
                }
                // 스택에서 뺀다.
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
