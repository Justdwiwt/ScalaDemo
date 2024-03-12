package leetCode._2400

object Solution_2320 {
  private def modulo(i: Long): Long = i % 1000000007

  def countHousePlacements(n: Int): Int = {
    @scala.annotation.tailrec
    def f(pre: Long, cur: Long, k: Int): Long =
      if (k == n) cur
      else f(cur, modulo(pre + cur), k + 1)

    val v = f(1, 2, 1)
    modulo(v * v).toInt
  }
}
