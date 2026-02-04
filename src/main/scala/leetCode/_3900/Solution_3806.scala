package leetCode._3900

object Solution_3806 {
  def maximumAND(nums: Array[Int], k: Int, m: Int): Int = {
    val sorted = nums.sorted
    val n = sorted.length
    val maxAns = sorted.last + k / m
    if (sorted(n - m) == sorted.last) return maxAns

    val maxWidth = Integer.SIZE - Integer.numberOfLeadingZeros(maxAns)

    (maxWidth - 1 to 0 by -1).foldLeft(0)((ans, bit) => {
      val target = ans | (1 << bit)

      val cost = sorted
        .iterator
        .map(x => {
          val diff = target & ~x
          if (diff == 0) 0L
          else {
            val j = Integer.SIZE - Integer.numberOfLeadingZeros(diff)
            val mask = (1L << j) - 1
            (target.toLong & mask) - (x.toLong & mask)
          }
        })
        .toArray
        .sorted
        .take(m)
        .sum

      if (cost <= k) target else ans
    })
  }
}
