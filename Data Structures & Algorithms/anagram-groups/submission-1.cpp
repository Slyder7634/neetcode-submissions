class Solution {
public:
    std::vector<std::vector<std::string>> groupAnagrams(std::vector<std::string>& strs) {
        // Map to store: Frequency Key String -> Vector of Anagrams
        std::unordered_map<std::string, std::vector<std::string>> anagramMap;
        
        for (const std::string& str : strs) {
            // 1. Create a frequency array (initialized to 0)
            int count[26] = {0};
            for (char ch : str) {
                count[ch - 'a']++;
            }
            
            // 2. Build a unique string key from the frequency array
            std::string key = "";
            for (int i = 0; i < 26; i++) {
                key += std::to_string(count[i]) + "#"; // Delimiter prevents collisions
            }
            
            // 3. Push the original string directly into the map group
            anagramMap[key].push_back(str);
        }
        
        // 4. Collect and return all grouped lists
        std::vector<std::vector<std::string>> result;
        result.reserve(anagramMap.size()); // Optimization: Allocate memory upfront
        
        for (auto& pair : anagramMap) {
            result.push_back(std::move(pair.second)); // move avoids copying overhead
        }
        
        return result;
    }
};
