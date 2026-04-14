class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int freq[]=new int[26];
        int left=0;
        for(char c:s1.toCharArray()){
            freq[c-'a']++;
        }
        for(int right=0;right<s2.length();right++){
            char c=s2.charAt(right);
            freq[c-'a']--;

            while(freq[c-'a']<0){
                freq[s2.charAt(left)-'a']++;
                left++;
            }
            if(right-left+1==s1.length()){
                return true;
            }
        }
        return false;
    }
}
