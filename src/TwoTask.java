import java.util.Scanner;

public class TwoTask {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double n = scanner.nextInt();
        double m = scanner.nextInt();
        double k = scanner.nextInt();
        int r = 0;
        double a = 0;
        for (int i = 0; i < n ; i++){

            a =  a + (m/k);
            r++;
            if (a >= n){
                break;
            }
        }



        System.out.println(r);
    }
}
