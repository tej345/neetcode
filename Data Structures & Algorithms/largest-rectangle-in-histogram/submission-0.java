class Solution {
    public int largestRectangleArea(int[] heights) {
        int max=0;
        int n=heights.length;
        if(n==1){
            return heights[0];
        }
        Stack <Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            int idx=-1;
            while(!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                idx=stack.pop();
                int left;
                if(stack.isEmpty()){
                    left=-1;
                }else{
                    left=stack.peek();
                }
                int width= i-left-1;
                int area=heights[idx]*width;
                max=Math.max(area,max);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int idx=stack.pop();
             int left;
                if(stack.isEmpty()){
                    left=-1;
                }else{
                    left=stack.peek();
                }
            int width= n-1-left;
            int area=heights[idx]*width;
            max=Math.max(area,max);
        }
        return max;
    }
}
