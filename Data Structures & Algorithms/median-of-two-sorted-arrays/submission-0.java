class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;

        if(n>m){
            return findMedianSortedArrays(nums2,nums1);
        }

        int l1=0;
        int r1=n;

        while(l1<=r1){
            int cut1=l1+(r1-l1)/2;
            int cut2=(n+m+1)/2-cut1;

            int left1=(cut1==0)? Integer.MIN_VALUE : nums1[cut1-1];
            int right1=(cut1==n)? Integer.MAX_VALUE : nums1[cut1];
            int left2=(cut2==0)? Integer.MIN_VALUE : nums2[cut2-1];
            int right2=(cut2==m)? Integer.MAX_VALUE : nums2[cut2];

            if(left1>right2){
                r1=cut1-1;
            }else if(left2>right1){
                l1=cut1+1;
            }else{
                if((n+m)%2==0){
                    return (Math.max(left1,left2)+Math.min(right1,right2))/2.0;
                }else{
                    return Math.max(left1,left2);
                }
            }
        }
        return 0.0;
    }
}
