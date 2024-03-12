package leetCode._1500

object Solution_1498 {
  def numSubseq(nums: Array[Int], target: Int): Int = {
    var res = 0
    val sorted = nums.sorted
    val M = (1e9 + 7).toInt
    var r = nums.length - 1
    val dic = Array.fill(nums.length)(0)
    dic(0) = 1
    nums.indices.drop(1).foreach(i => dic(i) = (dic(i - 1) << 1) % M)
    var l = 0
    while (l <= r) {
      while (sorted(r) + sorted(l) > target && r > l) r -= 1
      if (sorted(r) + sorted(l) <= target) {
        res += dic(r - l)
        res %= M
      }
      l += 1
    }
    res
  }
}

object Cal {
  val M: Long = 1e9.toLong + 7
  val zero: Long = 0.toLong

  def getMod(x: Long, flag: Boolean = true): Long = if (flag) x % M else x

  def sum(seq: Seq[Int], flag: Boolean = true): Int =
    getMod(seq./:(zero)((acc, x) => acc + x.toLong), flag).toInt

  def mul(x: Int, y: Int, flag: Boolean = true): Int =
    getMod(x.toLong * y.toLong, flag).toInt

  def add(x: Int, y: Int, flag: Boolean = true): Int =
    getMod(x.toLong + y.toLong, flag).toInt
}

object Solution_1498_2 {
  def numSubseq(nums: Array[Int], target: Int): Int = {
    val M = nums.max
    var res = 0.toLong
    val A = Array.fill(M + 1)(0)
    val B = Array.fill(M + 1)(0)
    val base2 = Array.fill(nums.length + 1)(1.toLong)
    (1 to nums.length).foreach({ i => base2(i) = (2 * base2(i - 1)) % Cal.M })
    nums.foreach({ x => A(x) += 1 })
    (1 to M).foreach(i => B(i) = B(i - 1) + A(i))
    (1 to M)
      .withFilter(x => A(x) > 0)
      .withFilter(x => target - x >= x)
      .map({ x => val tmp = M.min(target - x); (x, tmp) })
      .map({ case (x, tmp) => val f = base2(A(x)) - 1; (x, tmp, f) })
      .map({ case (x, tmp, f) => val g = base2(B(tmp) - B(x)); (x, tmp, f, g) })
      .foreach({ case (_, _, f, g) => res = (res + f * g) % Cal.M })
    (res % Cal.M).toInt
  }
}
