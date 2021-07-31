package chapter05

object Test01_FunctionAndMethod {
  def main(args: Array[String]): Unit = {

    //定义函数
    def sayHi(name: String): Unit = {
      println("hi " + name)
    }

    //调用函数
    sayHi("alice")
    //调用对象方法
    Test01_FunctionAndMethod.sayHi("bob")
  }

  //定义对象方法
  def sayHi(name: String): String={

    println("Hi " + name)
    "Hi " +  name
  }

}
