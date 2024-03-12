package leetCode._1000

object Solution_921 {
  def minAddToMakeValid(S: String): Int = {
    @scala.annotation.tailrec
    def f(i: String): String =
      if (i.contains("()")) f(i.replace("()", ""))
      else i

    f(S).length
  }
}
