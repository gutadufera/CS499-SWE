package org.example;

import org.example.Service.ArrayFlattenerService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ArrayFlattener {
    private ArrayFlattenerService arrayFlattenerService;
    public ArrayFlattener(ArrayFlattenerService arrayFlattenerService) {
        this.arrayFlattenerService = arrayFlattenerService;
    }

    public int[] arrayFlattener(int[][] arrays) {
        if (arrays == null) return null;
        int[] flatArray = Arrays.stream(arrays)
                .flatMapToInt(Arrays::stream)
                .toArray();
        return flatArray;
    }
}

