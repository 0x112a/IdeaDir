package chapter02

object Test03_Identifier {

  def main(args: Array[String]): Unit = {
    //1.以字母或者下划线开头，后接字母、数字、下划线
    val hello: Int = 10
    val a0x112: String = ""
    var _monica001 = 12

    //val a-b = ""
    //val 123abc = 122

    //2.以操作符开头，且之包含操作符（ + - * / # ! % )等
    val +- :Int = 12
    println(+-)

    //3.用反引号`Int`包含的任意字符，即使是Scala 的关键字 也可以
    val `if` = "if"
    println(`if`)

  }
}
