import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         sequence();
    }

    public static void sequence()
    {
        Scanner scanner = new Scanner(System.in);

        int n =4;
        int[] array = new int[4];
        System.out.println("Enter numbers: ");
        for (int i = 0; i < n; i++)
        {


            array[i] = scanner.nextInt();
        }


        boolean isAscending = array[0] < array[1];
        boolean descending = array[0] > array[1];
        for (int i = 2; i < array.length; i++)
        {
            if ((array[i - 1] > array[i] && isAscending) ||
                    (array[i - 1] < array[i] && descending))
            {
                System.out.println("NO");
                return;
            }

        }
        System.out.println("YES");
    }
}

