package leetCode._2500

object Solution_2403 {
  def minimumTime(power: Array[Int]): Long = {
    val mask = 1 << power.length
    val dp = Array.fill(mask)(Long.MaxValue)
    dp(0) = 0L
    (0 until mask).foreach(i => power.indices.foreach(j => if ((i & (1 << j)) != 0) {
      val bits = Integer.bitCount(i)
      dp(i) = dp(i).min(dp(i ^ (1 << j)) + power(j) / bits + (if (power(j) % bits == 0) 0 else 1))
    }))
    dp(mask - 1)
  }
}
