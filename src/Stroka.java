import java.util.Scanner;

import static java.lang.Math.min;

public class Stroka {
    public static void main(String[] args) {

        stringLength();

    }

    public static void stringLength() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        int n = scanner.nextInt();
        String string = scanner1.nextLine();
        if (n != string.length());
        int posa = -1, posb = -1, posc = -1, posd = -1;
        int ans = -1;
        for (int r = 0; r < n; r++) {
            if (string.charAt(r) == 'a') posa = r;
            if (string.charAt(r) == 'b') posb = r;
            if (string.charAt(r) == 'c') posc = r;
            if (string.charAt(r) == 'd') posd = r;
            int l = min(min(posa, posb), min(posc, posd));
            int len = r - l + 1;
            if (l != -1) {
                if (ans == -1 || len < ans) {
                    ans = len;
                }
            }


        }
        System.out.println(ans);
    }
}

