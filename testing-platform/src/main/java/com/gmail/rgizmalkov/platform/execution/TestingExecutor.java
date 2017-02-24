package com.gmail.rgizmalkov.platform.execution;

import com.gmail.rgizmalkov.algs.interfaces.AbstractEnum;
import com.gmail.rgizmalkov.algs.interfaces.Algorithm;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Executable;
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
    private Map<String, TestingFile> scope;
    private ExecutorService executor;
    private long limit;


    public TestingExecutor                          (
            TestingClassFactory.AlgorithmsEnum pack ,
            AbstractEnum alg                        ,
            long limit                              ,
            String question                         ,
            String answer                           ,
            String path                             )
            throws Exception {
        this.alg = TestingClassFactory.newInstance(pack, alg);
        this.scope = new HashMap<>();
        this.executor = Executors.newSingleThreadExecutor();
        this.limit = limit;
        prepare(path,question,answer);

    }

    private void prepare(String spath, String question, String answer) throws Exception{
        Pattern pquestion = Pattern.compile(question);
        Pattern panswer = Pattern.compile(answer);

        Stream<Path> stream = Files.list(Paths.get(spath));
        stream.forEach(path ->{
            File file = path.toFile();
            if(pquestion.matcher(file.getName()).matches()){
                TestingFile testingFile = new TestingFile();
                testingFile.setQuestion(file);
                scope.put(file.getName(), testingFile);
            }else if(panswer.matcher(file.getName()).matches()){
                scope.get(file.getName().substring(0, file.getName().indexOf('.'))).setAnswer(file);
            }
        });
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
            TestingFile testingFile = scope.get(fileName);
            Scanner scanner = new Scanner(testingFile.getQuestion());
            alg.prepare(scanner);
            Review review = alg(fileName);
            if(review.getBox() != CheckBox.TEST_NOT_PASSED){
                scanner = new Scanner(testingFile.getAnswer());
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
