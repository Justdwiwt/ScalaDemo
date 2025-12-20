package leetCode._3700

object Solution_3649 {
  def perfectPairs(nums: Array[Int]): Long = {
    val sorted = nums.map(math.abs).sorted

    sorted.zipWithIndex.foldLeft((0, 0L)) { case ((left, acc), (b, j)) =>
      val newLeft = Iterator.iterate(left)(_ + 1)
        .dropWhile(l => l < j && sorted(l) * 2 < b)
        .next()
      (newLeft, acc + (j - newLeft))
    }._2
  }
}
