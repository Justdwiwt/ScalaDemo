package leetCode._2500

object Solution_2488 {
  def countSubarrays(nums: Array[Int], k: Int): Int = {
    val (l, r) = nums.splitAt(nums.indexOf(k))

    val cnt = l
      .:\(Map[Int, Int](0 -> 1).withDefaultValue(0), 0) {
        case (n, (map, key)) =>
          val newKey = if (n > k) key + 1 else key - 1
          (map + (newKey -> (map(newKey) + 1)), newKey)
      }
      ._1

    r
      ./:(0, 0) { case ((res, key), n) =>
        val newKey = if (n > k) key - 1 else if (n < k) key + 1 else key
        (res + cnt(newKey) + cnt(newKey + 1), newKey)
      }
      ._1
  }
}
