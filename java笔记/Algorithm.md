### 二分查找算法

```Java
package com.hanson.Algorithm;

/**
 * @author 黄忠
 */
public class binarySearch {
    public static int binarySearch(int[] array,int a){
        int low = 0;
        int high = array.length-1;
        int mid;
        while (low <= high) {
            mid = (low+high)/2;//中间位置
            if (array[mid] ==a){
                return mid;
            }else if (a>array[mid]){//向右查找
                low = mid+1;
            }else {
                //向左查找
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        binarySearch binarySearch = new binarySearch();
        int[] array = {3,4,6,20,40,45,51,62,70,99,110};
        System.out.println("查找数的索引下标："+binarySearch(array,120));
    }
}
```

### 冒泡排序法

```Java
package com.hanson.Algorithm;

/**
 * @author 黄忠
 */
public class bubbleSort {
    public static int[] bubbleSort(int[] arr){
        //外循环控制循环的趟数
        for(int i = 0; i < arr.length-1; i++){
            //内循环控制每一趟排序多少次
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {4,5,6,3,2,1};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
```

### 插入排序

```java
package com.hanson.Algorithm;

/**
 * @author 黄忠
 */
public class insertSort {
    public static int[] insertSort(int[] arr){
       for (int i = 1; i < arr.length; i++) {
           //插入的数
           int insertVal = arr[i];
           //被插入的位置(准备和前一个数进行比较)
           int index = i-1;
           while (index >=0&&insertVal<arr[index]) {
               //则将arr[index]向后移
               arr[index+1]=arr[index];
               //将index向前移动;
           }
           //将插入的数放入合适的位置
           arr[index+1]=insertVal;
       }
       return arr;
    }
    public static void main(String[] args) {
     int[] arr = {6,2,5,7,8};
     insertSort(arr);
     for (int i = 0; i <arr.length ; i++) {
         System.out.println(arr[i]);
        }
    }
}
```

