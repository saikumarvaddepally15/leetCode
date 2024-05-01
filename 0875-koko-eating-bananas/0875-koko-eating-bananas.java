class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=0, high= findMax(piles);
        while(low<=high){
            int mid=(low+high)/2;
            int th=totalHours(piles,mid);
            if(th<=h){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    private int findMax(int[] arr){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
        }
        return max;
    }
    private int totalHours(int[] arr, int hrs){
        int th=0;
        for(int i=0;i<arr.length;i++){
            th+=Math.ceil((double)(arr[i])/(double)(hrs));
        }
        return th;
    }
}