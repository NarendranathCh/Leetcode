class Solution {
    public boolean canAliceWin(int[] nums) {
        int singledigit=0;
        int doubleDigit=0;
        int totalSum=0;
        for(int num : nums){
            totalSum += num;
            if(num<=9){
                singledigit+=num;
                }else if (num >= 10) {
                    doubleDigit+= num;
            }
        }
        if(singledigit>totalSum-singledigit){
            return true;
        }
        if(doubleDigit>totalSum-doubleDigit){
            return true;
        }
        return false;
    }
}
      