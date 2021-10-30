package hello;

import java.util.Scanner;

public class hello {
    public static void main(String[] args){
//        System.out.println("Hello:");
//        Scanner in = new Scanner(System.in);
//        int a = in.nextInt();
//        int b = in.nextInt();
//        System.out.println(b);
//        System.out.println("100-"+a+"="+(100-a));
//
        Person zzuli = new Person("zzuli", 22);
        Person hacz = new Person("hacz", 23);

        System.out.println(zzuli);
        System.out.println(hacz);

        swap(zzuli,hacz);

        System.out.println(zzuli);
        System.out.println(hacz);

    }

    public static void swap(Person a, Person b){
        Person temp = a;
        a = b;
        b = temp;
    }

}

class Person{
    String neme;
    Integer age;

    public Person(String neme, Integer age) {
        this.neme = neme;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "neme='" + neme + '\'' +
                ", age=" + age +
                '}';
    }
}
