class Main {
    public static void main(String[] args) {
        Solution n = new Solution(4,6);
        //Scanner sc = new Scanner(System.in);
        System.out.println(n.reduce().getNumerator() + "/" + n.reduce().getDenominator());
        Solution b = new Solution(5, 25);
        System.out.println(n.add(b).getNumerator() + "/" + n.add(b).getDenominator());
        System.out.println(n.fibonacci(9));
        System.out.println(n.gcd(-12, -15));
        System.out.println(n.isPrime(13));
    }
}
