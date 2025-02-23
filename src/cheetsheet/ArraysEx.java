package cheetsheet;

import java.util.Arrays;

public class ArraysEx {
    public static void main(String[] args) {
    	
        // 配列の宣言
        int[] arr = {5, 2, 8, 1, 3};
        
        System.out.println("length: " + arr.length);
        
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
        
        // indexが不要な拡張for
        for (int p : arr) {
        	System.out.println(":: " + p);
        }

        // 配列の昇順ソート
        Arrays.sort(arr);

        // 配列のまま見やすく表示
        System.out.println("Sorted array: " + Arrays.toString(arr));
        
        // 二分探索（ソート済みであることが前提）
        int index = Arrays.binarySearch(arr, 3);
        System.out.println("Index of 3: " + index);
        
        // 複製（長さ指定）
        int[] newArr = Arrays.copyOf(arr, arr.length);
        
        // 要素が全て等しいか比較
        boolean same = Arrays.equals(arr, newArr);
        System.out.println("配列は等しいか: " + same);
        
        // 配列全体または一部を指定した値で埋める
        int[] zeros = new int[5];
        Arrays.fill(zeros, 0);
        System.out.println(Arrays.toString(zeros));  // [0, 0, 0, 0, 0]
        
        int[][] matrix = {
        	{1, 0, 0},
        	{0, 1, 0},
        	{0, 0, 1},
        };
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
