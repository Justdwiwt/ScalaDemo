package leetCode._1900

import scala.collection.mutable

object Solution_1856 {
  def maxSumMinProduct(nums: Array[Int]): Int = {
    var max = BigInt(0)
    val pre = nums.scanLeft(BigInt(0))(_ + _)
    val st = mutable.Stack[(BigInt, Int)]()
    (nums :+ 0).zipWithIndex.foreach { case (n, currIdx) =>
      var idx = currIdx
      while (st.nonEmpty && st.head._1 > n) {
        val (prev, prevIdx) = st.pop()
        max = max.max(prev * (pre(currIdx) - pre(prevIdx)))
        idx = prevIdx
      }
      st.push((n, idx))
    }

    (max % (math.pow(10, 9) + 7).toInt).toInt
  }
}
