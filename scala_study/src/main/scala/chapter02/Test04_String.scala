package chapter02

object Test04_String {
  def main(args: Array[String]): Unit = {
    //1.字符串，使用+号连接
    val name: String = "alice"
    val age: Int = 18
    println(age + "岁的" + name + "in the study scala")

    // * 用于将一个字符串复制多次并拼接
    println(name * 3)

    //2.print用法： 字符串，通过%传值
    printf("%d岁的%s在尚硅谷学习", age, name)
    println()

    //3.字符串模板（插值字符串）：通过$获取变量值
    println(s"${age} years old ${name}")

    val num: Double = 3.14159026

    println(f"The num is ${num}%2.2f") // 格式化模板字符串
    println(raw"The num is ${num}%5.2f")

    // 三引号表示字符串，保持多行字符串的元格式输出
    val sql =
      s"""
         |select *
         |form
         |  student
         |where
         |  name = ${name}
         |and
         |  age > ${age}
         |""".stripMargin

    println(sql)
  }

}
