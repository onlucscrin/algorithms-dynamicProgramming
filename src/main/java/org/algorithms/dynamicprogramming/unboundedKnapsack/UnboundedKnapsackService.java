package org.algorithms.dynamicprogramming.unboundedKnapsack;

import org.algorithms.dynamicprogramming.Util;
import org.springframework.stereotype.Service;

@Service
public class UnboundedKnapsackService {
    int count= 0;
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        Integer[][] dpArray2 = new Integer[capacity+1][weights.length+1];
        int result = solveKnapsackRecursive(profits, weights, capacity, 0, dpArray2);
        Util.printArray(dpArray2);
        return result;
    }
    public int solveKnapsackRecursive(int[] profits, int[] weights, int capacity, int cIndex, Integer[][] dpArray){

        if(cIndex == weights.length || capacity == 0)
            return 0;
        if(dpArray[capacity][cIndex]!=null)
            return dpArray[capacity][cIndex];
        int profit_1 = 0;
        if(capacity- weights[cIndex] >= 0)
            profit_1 = profits[cIndex] + solveKnapsackRecursive(profits, weights, capacity - weights[cIndex], cIndex , dpArray);
        int profit_2 = solveKnapsackRecursive(profits, weights, capacity, cIndex +1, dpArray);
        return dpArray[capacity][cIndex] = Math.max(profit_1, profit_2);
    }
    public int solveRodCutting(int[] lengths, int[] prices, int n) {
        Integer[][] dpArray = new Integer[n+1][lengths.length+1];
        int result = solveRodCuttingRecursive(lengths, prices, n, 0, dpArray);
        System.out.println("Count :  " + count);
        return result;
    }

    public int solveRodCuttingRecursive(int[] lengths, int[] prices, int n, int cIndex, Integer[][] dpArray){
        count = count+1;
        if(cIndex == lengths.length ||  n==0)
            return 0;
        int price_1 =0;
        if(dpArray[n][cIndex] !=null)
            return dpArray[n][cIndex];
        if(n - lengths[cIndex] >= 0)
            price_1 = prices[cIndex] + solveRodCuttingRecursive(lengths, prices, n - lengths[cIndex], cIndex, dpArray);
        int price_2 = solveRodCuttingRecursive(lengths, prices, n , cIndex + 1, dpArray);
        return dpArray[n][cIndex] = Math.max(price_2, price_1);
    }
    public int countChange(int[] denominations, int total) {
        int[] val = {0};
        Integer[][] dpArray = new Integer[total+1][denominations.length+1];
        int result = countChangeRecursive(denominations, total, 0, dpArray);
        System.out.println("Count :  " + count);
        return result;
    }
    public int countChangeRecursive(int[] denominations, int total, int cIndex, Integer[][] dpArray){
        count = count +1;
        if(total == 0)
            return 1;
        if(cIndex == denominations.length)
            return 0;
        if(dpArray[total][cIndex]!=null)
            return dpArray[total][cIndex];
        int count_1 =0;
        if(total - denominations[cIndex] >= 0){
            count_1 = countChangeRecursive(denominations, total - denominations[cIndex], cIndex, dpArray);
        }
        int count_2 = countChangeRecursive(denominations, total, cIndex+1, dpArray);
        return dpArray[total][cIndex] = count_1 + count_2;
    }

    public int countMinimumChange(int[] denominations, int total) {
        Integer[][] dpArray = new Integer[total][denominations.length];
        int result = countMinimumChangeRecursive(denominations, total, 0, dpArray);
        return (result == Integer.MAX_VALUE ? -1 : result);
    }

    public int countMinimumChangeRecursive(int[] denomincations, int total, int cIndex, Integer[][] dpArray){
        if(total == 0)
            return 1;
        if(cIndex >= denomincations.length )
            return Integer.MAX_VALUE;
        if(dpArray[total][cIndex] != null)
            return dpArray[total][cIndex];
        int count_1 = Integer.MAX_VALUE;
        if(total-denomincations[cIndex] >= 0)
        {
            int res = countMinimumChangeRecursive(denomincations, total - denomincations[cIndex] , cIndex, dpArray);
            if(res == Integer.MAX_VALUE)
                count_1 = Integer.MAX_VALUE;
            else
                count_1 = res+1;
        }
        int count_2 = countMinimumChangeRecursive(denomincations, total, cIndex+1, dpArray);
        return dpArray[total][cIndex] = Math.min(count_1, count_2);
    }
    public int countRibbonPieces(int[] ribbonLengths, int total) {
        int result = countRibbonPieceRecurse(ribbonLengths, total, 0);
        return result;
    }

    public int countRibbonPieceRecurse(int[] ribbonLengths, int total, int cIndex) {
        if(total == 0)
            return 0;
        if(cIndex >= ribbonLengths.length)
            return Integer.MIN_VALUE;

        int count_1 = 0;
        if(total - ribbonLengths[cIndex] >=0)
        {
            int res = countRibbonPieceRecurse(ribbonLengths, total-ribbonLengths[cIndex], cIndex);
            if (res == Integer.MIN_VALUE)
                count_1 = 0;
            else
                count_1 = res+1;
        }
        System.out.println( "Count1 : " + count_1);
        int count_2 = countRibbonPieceRecurse(ribbonLengths, total, cIndex+1);
        System.out.println( "Count2 : " + count_2);
        return Math.max(count_1, count_2);
    }


}