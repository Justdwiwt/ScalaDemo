package leetCode

object Solution_921 {
  def minAddToMakeValid(S: String): Int = {
    var left = 0
    var res = 0
    S.foreach(i => if (i == '(') left += 1 else if (left > 0) left -= 1 else res += 1)
    left + res
  }
}
