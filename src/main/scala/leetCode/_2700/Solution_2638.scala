package leetCode._2700

import scala.collection.mutable

object Solution_2638 {
  def countTheNumOfKFreeSubsets(nums: Array[Int], k: Int): Long = {
    val group = mutable.HashMap.empty[Int, List[Int]]
    val key = Array.fill(10001)(0)
    val sorted = nums.sorted
    sorted.foreach(num => {
      val x = if (num >= k && key(num - k) > 0) key(num - k) else num
      val updatedList = num :: group.getOrElse(x, List.empty[Int])
      group.update(x, updatedList)
      key(num) = x
    })
    var res = 1L
    group.values.foreach(list => {
      var (a, b) = (1L, 2L)
      list.indices.drop(1).foreach(_ => {
        val t = a
        a = b
        b += t
      })
      res *= b
    })
    res
  }
}
