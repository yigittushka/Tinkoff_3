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
            int[] array = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                array[i] = in.nextInt();
            }
            long[] p = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                p[i] = p[i - 1] + array[i];
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
//
//
//
////
//
//import java.util.*;
//        import java.io.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int[] a = new int[n + 1];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 1; i <= n; i++) {
//            a[i] = Integer.parseInt(st.nextToken());
//        }
//        Map<Integer, Integer> cnt = new HashMap<>();
//        Set<Pair> st = new TreeSet<>();
//        int ans = -1;
//        for (int l = 1; l <= n; l++) {
//            st.remove(new Pair(cnt.get(a[l]), a[l]));
//            cnt.put(a[l], cnt.getOrDefault(a[l], 0) + 1);
//            st.add(new Pair(cnt.get(a[l]), a[l]));
//
//            int mn = st.iterator().next().first;
//            int mx = ((TreeSet<Pair>) st).last().first;
//            if (mn == mx) {
//                ans = l;
//                continue;
//            }
//            int cntMN = 1, cntMX = 1;
//            if (st.size() > 1) {
//                Iterator<Pair> it = st.iterator();
//                it.next();
//                if (it.next().first == mn) {
//                    cntMN = 2;
//                }
//                it = st.iterator();
//                while (it.hasNext()) {
//                    it.next();
//                }
//                it.previous();
//                if (it.previous().first == mx) {
//                    cntMX = 2;
//                }
//            }
//            if (mn + 1 == mx && cntMX == 1) {
//                ans = l;
//            }
//            if (mn == 1 && cntMN == 1) {
//                if (st.size() > 1) {
//                    Iterator<Pair> it = st.iterator();
//                    it.next();
//                    if (it.next().first == mx) {
//                        ans = l;
//                    }
//                }
//            }
//        }
//        System.out.println(ans);
//    }
//}
//
//class Pair implements Comparable<Pair> {
//    int first, second;
//
//    Pair(int first, int second) {
//        this.first = first;
//        this.second = second;
//    }
//
//    @Override
//    public int compareTo(Pair o) {
//        if (first != o.first) {
//            return first - o.first;
//        }
//        return second - o.second;
//    }
//}