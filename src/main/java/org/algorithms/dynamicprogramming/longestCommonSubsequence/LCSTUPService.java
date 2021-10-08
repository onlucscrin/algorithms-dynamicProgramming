package org.algorithms.dynamicprogramming.longestCommonSubsequence;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LCSTUPService {

    public String getLongestSubstring(String inputString){
        HashMap<String, Integer> dpHash = new HashMap();
        Integer count = getLongestSubstringRecursive(inputString,  0, inputString.length()-1, dpHash);
        return count.toString();
    }
    public Integer getLongestSubstringRecursive(String inputString, int startIndex, int endIndex, HashMap<String, Integer> dpHash){
        if(startIndex > endIndex)
            return 0;
        if(dpHash.get(inputString.substring(startIndex, endIndex))!=null)
            return dpHash.get(inputString.substring(startIndex, endIndex));
        if(startIndex == endIndex)
            return 1;
        if(inputString.charAt(startIndex) == inputString.charAt(endIndex))
            return 2 + getLongestSubstringRecursive(inputString, startIndex+1, endIndex-1, dpHash);
        int count_1 = getLongestSubstringRecursive(inputString, startIndex+1, endIndex, dpHash);
        int count_3 = getLongestSubstringRecursive(inputString, startIndex, endIndex-1, dpHash);
        System.out.println(" Palindrome : " + inputString.substring(startIndex, endIndex));
        return Math.max(count_1, count_3);
    }

    public int countPalindromicSubstring(String st) {
        int result = countPalindromicSubstringRecursive(st, 0, st.length()-1);
        return result;
    }
    public int countPalindromicSubstringRecursive(String st, int startIndex, int endIndex) {
        if(startIndex > endIndex)
            return 0;
        if(startIndex == endIndex)
            return 1;
        int c1 = 0;
        if(st.charAt(startIndex) == st.charAt(endIndex))
            c1 += countPalindromicSubstringRecursive(st, startIndex + 1, endIndex-1) +1;
        c1 += countPalindromicSubstringRecursive(st, startIndex + 1, endIndex);
        c1 += countPalindromicSubstringRecursive(st, startIndex, endIndex - 1);
        c1 -= countPalindromicSubstringRecursive(st, startIndex+1, endIndex - 1);
        return c1 ;
    }

    public int findMinimumDeletions(String st) {
        int result = findMaximumLPSLengthRecursive(st, 0,st.length()-1);
        return st.length() - result;
    }
    public int findMaximumLPSLengthRecursive(String input, int startIndex, int endIndex){
        if(startIndex > endIndex)
            return 0;
        if(startIndex == endIndex)
            return 1;
        if(input.charAt(startIndex) == input.charAt(endIndex))
            return 2+findMaximumLPSLengthRecursive(input, startIndex+1, endIndex-1);
        int count1 = findMaximumLPSLengthRecursive(input, startIndex, endIndex-1);
        int count2 = findMaximumLPSLengthRecursive(input, startIndex+1, endIndex);
        return Math.max(count1, count2);
    }
    public int findMPPCuts(String st) {
        return this.findMPPCutsRecursive(st, 0, st.length()-1);
    }
    public int findMPPCutsRecursive(String input, int startIndex, int endIndex){
        if(startIndex > endIndex)
            return 0;
        if(startIndex==endIndex)
            return 0;
        if(input.charAt(startIndex) == input.charAt(endIndex))
        {
            int value = findMPPCutsRecursive(input, startIndex+1,endIndex-1);
            if(value==0)
                return 0;
            else
             return 1 + value;
        }
        int count2 = 1 + findMPPCutsRecursive(input, startIndex+1,endIndex);
        int count = 1 + findMPPCutsRecursive(input, startIndex,endIndex-1);

        return Math.min(count, count2);
    }

}
