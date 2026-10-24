class Solution {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int maxArea=0;
        // int area=min(height[left],height[right])*(right-left)
        while(left<=right){
            int area=(height[left]>height[right]?height[right]:height[left])*(right-left);
            maxArea=area>maxArea?area:maxArea;

            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}