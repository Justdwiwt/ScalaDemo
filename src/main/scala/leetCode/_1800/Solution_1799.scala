package leetCode._1800

object Solution_1799 {
  def maxScore(nums: Array[Int]): Int = {
    @scala.annotation.tailrec
    def gcd(a: Int, b: Int): Int =
      if (b == 0) a
      else gcd(b, a % b)

    val dp = Array.fill(1 << nums.length)(0)
    val g = Array.ofDim[Int](nums.length, nums.length)
    nums.indices.foreach(i => (i + 1 until nums.length).foreach(j => {
      g(i)(j) = gcd(nums(i), nums(j))
      g(j)(i) = g(i)(j)
    }))

    (0 until 1 << nums.length).foreach(x => {
      val c = x.toBinaryString.count(_ == '1')
      if (c % 2 == 0)
        nums.indices.foreach(j => (j + 1 until nums.length).foreach(k => if ((x & (1 << j)) > 0 && (x & (1 << k)) > 0) {
          val tmp = x - (1 << j) - (1 << k)
          dp(x) = dp(x).max(dp(tmp) + c / 2 * g(j)(k))
        }))
    })
    dp.last
  }
}
