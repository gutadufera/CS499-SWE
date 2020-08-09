package org.example;

import org.example.Service.ArrayFlattenerService;

public class ArrayReversor {
    private ArrayFlattenerService arrayFlattenerService;

    public ArrayReversor(ArrayFlattenerService arrayFlattenerService) {
        this.arrayFlattenerService = arrayFlattenerService;
    }
    public int[] reversedArray(int [][] nestedArray){
        int[] flattenArray = arrayFlattenerService.flatternArray(nestedArray);
        if (flattenArray==null){
            return null;
        }
        int i=0;
        int j= flattenArray.length-1;
        while (i<j){
            int temp = flattenArray[i];
            flattenArray[i]=flattenArray[j];
            flattenArray[j]=temp;
            i++;
            j--;
        }
        return flattenArray;
    }
}
