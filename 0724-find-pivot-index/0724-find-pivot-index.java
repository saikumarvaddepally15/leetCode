class Solution {
    public int pivotIndex(int[] nums) {
        int sum=0;
       
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
        }
        int leftSum=0;
        int rightSum=sum;
        for(int i=0;i<nums.length;i++){
            rightSum=rightSum-nums[i];
            if(rightSum==leftSum){
                return i;
            }
       
                leftSum=leftSum+nums[i];

        }
        return -1;
   }
}