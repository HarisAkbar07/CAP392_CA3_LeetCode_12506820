class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;

        for (int[] customer : accounts) {
            int wealth = 0;
            for (int bank : customer) wealth += bank; // total across all banks
            max = Math.max(max, wealth);              // track richest so far
        }
        return max;
    }
}
