class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";

        HashMap <Character,Integer> map = new HashMap<>();

        for(char c : t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int required=map.size();
        int min=Integer.MAX_VALUE;
        int formed=0;
        int left=0;
        int rightIndex=0;
        int leftIndex=0;

        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)==0){
                    formed++;
                }
            }
            while(formed==required){
                char l=s.charAt(left);
                if(right-left+1<min){
                    min=right-left+1;
                    rightIndex=right;
                    leftIndex=left;
                }
                if(map.containsKey(l)){
                    map.put(l,map.get(l)+1);
                    if(map.get(l)>0){
                        formed--;
                    }
                    left++;
                }else{
                    left++;
                }
            }
        }
        if(min==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(leftIndex,rightIndex+1);
    }
}
