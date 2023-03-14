import java.util.Scanner;

public class MyTask2 {
    public static void main(String[] args) {

        calculate();
    }

    static void calculate() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int min = 0;

        for (int i = 0; i <= n; i++) {
            if (m == k) {
                min = n;
            }
            else {
                min = (int) (m * 0.5 / k * n);
            }git
        }
        System.out.println(min);
    }
}