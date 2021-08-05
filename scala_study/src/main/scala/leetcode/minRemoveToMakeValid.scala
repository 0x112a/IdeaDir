package leetcode


object minRemoveToMakeValid {
  def minRemoveToMakeValid(s: String): String ={
    val c = '('
    val c1 = ')'
    val length = s.length
    length
    var ans: String = ""
    var ans1: String = ""
    var balance: Int = 0
    var `sum(` = 0
    for (i <- 0 until length){

      val c2 = s.charAt(i)

      if (c2 == c){
        balance += 1
        `sum(` += 1
      }  else if (c2 == c1){
          balance-=1
      }

      if (balance < 0) {
        balance+=1
      }else{
        ans+=c2
      }

    }
    `sum(` -= balance
    for (i <- 0 until ans.length ){
      val temp=ans.charAt(i)
      if (temp == c ) `sum(`-=1

      if (`sum(` < 0){
        `sum(`+=1
      }else{
        ans1+=temp
      }

    }
    ans1
  }

  def main(args: Array[String]): Unit = {
//    val s = "lee(t(c)o)(de)(("
    val s= args(0)
    println(minRemoveToMakeValid(s))
  }
}
