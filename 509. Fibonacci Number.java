class Solution {
    public int fib(int n) {
        if (n < 2) return n; // base cases: fib(0)=0, fib(1)=1

        int prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            int next = prev + curr; // fib(i) = fib(i-1) + fib(i-2)
            prev = curr;            // slide the window forward
            curr = next;
        }
        return curr;
    }
}
