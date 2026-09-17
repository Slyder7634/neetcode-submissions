class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortKey = new String(chars);

            if(!map.containsKey(sortKey)){
                map.put(sortKey, new ArrayList<>());
            }
            map.get(sortKey).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
