package leetCode.offer

import java.util.Scanner

object MeiTuan_009 {
  def main(args: Array[String]): Unit = {
    val M = 998244353

    def getRes(n: Int, m: Int): Int = {
      val dp = Array.fill(m, n + 1)(0)
      (1 to n).foreach(i => dp.head(i) = 1)
      (0 until m - 1).foreach(i => (1 to n).foreach(j => (1 to n / j).foreach(k =>
        dp(i + 1)(j * k) = (dp(i + 1)(j * k) + dp(i)(j)) % M
      )))
      var res = 0
      (1 to n).foreach(i => res = (res + dp(m - 1)(i)) % M)
      res
    }

    val sc = new Scanner(System.in)
    val n = sc.nextInt()
    val m = sc.nextInt()
    println(getRes(n, m))
  }
}
