package com.hanson.Algorithm;


public class HeapSort extends Sort {
    private int heapSize;

    @Override
    protected void sort() {
        //原地建堆
        heapSize = array.length;
        for (int i = (heapSize - 1); i >= 0; i--) {
            siftDown(i);
        }

        while (heapSize > 1) {
            //交换对顶元素和尾部元素
            swap(0,heapSize-1);

            heapSize--;
            //对0位置进行siftDown（恢复堆的性质）
            siftDown(0);
        }
    }
    private void siftDown(int index){
        Integer element = array[index];
        int half = heapSize >> 1;
        while (index < half){//index必须是非叶子节点
            //默认是在左边跟父节点比
            int childIndex = (index << 1)+1;
            Integer child = array[childIndex];

            int rightIndex = childIndex + 1;
            //右叶子节点比左叶子节点大
            if (rightIndex<heapSize&&
                    cmpElements(array[childIndex],child)>0){
                child = array[childIndex=rightIndex];
            }
            //大于等于子节点
            if (cmpElements(element,child)>=0){
                break;
            }
            array[index]=child;
            index = childIndex;
        }
        array[index] = element;
    }
}
