package D1E;

import java.util.Arrays;

public class Fibonacci {

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int x = fibonacci(n - 1);
        int y = fibonacci(n - 2);
        return x + y;
    }


    public static int fibonacciP(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = -1;
        return f(n, cache);
    }

    private static int f(int n, int[] cache) {
        if (cache[n] != -1) {
            return cache[n];
        }
        int x = f(n - 1, cache);
        int y = f(n - 2, cache);
        cache[n] = x + y;
        return cache[n];
    }
}
