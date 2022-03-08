package totalRun;

/**
 * @author 黄忠
 */
public class Solution {
    public static long totalRun(int days) {
        // write code here
        int sum = 0;
        if (days < 8 ) {
            for (int i = 0;i<= days ;i++) {
                sum=sum+i*100;
            }
        }else {
            for (int i = 0; i <= days; i++) {
                sum = 2700+100*i;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        long l = totalRun(10);
        System.out.println(l);
    }
}
