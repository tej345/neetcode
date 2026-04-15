class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int left=1;
        int right=piles[piles.length-1];
        while(left<=right){
            int mid=left+(right-left)/2;
            long count=0;
            for(int pile :piles){
                int hours=(pile+mid-1)/mid;
                count+=hours;
            }
            if(count<=h){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}
