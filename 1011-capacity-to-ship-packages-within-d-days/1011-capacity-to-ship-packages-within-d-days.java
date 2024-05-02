class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<weights.length;i++){
            max=Math.max(max,weights[i]);
            sum+=weights[i];
        }
        int low=max,high=sum;
        while(low<=high){
            int mid=(low+high)/2;
            int numOfDays= checkLoad(weights,mid);
            if(numOfDays<=days){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    private int checkLoad(int[] wt,int cap){
        int load=0;
        int days=1;
        for(int i=0;i<wt.length;i++){
            if(load+wt[i]>cap){
                days+=1;
                load=wt[i];
            }else{
                load+=wt[i];
            }
        }
        return days;
    }
}