package com.hanson.Exception;

public class MyException {
    public static void main(String[] args) throws Exception {
        String str = "Hello offer";
        int index = 10;
        if(index >= str.length()){
            //1:使用throw在方法内抛出异常
            throw  new StringIndexOutOfBoundsException();
        }else {
            System.out.println(str.substring(0,index));
        }

        System.out.println(div(10,2));
    }

    static int div(int a, int b) throws  Exception{
        return a/b;
    }
}
