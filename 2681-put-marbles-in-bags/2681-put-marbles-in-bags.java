class Solution {
    public long putMarbles(int[] weights, int k) {
         int n = weights.length;
        if (k == 1 || n == k) {
            return 0;
        }
        
        List<Integer> candidates = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            candidates.add(weights[i] + weights[i + 1]);
        }
        Collections.sort(candidates);
        
        long min = 0;
        long max = 0;
        for (int i = 0; i < k - 1; i++) {
            min += candidates.get(i);
            max += candidates.get(candidates.size() - 1 - i);
        }
        
        return max - min;
        
    }
}