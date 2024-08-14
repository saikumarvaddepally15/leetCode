import java.util.Arrays;

class Solution {
    
    int countPairs(int[] nums, int maxDistance) {
        int count = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            while (nums[r] - nums[l] > maxDistance) {
                l++;
            }
            count += r - l; 
        }
        return count;
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length - 1] - nums[0];
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            int count = countPairs(nums, mid);

            if (count < k) {
                low = mid + 1;
            } else {
                result = mid;
                high = mid - 1;
            }
        }

        return result;
    }
}
