class Solution {
    public int subtractProductAndSum(int n) {
        int product = 1; // starts at 1, the identity for multiplication
        int sum = 0;     // starts at 0, the identity for addition

        while (n > 0) {
            int digit = n % 10; // last digit of n
            product *= digit;
            sum += digit;
            n /= 10;            // drop the last digit
        }

        return product - sum;
    }
}
