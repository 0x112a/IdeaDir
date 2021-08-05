package chapter05

object Test05_Lambda {
  def main(args: Array[String]): Unit = {
    val stringToUnitfg = (name: String) => {println(name)}
    val fun = stringToUnitfg
    fun("monica")
  }

}
