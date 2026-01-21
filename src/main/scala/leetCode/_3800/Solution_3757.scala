package leetCode._3800

object Solution_3757 {
  private val M = 1000000007
  private val MAX_N = 100001

  private val pow2: Array[Int] = {
    val a = new Array[Int](MAX_N)
    a(0) = 1
    var i = 1
    while (i < MAX_N) {
      a(i) = (a(i - 1).toLong * 2 % M).toInt
      i += 1
    }
    a
  }

  def countEffective(nums: Array[Int]): Int = {
    if (nums.forall(_ == nums.head)) return 1

    val orAll = nums.foldLeft(0)(_ | _)
    val w = 32 - Integer.numberOfLeadingZeros(orAll)
    val u = 1 << w

    val f = new Array[Int](u)
    nums.foreach(f(_) += 1)

    var bit = 0
    while (bit < w) {
      val mask = 1 << bit
      if ((orAll & mask) != 0) {
        var s = 0
        while (s < u) {
          if ((s & mask) != 0)
            f(s) += f(s ^ mask)
          s += 1
        }
      }
      bit += 1
    }

    var ans = pow2(nums.length).toLong
    var sub = orAll
    while (true) {
      val p2 = pow2(f(sub)).toLong
      if ((Integer.bitCount(orAll ^ sub) & 1) == 1) ans += p2
      else ans -= p2

      if (sub == 0)
        return ((ans % M + M) % M).toInt

      sub = (sub - 1) & orAll
    }
    0
  }
}
