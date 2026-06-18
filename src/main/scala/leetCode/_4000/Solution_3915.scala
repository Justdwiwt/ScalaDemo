package leetCode._4000

object Solution_3915 {
  private final class Fenwick(n: Int) {
    private val bit = Array.fill[Long](n + 1)(0L)

    def update(i: Int, v: Long): Unit = {
      var x = i
      while (x <= n) {
        bit(x) = bit(x).max(v)
        x += x & -x
      }
    }

    def query(i: Int): Long = {
      var x = i
      var res = 0L
      while (x > 0) {
        res = res.max(bit(x))
        x &= x - 1
      }
      res
    }
  }

  def maxAlternatingSum(nums: Array[Int], k: Int): Long = {
    val values = nums.distinct.sorted
    val m = values.length

    val rank = nums.map(java.util.Arrays.binarySearch(values, _))

    val fInc = Array.fill[Long](nums.length)(0L)
    val fDec = Array.fill[Long](nums.length)(0L)

    val inc = new Fenwick(m + 1)
    val dec = new Fenwick(m + 1)

    nums.indices.foldLeft(0L) { (ans, i) =>
      if (i >= k) {
        val r = rank(i - k)
        inc.update(m - r, fInc(i - k))
        dec.update(r + 1, fDec(i - k))
      }

      val r = rank(i)
      val x = nums(i).toLong

      fInc(i) = dec.query(r) + x
      fDec(i) = inc.query(m - 1 - r) + x

      ans.max(fInc(i)).max(fDec(i))
    }
  }
}
