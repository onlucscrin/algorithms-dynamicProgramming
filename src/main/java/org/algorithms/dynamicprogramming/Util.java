package org.algorithms.dynamicprogramming;

public class Util {
    public static void printArray(Integer[][] solution2DArray){
        System.out.print("[");
        for(int i=0;i< solution2DArray.length;i++){
            System.out.print("[");
            for(int j=0;j< solution2DArray[i].length;j++){
                System.out.print(solution2DArray[i][j] + ", ");
            }
            System.out.print("],");
            System.out.println();
        }
        System.out.print("]");
    }

    public static void printArray(Integer[] dpArray){
        System.out.print("[");
        for(int i=0;i< dpArray.length;i++){
            System.out.print(dpArray[i] + ", ");
        }
        System.out.print("]");
    }
}
