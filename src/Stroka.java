import java.util.Scanner;

import static java.lang.Math.min;

public class Stroka {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        int a = -1;
        int b = -1;
        int c = -1;
        int d = -1;
        int result = -1;
        for (int r = 0; r < n; r++){
            if (s.charAt(r) == 'a') {
                a = r;
            } else if (s.charAt(r) == 'b') {
                b = r;
            }else if (s.charAt(r) == 'c') {
                c = r;
            }else if (s.charAt(r) == 'd') {
                d = r;
            }
            int minLenth = min(min(a, b), min(c, d));
            int lenth = r - minLenth + 1;
            if (minLenth != -1){
                if (result == -1 || lenth < result){
                    result = lenth;
                }
            }
        }
        System.out.println(result);
    }
}


//import java.util.Scanner;
//
//import static java.lang.Math.min;
//
//public class Stroka {
//    public static void main(String[] args) {
//
//        stringLength();
//
//    }
//
//    public static void stringLength() {
//        Scanner scanner = new Scanner(System.in);
//        Scanner scanner1 = new Scanner(System.in);
//        int n = scanner.nextInt();
//        String string = scanner1.nextLine();
//        if (n != string.length());
//        int posa = -1, posb = -1, posc = -1, posd = -1;
//        int ans = -1;
//        for (int r = 0; r < n; r++) {
//            if (string.charAt(r) == 'a') posa = r;
//            if (string.charAt(r) == 'b') posb = r;
//            if (string.charAt(r) == 'c') posc = r;
//            if (string.charAt(r) == 'd') posd = r;
//            int l = min(min(posa, posb), min(posc, posd));
//            int len = r - l + 1;
//            if (l != -1) {
//                if (ans == -1 || len < ans) {
//                    ans = len;
//                }
//            }
//
//
//        }
//        System.out.println(ans);
//    }
//}

