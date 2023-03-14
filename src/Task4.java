import java.util.*;
import java.io.*;

public class Task4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 1];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st1.nextToken());
        }
        Map<Integer, Integer> cnt = new HashMap<>();
        TreeSet<Pair> st = new TreeSet<>();
        int ans = -1;
        for (int l = 1; l <= n; l++) {
            st.remove(new Pair(cnt.get(a[l]), a[l]));
            cnt.put(a[l], cnt.getOrDefault(a[l], 0) + 1);
            st.add(new Pair(cnt.get(a[l]), a[l]));

            int mn = st.first().x;
            int mx = st.last().x;
            if (mn == mx) {
                ans = l;
                continue;
            }
            int cntMN = 1, cntMX = 1;
            if (st.size() > 1) {
                Pair it = st.first();
                it = st.higher(it);
                if (it.x == mn) {
                    cntMN = 2;
                }
                it = st.last();
                it = st.lower(it);
                if (it.x == mx) {
                    cntMX = 2;
                }
            }
            if (mn + 1 == mx && cntMX == 1) {
                ans = l;
            }
            if (mn == 1 && cntMN == 1) {
                if (st.size() > 1) {
                    Pair it = st.first();
                    it = st.higher(it);
                    if (it.x == mx) {
                        ans = l;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}

class Pair implements Comparable<Pair> {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair o) {
        if (x != o.x) {
            return x - o.x;
        }
        return y - o.y;
    }
}


//import java.util.*;
//import java.io.*;
//
//public class Task4 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int[] a = new int[n + 1];
//        StringTokenizer st1 = new StringTokenizer(br.readLine());
//        for (int i = 1; i <= n; i++) {
//            a[i] = Integer.parseInt(st1.nextToken());
//        }
//        Map<Integer, Integer> cnt = new HashMap<>();
//        TreeSet<Pair> st = new TreeSet<>();
//        int ans = -1;
//        for (int l = 1; l <= n; l++) {
//            st.remove(new Pair(cnt.get(a[l]), a[l]));
//            cnt.put(a[l], cnt.getOrDefault(a[l], 0) + 1);
//            st.add(new Pair(cnt.get(a[l]), a[l]));
//
//            int mn = st.first().x;
//            int mx = st.last().x;
//            if (mn == mx) {
//                ans = l;
//                continue;
//            }
//            int cntMN = 1, cntMX = 1;
//            if (st.size() > 1) {
//                Pair it = st.first();
//                it = st.higher(it);
//                if (Objects.requireNonNull(it).x == mn) {
//                    cntMN = 2;
//                }
//                it = st.last();
//                it = st.lower(it);
//                if (Objects.requireNonNull(it).x == mx) {
//                    cntMX = 2;
//                }
//            }
//            if (mn + 1 == mx && cntMX == 1) {
//                ans = l;
//            }
//            if (mn == 1 && cntMN == 1) {
//                if (st.size() > 1) {
//                    Pair it = st.first();
//                    it = st.higher(it);
//                    if (Objects.requireNonNull(it).x == mx) {
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
//    int x, y;
//
//    Pair(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    @Override
//    public int compareTo(Pair o) {
//        if (x != o.x) {
//            return x - o.x;
//        }
//        return y - o.y;
//    }
//}
//




//
//import java.util.*;
//
//public class Task4 {
//    public static void main(String[] args) {
//
//         func();
//    }
//
//    static void func(){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] a = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            a[i] = sc.nextInt();
//        }
//        Map<Integer, Integer> cnt = new HashMap<>();
//        TreeSet<Pair> st = new TreeSet<>();
//        int ans = -1;
//        for (int l = 1; l <= n; l++) {
//            st.remove(new Pair(cnt.get(a[l]), a[l]));
//            cnt.put(a[l], cnt.getOrDefault(a[l], 0) + 1);
//            st.add(new Pair(cnt.get(a[l]), a[l]));
//
//            int mn = st.iterator().next().first;
//            int mx = st.last().first;
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
//                it = st.descendingIterator();
//                it.next();
//                if (it.next().first == mx) {
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
//    }

