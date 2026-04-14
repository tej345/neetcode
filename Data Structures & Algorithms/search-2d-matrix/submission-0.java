class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low=0;
        int rows=matrix.length;
        int cols=matrix[0].length;
        int high=rows*cols-1;
        while(low<=high){
            int mid=low + (high-low)/2;
            int midVal = matrix[mid/cols][mid%cols];
            if(midVal==target){
                return true;
            }else if(midVal<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
    }
}
