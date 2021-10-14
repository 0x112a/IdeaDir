package com.intoan.waitAndSleep;

public class WaitAndSleep_II {
    public static void main(String[] args) {
        Printer p = new Printer();

        new Thread(){
            @Override
            public void run(){
                while (true){
                    try {
                        p.printOne();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run(){
                while (true){
                    try {
                        p.printTow();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
class Printer{
    private int flag = 1;
    public void printOne() throws InterruptedException {
        synchronized(Printer.class){
            if (flag != 1){
                Printer.class.wait();
            }
            System.out.println("郑州轻工业大学");
            flag = 2;
            Printer.class.notify();
        }
    }

    public void printTow() throws InterruptedException{
        synchronized (Printer.class){
            if (flag != 2){
                Printer.class.wait();
            }
            System.out.println("计算机与通信工程学院");
            flag = 1;
            Printer.class.notify();
        }
    }
}
