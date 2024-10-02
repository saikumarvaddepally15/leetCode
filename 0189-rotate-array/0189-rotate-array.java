class Solution {
     //  Anti-clockwise traversal
    public void rotate(int[] nums, int k) {
        
        k = k%nums.length;
        
        //Reverse entire array
        reverse(nums, 0, nums.length-1);

        //reverse first k-elements
        reverse(nums, 0, k-1);

        //reverse remaining element
        reverse(nums, k, nums.length-1);
    }


    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}