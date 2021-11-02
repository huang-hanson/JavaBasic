package com.hanson.niuke;

public class FinalTest {
    public static void main(String[] args) {
        System.out.println(test(null)+","+test("0")+","+test("1"));
    }

    public static int test(String str){
        try {
            return str.charAt(0) - '0';
        }catch (NullPointerException e1){
            return 1;
        }catch (StringIndexOutOfBoundsException e2){
            return  2;
        }catch (Exception e3){
            return 3;
        }finally {
            return 4;
        }
    }
}
