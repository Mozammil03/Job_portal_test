package com.example.demo;

public class Test {

    public static void main(String[] args) {
        System.out.println("Debugging started...");

        int result = calculateSum(10);              // Step Into
        System.out.println("Sum: " + result);

        int factorialResult = factorial(5);         // Step Into
        System.out.println("Factorial: " + factorialResult);

        checkEvenOdd(result);                       // Inspect conditions

        try {
            riskyDivision(10, 0);                   // Trace exception
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        System.out.println("Debugging ended.");
    }

    public static int calculateSum(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {              // Loop iteration
            sum += i;
        }
        return sum;
    }

    public static int factorial(int n) {
        if (n <= 1)
            return 1;
        else
            return n * factorial(n - 1);           // Recursive step-into
    }

    public static void checkEvenOdd(int num) {
        if (num % 2 == 0) {
            System.out.println(num + " is Even");
        } else {
            System.out.println(num + " is Odd");
        }
    }

    public static void riskyDivision(int a, int b) {
        int result = a / b;                        // Force exception (div by zero)
        System.out.println("Result: " + result);
    }
}
