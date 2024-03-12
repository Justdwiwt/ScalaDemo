package leetCode.offer

import java.util.Scanner

object MeiTuan_010 {
  def main(args: Array[String]): Unit = {
    var n = 0
    var f = Array.emptyIntArray

    def check(l: Int, r: Int): Boolean = {
      var pre = 0
      (0 until n).foreach(i => {
        val x = f(i)
        if (x < l || x > r) {
          if (x < pre) return false
          pre = x
        }
      })
      true
    }

    val sc = new Scanner(System.in)
    val m = sc.nextInt()
    n = sc.nextInt()
    f = Array.fill(n)(0)
    (0 until n).foreach(i => f(i) = sc.nextInt())
    var xt = 0
    var res = 0
    (1 to m).foreach(i => {
      val xm = i
      var l = i
      var r = m + 1
      while (l < r) {
        val mid = (l + r) >>> 1
        if (check(xm, mid)) r = mid
        else l = mid + 1
      }
      xt = 1
      res += m - xt + 1
    })
    println(res)
  }
}
