package chapter02

import chapter01.Student

object Test02_Variable {
  def main(args: Array[String]): Unit = {

    //声明一个变量的通用语法
    var a: Int = 10

    //1.声明变量时，类型可以省略，编译器自动推导，即类型推导
    var b = 12
    val b1 =22

    //2.类型确定后,就不能修改。Scala是强类型语言
    var a2 =15
    //a2 = "scala" error

    //3.变量声明时，必须要有初始值
    //var a3: Int

    //4.在声明/定义一个变量时，可以使用var/val来修饰，var修饰的变量可改变，val修饰的变量不可改变
    b = 32
    //b1 = 11

    var alice = new Student("alice", 20)
    alice = new Student("Alice",23)
    alice =null

    val bob = new Student("bob", 24)
    bob.age =22
    bob.printInfo()
    //bob =new Student("bob",24)



  }

}
