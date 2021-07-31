package chapter01

/**
 * object: 关键字，声名一个单例对象（伴生对象）
 */
object Helloworld {

  /**
   * main 方法：从外部可以直接调用
   * def 方法名称（）：返回值类型 = {方法体}
   * @param args
   */
  def main(args: Array[String]): Unit = {

    println("Hello, World")
    System.out.println("hello scala from scala")
  }
}
