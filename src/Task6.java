import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        int s = in.nextInt();
        int[] ql = new int[n + 1];
        int[] qr = new int[n + 1];
        for (int i = 1; i <= n; i++){
            ql[i] = in.nextInt();
            qr[i] = in.nextInt();
        }
        long ans = check(ql, qr, n, s);
        System.out.println(ans);
    }
    public static long check(int[] ql, int[] qr, int n, int s){
        int A = 0;
        int B = 0;
        long sum = 0;
        ArrayList<Integer> L = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            if (qr[i] < s){
                A++;
                sum += ql[i];
            }else if (ql[i] > r){
                B++;
                sum += ql[i];
            }else{
                L.add(ql[i]);
            }
        }
        Collections.sort(L);
        if (A <= n / 2 && B <= n / 2){
            for (int i = 0; i < n / 2 - A; i++){
                sum += L.get(i);
            }
            long oc = Math.max(0, s - sum);
            long c = oc / ((n / 2 + 1 - B));
            if (c >= r) c = r;
            sum += c * 1ll * (n / 2 + 1 - B);
            if (sum <= s && c >= l && c <= r) return c;
        }
        return -1;
    }
}