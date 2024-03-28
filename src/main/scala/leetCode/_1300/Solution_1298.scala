package leetCode._1300

object Solution_1298 {
  def maxCandies(status: Array[Int], candies: Array[Int], keys: Array[Array[Int]], containedBoxes: Array[Array[Int]], initialBoxes: Array[Int]): Int = {
    @scala.annotation.tailrec
    def f(l: List[Int], acc: Int): Int =
      if (!l.exists(status(_) == 1)) acc
      else {
        val p = l.filter(status(_) == 1)
        p.foreach(keys(_).foreach(status(_) = 1))
        val q = l.filterNot(p.contains) ++ p.flatMap(containedBoxes(_))
        f(q, acc + p.map(candies).sum)
      }

    f(initialBoxes.toList, 0)
  }
}
