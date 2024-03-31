package leetCode._1000

import scala.collection.mutable

object Solution_902 {
  def atMostNGivenDigitSet(rawDigits: Array[String], n: Long): Int = {
    val digits = rawDigits.map(_.toInt)
    val num = n.toString.map(_ - '0')
    val m = mutable.Map.empty[(Int, Boolean, Boolean), Int]

    def dfs(i: Int, isPrefix: Boolean, isBigger: Boolean): Int = m.getOrElseUpdate(
      (i, isPrefix, isBigger), {
        if (i == num.length) if (isBigger) 0 else 1
        else if (!isPrefix && !isBigger) 1 + digits.length * dfs(i + 1, isPrefix, isBigger)
        else 1 + digits.map(d => dfs(i + 1, isPrefix && d == num(i), isBigger || (isPrefix && d > num(i)))).sum
      }
    )

    dfs(i = 0, isPrefix = true, isBigger = false) - 1
  }
}
