package leetCode

import scala.collection.mutable

object Solution_312 {
  def maxCoins(nums: Array[Int]): Int = {
    val arr = 1 +: nums.filter(_ > 0) :+ 1
    val m = mutable.Map.empty[(Int, Int), Int]

    def f(left: Int, right: Int): Int =
      if (left >= right) 0
      else m.getOrElse((left, right), {
        m((left, right)) = Range(left + 1, right).map(curr => arr(left) * arr(curr) * arr(right) + f(left, curr) + f(curr, right))./:(0)((max, current) => max.max(current))
        m((left, right))
      })

    f(0, arr.length - 1)
  }
}
