package com.gmail.rgizmalkov.enums;

import com.gmail.rgizmalkov.algs.interfaces.AbstractEnum;

/**
 * Created by romanizmalkov on 21.02.17.
 */
public enum DataStructureAlgorithms implements AbstractEnum {
    BRACKETS("BRACKETS", "../algs-data-structure/src/main/resources/week_01/brackets/tests"),;

    private String name;
    private String path;

    DataStructureAlgorithms(String name, String path) {
        this.path = path;
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPath() {
        return path;
    }
}
