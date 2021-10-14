package com.intoan.multiThread;

public class MultiThread implements Runnable{
    private int ticket = 100;

    @Override
    public void run() {
        while (true){
            if (ticket <= 0) break;

            try{
                Thread.sleep(200);
                String name = Thread.currentThread().getName();
                System.out.println(name + "正在卖出第" + (100-ticket+1) + "张票。还剩余" + (--ticket) + "张");
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }

    }
}

class Test{
    public static void main(String[] args) {
        MultiThread multiThread = new MultiThread();

        new Thread(multiThread,"Window 1").start();
        new Thread(multiThread,"Window 2").start();

    }
}