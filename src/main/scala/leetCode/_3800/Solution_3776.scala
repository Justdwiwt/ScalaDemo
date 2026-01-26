package leetCode._3800

object Solution_3776 {
  def minMoves(balance: Array[Int]): Long = {
    val sum = balance.map(_.toLong).sum
    if (sum < 0) return -1L

    val i = balance.indexWhere(_ < 0)
    if (i < 0) return 0L

    val n = balance.length

    Iterator
      .from(1)
      .scanLeft((-balance(i).toLong, 0L)) { case ((need, ans), d) =>
        val s = balance((i - d + n) % n).toLong + balance((i + d) % n).toLong

        val take = math.min(need, s)
        (need - take, ans + take * d)
      }
      .drop(1)
      .find(_._1 == 0)
      .get
      ._2
  }
}
