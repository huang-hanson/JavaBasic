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

### 快速排序

```Java
public class QuickSort {

    static int[] arr = new int[]{3,2,1,5,6,4};

    public static void main(String[] args) {
        QuickSort(arr,0,arr.length-1);
        for (int i : arr){
            System.out.println(i);//{1,2,2,3,3,4,5,5,6}
        }
        //System.out.println(arr[arr.length-2]);
    }

    public static void QuickSort(int[] arr,int left,int right){

        if (arr == null || arr.length == 0) {
            return;
        }
        if(left > right){
            return;
        }
        int key = arr[left];
        int l = left;
        int r = right;
        while (l != r) {
            while (arr[r]>=key && l < r) {
                r--;
            }
            while (arr[l] <= key && l < r) {
                l++;
            }
            if(l < r){
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }

        }
        arr[left] = arr[l];
        arr[l]=key;

        QuickSort(arr,left,l-1);
        QuickSort(arr,l+1,right);

    }
}
```

### 希尔排序

```Java
public class shellSort {

    public static int[] shellSort(int[] arr){
        int dk = arr.length/3+1;
        while (dk==1){
            ShellInsertSort(arr,dk);
            dk=dk/3+1;
        }
        return arr;
    }
    public static void ShellInsertSort(int[] a, int dk){
        //类似于插入排序算法，但插入排序的算法增量都是1，这里的增量是dk，将1换成dk即可
        for (int i = dk;i<a.length; i++){
            if(a[i]<a[i-dk]){
                int j;
                int x = a[i];//x为待插入的元素
                a[i] = a[i-dk];
                for (j=i-dk; j >= 0&&x < a[j]; j=j-dk){
                    //通过循环，逐渐后移一位找到要插入的元素
                    a[j+dk]=a[j];
                }
                a[j+dk]=x;//将数据插入对应的位置
            }
        }
    }

    public static void main(String[] args) {
        int[] arr ={3,5,1,2,5,8};
        shellSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
```

###  桶排序

```Java
public class bucketSort {
    public static int[] bucketSort(int[] arr){
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        //创建桶
        int bucketNum = (max - min)/arr.length-1;
        ArrayList<ArrayList<Integer>> bucketArr= new ArrayList(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        //将每个元素都放入桶中
        for (int i = 0; i < arr.length; i++) {
            int num = (arr[i]-min)/(arr.length);
            bucketArr.get(num).add(arr[i]);
        }
        //对每一个桶进行排序
        for (int i = 0; i < bucketArr.size(); i++) {
            Collections.sort(bucketArr.get(i));
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {3,6,5,9,7,8};
        bucketSort(arr);
    }
}
```

### 基数排序

```Java
public class radixSort {
    //array:数组    maxigit：数组最大位数
    public static int[] radixSort(int[] array,int maxDigit){
        //数组最大位数的数据上限，比如3位数的最大上限为1000
        double max= Math.pow(10,maxDigit+1);
        int n=1;//代表位数对应的数：1,10,100....
        int k=0;//保存每一个排序后的结果，将当前位上排序的结果相同的数字放在一同一个桶里
        int length = array.length;
        //bucket用于保存每次排序后的结果，将当前位上排序的结果相同的数字放在同一个桶里
        int[][] bucket = new int[10][length];
        int[] order =new int[length];//用于保存每个桶里有多少数字
        while (n<max){
            for(int num:array){
                int digit = (num/n)%10;
                bucket[digit][order[digit]]=num;
                order[digit]++;
            }
            //将前一个循环生成的桶里面的数据覆盖到原数组中，用于保存这一位的排序结果
            for (int i = 0; i < length; i++) {
                //在这个桶中的数据，从上到下遍历一遍并将数据保存在原数组当中
                if(order[i]!=0){
                    for (int j = 0; j <order[i] ; j++) {
                        array[k]=bucket[i][j];
                        k++;
                    }
                }
                order[i] = 0;//将桶中的数字设置为0，用于下一次排序
            }
            n*=10;
            k=0;//将k设置为0，用于保存下一次排序的结果
        }
        return array;
    }
    public static void main(String[] args) {
        int[] array = {
            2,6,1,55,37,967
        };
        radixSort(array,3);
        for (int i :
                array) {
            System.out.println(i);
        }
    }
}
```

