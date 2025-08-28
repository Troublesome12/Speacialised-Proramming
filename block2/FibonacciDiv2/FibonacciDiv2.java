public class FibonacciDiv2 {
    
    public int find(int N) {
        int a = 0;
        int b = 1;

        while (b < N) {
            int c = a + b;
            a = b;
            b = c;
        }

        return Math.min(N-a, b-N);
    }

    public static void main(String[] args) {
        System.out.println(new FibonacciDiv2().find(1));       // 0
        System.out.println(new FibonacciDiv2().find(13));      // 0
        System.out.println(new FibonacciDiv2().find(15));      // 2
        System.out.println(new FibonacciDiv2().find(19));      // 2
        System.out.println(new FibonacciDiv2().find(1_000_000)); // 167960
    }
}
