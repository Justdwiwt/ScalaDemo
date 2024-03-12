package leetCode._2200

object Solution_2190 {
  def mostFrequent(nums: Array[Int], key: Int): Int = nums
    .indices
    .drop(1)
    ./:(Map.empty[Int, Int].withDefaultValue(0)) { case (cnt, idx) =>
      if (nums(idx - 1) != key) cnt
      else cnt.updated(nums(idx), cnt(nums(idx)) + 1)
    }
    .maxBy { case (_, c) => c }
    ._1
}
