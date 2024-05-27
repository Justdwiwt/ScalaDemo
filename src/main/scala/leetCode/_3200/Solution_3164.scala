package leetCode._3200

object Solution_3164 {
  def numberOfPairs(nums1: Array[Int], nums2: Array[Int], k: Int): Long = {
    val map = nums2.groupBy(_ * k).mapValues(_.length)
    nums1.foldLeft(0L)((res, n) => {
      val factors = (1 to math.sqrt(n).toInt).flatMap(i => {
        if (n % i == 0) {
          if (i * i == n) Seq(i)
          else Seq(i, n / i)
        } else Seq.empty
      })
      res + factors.map(map.getOrElse(_, 0)).sum
    })
  }
}
