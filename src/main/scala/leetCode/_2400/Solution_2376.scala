package leetCode._2400

import scala.collection.mutable

object Solution_2376 {
  def countSpecialNumbers(n: Int): Int = {
    val digits = n.toString.map(_ - '0')
    val m = mutable.Map.empty[(Int, Int, Boolean), Int]

    def dfs(i: Int, mask: Int, tight: Boolean): Int = m.getOrElseUpdate((i, mask, tight),
      if (i == digits.length) if (mask == 0) 0 else 1
      else {
        val limit = if (tight) digits(i) else 9
        (0 to limit).collect {
          case d if ((mask >> d) & 1) == 0 =>
            val newMask = if (mask == 0 && d == 0) mask else mask | (1 << d)
            dfs(i + 1, newMask, d == limit && tight)
        }.sum
      })

    dfs(0, 0, tight = true)
  }
}
