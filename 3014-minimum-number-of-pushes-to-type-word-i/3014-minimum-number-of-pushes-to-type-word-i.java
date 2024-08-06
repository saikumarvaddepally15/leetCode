class Solution {
    public int minimumPushes(String word) {
        int[] arr=new int[26];
        for(char ch: word.toCharArray()){
            arr[ch-'a']++;
        }
        Arrays.sort(arr);
         for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        int result=0;
        for(int i=0;i<26;i++){
            int freq=arr[i];
            int press=i/8+1;
            result+=press*freq;
        }
        return result;
    }
}