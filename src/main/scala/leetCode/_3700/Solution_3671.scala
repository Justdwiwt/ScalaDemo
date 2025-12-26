package leetCode._3700

object Solution_3671 {
  private val M = 1000000007
  private val MX = 70001

  private val divisors: Array[List[Int]] = {
    val g = Array.fill(MX)(List.empty[Int])
    (1 until MX).foreach(i => (i until MX by i).foreach(j => g(j) = i :: g(j)))
    g
  }

  private class BIT(n: Int) {
    private val t = Array.fill(n + 1)(0L)

    def update(i0: Int, v: Long): Unit = {
      var i = i0
      while (i <= n) {
        t(i) = (t(i) + v) % M
        i += i & -i
      }
    }

    def pre(i0: Int): Long = {
      var i = i0
      var s = 0L
      while (i > 0) {
        s += t(i)
        i &= i - 1
      }
      s % M
    }
  }

  def totalBeauty(nums: Array[Int]): Int = {
    val m = nums.max

    def countIncreasing(b: List[Int], g: Int): Long =
      if (b.isEmpty) 0L
      else {
        val bit = new BIT(m / g)
        b.foldLeft(0L)((res, x0) => {
          val x = x0 / g
          val cnt = (bit.pre(x - 1) + 1) % M
          bit.update(x, cnt)
          (res + cnt) % M
        })
      }

    val groups = Array.fill(m + 1)(List.empty[Int])
    nums.foreach(x => divisors(x).foreach(d => groups(d) = x :: groups(d)))

    val f = Array.fill(m + 1)(0L)

    (1 to m).reverse.foldLeft(0L)((ans, i) => {
      val seq = groups(i).reverse
      val base = countIncreasing(seq, i)

      val sub = (i * 2 to m by i).foldLeft(0L)((s, j) => (s + f(j)) % M)

      val v = (base - sub + M) % M
      f(i) = v
      (ans + v * i) % M
    }).toInt
  }
}
