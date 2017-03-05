package com.gmail.rgizmalkov.algs.week_04;

import com.gmail.rgizmalkov.algs.interfaces.Algorithm;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by romanizmalkov on 28.02.17.
 */
public class FindingAMajorityElement implements Algorithm {
    public static void main(String[] args) {
        FindingAMajorityElement o = new FindingAMajorityElement(new Scanner(System.in));
        System.out.println(o.alg());
    }

    public FindingAMajorityElement(Scanner scanner) {
        prepare(scanner);
    }

    private Map<Long, Long> tree = new TreeMap<>();
    private long N;


    @Override
    public Object alg() {
        return tree.get(tree.keySet().iterator().next()) > N/2 ? 1 : 0;
    }

    @Override
    public void prepare(Scanner scanner) {
        this.N = scanner.nextLong();


        for (int i = 0; i < N; i++) {
            long val = scanner.nextLong();
            if(tree.containsKey(val)){
                tree.replace(val, tree.get(val) + 1);
            }else {
                tree.put(val, 1l);
            }
        }
    }

    @Override
    public String answer(Scanner scanner) {
        return null;
    }
}
