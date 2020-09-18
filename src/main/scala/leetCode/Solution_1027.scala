package leetCode

import scala.collection.mutable

object Solution_1027 {
  def longestArithSeqLength(arr: Array[Int]): Int = {
    val dp = mutable.Map.empty[(Int, Int), Int].withDefaultValue(1)
    var res = 0
    arr.indices.foreach(i => (0 until i).foreach(j => {
      val delta = arr(i) - arr(j)
      val length = dp(j -> delta) + 1
      dp += (i, delta) -> length
      res = res.max(length)
    }))
    res
  }
}
