package com.gmail.rgizmalkov.algs.week_04;

import com.gmail.rgizmalkov.algs.interfaces.Algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by romanizmalkov on 28.02.17.
 */
public class BinarySearchEx implements Algorithm {
    public static void main(String[] args) {
        BinarySearchEx bse = new BinarySearchEx(new Scanner(System.in));
        System.out.println(bse.alg());
    }

    private Long[] inp1;
    private Long[] inp2;

    public BinarySearchEx(Scanner scanner) {
        prepare(scanner);
    }

    public BinarySearchEx() {
    }

    @Override
    public Object alg() {
        List<Integer> arr = new LinkedList<>();

        for (int i = 0; i < inp1.length; i++) {
            arr.add(binarySearch(inp1, 0, inp1.length - 1, inp2[i]));
        }

        return Arrays.toString(arr.toArray());
    }

    private int binarySearch(Long[] arr, int low, int high, Long srch) {
        if (high < low){
            return low - 1;
        }
        int mid = low + (high - low) / 2;
        if(arr[mid] == srch){
            return mid;
        }else if (srch < arr[mid]){
            return binarySearch(arr, low, mid - 1, srch);
        }else
            return binarySearch(arr, mid + 1, high, srch);
    }


    @Override
    public void prepare(Scanner scanner) {
        int n = scanner.nextInt();
        inp1 = new Long[n];
        for (int i = 0; i < n; i++) {
            inp1[i] = scanner.nextLong();
        }
        int m = scanner.nextInt();
        inp2 = new Long[m];
        for (int i = 0; i < m; i++) {
            inp2[i] = scanner.nextLong();
        }
    }

    @Override
    public String answer(Scanner scanner) {
        return null;
    }
}
