package leetCode._1500

import scala.collection.mutable

object Solution_1477 {
  def minSumOfLengths(arr: Array[Int], target: Int): Int = {
    val m = new mutable.HashMap[Int, Int]()
    m += 0 -> -1
    var mn = Int.MaxValue
    val diff = Array.fill(arr.length + 1)(Int.MaxValue)
    var sum = 0
    arr.indices.foreach(i => {
      sum += arr(i)
      if (m.contains(sum - target)) {
        val l = m(sum - target)
        val len = diff(l + 1)
        if (len != Int.MaxValue) mn = mn.min(len + i - l)
        diff(i + 1) = i - l
      }
      diff(i + 1) = diff(i).min(diff(i + 1))
      m += sum -> i
    })
    if (mn == Int.MaxValue) -1 else mn
  }
}
