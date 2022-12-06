package leetCode

object Solution_1923 {
  def longestCommonSubpath(n: Int, paths: Array[Array[Int]]): Int = {
    val (base, mod) = (1L << 17, 8417508174513L)

    def hash(nums: Array[Int]): Long = nums
      .map(_.toLong)
      .reduce((x, y) => ((x * base + y) % mod + mod) % mod)

    def allHash(path: Array[Int], len: Int): Set[Long] =
      if (path.length == len) Set(hash(path))
      else {
        val baseAcc = hash(1 +: Array.fill(len - 1)(0))
        path
          .sliding(path.length - len, len)
          .toArray
          .transpose
          .scanLeft(hash(path.take(len))) {
            case (pre, Array(oldVal, newVal)) => (((pre - baseAcc * oldVal % mod) * base + newVal) % mod + mod) % mod
          }
          .toSet
      }

    def check(len: Int): Boolean = paths
      .map(allHash(_, len))
      .reduce(_ & _)
      .nonEmpty

    var (lo, hi) = (1, paths.minBy(_.length).length + 1)

    while (lo < hi) {
      val mid = (lo + hi) >>> 1
      if (check(mid)) lo = mid + 1
      else hi = mid
    }

    lo - 1
  }
}
