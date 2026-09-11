class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> uniques = new HashSet<>();

        for (int i : nums) {
            if (!uniques.add(i)) {
                return true;
            }
        }

        return false;
    }
}