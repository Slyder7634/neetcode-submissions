class Solution {
public:
    std::vector<std::vector<std::string>> groupAnagrams(std::vector<std::string>& strs) {
        std::ios_base::sync_with_stdio(false);
        std::cin.tie(NULL);

        std::unordered_map<std::string, std::vector<std::string>> anagramMap;
        
        for (const std::string& str : strs) {
            // 1. Fixed-size string acting as a 26-byte frequency array
            std::string key(26, 0); 
            for (char ch : str) {
                key[ch - 'a']++;
            }
            
            // 2. The raw byte string works perfectly as a unique hash key
            anagramMap[key].push_back(str);
        }
        
        std::vector<std::vector<std::string>> result;
        result.reserve(anagramMap.size());
        
        for (auto& pair : anagramMap) {
            result.push_back(std::move(pair.second));
        }
        
        return result;
    }
};
