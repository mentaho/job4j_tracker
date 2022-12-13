package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {

        String firstStringO1 = o1.substring(0, o1.indexOf("/"));
        String secondStringO1 = o1.substring(o1.indexOf("/"), o1.length());
        String firstStringO2 = o2.substring(0, o2.indexOf("/"));
        String secondStringO2 = o2.substring(o2.indexOf("/"), o2.length());

        return
    }
    private class DescCompFirstPart implements Comparator<String>{

        public int compare(String o1, String o2){
            return o2.compareTo(o1);
        }
    }
    private class DescCompSecondPart implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }
}