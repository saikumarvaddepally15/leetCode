class Solution {
    public int removeDuplicates(int[] nums) {
        TreeSet<Integer> tmp=new TreeSet<>();
        for(int i=0;i<nums.length;i++){
           if(!tmp.contains(nums[i])){
               tmp.add(nums[i]);
           }
        }
        int k=0;
        for(Integer value: tmp){
            nums[k]=value;
            k++;
        }

        return tmp.size();
    }
}