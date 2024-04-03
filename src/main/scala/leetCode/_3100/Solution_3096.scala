package leetCode._3100

object Solution_3096 {
  def minimumLevels(possible: Array[Int]): Int = {
    val s = possible.sum * 2 - possible.length

    val prefixSums = possible.scanLeft(0)((acc, x) => acc + (if (x == 1) 2 else -2))

    possible
      .indices
      .drop(1)
      .map(i => (i, prefixSums(i)))
      .find { case (_, pre) => pre > s }
      .map(_._1)
      .getOrElse(-1)
  }
}
