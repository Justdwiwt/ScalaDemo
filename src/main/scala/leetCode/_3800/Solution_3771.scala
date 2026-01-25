package leetCode._3800

object Solution_3771 {
  private def lowerBound(arr: Array[Long], right: Int, target: Long): Int = Iterator
    .iterate((0, right)) {
      case (l, r) =>
        val m = l + ((r - l) >> 1)
        if (arr(m) < target) (m + 1, r) else (l, m)
    }
    .dropWhile { case (l, r) => l < r }
    .next()
    ._1

  def totalScore(hp: Int, damage: Array[Int], requirement: Array[Int]): Long = {
    val prefix = damage.scanLeft(0L)(_ + _)

    val n = damage.length
    val base = n.toLong * (n + 1) / 2

    (0 until n).foldLeft(base)((ans, i) => {
      val low = prefix(i + 1) + requirement(i) - hp
      if (low > 0) ans - lowerBound(prefix, i + 1, low)
      else ans
    })
  }
}
