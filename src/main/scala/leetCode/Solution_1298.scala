package leetCode

object Solution_1298 {
  def maxCandies(status: Array[Int], candies: Array[Int], keys: Array[Array[Int]], containedBoxes: Array[Array[Int]], initialBoxes: Array[Int]): Int = {
    @scala.annotation.tailrec
    def f(l: List[Int], acc: Int): Int =
      if (!l.exists(x => status(x) == 1)) acc
      else {
        val p = l.filter(x => status(x) == 1)
        p.foreach(x => keys(x).foreach(y => status(y) = 1))
        val q = l.filterNot(p.contains) ++ p.flatMap(x => containedBoxes(x))
        f(q, acc + p.map(candies).sum)
      }

    f(initialBoxes.toList, 0)
  }
}
