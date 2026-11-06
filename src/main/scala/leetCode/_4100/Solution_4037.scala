package leetCode._4100

object Solution_4037 {
  def maxValidSplits(nums: Array[Int]): Int = {
    val n = nums.length

    @scala.annotation.tailrec
    def gcd(a: Int, b: Int): Int =
      if (b == 0) a else gcd(b, a % b)

    val pre = nums.scanLeft(0)(gcd).tail
    val suf = nums.scanRight(0)(gcd)

    val allGcd = suf(0)
    val p = pre.indexOf(allGcd)
    val q = suf.take(n).lastIndexOf(allGcd)

    val initial = (q - p).max(0)

    nums
      .indices
      .filter(i => i == 0 || pre(i) != pre(i - 1))
      .foldLeft(initial) { (ans, i) =>
        val newG = gcd(if (i == 0) 0 else pre(i - 1), suf(i + 1))

        val kept = nums.indices.filter(_ != i).toArray

        val pPos = kept
          .scanLeft(0)((g, j) => gcd(g, nums(j)))
          .tail.indexWhere(_ == newG)

        val qPos = kept
          .reverse
          .scanLeft(0)((g, j) => gcd(g, nums(j)))
          .tail.indexWhere(_ == newG)

        val res =
          if (pPos < 0 || qPos < 0) 0
          else {
            val left = kept(pPos)
            val right = kept.reverse(qPos)

            right - left - (if (left < i && i < right) 1 else 0)
          }

        ans.max(res)
      }
  }
}
