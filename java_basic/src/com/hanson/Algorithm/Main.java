package com.hanson.Algorithm;

import com.hanson.tools.Asserts;
import com.hanson.tools.Integers;
import com.hanson.tools.Times;

public class Main {
    public static void main(String[] args) {
        Integer[] array1 = Integers.random(10000,1,20000);

        testSorts(array1,new HeapSort(),new SelectionSort(),new BubbleSort3());
//        Integer[] array2 = Integers.copy(array1);
//        Integer[] array3 = Integers.copy(array1);
//        Integer[] array4 = Integers.copy(array1);

//        Times.test("HeapSort",()->{
//            new HeapSort().sort(array1);
//        });
//        Times.test("SelectSort",()->{
//            new SelectionSort().sort(array2);
//        });
//        Times.test("BubbleSort3",()->{
//            new BubbleSort3().sort(array3);
//        });

    }
    static void testSorts(Integer[] array,Sort... sorts){
        for (Sort sort:sorts
             ) {
            sort.sort(Integers.copy(array));
            System.out.println(sort);
        }
    }
}
