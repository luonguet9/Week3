public class Solution {
    private int numerator;
    private int denominator;

    /**
     * Comments.
     */
    public Solution() {
        this.denominator = 1;
    }

    /**
     * Comments.
     */
    public Solution(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    /**
     * Comments.
     */
    public Solution reduce() {
        int x = gcd(this.numerator, this.denominator);
        this.setNumerator(this.numerator / x);
        this.setDenominator(this.denominator / x);
        return this;
    }

    /**
     * Comments.
     */
    public Solution add(Solution other) {
        this.setNumerator(this.getNumerator() * other.getDenominator() + this.getDenominator() * other.getNumerator());
        this.setDenominator(this.getDenominator() * other.getDenominator());
        reduce();
    }

    /**
     * Comments.
     */
    public Solution subtract(Solution other) {
        this.setNumerator(this.getNumerator() * other.getDenominator() - this.getDenominator() * other.getNumerator());
        this.setDenominator(this.getDenominator() * other.getDenominator());
        reduce();
    }

    /**
     * Comments.
     */
    public Solution multiply(Solution other) {
        this.setNumerator(this.getNumerator() * other.getNumerator());
        this.setDenominator(this.getDenominator() * other.getDenominator());
        reduce();
    }

    /**
     * Comments.
     */
    public Solution divide(Solution other) {
        this.setNumerator(this.getNumerator() * other.getDenominator());
        this.setDenominator(this.getDenominator() * other.getNumerator());
        reduce();
    }

    /**
     * Comments.
     */
    public boolean equals(Object obj) {
        if (obj instanceof Solution) {
            Solution other = (Solution) obj;
            if (this.getNumerator() * other.getDenominator() - this.getDenominator() * other.getNumerator() == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Fibonacci.
     */
    public long fibonacci(long n) {
        if (n < 0) {
            return -1;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        long a = 0;
        long b = 1;
        long i = 2;
        long res = 0;
        while (i <= n) {
            res = a + b;
            a = b;
            b = res;
            i++;
        }
        if (res < 0) {
            return Long.MAX_VALUE;
        }
        return res;
    }


    /**
     * GCD.
     */
    public int gcd(int a, int b) {
        if (a < 0) {
            a = -a;
        }
        if (b < 0) {
            b = -b;
        }
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    /**
     * Prime check.
     */
    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

