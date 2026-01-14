package leetCode._3800

object Solution_3737 {
  def countMajoritySubarrays(nums: Array[Int], target: Int): Int = {
    val freq = nums.scanLeft(0)((c, n) => if (n == target) c + 1 else c)

    def majority(seg: (Int, Int)) = {
      val (from, until) = seg
      (freq(until) - freq(from)) * 2 > (until - from)
    }

    val segments = nums.indices.flatMap(a => ((a + 1) to nums.length).map((a, _)))

    segments.count(majority)
  }
}
