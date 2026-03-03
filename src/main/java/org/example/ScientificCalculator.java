package org.example;

import java.util.Scanner;
import java.io.PrintWriter;

public class ScientificCalculator {
    public static double add(double a,double b){
        return a+b;
    }

    public static double subtract(double a,double b){
        return a-b;
    }

    public static double multiply(double a,double b){
        return a*b;
    }

    public static double divide(double a, double b) throws Exception{
        if(b==0){
            throw new ArithmeticException("Divide by 0 error");
        }
        else{
            return a/b;
        }
    }

    public static double power(double a,double b){
        return Math.pow(a,b);
    }

    public static double sqrt(double a) throws Exception{
        if(a<0){
            throw new ArithmeticException("Error! Attempt to sqaure root to negative image");
        }
        else{
            return Math.sqrt(a);
        }
    }

    public static double logarithm(double a) throws Exception{
        if(a<=0){
            throw  new ArithmeticException("Error! Logarithm of zero or negative number.");
        }
        else{
            return Math.log(a);
        }
    }

    public static double factorial(double num) {
        if (num < 0) {
            throw new ArithmeticException("Error! Factorial of a negative number.");
        }
        double result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        int choice;

        do{
            System.out.println("\nScientific Calculator:\n" +
                    "Enter your choice:\n" +
                    "1.Add\n" +
                    "2.Subtract\n" +
                    "3.Multiply\n" +
                    "4.Divide\n" +
                    "5.Power\n" +
                    "6.Square Root\n" +
                    "7.Logarithm\n" +
                    "8.Factorial\n" +
                    "9.Exit");

            choice=sc.nextInt();

            double num1=0;
            double num2=0;

            if (choice == 9) {
                System.out.println("Exiting the calculator...");
                break; 
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter two numbers: ");
                    num1 = sc.nextDouble();
                    num2 = sc.nextDouble();
                    try {
                        System.out.println("Result: " + add(num1, num2));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter two numbers: ");
                    num1 = sc.nextDouble();
                    num2 = sc.nextDouble();
                    try {
                        System.out.println("Result: " + subtract(num1, num2));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Enter two numbers: ");
                    num1 = sc.nextDouble();
                    num2 = sc.nextDouble();
                    try {
                        System.out.println("Result: " + multiply(num1, num2));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Enter two numbers: ");
                    num1 = sc.nextDouble();
                    num2 = sc.nextDouble();
                    try {
                        System.out.println("Result: " + divide(num1, num2));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Enter base and exponent: ");
                    num1 = sc.nextDouble();
                    num2 = sc.nextDouble();
                    try {
                        System.out.println("Result: " + power(num1, num2));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.print("Enter a number: ");
                    num1 = sc.nextDouble();
                    try {
                        System.out.println("Result: " + sqrt(num1));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.print("Enter a number: ");
                    num1 = sc.nextDouble();
                    try {
                        System.out.println("Result: " + logarithm(num1));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    System.out.print("Enter a number: ");
                    num1 = sc.nextDouble();
                    try {
                        System.out.println("Result: " + factorial(num1));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }while (true);
    }
}
