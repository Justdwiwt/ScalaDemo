package leetCode._3400

import scala.collection.mutable.ArrayBuffer

object Solution_3399 {
  def minLength(s: String, numOps: Int): Int = {
    val n = s.length
    val pre = Array.ofDim[Int](n + 1, 2)
    (1 to n).foreach(i => {
      pre(i)(0) = (if (s(i - 1) != '0') 1 else 0) + pre(i - 1)(0)
      pre(i)(1) = (if (s(i - 1) != '1') 1 else 0) + pre(i - 1)(1)
    })

    def check(x: Int): Boolean = {
      val dp = Array.ofDim[Int](n + 1, 2)

      def f(i: Int, v: Int): Int =
        dp(i)(v) - pre(i)(v ^ 1)

      dp(0)(0) = 0
      dp(0)(1) = 0

      val que0 = new ArrayBuffer[Int]()
      val que1 = new ArrayBuffer[Int]()
      que0 += 0
      que1 += 0

      (1 to n).foreach(i => {
        while (que0.nonEmpty && que0.head < i - x) que0.remove(0)
        while (que1.nonEmpty && que1.head < i - x) que1.remove(0)

        dp(i)(0) = pre(i)(0) + f(que1.head, 1)
        dp(i)(1) = pre(i)(1) + f(que0.head, 0)

        while (que0.nonEmpty && f(que0.last, 0) >= f(i, 0)) que0.remove(que0.length - 1)
        while (que1.nonEmpty && f(que1.last, 1) >= f(i, 1)) que1.remove(que1.length - 1)

        que0 += i
        que1 += i
      })

      dp(n).head.min(dp(n)(1)) <= numOps
    }

    var (lb, ub) = (1, s.length)
    while (lb <= ub) {
      val mid = (lb + ub) / 2
      if (!check(mid)) lb = mid + 1
      else ub = mid - 1
    }
    lb
  }
}
