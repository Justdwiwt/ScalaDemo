package leetCode._1700

import scala.collection.mutable

object Solution_1673 {
  def mostCompetitive(nums: Array[Int], k: Int): Array[Int] = {
    val res = mutable.Stack[Int]()
    nums.indices.foreach(i => {
      while (res.nonEmpty && res.top > nums(i) && res.size - 1 + nums.length - i >= k)
        res.pop
      if (res.size < k) res.push(nums(i))
    })
    res.reverse.toArray
  }
}
