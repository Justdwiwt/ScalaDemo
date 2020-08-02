package leetCode

object Solution_1529 {
  def minFlips(target: String): Int = {
    var res = 0
    if (target(0) == '1') res += 1
    (0 until target.length - 1).foreach(i => if (target(i) != target(i + 1)) res += 1)
    res
  }
}
