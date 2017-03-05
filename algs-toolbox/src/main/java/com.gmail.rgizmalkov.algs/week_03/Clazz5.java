package com.gmail.rgizmalkov.algs.week_03;

import com.gmail.rgizmalkov.algs.interfaces.Algorithm;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Created by romanizmalkov on 25.02.17.
 */
public class Clazz5 implements Algorithm{
    public static void main(String[] args) {
        Clazz5 o = new Clazz5(new Scanner(System.in));
        System.out.println(o.alg());
    }

    private long N;

    public Clazz5(Scanner scanner) {
        prepare(scanner);
    }

    @Override
    public Object alg() {
        ArrayList<Long> arr = new ArrayList<>();
        arr.add(0l);
        long n = 0;
        int index = 0;
        while(n < N){
            n = arr.get(index) + ++index;
            arr.add(n);
        }
        long sum = arr.get(index);
        long val = 0;
        if(sum != N){
            val = sum - N + 1;
        }

        StringBuilder builder = new StringBuilder("\n");
        for (long i = 1; i < arr.size(); i++) {
            if(!(i == val || i == index))
                builder.append(i).append(" ");
        }
        int lfin = arr.size() - 1;
        if(sum != N) {
            builder.append(++index).append(" ");
            lfin--;
        }
        String fin = String.valueOf(lfin);
        String ret = builder.toString();
        return fin + ret.substring(0, ret.length() - 1);
    }

    @Override
    public void prepare(Scanner scanner) {
        this.N = scanner.nextLong();
    }

    @Override
    public String answer(Scanner scanner) {
        return null;
    }
}
