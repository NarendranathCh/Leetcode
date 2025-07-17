class Solution {
    public int countDigits(int num) {
       int ans=0;
       int n=num;
       while(n>0){
        int x = n%10;
        if(x!=0 && num%x==0){
            ans++;
        }
        n=n/10;
       } 
    return ans;
    }
}