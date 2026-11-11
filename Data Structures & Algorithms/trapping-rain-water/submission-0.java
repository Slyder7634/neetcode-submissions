class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int score = 0;
        while(left < right){
            if(height[left] < height[right]){
                leftMax = Math.max(leftMax,height[left]);
                if(height[left] < leftMax){
                    score += leftMax - height[left];
                }
                left++;
            }else{
                rightMax = Math.max(rightMax,height[right]);
                if(height[right] < rightMax){
                    score += rightMax - height[right];
                }
                right--;
            }
        }
        return score;
    }
}
