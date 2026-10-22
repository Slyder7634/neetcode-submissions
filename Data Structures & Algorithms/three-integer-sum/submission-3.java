class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < n-2; i++){
            int j=i+1;
            int k=n-1;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0){
                    j++;
                }
                else if(sum > 0){
                    k--;
                }
                else{
                    List<Integer> seq = new ArrayList<>();
                    seq.add(nums[i]);
                    seq.add(nums[j]);
                    seq.add(nums[k]);
                    if(!result.contains(seq))
                        result.add(seq);
                        j++;
                }
            }    
        }
        return result;
    }
}
