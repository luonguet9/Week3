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
        if (denominator == 0) {
            this.numerator = 0;
            this.denominator = 1;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }

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

    /**
     * Set denominator is different 0.
     */
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            return;
        }
        this.denominator = denominator;
    }

    /**
     * Comments.
     */
    public Solution reduce() {
        Solution newSolution = new Solution();
        int x = gcd(this.numerator, this.denominator);
        newSolution.numerator = this.numerator / x;
        newSolution.denominator = this.denominator / x;
        return newSolution;
    }

    /**
     * Comments.
     */
    public Solution add(Solution other) {
        this.setNumerator(this.numerator * other.denominator + this.denominator * other.numerator);
        this.setDenominator(this.getDenominator() * other.getDenominator());
        return this.reduce();
    }

    /**
     * Comments.
     */
    public Solution subtract(Solution other) {
        this.setNumerator(this.numerator * other.denominator - this.denominator * other.numerator);
        this.setDenominator(this.getDenominator() * other.getDenominator());
        return this.reduce();
    }

    /**
     * Comments.
     */
    public Solution multiply(Solution other) {
        this.setNumerator(this.getNumerator() * other.getNumerator());
        this.setDenominator(this.getDenominator() * other.getDenominator());
        return this.reduce();
    }

    /**
     * Comments.
     */
    public Solution divide(Solution other) {
        if (other.denominator == 0) {
            return this;
        }
        this.setNumerator(this.getNumerator() * other.getDenominator());
        this.setDenominator(this.getDenominator() * other.getNumerator());
        return this.reduce();
    }

    /**
     * Comments.
     */
    public boolean equals(Object obj) {
        if (obj instanceof Solution) {
            Solution other = (Solution) obj;
            return this.numerator * other.denominator - this.denominator * other.numerator == 0;
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

