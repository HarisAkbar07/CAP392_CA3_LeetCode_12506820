class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>(); // value -> index

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (seen.containsKey(need)) {        // complement already seen
                return new int[]{seen.get(need), i};
            }
            seen.put(nums[i], i);                // store after check so an element can't pair with itself
        }
        return new int[]{};
    }
}
