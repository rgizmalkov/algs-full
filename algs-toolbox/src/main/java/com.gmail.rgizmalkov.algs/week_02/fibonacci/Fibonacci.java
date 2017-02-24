package com.gmail.rgizmalkov.algs.week_02.fibonacci;


import com.gmail.rgizmalkov.algs.interfaces.Algorithm;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by elion on 19.02.2017.
 */
@SuppressWarnings("Duplicates")
public class Fibonacci implements Algorithm {
    private int n;

    public Fibonacci(Scanner scanner){
        prepare(scanner);
    }

    public Fibonacci(){
    }

    @Override
    public BigInteger alg() {
        if(n <= 1) return BigInteger.valueOf(n);
        BigInteger[] F = new BigInteger[n+1];
        F[0] = BigInteger.valueOf(0);
        F[1] = BigInteger.valueOf(1);
        for (int i = 2; i < n+1; i++) {
            F[i] = F[i - 1].add(F[i - 2]);
        }
        return F[n];
    }

    @Override
    public void prepare(Scanner scanner) {
        this.n = scanner.nextInt();
    }

    @Override
    public String answer(Scanner scanner) {
        return String.valueOf(scanner.nextBigInteger());
    }

}
