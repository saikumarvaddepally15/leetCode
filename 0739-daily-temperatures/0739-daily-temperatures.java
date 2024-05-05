class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
       Stack<Integer> st = new Stack<>();
       int[] ans = new int[temperatures.length];
       for(int i=temperatures.length-1;i>=0;i--){
        //to remove smaller elements

        while( !st.empty()&& temperatures[st.peek()]<=temperatures[i]){
            st.pop();
        }
        if(st.empty()){
             ans[i]=0;
        }else{
            ans[i]=st.peek()-i;
        }
        st.push(i);
       }
     return ans;  
    }
 
}