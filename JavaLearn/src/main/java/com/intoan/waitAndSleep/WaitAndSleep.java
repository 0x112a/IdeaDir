package com.intoan.waitAndSleep;

public class WaitAndSleep {
    public static void main(String[] args) throws InterruptedException {
//        sleepMethod();
        waitMethod();

    }

    public static void sleepMethod() throws InterruptedException{
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello World!");
            Thread.sleep(1000);
        }
    }

    public static void waitMethod() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello World!");
            WaitAndSleep.class.wait(1000);
        }
    }
}
