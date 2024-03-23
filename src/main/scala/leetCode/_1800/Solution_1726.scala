package leetCode._1800

import scala.collection.mutable

object Solution_1726 {
  def tupleSameProduct(nums: Array[Int]): Int = {
    val m = mutable.Map.empty[Int, Int]
    nums.foreach(i => nums.foreach(j => if (i != j) m += (i * j) -> (m.getOrElse(i * j, 0) + 1)))
    m.values.filter(_ > 2).map(c => c * (c - 2)).sum
  }
}
