package com.gmail.rgizmalkov.platform.execution;

import com.gmail.rgizmalkov.algs.interfaces.AbstractEnum;
import com.gmail.rgizmalkov.algs.interfaces.Algorithm;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by romanizmalkov on 21.02.17.
 */
@SuppressWarnings("unchecked")
public class  TestingExecutor<T> {
    private static final Logger LOG = Logger.getLogger(TestingExecutor.class);

    private Algorithm alg;
    private Map<String, TestingSample<File>> scope;
    private ExecutorService executor;
    private long limit;


    public TestingExecutor                          (
            TestingClassFactory.AlgorithmsEnum pack ,
            AbstractEnum alg                        ,
            long limit                              ,
            String question                         ,
            String answer                           )
            throws Exception {
        this.alg = TestingClassFactory.newInstance(pack, alg);
        this.scope = new HashMap<>();
        this.executor = Executors.newSingleThreadExecutor();
        this.limit = limit;
        this.scope = TestsSampleLoader.fload(question, answer, alg.getPath());
    }


    private Review alg(String name){
        Future<T> future = executor.submit(new Task<T>(alg));
        T res;
        Review review = null;
        try {
            res = future.get(limit, TimeUnit.SECONDS);
            review = new Review(name, String.valueOf(res), CheckBox.TIME_LIMIT_OK);
        } catch (InterruptedException | ExecutionException e) {
            review = new Review(name, e.getMessage(), CheckBox.TEST_NOT_PASSED);
            e.printStackTrace();
        } catch (TimeoutException e) {
            review = new Review(name, "Time Limit!",CheckBox.TEST_NOT_PASSED);
            future.cancel(Boolean.TRUE);
            e.printStackTrace();
        }finally {
            return review;
        }
    }

    public void run() throws FileNotFoundException {
        for (String fileName : scope.keySet()) {
            TestingSample testingSample = scope.get(fileName);
            Scanner scanner = new Scanner((File)testingSample.getQuestion());
            alg.prepare(scanner);
            Review review = alg(fileName);
            if(review.getBox() != CheckBox.TEST_NOT_PASSED){
                scanner = new Scanner((File)testingSample.getAnswer());
                String answer = alg.answer(scanner);
                if(answer.equals(review.getMessage())){
                    review.setBox(CheckBox.TEST_PASSED);
                }else{
                    review.setMessage("[your answer: " + review.getMessage()
                            + "; correct answer: " + answer + "] ");
                }
            }
            System.out.println(review.toString());
        }
        executor.shutdown();
    }

}
