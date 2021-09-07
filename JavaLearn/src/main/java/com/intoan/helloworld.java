package com.intoan;

public class helloworld {
    public static void main(String[] args) {
        int a = 0;

        int result = divide(5,a);

        System.out.printf("divide(%d,%d) = %d",5,a,result);
    }

    public static int divide(int number, int divisor){
        try {
            return number/divisor;
        }catch (Throwable throwable){
            System.out.println("getMessage():" + throwable.getMessage());

            System.out.println("toString():" + throwable.toString());

            System.out.println("printStackTrace()输出信息如下：");
            throwable.printStackTrace();
        }
        return 0;
    }
}
