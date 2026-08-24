package leetCode._4000

object Solution_3969 {
  def countValidSubarrays(nums: Array[Int], x: Int): Int = nums
    .indices
    .foldLeft(0)((ans, i) => i.until(nums.length).foldLeft((ans, 0L)) {
      case ((count, sum), j) =>
        val s = sum + nums(j)
        var t = s

        while (t > 9) t /= 10

        (count + (if (s % 10 == x && t == x) 1 else 0), s)
    }._1)
}
