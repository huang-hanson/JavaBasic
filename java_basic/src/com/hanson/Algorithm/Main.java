package com.hanson.Algorithm;

import com.hanson.tools.Asserts;
import com.hanson.tools.Integers;

public class Main {
    public static void main(String[] args) {
        Integer[] array1 = Integers.random(10000,1,20000);
        Integer[] array2 = Integers.copy(array1);
        Integer[] array3 = Integers.copy(array1);
        Integer[] array4 = Integers.copy(array1);

        new HeapSort().sort(array1);
        Asserts.test(Integers.isAscOrder(array1));
    }
}
