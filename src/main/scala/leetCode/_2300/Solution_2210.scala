package leetCode._2300

object Solution_2210 {
  def countHillValley(nums: Array[Int]): Int = {
    @scala.annotation.tailrec
    def f(pre: Int, acc: Int, list: List[Int]): Int = list match {
      case h1 :: h2 :: tail =>
        if (h1 > pre && h1 > h2) f(h1, acc + 1, h2 :: tail)
        else if (h1 < pre && h1 < h2) f(h1, acc + 1, h2 :: tail)
        else if (h1 == h2) f(pre, acc, h2 :: tail)
        else f(h1, acc, h2 :: tail)
      case _ => acc
    }

    val l = nums.toList
    f(l.head, 0, l.tail)
  }
}
