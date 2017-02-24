package com.gmail.rgizmalkov.platform.execution;

import java.io.File;

/**
 * Created by romanizmalkov on 21.02.17.
 */
public class TestingFile {
    private File question;
    private File answer;

    public TestingFile(File question, File answer) {
        this.question = question;
        this.answer = answer;
    }

    public TestingFile() {
    }

    public File getQuestion() {
        return question;
    }

    public void setQuestion(File question) {
        this.question = question;
    }

    public File getAnswer() {
        return answer;
    }

    public void setAnswer(File answer) {
        this.answer = answer;
    }
}
