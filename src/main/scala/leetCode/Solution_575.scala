package leetCode

import scala.collection.mutable

object Solution_575 {
  def distributeCandies(candies: Array[Int]): Int = {
    val s = new mutable.HashSet[Int]()
    candies.foreach(i => s.add(i))
    s.size.min(candies.length / 2)
  }
}
