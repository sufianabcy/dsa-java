import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int maxLen=0;
        Set<Character> set=new HashSet<>();
        int l=0;
        for(int h=0;h<n;h++){
            char ch=s.charAt(h);
            while(set.contains(ch)){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(ch);
            maxLen=Math.max(h-l+1,maxLen);
        }
            
        return maxLen;
    }
       
}

//In this problem the main concept was to keep moving forward (high) and when you find any duplicate charc you have to move forward the low .low removes each letter it passes from the set, until the duplicate is gone.
