package chapter01

class Student(name: String, var age: Int){

  def printInfo(): Unit = {
    println(name + " " + age + " " + Student.school)
  }
}

// 引入伴生对象
object Student{
  val school: String = "intoan"

  def main(args: Array[String]): Unit = {
    val intoan = new Student("0x112", 20)
    val bob = new Student("Bob", 24)

    intoan.printInfo()
    bob.printInfo()

  }
}
