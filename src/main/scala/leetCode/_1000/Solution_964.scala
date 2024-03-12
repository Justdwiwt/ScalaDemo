package leetCode._1000

import scala.collection.mutable

object Solution_964 {
  private val m = mutable.HashMap[String, Int]()
  private var x = 0

  def leastOpsExpressTarget(x: Int, target: Int): Int = {
    this.x = x
    val ans = dp(0, target) - 1
    this.m.clear()
    ans
  }

  def dp(i: Int, target: Int): Int = {
    val code = "" + i + "#" + target
    if (m.contains(code)) return m(code)
    var res = 0
    if (target == 0) res = 0
    else if (target == 1) res = cost(i)
    else if (i >= 39) res = target + 1
    else {
      val t = target / x
      val r = target % x
      res = (r * cost(i) + dp(i + 1, t)).min((x - r) * cost(i) + dp(i + 1, t + 1))
    }

    m.put(code, res)
    res
  }

  def cost(i: Int): Int = if (i > 0) i else 2
}
