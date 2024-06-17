package leetCode._3200

import scala.collection.immutable.TreeSet

object Solution_3187 {
  def countOfPeaks(nums: Array[Int], queries: Array[Array[Int]]): List[Int] = {
    val n = nums.length
    var peaks = TreeSet.empty[Int]

    nums.indices.drop(1).dropRight(1).foreach(j => if (nums(j) > nums(j - 1) && nums(j) > nums(j + 1)) peaks = peaks + j)

    def addPeakIfValid(peaks: TreeSet[Int], index: Int): TreeSet[Int] =
      if (index >= 1 && index < n - 1 && nums(index) > nums(index - 1) && nums(index) > nums(index + 1)) peaks + index
      else peaks

    def removePeakIfExists(peaks: TreeSet[Int], index: Int): TreeSet[Int] =
      if (peaks.contains(index)) peaks - index
      else peaks

    val res = queries.flatMap {
      case Array(tp, x, y) if tp == 1 => Some(peaks.range(x + 1, y).size)
      case Array(_, x, y) =>
        peaks = (x - 1 to x + 1).foldLeft(peaks)((acc, v) => removePeakIfExists(acc, v))
        nums(x) = y
        peaks = (x - 1 to x + 1).foldLeft(peaks)((acc, v) => addPeakIfValid(acc, v))
        None
    }.toList
    res
  }
}
