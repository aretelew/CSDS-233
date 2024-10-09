package assignment1;

public class MathFunction {
    public static int multiplyRecursive(int x) {
        int result = compute(x, x);
        return result * 2;
    }

    private static int compute(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * compute(base, exponent - 1);
    }

    public static int sqrt(int x, int low, int high) {
        if (low > high || x < 0 || low < 0) {
            return -1;
        }
        for (int i = low; i <= high; i++) {
            if (i * i == x) {
                return i;
            }
        }
        return -1;
    }

}


