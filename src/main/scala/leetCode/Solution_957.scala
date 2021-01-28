package leetCode

import scala.collection.mutable

object Solution_957 {
  def nextDay(bit: Int): Int =
    (~(bit << 1) ^ (bit >> 1)) & 0x7e

  def prisonAfterNDays(cells: Array[Int], N: Int): Array[Int] = {
    val m = mutable.Map.empty[Int, Int]

    @scala.annotation.tailrec
    def simulate(cur: Int, n: Int, flag: Boolean): Int = {
      if (n == N) return cur
      if (flag) simulate(nextDay(cur), n + 1, flag = true)
      else if (m.contains(cur)) simulate(cur, N - (N - m(cur)) % (n - m(cur)), flag = true)
      else {
        m.update(cur, n)
        simulate(nextDay(cur), n + 1, flag = false)
      }
    }

    val state = cells./:(0x0)((acc, x) => (acc << 1) | x)
    val res = simulate(state, 0, flag = false)
    ("0000000" + res.toBinaryString).toArray.map(_.toInt - 48).takeRight(8)
  }
}
