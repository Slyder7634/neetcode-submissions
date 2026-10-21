class Solution { 
    public int[] twoSum(int[] numbers, int target) { 
        int left = 0; 
        int n = numbers.length; 
        int right = n - 1;
        while(numbers[left] + numbers[right] != target){
            if(numbers[left] + numbers[right] < target)
                left++;
            else
                right--;
        }
        return new int[] {left+1 , right+1};
    } 
}
