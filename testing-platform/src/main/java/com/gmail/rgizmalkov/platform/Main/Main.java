package com.gmail.rgizmalkov.platform.Main;

import com.gmail.rgizmalkov.algs.interfaces.Algorithm;
import com.gmail.rgizmalkov.enums.DataStructureAlgorithms;
import com.gmail.rgizmalkov.platform.execution.TestingClassFactory;
import com.gmail.rgizmalkov.platform.execution.TestingExecutor;

import java.math.BigInteger;

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
                "[0-9]*.a"
        );
        executor.run();

//        System.out.println(Paths.get("../algs-data-structure/src/main/resources/week_01/brackets/tests").toFile().exists());
//        Algorithm algorithm = TestingClassFactory.newInstance(TestingClassFactory.AlgorithmsEnum.DATA_STRUCTURE, DataStructureAlgorithms.BRACKETS);
//        System.out.println(algorithm.getClass().getPackage());
    }
}
