class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long max = 0L; // Use long to prevent integer overflow
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    long current = (long)(nums[i] - nums[j]) * nums[k];
                    if (current > max) {
                        max = current;
                    }
                }
            }
        }
        
        return max;
    }
}