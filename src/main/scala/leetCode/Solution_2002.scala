package leetCode

object Solution_2002 {
  def maxProduct(s: String): Int = {
    val len = s.length
    val max = 1 << len
    val all = Array.fill(max)(false)
    val bits = Array.fill(max)(0)

    def check(m: Int): Boolean = {
      val idx = s.indices.filter(i => (m & (1 << i)) != 0)
      if (idx.size == 1) true
      else (0 until (idx.size / 2)).forall(i => s(idx(i)) == s(idx(idx.size - 1 - i)))
    }

    (1 until max).foreach(i => if (check(i)) {
      all(i) = true
      bits(i) = countBits(i)
    })

    var res = 0
    (1 until max).foreach(i => (i + 1 until max).foreach(j => if (all(i) && all(j) && (i & j) == 0) res = res.max(bits(i) * bits(j))))
    res
  }

  def countBits(i: Int): Int =
    if (i == 0) 0 else 1 + countBits(i & (i - 1))
}
