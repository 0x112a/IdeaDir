package helloThread;

public class helloThread {
    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();

        System.out.println("当前主进程名："+currentThread.getName());
    }
}