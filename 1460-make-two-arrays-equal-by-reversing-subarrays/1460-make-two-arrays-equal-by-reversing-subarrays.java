class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] cnt1=new int[1001];
        int[] cnt2=new int[1001];
        for(int i: target){
            ++cnt1[i];
        }
        for(int j: arr){
            ++cnt2[j];
        }
       return  Arrays.equals(cnt1,cnt2);
    }
}