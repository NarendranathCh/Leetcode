public class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int maxCurr = nums[0];
        int minCurr = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = maxCurr;
                maxCurr = minCurr;
                minCurr = temp;
            }

            maxCurr = Math.max(nums[i], maxCurr * nums[i]);
            minCurr = Math.min(nums[i], minCurr * nums[i]);

            maxProd = Math.max(maxProd, maxCurr);
        }

        return maxProd;
    }
}

