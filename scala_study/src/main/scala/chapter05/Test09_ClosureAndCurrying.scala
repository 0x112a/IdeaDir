package chapter05

object Test09_ClosureAndCurrying {

  def main(args: Array[String]): Unit = {
    def add(a: Int,b: Int):Int ={
      a+b
    }

    //1.考虑固定一个加数的场景
    def addByFour(b: Int): Int ={
      4+b
    }

  }

}
