package leetCode._3800

object Solution_3768 {
  final class BIT(n: Int) {
    private val t = Array.fill(n + 1)(0)

    def add(i0: Int, v: Int): Unit = {
      var i = i0
      while (i <= n) {
        t(i) += v
        i += i & -i
      }
    }

    def sum(i0: Int): Int = {
      var i = i0
      var s = 0
      while (i > 0) {
        s += t(i)
        i &= i - 1
      }
      s
    }
  }

  def minInversionCount(nums: Array[Int], k: Int): Long = {
    if (k <= 1) return 0L

    val uniq = nums.distinct.sorted

    def idx(x: Int): Int = java.util.Arrays.binarySearch(uniq, x) + 1

    val bit = new BIT(uniq.length)

    var inv = 0L
    var ans = Long.MaxValue

    nums.indices.foreach(i => {
      val x = idx(nums(i))

      bit.add(x, 1)
      inv += math.min(i + 1, k) - bit.sum(x)

      val left = i + 1 - k
      if (left >= 0) {
        ans = math.min(ans, inv)

        val out = idx(nums(left))
        inv -= bit.sum(out - 1)
        bit.add(out, -1)
      }
    })

    ans
  }
}
