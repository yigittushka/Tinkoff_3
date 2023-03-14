
import java.util.*;

public class Task4 {
    public static void main(String[] args) {

         func();
    }

    static void func(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        Map<Integer, Integer> cnt = new HashMap<>();
        Set<Pair> st = new TreeSet<>();
        int ans = -1;
        for (int l = 1; l <= n; l++) {
            st.remove(new Pair(cnt.get(a[l]), a[l]));
            cnt.put(a[l], cnt.getOrDefault(a[l], 0) + 1);
            st.add(new Pair(cnt.get(a[l]), a[l]));

            int mn = st.iterator().next().first;
            int mx = ((TreeSet<Pair>) st).last().first;
            if (mn == mx) {
                ans = l;
                continue;
            }
            int cntMN = 1, cntMX = 1;
            if (st.size() > 1) {
                Iterator<Pair> it = st.iterator();
                it.next();
                if (it.next().first == mn) {
                    cntMN = 2;
                }
                it = ((TreeSet<Pair>) st).descendingIterator();
                it.next();
                if (it.next().first == mx) {
                    cntMX = 2;
                }
            }
            if (mn + 1 == mx && cntMX == 1) {
                ans = l;
            }
            if (mn == 1 && cntMN == 1) {
                if (st.size() > 1) {
                    Iterator<Pair> it = st.iterator();
                    it.next();
                    if (it.next().first == mx) {
                        ans = l;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}

class Pair implements Comparable<Pair> {
    int first, second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair o) {
        if (first != o.first) {
            return first - o.first;
        }
        return second - o.second;
    }
    }

