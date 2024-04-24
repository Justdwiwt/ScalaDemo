package leetCode._2200

import scala.collection.mutable

object Solution_2107 {
  def shareCandies(candies: Array[Int], k: Int): Int = {
    val counts = mutable.Map.empty[Int, Int]
    val length = candies.length
    (k until length).foreach(i => {
      val candy = candies(i)
      counts(candy) = counts.getOrElse(candy, 0) + 1
    })
    val maxFlavors = (k until length).foldLeft(counts.size)((max, i) => {
      val prev = candies(i - k)
      val curr = candies(i)
      counts(prev) = counts.getOrElse(prev, 0) + 1
      counts(curr) = counts(curr) - 1
      if (counts(curr) == 0) counts.remove(curr)
      max.max(counts.size)
    })
    maxFlavors
  }
}
