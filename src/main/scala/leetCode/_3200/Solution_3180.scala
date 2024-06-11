package leetCode._3200

import scala.collection.immutable.SortedSet

object Solution_3180 {
  def maxTotalReward(rewardValues: Array[Int]): Int = rewardValues
    .sorted
    .foldLeft(SortedSet(0))((poss, r) => poss ++ poss.takeWhile(_ < r).map(_ + r))
    .max
}
