class Pair{
    String first;
    int second;
    public Pair(String first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        Set<String> st=new HashSet<String>();
        for(int i=0;i<wordList.size();i++){
            st.add(wordList.get(i));
        }
        st.remove(beginWord);
        while(!q.isEmpty()){
            String word=q.peek().first;
            int steps=q.peek().second;
            q.remove();

            if(word.equals(endWord)==true) return steps;

            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char replacechar[]=word.toCharArray();
                    replacechar[i]=ch;
                    String replaceword=new String(replacechar);

                    if(st.contains(replaceword)==true){
                        st.remove(replaceword);
                        q.add(new Pair(replaceword,steps+1));
                    }
                }    
            }       
            }
            return 0;
    }
}