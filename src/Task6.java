import java.util.*;


import static java.lang.Math.max;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int[] array = new int[n + 1];
        int[] array1 = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = scanner.nextInt();
            array1[i] = scanner.nextInt();
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(array[i]);
            list.add(array1[i]);
        }
        Collections.sort(list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == list.get(i - 1)) {
                list.remove(i);
                i--;
            }
        }
        long answer = -1;
        int mid = list.size() / 2;
        for (int del = -1; del <= 1; del++) {
            int i = mid + del;
            if (i >= 1 && i <= n)
                answer = max(answer, Check(list.get(i), list.get(i), array, array1, n, s));
        }
        for (int del = -1; del <= 1; del++) {
            int i = del + mid;
            if (i >= 1 && i < n)
                answer = max(answer, Check(list.get(i), list.get(i + 1), array, array1, n, s));
        }
        System.out.println(answer);
    }

    public static long Check(int l, int r, int[] array, int[] array1, int n, int s) {
        int A = 0;
        int B = 0;
        long sum = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (array[i] < l) {
                A++;
                sum += array[i];
            } else if (array[i] > r) {
                B++;
                sum += array[i];
            } else {
                arrayList.add(array[i]);
            }
        }
        Collections.sort(arrayList);
        if (A <= n / 2 && B <= n / 2) {
            for (int i = 0; i < n / 2 - A; i++) {
                sum += arrayList.get(i);
            }
            long oc = max(0, s - sum);
            long c = oc / (n / 2 + 1 - B);
            if (c >= r)
                c = r;
            sum += c * (n / 2 + 1 - B);
            if (sum <= s && c >= l && c <= r)
                return c;
        }
        return -1;
    }
}

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Scanner;
//
//public class Task6 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        int n = in.nextInt();
//        int s = in.nextInt();
//        int[] ql = new int[n + 1];
//        int[] qr = new int[n + 1];
//        for (int i = 1; i <= n; i++){
//            ql[i] = in.nextInt();
//            qr[i] = in.nextInt();
//        }
//        long ans = check(ql, qr, n, s);
//        System.out.println(ans);
//    }
//    public static long check(int[] ql, int[] qr, int n, int s){
//        int A = 0;
//        int B = 0;
//        long sum = 0;
//        ArrayList<Integer> L = new ArrayList<>();
//        for (int i = 1; i <= n; i++){
//            if (qr[i] < s){
//                A++;
//                sum += ql[i];
//            }else if (ql[i] > r){
//                B++;
//                sum += ql[i];
//            }else{
//                L.add(ql[i]);
//            }
//        }
//        Collections.sort(L);
//        if (A <= n / 2 && B <= n / 2){
//            for (int i = 0; i < n / 2 - A; i++){
//                sum += L.get(i);
//            }
//            long oc = Math.max(0, s - sum);
//            long c = oc / ((n / 2 + 1 - B));
//            if (c >= r) c = r;
//            sum += c * 1ll * (n / 2 + 1 - B);
//            if (sum <= s && c >= l && c <= r) return c;
//        }
//        return -1;
//    }
//}