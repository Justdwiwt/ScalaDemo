package leetCode

import java.util.Scanner
import scala.collection.mutable.ListBuffer

object MeiTuan_005 {
  def main(args: Array[String]): Unit = {
    var n, k = 0
    var level = Array.emptyIntArray
    var used = Array.emptyBooleanArray
    val M = 1000000007
    var e = List.empty[ListBuffer[Int]]

    val in = new Scanner(System.in)
    n = in.nextInt()
    k = in.nextInt()
    level = Array.fill(n + 1)(0)
    used = Array.fill(n + 1)(false)
    (0 to n).foreach(_ => e :+= ListBuffer.empty[Int])
    (1 until n).foreach(_ => {
      val x = in.nextInt()
      val y = in.nextInt()
      e(x) += y
      e(y) += x
    })
    (1 to n).foreach(i => level(i) = in.nextInt())
    var res = 0L
    (1 to n).foreach(i => {
      used = Array.fill(n + 1)(false)
      res = (res + dfs(i, i)) % M
    })


    def dfs(u: Int, s: Int): Long = {
      used(u) = true
      var res = 1L
      e(u).withFilter(v => !used(v)).foreach(v =>
        if (level(v) > level(s) && level(v) - level(s) <= k || level(v) == level(s) && v > s)
          res *= (1 + dfs(v, s)) % M
      )
      res
    }

    println(res)
  }
}
