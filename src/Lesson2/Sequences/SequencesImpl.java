package Lesson2.Sequences;

import java.util.Scanner;


public class SequencesImpl implements Sequences {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        SequencesImpl sequences = new SequencesImpl();
        sequences.a(n);
    }


    @Override
    public void a(int n) {
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    @Override
    public void b(int n) {

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                System.out.println(i);
            }
        }
    }

    @Override
    public void c(int n) {
        for (int i = 1; i <= n; i++) {
            int a = i * i;
            System.out.println(a);

        }

    }

    @Override
    public void d(int n) {
        for (int i = 1; i <= n; i++) {
            int a = i * i * i;
            System.out.println(a);
        }
    }

    @Override
    public void e(int n) {

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.println(-1);
            } else {
                System.out.println(1);
            }
        }

    }

    @Override
    public void f(int n) {

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.println(-i);
            } else {
                System.out.println(i);
            }
        }
    }

    @Override
    public void g(int n) {

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                int a = i * i;
                System.out.println(a);
            } else {
                int a = i * i;
                System.out.println(-a);
            }

        }

    }

    @Override
    public void h(int n) {

        for (int i = 1; i <= n; i++) {
            System.out.println(i + "\n0");
        }
    }

    @Override
    public void i(int n) {


        int a = 1;
        for (int i = 1; i <= n; i++) {
            a = a * i;
            System.out.println(a);
        }

    }

    @Override
    public void j(int n) {

        int[] array = new int[n];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < array.length; ++i) {
            array[i] = array[i - 1] + array[i - 2];
            System.out.println(array[i]);
        }
    }
}
