class Solution {
    public int trap(int[] height) {
        int water=0;
        int len=height.length;
        int start=0;

        while(start<len-1) {
            while(start<len-1 && height[start+1]>=height[start]){
                start++;
            }
            if (start>=len-1) break;
            int end=-1;
            int maxIndex=start+1;

            for(int i=start+1;i<len;i++){
                if(height[i]>=height[start]){
                    end=i;
                    break;
                }
                if(height[i]>height[maxIndex]){
                    maxIndex=i;
                }
            }
            if(end==-1){
                end=maxIndex;
            }

            int bound=Math.min(height[start],height[end]);
            for (int i=start+1;i<end;i++){
                water+=bound-height[i];
            }
            start=end;
        }
        return water;
    }
}

