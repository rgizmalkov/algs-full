package com.gmail.rgizmalkov.algs.interfaces;


import java.util.Scanner;

/**
 * Created by elion on 19.02.2017.
 */
public interface Algorithm {
    Object alg();
    void prepare(Scanner scanner);

    /*for test samples*/
    String answer(Scanner scanner);
}
