package leetCode

import scala.collection.mutable

object Solution_2404 {
  def mostFrequentEven(nums: Array[Int]): Int = {
    val cnt = mutable.SortedMap.empty[Int, Int]
    nums.foreach(i => if (i % 2 == 0) cnt.update(i, cnt.getOrElse(i, 0) + 1))
    if (cnt.isEmpty) -1 else cnt.maxBy(_._2)._1
  }
}
