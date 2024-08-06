class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        
        ArrayList<Integer> sumarr = new ArrayList<>();
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum=sum+nums[j];
                sumarr.add(sum);
            }
        }
        Collections.sort(sumarr);
        int MOD = 1000000007;
        int result=0;
        for(int i=left-1;i<right;i++){
             result = (result + sumarr.get(i)) % MOD;
        }
        return result;
    }
}