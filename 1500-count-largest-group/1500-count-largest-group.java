class Solution {
    public int countLargestGroup(int n) {
       Map<Integer, Integer> sumCount = new HashMap<>();
        
        // Calculate digit sum for each number from 1 to n
        for (int i = 1; i <= n; i++) {
            int sum = digitSum(i);
            sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
        }
        
        // Find the maximum group size
        int maxSize = 0;
        for (int size : sumCount.values()) {
            maxSize = Math.max(maxSize, size);
        }
        
        // Count how many groups have this maximum size
        int count = 0;
        for (int size : sumCount.values()) {
            if (size == maxSize) {
                count++;
            }
        }
        
        return count;
    }
    
    // Helper function to calculate the sum of digits of a number
    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum; 
    }
}