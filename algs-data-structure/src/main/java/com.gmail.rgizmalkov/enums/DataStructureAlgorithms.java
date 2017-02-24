package com.gmail.rgizmalkov.enums;

import com.gmail.rgizmalkov.algs.interfaces.AbstractEnum;

/**
 * Created by romanizmalkov on 21.02.17.
 */
public enum DataStructureAlgorithms implements AbstractEnum {
    BRACKETS("BRACKETS"),;

    private String name;

    DataStructureAlgorithms(String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }
}
