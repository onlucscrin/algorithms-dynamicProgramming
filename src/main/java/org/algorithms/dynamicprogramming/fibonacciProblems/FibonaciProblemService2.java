package org.algorithms.dynamicprogramming.fibonacciProblems;

import org.algorithms.dynamicprogramming.Util;
import org.springframework.stereotype.Service;

@Service
public class FibonaciProblemService2 {
    public Integer count = 0;

    public int calculateFibonacci(int n) {
        Integer[] dpArray = new Integer[n + 1];
        int result = calculateFibonacciRecursive(n, dpArray);
        System.out.println(" Count : " + count);
        Util.printArray(dpArray);
        return result;
    }

    public int calculateFibonacciRecursive(int n, Integer[] dpArray) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (dpArray[n] != null)
            return dpArray[n];
        count++;
        int n1 = calculateFibonacciRecursive(n - 1, dpArray);
        int n2 = calculateFibonacciRecursive(n - 2, dpArray);
        return dpArray[n] = n1 + n2;
    }

    public int countWays(int n) {
        int result = countWaysRecursive(n);
        return result;
    }

    public int countWaysRecursive(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int result1 = countWaysRecursive(n - 1);
        int result2 = countWaysRecursive(n - 2);
        int result3 = countWaysRecursive(n - 3);
        return result1 + result2 + result3;
    }

    public int countStaircase(int n) {
        int result = countStaircaseRecursive(n);
        return result;
    }

    public int countStaircaseRecursive(int n) {
        if (n == 0 || n == 1 || n == 2 )
            return 1;
        if (n == 3)
            return 2;
        if (n == 4)
            return 4;
        int result_1 = countStaircaseRecursive(n - 1);
        int result_3 = countStaircaseRecursive(n - 3);
        int result_4 = countStaircaseRecursive(n - 4);
        return result_1 + result_3 + result_4;
    }


    public int countMinJumps(int[] jumps) {
        int result = countMinJumpsRecursive(jumps, 0);
        return result;
    }

    public int countMinJumpsRecursive(int[] jumps, int cIndex) {
        if(cIndex >= jumps.length-1)
            return 0;
        if(jumps[cIndex]==0)
            return Integer.MAX_VALUE-10;

        int tempIndex = jumps[cIndex];
        int jumpCount_1 = Integer.MAX_VALUE -1 ;
        while(tempIndex >= 1 ) {
             int jumpCount_2 = 1 + countMinJumpsRecursive(jumps, cIndex + tempIndex);
             jumpCount_1 = Math.min(jumpCount_1, jumpCount_2);
             --tempIndex;
        }
        return jumpCount_1;
    }

    public int findMinFee(int[] fee, int n) {
        int result = findMinFeeRecursive(fee, n, 0);
        return result;
    }

    public int findMinFeeRecursive(int[] fee, int n, int cIndex) {
        if(cIndex >= n)
            return 0;
        int fee_1 = fee[cIndex] + findMinFeeRecursive(fee, n, cIndex+1);
        int fee_2 = fee[cIndex] + findMinFeeRecursive(fee, n, cIndex+2);
        int fee_3 = fee[cIndex] + findMinFeeRecursive(fee, n, cIndex+3);
        int result = Math.min(fee_3, Math.min(fee_1, fee_2));
        return result;
    }

    public int findMaxSteal(int[] wealth) {
        count = 0;
        Integer[] dpArray = new Integer[wealth.length];
        int result = findMaxStealRecursive(wealth, 0, dpArray);
        System.out.println("count : "+ count);
        return result;
    }

    public int findMaxStealRecursive(int[] wealth, int cIndex, Integer[] dpArray) {
        if(cIndex >= wealth.length)
            return 0;
        count++;
        if(dpArray[cIndex]!= null)
            return dpArray[cIndex];
        int loot_1 = wealth[cIndex] + findMaxStealRecursive(wealth, cIndex+2, dpArray);
        int loot_2 = findMaxStealRecursive(wealth, cIndex+1, dpArray);
        return dpArray[cIndex] = Math.max(loot_1, loot_2);
    }


}
