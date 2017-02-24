package com.gmail.rgizmalkov.platform.execution;

/**
 * Created by elion on 19.02.2017.
 */
public enum CheckBox {
    TEST_PASSED("[V]","Test passed"),
    TIME_LIMIT_OK("[X]", "Time limit is OK! Wrong answer."),
    TEST_NOT_PASSED("[X]","Test not passed");


    private String box;
    private String definition;

    CheckBox(String box, String definition) {
        this.box = box;
        this.definition = definition;
    }

    public String getBox() {
        return box;
    }

    public String getDefinition() {
        return definition;
    }

    public String getAnswer(){
        return "<"+ definition + " " +box + ">";
    }
}
