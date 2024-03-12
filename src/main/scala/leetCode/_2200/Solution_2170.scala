package leetCode._2200

import scala.collection.mutable

object Solution_2170 {
  def minimumOperations(nums: Array[Int]): Int = {
    def f(idx: Iterator[Int]): Array[(Int, Int)] = {
      val m = mutable.Map(0 -> 0, -1 -> 0).withDefaultValue(0)
      idx.foreach(idx => m(nums(idx)) += 1)
      m.toArray.sortBy { case (num, cnt) => (-cnt, num) }
    }

    val even = f((nums.indices by 2).iterator)
    val odd = f((nums.indices.drop(1) by 2).iterator)

    val unchanged =
      if (even.head._1 != odd.head._1) even.head._2 + odd.head._2
      else (even.head._2 + odd(1)._2).max(even(1)._2 + odd.head._2)

    nums.length - unchanged
  }
}
