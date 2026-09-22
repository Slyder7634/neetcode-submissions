class Solution {

    public String encode(List<String> strs) {
        String encoded_string = "";
        for (String s : strs) {
            encoded_string+=s;
            encoded_string+="π";
        }

        return encoded_string;
    }

    public List<String> decode(String str) {
        if (str.isEmpty()) {
            return new ArrayList<>();
        }
        
        String[] array = str.split("π", -1);
        List<String> decoded_strs = Arrays.asList(array);
        return decoded_strs.subList(0, decoded_strs.size() - 1);
    }
}