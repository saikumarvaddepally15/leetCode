class Solution {
    public int findMin(int[] nums) {
       int low = 0;
        int high=nums.length-1;
        int ans= Integer.MAX_VALUE;
        if(nums.length==1){
            return nums[low];
        }
        while (low <= high) {
            if (nums[low] < nums[high]) {
                ans = Math.min(ans, nums[low]);
                break; 
            }
            int mid = (low + high) / 2;
            ans = Math.min(ans, nums[mid]); 
            
            if (nums[mid] > nums[high]) {
                
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                
                high = mid;
            } else {
                high--;
            }
        }
        return ans;
    }
    } 
    
