package leetcode.isExist;

import java.util.Scanner;

/**
 * @author 黄忠
 */
public class IsExist {
    public int isExist(int[][] matrix, int target) {
        if (matrix.length < 1) {
            return 0;
        }
        int x = matrix.length-1;
        int y = 0;
        int length = matrix[0].length;
        while (x >= 0 && y < length){
            if (matrix[x][y] == target) {
                return 1;
            }else if (matrix[x][y] < target){
                y++;
            }else if (matrix[x][y] > target){
                x--;
            }
        }
        return 0;
    }



    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int matrix_rows = 0;
        int matrix_cols = 0;
        matrix_rows = in.nextInt();
        matrix_cols = in.nextInt();

        int[][] matrix = new int[matrix_rows][matrix_cols];
        for(int matrix_i=0; matrix_i<matrix_rows; matrix_i++) {
            for(int matrix_j=0; matrix_j<matrix_cols; matrix_j++) {
                matrix[matrix_i][matrix_j] = in.nextInt();
            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }


        int target;
        target = Integer.parseInt(in.nextLine().trim());

        res = new IsExist().isExist(matrix, target);
        System.out.println(String.valueOf(res));

    }
}