package leetCode

object XH_5_2 {
  def addMinimalBrackets(s: String): Int = {
    var left = 0
    var res = 0
    s.foreach(i => if (i == '(') left += 1 else if (left > 0) left -= 1 else res += 1)
    left + res
  }
}
