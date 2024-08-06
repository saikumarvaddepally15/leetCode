class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String,Integer> map=new HashMap<>();
        for(String word: arr){
                map.put(word,map.getOrDefault(word,0)+1);
        }
            List<String> distinct = new ArrayList<>();
            for(String word: arr){
                if(map.get(word)==1){
                    distinct.add(word);
                }
            }
            if(k<=distinct.size()){
                return distinct.get(k-1);
            }else{
                return "";
            }

        }
    }
