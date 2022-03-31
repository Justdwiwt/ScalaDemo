package leetCode

object Solution_2218 {
  def maxValueOfCoins(piles: List[List[Int]], k: Int): Int = piles
    .iterator
    .zip(piles.iterator.scanLeft(0)(_ + _.size))
    ./:(IndexedSeq(0)) { case (dp, (pile, total)) =>
      val t = pile.scanLeft(0)(_ + _)
      (0 to k.min(total + pile.size)).map(k => {
        (0.max(k - total) to k.min(pile.size))
          .iterator
          .map(i => t(i) + dp(k - i))
          .max
      })
    }
    .apply(k)
}
