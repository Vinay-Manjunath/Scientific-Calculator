package org.example;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ScientificCalculator {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) throws Exception {
        if (b == 0) {
            throw new ArithmeticException("Divide by 0 error");
        }
        return a / b;
    }
    

    public static double power(double a, double b) {
        return Math.pow(a, b);
    }

    public static double sqrt(double a) throws Exception {
        if (a < 0) {
            throw new ArithmeticException("Error! Attempt to sqaure root to negative image");
        }
        return Math.sqrt(a);
    }

    public static double logarithm(double a) throws Exception {
        if (a <= 0) {
            throw new ArithmeticException("Error! Logarithm of zero or negative number.");
        }
        return Math.log(a);
    }

    public static double factorial(double num) {
        if (num < 0) {
            throw new ArithmeticException("Error! Factorial of a negative number.");
        }

        int n = (int) num;
        double result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\nScientific Calculator:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Power");
            System.out.println("6. Square Root");
            System.out.println("7. Logarithm");
            System.out.println("8. Factorial");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
                continue;
            }

            if (choice == 9) {
                System.out.println("Exiting the calculator...");
                break;
            }

            double num1, num2;

            try {

                switch (choice) {

                    case 1:
                        System.out.print("Enter two numbers: ");
                        num1 = sc.nextDouble();
                        num2 = sc.nextDouble();
                        System.out.println("Result: " + add(num1, num2));
                        break;

                    case 2:
                        System.out.print("Enter two numbers: ");
                        num1 = sc.nextDouble();
                        num2 = sc.nextDouble();
                        System.out.println("Result: " + subtract(num1, num2));
                        break;

                    case 3:
                        System.out.print("Enter two numbers: ");
                        num1 = sc.nextDouble();
                        num2 = sc.nextDouble();
                        System.out.println("Result: " + multiply(num1, num2));
                        break;

                    case 4:
                        System.out.print("Enter two numbers: ");
                        num1 = sc.nextDouble();
                        num2 = sc.nextDouble();
                        System.out.println("Result: " + divide(num1, num2));
                        break;

                    case 5:
                        System.out.print("Enter base and exponent: ");
                        num1 = sc.nextDouble();
                        num2 = sc.nextDouble();
                        System.out.println("Result: " + power(num1, num2));
                        break;

                    case 6:
                        System.out.print("Enter a number: ");
                        num1 = sc.nextDouble();
                        System.out.println("Result: " + sqrt(num1));
                        break;

                    case 7:
                        System.out.print("Enter a number: ");
                        num1 = sc.nextDouble();
                        System.out.println("Result: " + logarithm(num1));
                        break;

                    case 8:
                        System.out.print("Enter a number: ");
                        num1 = sc.nextDouble();
                        System.out.println("Result: " + factorial(num1));
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid numeric input.");
                sc.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        sc.close();
    }
}
