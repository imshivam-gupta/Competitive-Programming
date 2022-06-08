//                        Longest Substring with Atmost Two Distinct Characters

// You are given a string ‘S’, you need to find the length of the longest substring that contains at most two distinct characters.
// Note:
// A string ‘B’ is a substring of a string ‘A’ if ‘B’ that can be obtained by deletion of, several characters(possibly none) from the start of ‘A’ and several characters(possibly none) from the end of ‘A’. 
// Follow up :
// Can you try to solve this problem in O(N) time and O(1) space.
// Example :
// If ‘S’ = “ninninja”

// Then, “ninnin” is the longest substring that contains at most two distinct characters. We will print the length of this substring which is equal to 6.
// Input Format :
// The first line contains a single integer ‘T’ denoting the number of test cases, then each test case follows:

// The first line of each test case contains a string ‘S’, denoting the input string.
// Output Format :
// For each test case, print the length of the longest substring containing at most two distinct characters.

// Output for each test case will be printed in a separate line.
// Note :
// You are not required to print anything; it has already been taken care of. Just implement the function.
// Constraints :
// 1 ≤ T ≤ 10      
// 1 ≤ |S| ≤ 1000
// Where 'S' contains lowercase English alphabets

// Time limit: 1 sec
// Sample Input 1 :
// 2
// ninninja
// aaa
// Sample Output 1 :
// 6
// 3
// Explanation For Sample Input 1 :
// For test case 1 :
// We will print 6 because:
// “ninnin” is the longest substring containing at most two distinct characters.

// For test case 2 : 
// We will print 3 because:
// The given string “aaa” itself contains a single character, therefore the longest substring will itself be “aaa”.
// Sample Input 2 :
// 2
// ninjacoder
// abbadca
// Sample Output 2 :
// 3
// 4





import java.util.*;

public class Solution {
    
    public static int getLengthofLongestSubstring(int k, String s) {
		
        int n = s.length();
        int maxLen = 1; 
        Map<Character, Integer> windowCharCount = new HashMap<>(); 
        int windowStart = 0;

        for(int windowEnd = 0; windowEnd < n; windowEnd++) {
            char c = s.charAt(windowEnd);
            windowCharCount.put(c, windowCharCount.getOrDefault(c, 0) + 1);

            
            
            while(windowCharCount.size() > k) {
                char leftChar = s.charAt(windowStart);

                windowCharCount.put(leftChar, windowCharCount.get(leftChar) - 1);
                if(windowCharCount.get(leftChar) == 0) {
                    windowCharCount.remove(leftChar);
                }

                windowStart++;                
            }

            
            if(windowCharCount.size() == k) 
                maxLen = Math.max(maxLen, windowEnd-windowStart+1);
            
            
        }

        return maxLen;
    }
    
    
	public static int lengthOfLongestSubstring(String s) {
		return Math.max(getLengthofLongestSubstring(2,s),getLengthofLongestSubstring(1,s));
        
        
	}
}