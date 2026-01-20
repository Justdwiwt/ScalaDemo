package leetCode._3800

object Solution_3755 {
  def maxBalancedSubarray(nums: Array[Int]): Int = nums
    .zipWithIndex
    .foldLeft((0, 0, 0, Map("0:0" -> -1))) {
      case ((max, pxor, count, map), (v, i)) =>
        val newPXor = pxor ^ v
        val newCount = if (v % 2 == 0) count + 1 else count - 1
        val key = "" + newPXor + ":" + newCount
        map.get(key) match {
          case Some(j) =>
            val newMax = math.max(max, i - j)
            (newMax, newPXor, newCount, map)
          case None =>
            (max, newPXor, newCount, map + (key -> i))
        }
    }._1
}
