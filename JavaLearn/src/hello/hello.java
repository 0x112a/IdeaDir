package hello;

import java.util.Scanner;

public class hello {
    public static void main(String[] args){
        System.out.println("Hello:");
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(b);

        System.out.println("100-"+a+"="+(100-a));

    }
}
