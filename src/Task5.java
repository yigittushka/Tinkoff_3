import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Task5 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }
    static class Task {
        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = in.nextInt();
            }
            long[] p = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                p[i] = p[i - 1] + a[i];
            }
            Map<Long, Integer> last = new HashMap<>();
            last.put(0L, 0);
            int lastI = 0;
            long ans = 0;
            for (int j = 1; j <= n; j++) {
                if (!last.containsKey(p[j])) {
                    last.put(p[j], j);
                    continue;
                }
                int i = last.get(p[j]) + 1;
                long cntL = (i - lastI);
                long cntR = (n - j + 1);
                ans += cntL * cntR;
                lastI = i;
                last.put(p[j], j);
            }
            out.println(ans);
        }
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
