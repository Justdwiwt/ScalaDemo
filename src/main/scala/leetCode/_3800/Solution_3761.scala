package leetCode._3800

object Solution_3761 {
  def minMirrorPairDistance(nums: Array[Int]): Int = {
    val (_, ans) = nums.zipWithIndex.foldLeft((Map.empty[Int, Int], Int.MaxValue)) { case ((lastIndex, best), (x, j)) =>
      val newBest = lastIndex.get(x).map(i => best.min(j - i)).getOrElse(best)
      val rev = x.toString.reverse.toInt
      (lastIndex.updated(rev, j), newBest)
    }

    if (ans == Int.MaxValue) -1 else ans
  }
}
