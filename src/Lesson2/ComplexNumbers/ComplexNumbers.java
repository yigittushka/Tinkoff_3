package Lesson2.ComplexNumbers;

import java.util.Scanner;

public class ComplexNumbers {


    double a;
    double b;

    public ComplexNumbers(double a, double b) {
        this.a = a;
        this.b = b;
    }

    // tests
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ComplexNumbers a = new ComplexNumbers(3, 3);
        ComplexNumbers b = new ComplexNumbers(2, 2);
        System.out.println(a.add(a, b));
        System.out.println(a.sub(a, b));
        System.out.println(a.mul(a, b));
        System.out.println(a.div(a, b));
    }

    public ComplexNumbers newComplexNum(double a, double b) {
        return new ComplexNumbers(a, b);
    }

    @Override
    public String toString() {
        return a + "+" + b + "i";
    }

    public ComplexNumbers add(ComplexNumbers num1, ComplexNumbers num2) {
        return new ComplexNumbers(num1.a + num2.a, num1.b + num2.b);
    }

    public ComplexNumbers sub(ComplexNumbers num1, ComplexNumbers num2) {
        return new ComplexNumbers(num1.a - num2.a, num1.b - num2.b);
    }

    public ComplexNumbers mul(ComplexNumbers num1, ComplexNumbers num2) {
        double a = num1.a, b = num1.b, c = num2.a, d = num2.b;
        return new ComplexNumbers(a * c - b * d, b * c + a * d);
    }

    public ComplexNumbers div(ComplexNumbers num1, ComplexNumbers num2) {
        double a = num1.a, b = num1.b, c = num2.a, d = num2.b;
        return new ComplexNumbers((a * c + b * d) / (c * c + d * d),
                (b * c - a * d) / (c * c + d * d));
    }
}
