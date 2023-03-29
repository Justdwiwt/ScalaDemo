package leetCode

object Solution_2594 {
  def repairCars(ranks: Array[Int], cars: Int): Long = {
    @scala.annotation.tailrec
    def f(l: Long, r: Long): Long =
      if (l >= r) l
      else {
        val mid = (l + r) >>> 1
        val cur = ranks.map(r => math.sqrt(mid.toDouble / r).toLong).sum
        if (cur < cars) f(mid + 1, r) else f(l, mid)
      }

    f(l = 1L, r = ranks.head.toLong * cars * cars)
  }
}
