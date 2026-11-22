class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // put each value v in range [1, n] at index v - 1
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int target = nums[i] - 1;
                int tmp = nums[target];
                nums[target] = nums[i];
                nums[i] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1; // first slot holding the wrong value
        }
        return n + 1; // 1..n all present
    }
}
