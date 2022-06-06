package leetCode

import scala.collection.mutable

object Solution_2295 {
  def arrayChange(nums: Array[Int], operations: Array[Array[Int]]): Array[Int] = {
    val m = mutable.HashMap.empty[Int, Int]
    nums.indices.foreach(i => m += nums(i) -> i)
    operations.foreach(i => {
      val idx = m(i.head)
      m += i(1) -> idx
      nums(idx) = i(1)
    })
    nums
  }
}
