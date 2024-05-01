class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(nums[i],max);
        }
        int low=0,high=max;
        while(low<=high){
            int mid=(low+high)/2;
            if(sumByDiv(nums,mid)<=threshold){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    private int sumByDiv(int[] nums,int d){
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=Math.ceil((double)(nums[i])/(double)(d));
        }
        return sum;
    }
}