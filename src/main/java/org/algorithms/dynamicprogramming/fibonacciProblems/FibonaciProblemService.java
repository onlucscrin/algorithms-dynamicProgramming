package org.algorithms.dynamicprogramming.fibonacciProblems;

import org.springframework.stereotype.Service;

@Service
public class FibonaciProblemService {
    public int calculateFibonacciRecursive(int dp[], int n) {
        if(n<2)
            dp[n] = n;
        else if(dp[n]==0)
            dp[n] = calculateFibonacciRecursive(dp, n-1)+ calculateFibonacciRecursive(dp, n-2);
        return dp[n];
    }
    //0,1,1,2,3,5,8,13,21,34,55
    public int solveFibSeries(int n) {
        int[] dp = new int[n+1];
        dp[n]= calculateFibonacciRecursive(dp, n);
        return dp[n];
    }
    public int solveFibSeriesBUP(int n) {
        int dp_1 = 0;
        int dp_2 = 1;
        int result =0;
        for(int i=3;i<=n;i++){
            result = dp_1 + dp_2;
            dp_1 =dp_2;
            dp_2 =result;
        }
        return result;
    }

    //steps==1, ways=1 =1
    //steps==2, ways =2 {1,1},{2} = 2
    //steps==3, ways== {1,1,1},{1,2},{2,1}{3} = 4
    public int solveCountWaysRecursive(int[]dp, int n) {
        if(n<=2)
            dp[n] = n;
        else if(n==3)
            dp[n] = 4;
        else  if(dp[n]==0)
            dp[n] = solveCountWaysRecursive(dp, n-1)+solveCountWaysRecursive(dp,n-2)+solveCountWaysRecursive(dp,n-3);
        return dp[n];
    }

    public int solveCountWays(int n){
        int[] dp = new int[4];
        return solveCountWaysRecursive(dp,n);
    }

    public int solveCountWaysBup(int n){
        int[] dp = new int[4];
        dp[0]=0;dp[1]=1;dp[2]=2;dp[3]=4;
        for(int i=4;i<=n;i++){
            int result = dp[1]+dp[2]+dp[3];
            dp[1]=dp[2];
            dp[2]=dp[3];
            dp[3]=result;
        }
        return dp[3];
    }

    /**
     *  1, 3, or 4.
     * n==1, factr =1
     * n=2, factr = {1,1}, 1
     * n=3, factr ={1,3},{3,1}{1111} = 3
     * n=4 factr = {1,3} {1,1,1,1} {3,1} {4} = 4
     */
    public int numberFactorRecursiveFuntion(int dp[], int n){
        if(n>0 && dp[n]==0)
            dp[n] = numberFactorRecursiveFuntion(dp,n-1)+numberFactorRecursiveFuntion(dp,n-3)+numberFactorRecursiveFuntion(dp,n-4);
        return dp[n];
    }

    public int numberFactorTUP(int n) {
        int size =5;
        if(n>=5)
            size =n+1;
        int[] dp = new int[size];
        dp[0]=0;dp[1]=1;dp[2]=1;dp[3]=3;dp[4]=4;
        return numberFactorRecursiveFuntion(dp, n);
    }
    public int numberFactorBUP(int n) {
        int size =5;
        if(n>=5)
            size =n+1;
        int[] dp = new int[size];
        dp[0]=0;dp[1]=1;dp[2]=1;dp[3]=3;dp[4]=4;
        for(int i=5;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-3]+dp[i-4];
        }
        return dp[n];
    }
    public int countMinJumpsRecursive(int[] dp, int[] jumps, int start) {
        if(start>=jumps.length-1)
            return 0;
        if(dp[start]!=0)
            return dp[start];
        int n = jumps[start];
        int result = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++) {
            int length = countMinJumpsRecursive(dp, jumps, start + i) + 1;
            result = Math.min(result , length);
        }
        dp[start] = result;
        return result;
    }

    public int countMinJumps(int[] jumps) {
        int dp[] = new int[jumps.length];
        int result = countMinJumpsRecursive(dp, jumps, 0);
        return result;
    }

    public int minJumpFeeRecursive(int[] dp, int[] fees, int n, int index){
        if(index >= n)
            return 0;
        if(dp[index]!=0)
            return dp[index];
        int step1= fees[index] + minJumpFeeRecursive(dp, fees, n, index+1);
        int step2= fees[index] + minJumpFeeRecursive(dp,fees, n, index+2);
        int step3= fees[index] + minJumpFeeRecursive(dp,fees, n, index+3);
        int result = Math.min(Math.min(step1, step2), step3);
        dp[index] = result;
        return result;
    }
    public int countJumpFees(int[] fees, int n) {
        int dp[] = new int[n];
        return minJumpFeeRecursive(dp, fees, n,0);
    }
    public int findMaxStealRecursive(int[] dp, int[] wealth, int index) {
        if(index>wealth.length-1)
            return 0;
        if(index==wealth.length-1)
            return wealth[index];
        if(dp[index]!=0)
            return dp[index];
        int house1 = wealth[index] + findMaxStealRecursive(dp, wealth, index+2);
        int house2 = wealth[index+1] + findMaxStealRecursive(dp, wealth, index+3);
        int result = Math.max(house1, house2);
        dp[index] = result;
        return result;
    }

    public int houseTheif(int[] wealth) {
        int dp[] = new int[wealth.length-1];
        return findMaxStealRecursive(dp, wealth, 0);
    }

    public int houseTheifBUP(int[] wealth) {
        int dp[] = new int[wealth.length+1];
        dp[0] = 0;
        dp[1] = wealth[0];
        for(int i=1;i<wealth.length;i++){
            dp[i+1] = Math.max(wealth[i]+dp[i-1], dp[i]);
        }
        return dp[wealth.length];
    }


}
