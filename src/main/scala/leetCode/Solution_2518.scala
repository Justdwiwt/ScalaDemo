package leetCode

object Solution_2518 {
  def countPartitions(nums: Array[Int], k: Int): Int = {
    val (m, n) = ((1e9 + 7).toInt, nums.length)

    val inv = nums./:(Vector.fill(k)(BigInt(1))) {
      case (dp, a) => Vector.tabulate(k)(i => dp(i) + dp.lift(i - a).getOrElse(BigInt(0)))
    }.last

    val tot = BigInt(2).pow(n)

    ((tot - 2 * inv) % BigInt(m)).max(0).toInt
  }
}
