class Solution {
    public int trap(int[] height) {
        int sum=0,lmax=0,rmax=0;
        int left=0,right=height.length-1;
        while(left<right){
            if(height[left]<=height[right]){
                if(lmax>height[left]){
                    sum+=lmax-height[left];
                }
                else{
                    lmax=height[left];
                }
                left++;
            }
            else{
                if(rmax>height[right]){
                    sum+=rmax-height[right];
                }
                else{
                    rmax=height[right];
                }
                right--;
            }
        }
        return sum;
    }
}