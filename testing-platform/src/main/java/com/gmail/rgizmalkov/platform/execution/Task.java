package com.gmail.rgizmalkov.platform.execution;

import com.gmail.rgizmalkov.algs.interfaces.Algorithm;

import java.util.concurrent.Callable;

/**
 * Created by romanizmalkov on 21.02.17.
 */
public class Task<T> implements Callable<T>{
    private Algorithm alg;

    public Task(Algorithm alg) {
        this.alg = alg;
    }

    @Override @SuppressWarnings("unchecked")
    public T call() throws Exception {
        return (T) alg.alg();
    }
}
