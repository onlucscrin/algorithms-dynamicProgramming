package org.algorithms.dynamicprogramming.baseSetProblems;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DPBaseProblemService {

    public int getMaxProfitBA(int[] profits, int[] weights, int capacity) {
        int result = -1;

        return result;
    }
    public int getMaxProfitTA(int[] weights, int[] profits, int capacity) {
        int result = -1;
        Integer[][] dpArray = new Integer[capacity+1][weights.length];
        result = getMaxProfitRecursive(weights, profits, capacity, 0,  dpArray);

        return result;
    }
    public int getMaxProfitRecursive(int[] weights, int[] profits, int capacity, int pt1, Integer[][] dpArray){
        if(pt1 == profits.length || capacity==0)
            return 0;
        if(dpArray[capacity][pt1] != null)
            return dpArray[capacity][pt1];
        int profit_1 =0;
        if(capacity >= weights[pt1])
         profit_1 = profits[pt1] + getMaxProfitRecursive(weights, profits, capacity-weights[pt1], pt1+1, dpArray);
        int profit_2 = getMaxProfitRecursive(weights, profits, capacity, pt1+1, dpArray);
        int result = Math.max(profit_1, profit_2);
        dpArray[capacity][pt1] = result;
        return result;
    }
    public boolean canPartition(int[] num) {
        int sum =0;
        for(int i=0;i<num.length;i++)
            sum += num[i];
        if(sum%2 != 0)
            return false;
        Boolean[][] dpArray = new Boolean[(sum/2)+1][num.length];
        return this.canPartitionRecursive(num, sum/2, 0, dpArray);
    }

    public boolean canPartitionRecursive(int[] num, int sum, int pt1,Boolean[][] dpArray) {
        if(sum==0)
            return true;
        if(pt1 == num.length)
            return false;
        if(dpArray[sum][pt1] != null)
            return dpArray[sum][pt1];

        boolean result_1 = false;
        if(num[pt1] <= sum )
           result_1 = canPartitionRecursive(num, sum - num[pt1], pt1+1, dpArray);
        boolean result_2 = canPartitionRecursive(num, sum, pt1+1, dpArray);
        dpArray[sum][pt1] = result_1 || result_2;
        return result_1 || result_2;
    }

    public int countSubsets(int[] num, int sum) {
        return this.countSubsetsRecursive(num, 0,sum, 0);
    }
    private int countSubsetsRecursive(int[] num, int sum, int sumRef, int currentIndex) {
        if(sum==sumRef)
            return 1;
        if (currentIndex == num.length)
            return 0;
        int result_1 =+ countSubsetsRecursive(num, sum + num[currentIndex], sumRef,currentIndex + 1);
        int result_2 =+ countSubsetsRecursive(num, sum , sumRef, currentIndex+1);
        return result_1+result_2;
    }

    public int findTargetSubsets(int[] nums, int s) {
        int nSum = Arrays.stream(nums).sum();
        int sumVal = (nSum + s)/2;
        Integer[][] dpArray = new Integer[sumVal][nums.length];
        int count = findTargetSubsetsRecursively(nums, sumVal, 0, 0, dpArray);
        return count;
    }

    public int findTargetSubsetsRecursively(int[] nums, int refSum, int currentSum, int currentIndex, Integer[][] dpArray){
        if(currentSum == refSum)
            return 1;
        if(currentIndex == nums.length || currentSum > refSum)
            return 0;
        if(dpArray[currentSum][currentIndex] != null)
            return dpArray[currentSum][currentIndex];
        int count = 0;
        if(nums[currentIndex] <= refSum)
            count += findTargetSubsetsRecursively(nums, refSum, currentSum + nums[currentIndex], currentIndex+1, dpArray);
        count += findTargetSubsetsRecursively(nums, refSum, currentSum , currentIndex+1, dpArray);
        dpArray[currentSum][currentIndex] = count;
        return count;
    }
}