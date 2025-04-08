class Solution {
    public int minimumOperations(int[] nums) {
        int operations = 0;
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        
        // Check if the array already has distinct elements
        boolean allDistinct = true;
        for (int num : nums) {
            if (set.contains(num)) {
                allDistinct = false;
                break;
            }
            set.add(num);
        }
        if (allDistinct) {
            return 0;
        }
        
        // Perform operations until the remaining elements are distinct
        while (true) {
            operations++;
            int removeCount = Math.min(3, n);
            n -= removeCount;
            
            if (n == 0) {
                return operations;
            }
            
            // Check if the remaining elements are distinct
            set.clear();
            allDistinct = true;
            for (int i = removeCount; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    allDistinct = false;
                    break;
                }
                set.add(nums[i]);
            }
            if (allDistinct) {
                return operations;
            }
            
            // If not, continue with the remaining elements
            int[] newNums = new int[n];
            System.arraycopy(nums, removeCount, newNums, 0, n);
            nums = newNums;
        }
    }
}