package com.gmail.rgizmalkov.platform.execution;

import com.gmail.rgizmalkov.Week_01.CheckBrackets;
import com.gmail.rgizmalkov.algs.interfaces.AbstractEnum;
import com.gmail.rgizmalkov.algs.interfaces.Algorithm;
import com.gmail.rgizmalkov.algs.week_02.fibonacci.Fibonacci;
import com.gmail.rgizmalkov.algs.week_03.ChangingMoney;

/**
 * Created by romanizmalkov on 21.02.17.
 */
public class TestingClassFactory {
    public enum AlgorithmsEnum{
        ALGORITHMIC_TOOLBOX,
        DATA_STRUCTURE;
    }


    public static Algorithm newInstance(AlgorithmsEnum pack, AbstractEnum alg){
        if(pack == AlgorithmsEnum.ALGORITHMIC_TOOLBOX){
            switch (alg.getName()){
                case "FIBONACCI": return new Fibonacci();
                case "CHANGING_MONEY": return new ChangingMoney();
            }
        }
        if(pack == AlgorithmsEnum.DATA_STRUCTURE)
            switch (alg.getName()){
                case "BRACKETS": return new CheckBrackets();
            }
        return null;
    }
}
