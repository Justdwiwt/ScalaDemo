package leetCode._3900

object Solution_3847 {
  def scoreDifference(nums: Array[Int]): Int = {
    @scala.annotation.tailrec
    def f(remaining: List[Int], score: (Int, Int), active: Int, count: Int): Int = remaining match {
      case Nil => score._1 - score._2
      case x :: xs =>
        val nextActive1 = if (x % 2 == 1) active ^ 1 else active
        val nextActive2 = if ((count + 1) % 6 == 0) nextActive1 ^ 1 else nextActive1
        val newScore = if (nextActive2 == 0) (score._1 + x, score._2) else (score._1, score._2 + x)
        f(xs, newScore, nextActive2, count + 1)
    }

    f(nums.toList, (0, 0), 0, 0)
  }
}
