import java.util.HashMap;

public class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, maxLength = 0;

        while (right < s.length()) {
            char currentChar = s.charAt(right);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating solution = new LongestSubstringWithoutRepeating();
        String s = "eceba";
        int k = 2;
        System.out.println(solution.lengthOfLongestSubstringKDistinct(s, k)); 
    }
}
