package leetCode._3300

import scala.math.{floor, log}

object Solution_3209 {
  def countSubarrays(nums: Array[Int], k: Int): Long = {
    val max = nums.max
    val m = floor(log(max) / log(2) + 1).toInt
    val lastZeroIndices = Array.fill(m)(-1)

    nums.zipWithIndex.foldLeft((0L, -1)) { case ((res, start), (num, i)) =>
      if ((num & k) != k) (res, i)
      else {
        val end = (0 until m).foldLeft(i)((currentEnd, j) => {
          val mask = num ^ k
          if ((mask & (1 << j)) > 0) currentEnd.min(lastZeroIndices(j))
          else {
            lastZeroIndices(j) = i
            currentEnd
          }
        })
        (res + 0.max(end - start), start)
      }
    }._1
  }
}
