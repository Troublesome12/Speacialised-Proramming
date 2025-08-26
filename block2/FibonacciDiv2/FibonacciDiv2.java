public class FibonacciDiv2 {
    
    public int find(int N) {
        if (N == 0)
            return N;

        int temp1 = 0;
        int temp2 = 1;
        int temp3, temp4;

        while (true) {
            temp3 = temp1 + temp2;
            
            if (temp3 < N) {
                temp1 = temp2;
                temp2 = temp3;
            }
            else if (temp3 > N)
                return Math.min(N-temp2, temp3-N);
            else {
                return 0;
            }

        } 
    }

    public static void main(String[] args) {
        System.out.println(new FibonacciDiv2().find(1000000));
    }
}
