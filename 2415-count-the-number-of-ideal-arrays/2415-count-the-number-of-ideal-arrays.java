class Solution {
    private static final int MOD = (int) (1e9 + 7); // 10^9 + 7
    public int idealArrays(int n, int maxValue) {
        int[][] comb = new int[n + 14][14]; // n + k - 1 choose k-1, where k can be up to 13 (since 2^13 > 5000)
        comb[0][0] = 1;
        for (int i = 1; i < comb.length; i++) {
            comb[i][0] = 1;
            for (int j = 1; j < comb[i].length; j++) {
                comb[i][j] = (comb[i-1][j-1] + comb[i-1][j]) % MOD;
            }
        }
        
        // For each number from 1 to maxValue, factorize it and count the exponents
        int result = 0;
        for (int num = 1; num <= maxValue; num++) {
            List<Integer> exponents = new ArrayList<>();
            int temp = num;
            
            // Factorize the number into its prime factors
            for (int p = 2; p * p <= temp; p++) {
                if (temp % p == 0) {
                    int cnt = 0;
                    while (temp % p == 0) {
                        temp /= p;
                        cnt++;
                    }
                    exponents.add(cnt);
                }
            }
            if (temp > 1) {
                exponents.add(1);
            }
            
            // Calculate the product of combinations for each exponent
            long product = 1;
            for (int e : exponents) {
                product = product * comb[n + e - 1][e] % MOD;
            }
            result = (result + (int) product) % MOD;
        }
        
        return result;
    }
}