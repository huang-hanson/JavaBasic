package Q152;

/**
 * @author 黄忠
 */
public class Test152 {
//    给定一个double类型的数组arr，其中的元素可正可负可0，返回子数组累乘的最大乘积。
//    例如arr=[-2.5，4，0，3，0.5，8，-1]，子数组[3，0.5，8]累乘可以获得最大的乘积12，所以返回12。\
    public static double findMaxMutil(double[] arr){
        int n = arr.length;
        double f = arr[0];//记录以i结尾的累乘的最大值
        double g = arr[0];//记录以i结尾的累乘的最小值
        double max = f;
        for (int i = 1; i < n; i++) {
            f = Math.max(arr[i],Math.max(arr[i]*f,arr[i]*g));
            g = Math.min(arr[i],Math.min(arr[i]*f,arr[i]*g));
            max = Math.max(max,f);
        }
        return max;
    }

    public static void main(String[] args) {
        double[] arr= {-2.5,4,0,3,0.5,8,-1};
        System.out.println(findMaxMutil(arr));
    }
}
