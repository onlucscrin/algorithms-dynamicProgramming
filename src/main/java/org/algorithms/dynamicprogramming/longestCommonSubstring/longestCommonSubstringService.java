package org.algorithms.dynamicprogramming.longestCommonSubstring;

import org.springframework.stereotype.Service;

@Service
public class longestCommonSubstringService {

    public int findLongestCommonSubstring(String input1, String input2){
        int result = findLongestCommonSubstringRecursive(input1, input2, 0, 0, 0);
        return result;
    }
    public int findLongestCommonSubstringRecursive(String input1, String input2, int index1, int index2, int count) {
        if(index1==input1.length() || index2 == input2.length()-1)
            return count;
        int c1 = count;
        if(input1.charAt(index1) == input2.charAt(index2)) {
            c1 =  findLongestCommonSubstringRecursive(input1, input2, index1+1, index2+1, count+1);
        }
        int count1 = findLongestCommonSubstringRecursive(input1, input2, index1, index2+1, 0);
        int count2 = findLongestCommonSubstringRecursive(input1, input2, index1+1, index2, 0);
        return Math.max(c1,Math.max(count1, count2));
    }
    public int findLongestCommonSubsequence(String input1, String input2){
        int result = findLongestCommonSubsequenceRecursive(input1, input2, 0, 0);
        return result;
    }
    public int findLongestCommonSubsequenceRecursive(String input1, String input2, int index1, int index2) {
        if(index1==input1.length() || index2 == input2.length()-1)
            return 0;
        if(input1.charAt(index1) == input2.charAt(index2)) {
           return 1 + findLongestCommonSubsequenceRecursive(input1, input2, index1+1, index2+1);
        }
        int count1 = findLongestCommonSubsequenceRecursive(input1, input2, index1, index2+1);
        int count2 = findLongestCommonSubsequenceRecursive(input1, input2, index1+1, index2);
        return Math.max(count1, count2);
    }
    public String minimumDeleteionsInsertions(String input1, String input2){
        int tmpRes = minimumDeleteionsInsertionsRecursive(input1, input2, 0, 0);
        String result = "Insertions : "  + (input1.length() - tmpRes) + ", Deletions : "  + (input2.length() - tmpRes);
        return result;
    }
    public int minimumDeleteionsInsertionsRecursive(String input1, String input2, int index1, int index2) {
      if(index1 == input1.length() || index2 == input2.length())
          return 0;
      if(input1.charAt(index1) == input2.charAt(index2))
          return 1+minimumDeleteionsInsertionsRecursive(input1, input2, index1+1,index2+1);
      int c1 = minimumDeleteionsInsertionsRecursive(input1, input2, index1+1, index2);
      int c2 = minimumDeleteionsInsertionsRecursive(input1, input2, index1, index2+1);
      return Math.max(c1, c2);
    }

    public int longestIncreasingSubsequence(int[] input1){
        int result = longestIncreasingSubsequenceRecursive(input1, 0, 0);
        return result;
    }
    public int longestIncreasingSubsequenceRecursive(int[] input, int index1, int index2) {
        if(index1 == input.length || index2 ==input.length)
            return 0;
        int count1 =0;
        if(index1 < index2 && input[index1]<input[index1+1])
             count1 = longestIncreasingSubsequenceRecursive(input, index1+1, index2);
        int count2 = longestIncreasingSubsequenceRecursive(input, index1, index2+1);
        return Math.max(count1, count2);
    }

    public int findLRSLength(String str) {
        int result = findLRSLengthRecursive(str,0, 0);
        return result;
    }
    public int findLRSLengthRecursive(String inputString, int currentIndex, int nextIndex) {
        if(currentIndex == inputString.length() || nextIndex ==inputString.length())
            return 0;
        if(inputString.charAt(currentIndex) == inputString.charAt(nextIndex) && currentIndex!=nextIndex)
            return 1+ findLRSLengthRecursive(inputString, currentIndex+1, nextIndex+1);
        int count2 = findLRSLengthRecursive(inputString, currentIndex, nextIndex+1);
        int count3 = findLRSLengthRecursive(inputString, currentIndex+1, nextIndex);
        return Math.max(count2, count3);
    }
    public int findSPMCount(String input, String pattern) {
        int result = findSPMCountRecursive(pattern,input, 0, 0);
        return result;
    }
    public int findSPMCountRecursive(String patternString, String inputString, int patternStringIndex, int inputStringIndex) {
        if(inputStringIndex == inputString.length() )
            return 0;
        int c1 =0;
        if(inputString.charAt(inputStringIndex) == patternString.charAt(patternStringIndex))
            c1 = 1+ findSPMCountRecursive(patternString,inputString, patternStringIndex+1, inputStringIndex+1);
        int c2 = findSPMCountRecursive(patternString,inputString, patternStringIndex, inputStringIndex+1);
//        int c3 = findSPMCountRecursive(patternString,inputString, 0, inputStringIndex+1);
        return c2 +c1;
    }

}
