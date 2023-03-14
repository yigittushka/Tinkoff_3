//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int h1 = sc.nextInt();
//        int h2 = sc.nextInt();
//        int h3 = sc.nextInt();
//        int h4 = sc.nextInt();
//        if (h1 <= h2 && h2 <= h3 && h3 <= h4){
//            System.out.println("YES");
//        }else if (h1 >= h2 && h2 >= h3 && h3 >= h4){
//            System.out.println("YES");
//        }else{
//            System.out.println("NO");
//        }
//    }
//}


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ChekYESorNO();
    }

    public static void ChekYESorNO() {
        Scanner ourNumber = new Scanner(System.in);

        int n = 4;
        int[] array = new int[4];
        for (int i = 0; i < n; i++) {
            int emp = ourNumber.nextInt();
            if (emp >= 0 && emp <= 300) {
                array[i] = emp;
            } else {
                return;
            }
        }

        boolean isAscending = array[0] < array[1];
        boolean descending = array[0] > array[1];
        for (int i = 2; i < array.length; i++) {
            if ((array[i - 1] > array[i] && isAscending) || (array[i - 1] < array[i] && descending)) {
                System.out.println("NO");
                return;
            }

        }
        System.out.println("YES");
    }
}

