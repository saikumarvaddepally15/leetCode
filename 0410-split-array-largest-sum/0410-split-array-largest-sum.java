class Solution {
    public int splitArray(int[] nums, int k) {
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int i=0;i<nums.length;i++){
            low=Math.max(low,nums[i]);
            high+=nums[i];
        }
        while(low<=high){
            int mid=(low+high)/2;
            int painters=numOfPainters(nums,mid);
            if(painters>k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;

    }
    private int numOfPainters(int[] nums,int sum){
        int painters=1;
        long paintersWork=0;
        for(int i=0;i<nums.length;i++){
            if(paintersWork+nums[i]<=sum){
                paintersWork+=nums[i];
            }else{
                painters++;
                paintersWork=nums[i];
            }
        }
        return painters;
    }
}