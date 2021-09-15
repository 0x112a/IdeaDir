package com.intoan;

/**
 * Class class
public class Main {

    public static void main(String[] args) {
        printClassInfo("".getClass());
        printClassInfo(Runnable.class);
        printClassInfo(java.time.Month.class);
        printClassInfo(String[].class);
        printClassInfo(int.class);

    }

    static void printClassInfo(Class cls){
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());

        if(cls.getPackage() != null){
            System.out.println("Package name: " + cls.getPackage().getName());
        }

        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());

    }
}
 */

import java.lang.reflect.*;

/**
 * 获取字段

public class Main {
    public static void main(String[] args) throws NoSuchFieldException {
        Class stdClass = Student.class;

        System.out.println(stdClass.getField("name"));

        System.out.println(stdClass.getField("score"));

        System.out.println(stdClass.getDeclaredField("grade"));

        Field f = String.class.getDeclaredField("value");

        System.out.println(f.getName());

        System.out.println(f.getType());// class [C char类型的数组

        int modifiers = f.getModifiers();
        Modifier.isFinal(modifiers); // true
        Modifier.isPublic(modifiers); // false
        Modifier.isProtected(modifiers); // false
        Modifier.isPrivate(modifiers); // true
        Modifier.isStatic(modifiers); // false
    }

}

class Student extends Person{
    public int score;
    private int grade;

}

class Person{
    public String name;
}
 */

/**
 * get Filed value

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Object moncia = new Person("moncia");

        Class cls = moncia.getClass();
        System.out.println(cls.getName());

        Field f = cls.getDeclaredField("name");

        f.setAccessible(true);
        Object value = f.get(moncia);

        System.out.println(value);
    }
}

class Person{
    private String name;

    public Person(String name){
        this.name = name;
    }
}
 */

/**
 * set Field value
public class Main {
    public static void main(String[] args) throws Exception{
        Person p = new Person("monica");
        System.out.println(p.getName());

        Class c = p.getClass();

        Field f = c.getDeclaredField("name");

        f.setAccessible(true);

        f.set(p,"0x112");

        System.out.println(p.getName());
    }
}

class Person{
    private String name;

    public Person(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
 */

/**
 * Method

public class Main {
    public static void main(String[] args) throws Exception{
        Class cls = "Hello world".getClass();

        Method substring = cls.getMethod("substring", int.class, int.class);

        String hello_world = (String) substring.invoke("Hello world", 4, 7);

        System.out.println(hello_world);
    }
}
 */

/**
 * 多态

public class Main {
    public static void main(String[] args) throws Exception {
        Method hello = Person.class.getMethod("hello");

        hello.invoke(new Person());
    }

}

class Person{
    public void hello(){
        System.out.println("Person:hello");
    }
}

class Student extends Person{
    public void hello(){
        System.out.println("Student:hello");
    }
}
 */


/**
 * Static Proxy
 *
 */

interface Hello{
    void say();
}

class People implements Hello{

    @Override
    public void say() {
        System.out.println("Hello");
    }
}

class Teach implements Hello{
    private Hello target;

    public Teach(Hello oj){
        this.target = oj;
    }

    @Override
    public void say() {
        System.out.println("pre");
        target.say();
        System.out.println("post");

    }
}

public class Main {
    public static void main(String[] args) {
        Hello people = new People();
        Teach teach = new Teach(people);
        teach.say();
    }
}

/**
 * 动态代理
public class Main {
    public static void main(String[] args) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("morning")) {
                    System.out.println("Good morning, " + args[0]);
                }
                return null;
            }
        };

         Hello hello = (Hello)Proxy.newProxyInstance(
                Hello.class.getClassLoader(),
                new Class[]{Hello.class},
                handler
        );
         hello.morning("monica");
    }
}

interface Hello{
    void morning(String name);
}
 */

