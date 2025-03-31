package leetCode._3500

object Solution_3494 {
  def minTime(skill: Array[Int], mana: Array[Int]): Long = {
    val prefixSum = skill.scanLeft(0L)(_ + _)

    if (mana.length == 1) return mana.head * prefixSum.last

    val start = mana.sliding(2).map { case Array(pre, cur) =>
      (prefixSum.init zip prefixSum.tail).map { case (sPrev, sNext) =>
        pre * sNext - cur * sPrev
      }.reduceOption(_.max(_)).getOrElse(0L)
    }.sum

    start + mana.last * prefixSum.last
  }
}
