package leetCode._3600

object Solution_3583 {
  def specialTriplets(nums: Array[Int]): Int =
    nums.foldLeft((Map.empty[Int, Long].withDefaultValue(0L), Map.empty[Int, Long].withDefaultValue(0L), 0L)) { case ((cnt1, cnt12, cnt123), x) =>
      val newCnt123 = if (x % 2 == 0) (cnt123 + cnt12(x / 2)) % 1000000007 else cnt123
      val newCnt12 = cnt12.updated(x, (cnt12(x) + cnt1(x * 2)) % 1000000007)
      val newCnt1 = cnt1.updated(x, (cnt1(x) + 1) % 1000000007)
      (newCnt1, newCnt12, newCnt123)
    }._3.toInt
}
