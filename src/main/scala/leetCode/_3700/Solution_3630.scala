package leetCode._3700

object Solution_3630 {
  final class XorBasis(bits: Int) {
    private val b = Array.fill(bits)(0)

    def insert(x0: Int): Unit = {
      var x = x0
      while (x != 0) {
        val i = 31 - Integer.numberOfLeadingZeros(x)
        if (b(i) == 0) {
          b(i) = x
          return
        }
        x ^= b(i)
      }
    }

    def maxXor(): Int =
      (bits - 1 to 0 by -1).foldLeft(0)((res, i) => {
        val t = res ^ b(i)
        if (t > res) t else res
      })
  }

  def maximizeXorAndXor(nums: Array[Int]): Long = {
    val n = nums.length
    val sz = 32 - Integer.numberOfLeadingZeros(nums.max)
    val U = 1 << n
    val all = U - 1

    val subAnd = Array.fill(U)(0)
    val subXor = Array.fill(U)(0)
    val subOr = Array.fill(U)(0)

    subAnd(0) = -1
    nums.indices.foreach(i => {
      val bit = 1 << i
      val x = nums(i)
      (0 until bit).foreach(mask => {
        val m = bit | mask
        subAnd(m) = subAnd(mask) & x
        subXor(m) = subXor(mask) ^ x
        subOr(m) = subOr(mask) | x
      })
    })
    subAnd(0) = 0

    def maxXor2(sub: Int): Long = {
      val xor = subXor(sub)
      val basis = new XorBasis(sz)
      (0 until n)
        .filter(i => ((sub >> i) & 1) == 1)
        .foreach(i => basis.insert(nums(i) & ~xor))

      xor.toLong + 2L * basis.maxXor()
    }

    (0 until U).foldLeft(0L)((ans, i) => {
      val j = all ^ i
      val upper =
        subAnd(i).toLong +
          subOr(j).toLong * 2 -
          subXor(j)

      if (upper <= ans) ans
      else {
        val cand = subAnd(i).toLong + maxXor2(j)
        if (cand > ans) cand else ans
      }
    })
  }
}
