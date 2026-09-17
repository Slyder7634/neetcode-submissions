// Custom hash function for std::array so it can be used in unordered_map
struct ArrayHasher {
    std::size_t operator()(const std::array<int, 26>& arr) const {
        std::size_t hash = 0;
        for (int count : arr) {
            // A basic polynomial rolling hash to mix the array values
            hash ^= std::hash<int>{}(count) + 0x9e3779b9 + (hash << 6) + (hash >> 2);
        }
        return hash;
    }
};

class Solution {
public:
    std::vector<std::vector<std::string>> groupAnagrams(std::vector<std::string>& strs) {
        std::ios_base::sync_with_stdio(false);
        std::cin.tie(NULL);

        std::unordered_map<std::array<int, 26>, std::vector<std::string>, ArrayHasher> anagramMap;
        
        for (const std::string& str : strs) {
            std::array<int, 26> count = {0};
            for (char ch : str) {
                count[ch - 'a']++;
            }
            anagramMap[count].push_back(str);
        }
        
        std::vector<std::vector<std::string>> result;
        result.reserve(anagramMap.size());
        for (auto& pair : anagramMap) {
            result.push_back(std::move(pair.second));
        }
        return result;
    }
};
