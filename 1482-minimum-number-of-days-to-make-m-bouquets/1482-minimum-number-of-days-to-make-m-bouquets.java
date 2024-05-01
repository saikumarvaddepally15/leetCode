class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int min = Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;
        int n=bloomDay.length;
        int val= m*k;
        if(val>n) return -1;
        for(int i=0;i<n;i++){
            min=Math.min(min,bloomDay[i]);
            max=Math.max(max,bloomDay[i]);
        }
        int low=min,high=max;
        while(low<=high){
            int mid=(low+high)/2;
            if(possible(bloomDay,mid,m,k)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;

    }
    private static boolean possible(int[] arr,int day, int m, int k){
        int c=0;
        int noOfBoq=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=day){
                c++;
            }else{
                noOfBoq+=(c/k);
                c=0;
            }
        }
        noOfBoq+=(c/k);
        return noOfBoq>=m;
    }
}