package com.gmail.rgizmalkov.platform.Main;

import com.gmail.rgizmalkov.algs.enums.AlgorithmToolboxEnum;
import com.gmail.rgizmalkov.enums.DataStructureAlgorithms;
import com.gmail.rgizmalkov.platform.execution.TestingClassFactory;
import com.gmail.rgizmalkov.platform.execution.TestingExecutor;

import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by romanizmalkov on 21.02.17.
 */
public class Main {
    public static void main(String[] args) throws Exception {

        TestingExecutor<BigInteger> executor = new TestingExecutor<>(
                TestingClassFactory.AlgorithmsEnum.DATA_STRUCTURE,
                DataStructureAlgorithms.BRACKETS,
                1,
                "[0-9]*",
                "[0-9]*.a",
                "algs-data-structure/src/main/resources/week_01/brackets/tests"
        );
        executor.run();

    }
}
