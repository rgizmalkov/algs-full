package com.gmail.rgizmalkov.algs.enums;

import com.gmail.rgizmalkov.algs.interfaces.AbstractEnum;

/**
 * Created by romanizmalkov on 21.02.17.
 */
public enum AlgorithmToolboxEnum implements AbstractEnum{
    FIBONACCI("FIBONACCI"),;

    private String name;

    AlgorithmToolboxEnum(String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }
}
