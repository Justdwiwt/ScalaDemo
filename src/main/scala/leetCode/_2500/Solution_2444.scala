package leetCode._2500

object Solution_2444 {
  def countSubarrays(nums: Array[Int], minK: Int, maxK: Int): Long = nums
    .zipWithIndex
    ./:(0L, 0, -1, -1) {
      case ((cnt, left, lastMinK, lastMaxK), (num, right)) =>
        if (num < minK || num > maxK) (cnt, right + 1, lastMinK, lastMaxK)
        else {
          val newLastMinK = if (num == minK) right else lastMinK
          val newLastMaxK = if (num == maxK) right else lastMaxK
          val newCount = if (newLastMinK < left || newLastMaxK < left) 0 else newLastMinK.min(newLastMaxK) - left + 1
          (cnt + newCount, left, newLastMinK, newLastMaxK)
        }
    }
    ._1
}
