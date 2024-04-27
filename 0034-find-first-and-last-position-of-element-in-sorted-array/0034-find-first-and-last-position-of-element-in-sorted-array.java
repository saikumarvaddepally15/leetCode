class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstPos = findFirstPosition(nums, target);
        if (firstPos == -1) {  
            return new int[] {-1, -1};
        }
        int lastPos = findLastPosition(nums, target);
        return new int[] {firstPos, lastPos};
    }

    private int findFirstPosition(int[] nums, int target) {
        int index = -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                if (nums[mid] == target) index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }

    private int findLastPosition(int[] nums, int target) {
        int index = -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= target) {
                if (nums[mid] == target) index = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }
}
       
    
