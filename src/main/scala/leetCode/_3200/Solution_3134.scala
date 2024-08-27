package leetCode._3200

import scala.collection.mutable

object Solution_3134 {
  private def getLessOrEqualMedianCount(nums: Array[Int], median: Int): Long = {
    val countMap = mutable.Map.empty[Int, Int]
    var l = 0
    var res = 0L

    nums.indices.foreach(r => {
      countMap(nums(r)) = countMap.getOrElse(nums(r), 0) + 1
      while (countMap.size > median) {
        countMap(nums(l)) -= 1
        if (countMap(nums(l)) == 0) countMap.remove(nums(l))
        l += 1
      }
      res += (r - l + 1)
    })
    res
  }

  def medianOfUniquenessArray(nums: Array[Int]): Int = {
    val n = nums.length
    val total: Long = n.toLong * (n + 1) / 2
    val target: Long = (total + 1) / 2

    @scala.annotation.tailrec
    def f(left: Int, right: Int): Int =
      if (left > right) left
      else {
        val median = (left + right) / 2
        val count = getLessOrEqualMedianCount(nums, median)
        if (count < target) f(median + 1, right)
        else f(left, median - 1)
      }

    f(1, n)
  }
}
